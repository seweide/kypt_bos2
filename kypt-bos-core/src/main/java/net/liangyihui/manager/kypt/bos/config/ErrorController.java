package net.liangyihui.manager.kypt.bos.config;


import net.liangyihui.digitalmarketing.response.CommonResponse;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ErrorProperties;
import org.springframework.boot.autoconfigure.web.servlet.error.BasicErrorController;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

import static net.liangyihui.digitalmarketing.constant.Constant.RESPONSE_CODE;
import static net.liangyihui.digitalmarketing.constant.ErrorCodeConstant.COMMON_ERROR;

/**
 * 统一捕获filter中的异常
 *
 * @author liu_y
 */
@RestController
public class ErrorController extends BasicErrorController {
    private static final Logger logger = LoggerFactory.getLogger(ErrorController.class);
    public static final String MESSAGE = "message";
    public static final String MSG = "msg";
    public static final String CODE = "code";
    public static final String PATH = "path";
    public static final String ERROR_CODE_SPLIT = ">>";

    public ErrorController() {
        super(new DefaultErrorAttributes(), new ErrorProperties());
    }

    @Autowired
    private ErrorMessageTranslator errorMessageTranslator;

    @Override
    @RequestMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Map<String, Object>> error(HttpServletRequest request) {
        Map<String, Object> body = getErrorAttributes(request, isIncludeStackTrace(request, MediaType.ALL));
        HttpStatus status = getStatus(request);

        Map<String, Object> response =
                CommonResponse.failedResMap(COMMON_ERROR, "filer throw exception");
        String message = (String) body.get(MESSAGE);

        if (StringUtils.isNoneBlank(message)) {
            if (message.contains(ERROR_CODE_SPLIT)) {
                String[] errorInfo = message.split(ERROR_CODE_SPLIT);
                String errorCode = errorInfo[1];
                message = errorInfo[0];
                response = CommonResponse.failedResMap(Integer.parseInt(errorCode), message);
            } else {
                response = CommonResponse.failedResMap(COMMON_ERROR, message);

                Object statusInt = body.get("status");
                if (null != statusInt) {
                    response.put(RESPONSE_CODE, statusInt);
                }

            }

            status = HttpStatus.OK;
        }

        translateAndLogMsg(body, response);

        return new ResponseEntity<>(response, status);
    }

    /**
     * 打印相关信息，并把正确的msg返回给前端
     */
    private void translateAndLogMsg(Map<String, Object> body, Map<String, Object> response) {
        Object uri = body.get(PATH);
        Object msg = response.get(MSG);
        Object code = response.get(CODE);
        String messageTranslated;
        if (code instanceof String) {
            messageTranslated = errorMessageTranslator.getMessage(Integer.valueOf((String) code));
        } else {
            messageTranslated = errorMessageTranslator.getMessage((int) code);
        }
        logger.error(String.format("uri: %s ,error: %s ", uri, msg));
        response.put(MSG, messageTranslated);
    }


}