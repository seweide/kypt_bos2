package net.liangyihui.manager.kypt.bos.config;

import io.undertow.servlet.spec.HttpServletRequestImpl;
import net.liangyihui.digitalmarketing.common.core.exception.BaseException;
import net.liangyihui.manager.kypt.bos.bo.UserInfo;
import net.liangyihui.manager.kypt.bos.exception.CommonBusinessException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static net.liangyihui.manager.kypt.bos.config.ErrorController.ERROR_CODE_SPLIT;

/**
 * @author liu_y
 */
@WebFilter(filterName = "pmLoginFilter", urlPatterns = "/*")
@Component
@ConditionalOnClass({JwtService.class, KyptExceptionHandler.class, ErrorMessageTranslator.class})
@ConfigurationProperties(prefix = "net.liangyihui.kypt.bos")
public class LoginFilter implements Filter {
    /**
     * swagger
     */
    private static final String SWAGGER_UI_HTML = "/swagger-ui.html/**";
    private static final String WEBJARS = "/webjars/**";
    private static final String SWAGGER_RESOURCES = "/swagger-resources/**";
    private static final String V_2_API_DOCS = "/v2/api-docs/**";
    /**
     * 程序内
     */
    private static final String LOGIN = "/login";
    private static final String LOGIN_CAPTCHA = "/login/send-captcha";
    private static final String FORGET_PASSWORD = "/login/forget-password";
    private static final String CHAT_SUB_CALLBACK = "/common/chat-sub-callback";
    private static final String PATIENT = "/WeChat/patient";
    private static final String PATIENT_UPDATE = "/WeChat/patient/update";
    private static final String PATIENT_SYNCINFO = "/WeChat/patient/syncInfo";
    private static final String HOSPITAL = "/common/hospital";
    private static final String DEPT = "/common/dept";
    private static final String DISEASE = "/common/disease";
    private static final String FILE_UPLOAD = "/file/upload";
    private static final String CITY_LIVE = "/common/city";
    private static final String MESSAGE_READ = "/user/msg/read";
    private static final String MINIPROGRAM_MESSAGE_READ = "/user/msg/miniprogram/read";
    private static final String COMMON_GENE = "/common/gene";
    private static final String COMMON_STATE = "/common/state";
    private static final String COMMON_STAGING = "/common/staging";
    private static final String SCALE_SEND = "/user/msg/scale/send";
    private static final String SCALE_SEND_USER = "/user/msg/scale/user/send";



    /**
     * actuator
     */
    private static final String ACTUATOR = "/actuator/*";
    private static final String ACCESS_TOKEN = "Access-Token";

    @Autowired
    private JwtService jwtService;

    private List<String> passUrl = new ArrayList<>();

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String url = ((HttpServletRequestImpl) servletRequest).getServletPath();
        String token = request.getHeader(ACCESS_TOKEN);
        if (StringUtils.isNotBlank(token) || !canPassDirectly(url)) {
            try {
                UserInfo userInfo = jwtService.parseToken(token);
                UserHolder.setUserInfo(userInfo);
            } catch (BaseException e) {
                String message = e.getMessage();
                int code = e.getErrorCode();
                message = message + ERROR_CODE_SPLIT + code;
                throw new CommonBusinessException(code, message);
            }
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    private boolean canPassDirectly(String url) {
        AntPathMatcher path = new AntPathMatcher();

        String[] urlPrefixList = {SWAGGER_UI_HTML, WEBJARS, SWAGGER_RESOURCES,
                V_2_API_DOCS, ACTUATOR, LOGIN, FORGET_PASSWORD, LOGIN_CAPTCHA, CHAT_SUB_CALLBACK,
                PATIENT, PATIENT_UPDATE, PATIENT_SYNCINFO,HOSPITAL, DEPT, DISEASE, FILE_UPLOAD, MESSAGE_READ, CITY_LIVE,COMMON_GENE,
                MINIPROGRAM_MESSAGE_READ,COMMON_STATE,COMMON_STAGING,SCALE_SEND,SCALE_SEND_USER};
        for (String urlPattern : urlPrefixList) {
            if (path.match(urlPattern, url)) {
                return true;
            }
        }
        for (String urlPattern : passUrl) {
            if (path.match(urlPattern, url)) {
                return true;
            }
        }
        return false;
    }

    public List<String> getPassUrl() {
        return passUrl;
    }

    public void setPassUrl(List<String> passUrl) {
        this.passUrl = passUrl;
    }
}
