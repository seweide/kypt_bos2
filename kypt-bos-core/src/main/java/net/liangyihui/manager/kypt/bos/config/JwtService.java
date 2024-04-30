package net.liangyihui.manager.kypt.bos.config;


import net.liangyihui.digitalmarketing.common.cache.dao.RedisDao;
import net.liangyihui.manager.kypt.bos.bo.UserInfo;
import net.liangyihui.manager.kypt.bos.exception.CommonBusinessException;
import org.apache.commons.lang3.StringUtils;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.jose4j.base64url.internal.apache.commons.codec.binary.Base64;
import org.jose4j.jws.AlgorithmIdentifiers;
import org.jose4j.jws.JsonWebSignature;
import org.jose4j.jwt.JwtClaims;
import org.jose4j.jwt.consumer.JwtConsumer;
import org.jose4j.jwt.consumer.JwtConsumerBuilder;
import org.jose4j.lang.JoseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import sun.security.util.DerInputStream;
import sun.security.util.DerValue;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Security;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.RSAPrivateCrtKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import static net.liangyihui.digitalmarketing.constant.Constant.PREFIX_USER_TOKEN;
import static net.liangyihui.digitalmarketing.constant.ErrorCodeConstant.TOKEN_INVALID;
import static net.liangyihui.digitalmarketing.constant.ErrorCodeConstant.TOKEN_NOT_FOUND;


@Service
public class JwtService {

    private static final Logger logger = LoggerFactory.getLogger(JwtService.class);

    public static final int SEQ_LENGTH = 9;
    public static final String PRIVATE_KEY_PATH = "ssl/rsa_private_key.pem";
    public static final String PUBLIC_KEY_PATH = "ssl/rsa_public_key.pem";
    public static final String AUDIENCE_SIGN = "p-m-Audience";
    public static final String ADMIN_NAME = "adminName";
    public static final String USER_ID = "userId";
    public static final String MOBILE = "mobile";
    public static final String LAST_UPDATE_TIME = "lastUpdateTime";
    public static final String LAST_LOGIN_TIME = "lastLoginTime";
    public static final String ENTERPRISE_ID = "enterpriseId";
    public static final String STATUS = "status";
    public static final int MODULUS = 1;
    public static final int PUBLIC_EXP = 2;
    public static final int PRIVATE_EXP = 3;
    public static final int PRIME_P = 4;
    public static final int PRIME_Q = 5;
    public static final int EXP_P = 6;
    public static final int EXP_Q = 7;
    public static final int CRT_COEFF = 8;

    private static DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy^MM^dd");

    @Autowired
    private RedisDao redisDao;

    /**
     * 过期时间
     */
    @Value("${net.liangyihui.kypt.bos.login.expire-minutes}")
    private int expireTimeMinutes;

    private static final int TOKEN_EXPIRE_TIME_MINUTES = 3600;

    private String privateKey;
    private String publicKey;
    private PublicKey pubKey;
    private PrivateKey priKey;

    @PostConstruct
    public void init() {
        privateKey = getKeyString(PRIVATE_KEY_PATH);
        publicKey = getKeyString(PUBLIC_KEY_PATH);
        pubKey = getPublicKey(this.publicKey);
        priKey = getPrivateKey(this.privateKey);
    }

    /**
     * 获取PublicKey对象
     *
     * @param publicKeyBase64 key string
     * @return PublicKey
     */
    private PublicKey getPublicKey(String publicKeyBase64) {
        Security.addProvider(new BouncyCastleProvider());
        X509EncodedKeySpec pubKeySpec = new X509EncodedKeySpec(Base64.decodeBase64(publicKeyBase64));
        KeyFactory keyFactory = null;
        try {
            keyFactory = KeyFactory.getInstance("RSA");

            return keyFactory.generatePublic(pubKeySpec);
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            logger.error("init public key error", e);
            throw new CommonBusinessException("init public key error");
        }
    }

    public UserInfo parseToken(String token) {

        if (token == null) {
            throw new CommonBusinessException(TOKEN_NOT_FOUND, "token is null");
        }

        JwtClaims jwtClaims = verifyToken(token);
        UserInfo userInfo = convertToUserInfoBo(jwtClaims);

        Object obj = redisDao.get(generateUserInfoKey(token, userInfo.getUserId()));
        redisDao.set(generateUserInfoKey(token, userInfo.getUserId()), expireTimeMinutes,
                TimeUnit.MINUTES, userInfo);

        if (null == obj) {
            throw new CommonBusinessException(TOKEN_INVALID, "token time out in redis");
        }
        return userInfo;
    }

    @SuppressWarnings("unchecked")
    private static UserInfo convertToUserInfoBo(JwtClaims jwtClaims) {
        UserInfo userInfo = new UserInfo();
        userInfo.setAdminName((String) jwtClaims.getClaimValue(ADMIN_NAME));
        userInfo.setEnterpriseId((long) jwtClaims.getClaimValue(ENTERPRISE_ID));
        userInfo.setStatus((String) jwtClaims.getClaimValue(STATUS));
        userInfo.setUserId((long) jwtClaims.getClaimValue(USER_ID));
        userInfo.setMobile((String) jwtClaims.getClaimValue(MOBILE));
        userInfo.setLastUpdateTime((String) jwtClaims.getClaimValue(LAST_UPDATE_TIME));
        userInfo.setLastLoginTime((String) jwtClaims.getClaimValue(LAST_LOGIN_TIME));
        return userInfo;
    }


    /**
     * 验证jwt
     *
     * @param token token
     * @return JwtClaims
     */
    public JwtClaims verifyToken(String token) {
        try {
            JwtConsumer jwtConsumer = new JwtConsumerBuilder()
                    .setRequireExpirationTime()
                    .setVerificationKey(pubKey)
                    //用于验证签名是否合法，可以设置多个，且可设置必须存在项，如果jwt中不包含这些内容则不通过
                    .setExpectedAudience(getAudienceArr())
                    .build();
            return jwtConsumer.processToClaims(token);
        } catch (Exception e) {
            logger.error("token verify error : {}", e.getMessage());
            throw new CommonBusinessException(TOKEN_INVALID, "token verify error");
        }
    }

    private String getTodayAudience() {
        LocalDate today = LocalDate.now();
        String todayStr = today.format(FORMATTER);
        return AUDIENCE_SIGN + todayStr;
    }

    private String[] getAudienceArr() {
        LocalDate today = LocalDate.now();
        LocalDate yesterday = today.minusDays(1);
        String todayStr = today.format(FORMATTER);
        String yesterdayStr = yesterday.format(FORMATTER);
        return new String[]{AUDIENCE_SIGN + todayStr, AUDIENCE_SIGN + yesterdayStr};
    }


    /**
     * 不校验解析jwt
     *
     * @param token token
     * @return JwtClaims
     */
    public static UserInfo parseTokenWithOutVerify(String token) {
        try {
            JwtConsumer jwtConsumer = new JwtConsumerBuilder()
                    .setSkipAllValidators()
                    .setSkipSignatureVerification()
                    .setSkipVerificationKeyResolutionOnNone()
                    .build();
            JwtClaims claims = jwtConsumer.processToClaims(token);
            return convertToUserInfoBo(claims);
        } catch (Exception e) {
            logger.error("token parse error", e);
            throw new CommonBusinessException(TOKEN_INVALID, "token parse error");
        }
    }

    /**
     * 生成jwt,
     * <p>
     * RS256(采用SHA-256的 RSA 签名)加密
     *
     * @return Sign
     */


    public String createToken(UserInfo userInfoBo) {
        if (null == userInfoBo) {
            throw new CommonBusinessException("userInfoBo is null");
        }
        final JwtClaims claims = new JwtClaims();
        claims.setClaim(ADMIN_NAME, userInfoBo.getAdminName());
        claims.setClaim(ENTERPRISE_ID, userInfoBo.getEnterpriseId());
        claims.setClaim(STATUS, userInfoBo.getStatus());
        claims.setClaim(USER_ID, userInfoBo.getUserId());
        claims.setClaim(MOBILE, userInfoBo.getMobile());
        claims.setClaim(LAST_UPDATE_TIME, userInfoBo.getLastUpdateTime());
        claims.setClaim(LAST_LOGIN_TIME, userInfoBo.getLastLoginTime());

        //用于验证签名是否合法，验证方必须包含这些内容才验证通过
        claims.setAudience(getTodayAudience());
        claims.setExpirationTimeMinutesInTheFuture(TOKEN_EXPIRE_TIME_MINUTES);
        claims.setIssuedAtToNow();

        // Generate the payload
        final JsonWebSignature jws = new JsonWebSignature();
        jws.setAlgorithmHeaderValue(AlgorithmIdentifiers.RSA_USING_SHA256);
        jws.setPayload(claims.toJson());
        jws.setKeyIdHeaderValue(UUID.randomUUID().toString());

        // Sign using the private key
        jws.setKey(priKey);
        try {
            String token = jws.getCompactSerialization();
            redisDao.set(generateUserInfoKey(token, userInfoBo.getUserId()), expireTimeMinutes,
                    TimeUnit.MINUTES, userInfoBo);
            return token;
        } catch (JoseException e) {
            logger.error("getCompactSerialization error", e);
            return null;
        }
    }

    private String getKeyString(String filePath) {

        InputStream inputStream = JwtService.class.getClassLoader().getResourceAsStream(filePath);
        if (null == inputStream) {
            throw new CommonBusinessException("not found pem file");
        }
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));

        StringBuilder sb = new StringBuilder();
        String line;
        try {
            while (null != (line = br.readLine())) {
                sb.append(line);
            }
            return sb.toString();
        } catch (IOException e) {
            logger.error("read private key error", e);
            throw new CommonBusinessException("read private key error");
        }
    }


    /**
     * 获取PrivateKey对象
     *
     * @param privateKeyPem string
     *                      private key
     * @return PrivateKey
     */
    private PrivateKey getPrivateKey(String privateKeyPem) {
        if (StringUtils.isBlank(privateKeyPem)) {
            return null;
        }

        // Base64 decode the data
        byte[] encoded = Base64.decodeBase64(privateKeyPem);

        try {
            DerInputStream derReader = new DerInputStream(encoded);
            DerValue[] seq = derReader.getSequence(0);

            if (seq.length < SEQ_LENGTH) {
                throw new GeneralSecurityException("Could not read private key");
            }

            // skip version seq[0];
            BigInteger modulus = seq[MODULUS].getBigInteger();
            BigInteger publicExp = seq[PUBLIC_EXP].getBigInteger();
            BigInteger privateExp = seq[PRIVATE_EXP].getBigInteger();
            BigInteger primeP = seq[PRIME_P].getBigInteger();
            BigInteger primeQ = seq[PRIME_Q].getBigInteger();
            BigInteger expP = seq[EXP_P].getBigInteger();
            BigInteger expQ = seq[EXP_Q].getBigInteger();
            BigInteger crtCoeff = seq[CRT_COEFF].getBigInteger();

            RSAPrivateCrtKeySpec keySpec = new RSAPrivateCrtKeySpec(modulus, publicExp, privateExp,
                    primeP, primeQ, expP, expQ, crtCoeff);

            KeyFactory factory = KeyFactory.getInstance("RSA");
            return factory.generatePrivate(keySpec);
        } catch (IOException | GeneralSecurityException e) {
            logger.error("init private key error", e);
        }
        return null;
    }

    public static String generateUserInfoKey(String token, long userId) {
        return PREFIX_USER_TOKEN + userId + ":" + token;
    }
}
