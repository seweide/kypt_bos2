package net.liangyihui.manager.kypt.bos.service.impl;

import com.alibaba.fastjson.JSON;
import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.google.common.collect.ImmutableMap;
import net.liangyihui.digitalmarketing.common.cache.dao.RedisDao;
import net.liangyihui.digitalmarketing.constant.Constant;
import net.liangyihui.manager.kypt.bos.api.request.ChangePasswordRequest;
import net.liangyihui.manager.kypt.bos.api.request.ForgetPasswordRequest;
import net.liangyihui.manager.kypt.bos.api.request.LoginRequest;
import net.liangyihui.manager.kypt.bos.api.response.AdminUserInfo;
import net.liangyihui.manager.kypt.bos.bo.UserInfo;
import net.liangyihui.manager.kypt.bos.config.JwtService;
import net.liangyihui.manager.kypt.bos.entity.AdminEnterprise;
import net.liangyihui.manager.kypt.bos.entity.AdminUser;
import net.liangyihui.manager.kypt.bos.entity.SmsSendLog;
import net.liangyihui.manager.kypt.bos.exception.CommonBusinessException;
import net.liangyihui.manager.kypt.bos.mapper.AdminEnterpriseMapper;
import net.liangyihui.manager.kypt.bos.mapper.AdminUserMapper;
import net.liangyihui.manager.kypt.bos.mapper.SmsSendLogMapper;
import net.liangyihui.manager.kypt.bos.mapper.SmsTemplateMapper;
import net.liangyihui.manager.kypt.bos.service.third.SendSmsResponse;
import net.liangyihui.manager.kypt.bos.entity.SmsTemplate;
import net.liangyihui.manager.kypt.bos.service.IUserService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static net.liangyihui.digitalmarketing.constant.Constant.PREFIX_LYH_DMP;
import static net.liangyihui.digitalmarketing.constant.Constant.PREFIX_VERIFICATION_NUMBER;
import static net.liangyihui.digitalmarketing.constant.ErrorCodeConstant.ACCOUNT_NOT_EXIST;
import static net.liangyihui.digitalmarketing.constant.ErrorCodeConstant.ACCOUNT_PASSWORD_INCORRECT;
import static net.liangyihui.digitalmarketing.constant.ErrorCodeConstant.CAPTCHA_EXPIRED;
import static net.liangyihui.digitalmarketing.constant.ErrorCodeConstant.CAPTCHA_INCORRECT;
import static net.liangyihui.digitalmarketing.constant.ErrorCodeConstant.DB_ERROR;
import static net.liangyihui.digitalmarketing.constant.ErrorCodeConstant.SEND_SMS_OVERHEATED;


/**
 * @author liu_y
 */
@Service
public class UserServiceImpl implements IUserService {

//    public static final String PATIENT_MANAGER_SALT = "patientManager-salt";
//    public static final String ACTIVE = "active";
//    public static final String LIMITING = "sms_limiting:";
//    public static final int INT_1000 = 1000;
//    public static final int MAX_SEND_PER_MINUTE = 100;
//    public static final String SUCCESS = "OK";
//    public static final int VERIFICATION_NUMBER_EXPIRED=300;
//    public static final String CHANGE_PASSWORD_TEMPLATE="SMS_88685058";
//    private final JwtService jwtService;
//    private final AdminUserMapper adminUserMapper;
//    private final AdminEnterpriseMapper adminEnterpriseMapper;
//    private final Logger logger = LoggerFactory.getLogger(getClass());
//
//    public UserServiceImpl(JwtService jwtService, AdminUserMapper adminUserMapper, AdminEnterpriseMapper adminEnterpriseMapper) {
//        this.jwtService = jwtService;
//        this.adminUserMapper = adminUserMapper;
//        this.adminEnterpriseMapper = adminEnterpriseMapper;
//    }
//
//    @Autowired
//    private RedisDao redisDao;
//
//    @Autowired
//    private SmsTemplateMapper smsTemplateMapper;
//
//    @Autowired
//    private SmsSendLogMapper smsSendLogMapper;
//
//    @Value("${aliyuncs.sms.accessKeyId}")
//    private String accessKeyId;
//
//    @Value("${aliyuncs.sms.accessSecret}")
//    private String accessSecret;
//
//    @Override
//    public String login(LoginRequest request) {
//        String passWord = DigestUtils.md5DigestAsHex((request.getPassWord() + PATIENT_MANAGER_SALT).getBytes());
//        LambdaQueryWrapper<AdminUser> wrapper = new LambdaQueryWrapper<>();
//        wrapper.eq(AdminUser::getMobile, request.getMobile());
//        AdminUser user = adminUserMapper.selectOne(wrapper);
//
//        if (null == user || !ACTIVE.equals(user.getStatus()) || !passWord.equals(user.getPassword())) {
//            throw new CommonBusinessException(ACCOUNT_PASSWORD_INCORRECT, "passWord not match");
//        }
//        UserInfo userInfo = new UserInfo(user);
//
//        user.setLastLoginTime(LocalDateTime.now());
//        if (!user.updateById()) {
//            throw new CommonBusinessException(DB_ERROR, "update user last login time error");
//        }
//        return jwtService.createToken(userInfo);
//    }
//
//    @Override
//    public AdminUserInfo userInfo(UserInfo userInfo) {
//
//        AdminUserInfo adminUserInfo = new AdminUserInfo();
//        adminUserInfo.setId(userInfo.getUserId());
//        adminUserInfo.setLastUpdateTime(userInfo.getLastUpdateTime());
//        adminUserInfo.setUserName(userInfo.getAdminName());
//
//        LambdaQueryWrapper<AdminEnterprise> adminEnterpriseWrapper = new LambdaQueryWrapper<>();
//        adminEnterpriseWrapper.eq(AdminEnterprise::getId, userInfo.getEnterpriseId());
//        AdminEnterprise enterprise = adminEnterpriseMapper.selectOne(adminEnterpriseWrapper);
//
//        adminUserInfo.setCompanyName(enterprise.getEnterpriseName());
//        adminUserInfo.setLogoUrl(enterprise.getEnterpriseLogo());
//
//        LambdaQueryWrapper<AdminUser> adminUserWrapper=new LambdaQueryWrapper<>();
//        adminUserWrapper.eq(AdminUser::getId,userInfo.getUserId());
//        AdminUser adminUser=adminUserMapper.selectOne(adminUserWrapper);
//
//        adminUserInfo.setAuthority(adminUser.getAuthority());
//
//        return adminUserInfo;
//    }
//
//    @Override
//    public String changePassword(ChangePasswordRequest request, UserInfo userInfo) {
//        String oldPassword=DigestUtils.md5DigestAsHex((request.getOldPassword() + PATIENT_MANAGER_SALT).getBytes());
//        LambdaQueryWrapper<AdminUser> wrapper=new LambdaQueryWrapper<>();
//        wrapper.eq(AdminUser::getId,userInfo.getUserId())
//                .eq(AdminUser::getPassword,oldPassword);
//        AdminUser user=adminUserMapper.selectOne(wrapper);
//        if(null==user||!user.getStatus().equals(ACTIVE)){
//            throw new CommonBusinessException(ACCOUNT_PASSWORD_INCORRECT, "passWord not match");
//        }
//        user.setPassword(DigestUtils.md5DigestAsHex((request.getNewPassword() + PATIENT_MANAGER_SALT).getBytes()));
//        adminUserMapper.updateById(user);
//        return "密码修改成功";
//    }
//
//    @Override
//    public Boolean sendCaptcha(String mobile) {
//        long timeMinutes = System.currentTimeMillis() / INT_1000;
//        long sendNum = redisDao.getAndIncrement(PREFIX_LYH_DMP + LIMITING + timeMinutes,
//                1, TimeUnit.MINUTES);
//        String redisKey = Constant.PREFIX_VERIFICATION_NUMBER + mobile;
//        if (sendNum > MAX_SEND_PER_MINUTE) {
//            throw new CommonBusinessException(SEND_SMS_OVERHEATED, "send verification code overheated");
//        }
//        String vnInRedis = redisDao.get(redisKey);
//        if (StringUtils.isNotBlank(vnInRedis)) {
//            throw new CommonBusinessException(1002007,
//                    "send verification frequently",
//                    new Object[]{(VERIFICATION_NUMBER_EXPIRED / 60) + "分钟"});
//        }
//        //验证用户存在
//        LambdaQueryWrapper<AdminUser> adminUserWrapper=new LambdaQueryWrapper<>();
//        adminUserWrapper.eq(AdminUser::getMobile,mobile);
//        AdminUser user= adminUserMapper.selectOne(adminUserWrapper);
//        if (null == user) {
//            throw new CommonBusinessException(ACCOUNT_NOT_EXIST, "account not exist");
//        }
//        String verificationNumber = (int) ((Math.random() * 9 + 1) * 100000) + "";
//        //发送短信
//        LambdaQueryWrapper<SmsTemplate> smsTemplateWrapper=new LambdaQueryWrapper<>();
//        smsTemplateWrapper.eq(SmsTemplate::getTemplateCode,CHANGE_PASSWORD_TEMPLATE);
//        SmsTemplate smsTemplate = smsTemplateMapper.selectOne(smsTemplateWrapper);
//        List<String> mobiles = new ArrayList<>();
//        mobiles.add(mobile);
//        List<String> signNames = new ArrayList<>();
//        signNames.add(smsTemplate.getSignName());
//        List<Map<String, String>> params = new ArrayList<>();
//        Map<String, String> map = ImmutableMap.of("code",verificationNumber);
//        params.add(map);
//        SendSmsResponse sendSmsResponse=send(mobiles,signNames,smsTemplate.getTemplateCode(),params);
//        if (SUCCESS.equals(sendSmsResponse.getCode())) {
//            //短信日志
//            SmsSendLog smsSendLog = new SmsSendLog();
//            smsSendLog.setPhoneNumber(mobile);
//            smsSendLog.setSmsType("changePassword");
//            smsSendLog.setSendTime(LocalDateTime.now());
//            String template_content = "验证码"+verificationNumber+"，您正在尝试修改登录密码，请妥善保管账户信息。";
//            smsSendLog.setContent(template_content);
//            smsSendLogMapper.insert(smsSendLog);
//            redisDao.set(redisKey, VERIFICATION_NUMBER_EXPIRED, TimeUnit.SECONDS, verificationNumber);
//            return true;
//        } else {
//            return false;
//        }
//    }
//
//    public SendSmsResponse send(List<String> mobiles, List<String> signNames, String templateCode, List<Map<String,String>> params) {
//        DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId, accessSecret);
//        IAcsClient client = new DefaultAcsClient(profile);
//
//        CommonRequest request = new CommonRequest();
//        request.setSysMethod(MethodType.POST);
//        request.setSysDomain("dysmsapi.aliyuncs.com");
//        request.setSysVersion("2017-05-25");
//        request.setSysAction("SendBatchSms");
//        request.putQueryParameter("RegionId", "cn-hangzhou");
//
//        request.putQueryParameter("PhoneNumberJson", JSON.toJSONString(mobiles));
//        request.putQueryParameter("SignNameJson",JSON.toJSONString(signNames));
//        request.putQueryParameter("TemplateCode",templateCode);
//        request.putQueryParameter("TemplateParamJson", JSON.toJSONString(params));
//        try {
//            CommonResponse response = client.getCommonResponse(request);
//            logger.info(JSON.toJSONString(response));
//            return JSON.parseObject(response.getData(), SendSmsResponse.class);
//        } catch (ServerException e) {
//            SendSmsResponse sendSmsResponse = new SendSmsResponse();
//            sendSmsResponse.setCode("-001");
//            logger.error("failed to send message",e);
//            return sendSmsResponse;
//        } catch (ClientException e) {
//            SendSmsResponse sendSmsResponse = new SendSmsResponse();
//            sendSmsResponse.setCode("-001");
//            logger.info("failed to send message",e);
//            return sendSmsResponse;
//        }
//    }
//
//    @Override
//    public Boolean forgetPassword(ForgetPasswordRequest request) {
//        //判断验证码
//        String captchaInRedis = redisDao.get(PREFIX_VERIFICATION_NUMBER + request.getMobile());
//        if (StringUtils.isBlank(captchaInRedis)) {
//            throw new CommonBusinessException(CAPTCHA_EXPIRED, "captcha expired");
//        }
//        if (!captchaInRedis.equals(request.getCaptcha())) {
//            throw new CommonBusinessException(CAPTCHA_INCORRECT, "captcha incorrect");
//        }
//
//        LambdaQueryWrapper<AdminUser> wrapper=new LambdaQueryWrapper<>();
//        wrapper.eq(AdminUser::getMobile,request.getMobile());
//        AdminUser adminUser=adminUserMapper.selectOne(wrapper);
//        if(null==adminUser||!adminUser.getStatus().equals(ACTIVE)){
//            throw new CommonBusinessException(ACCOUNT_PASSWORD_INCORRECT, "passWord not match");
//        }
//        String passwordEncrypted=DigestUtils.md5DigestAsHex((request.getNewPassword() + PATIENT_MANAGER_SALT).getBytes());
//        adminUser.setPassword(passwordEncrypted);
//        adminUser.setLastUpdateTime(LocalDateTime.now());
//        adminUserMapper.updateById(adminUser);
//        redisDao.del(PREFIX_VERIFICATION_NUMBER + request.getMobile());
//        return true;
//    }
}
