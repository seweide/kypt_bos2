package net.liangyihui.manager.kypt.bos.config;

import net.liangyihui.digitalmarketing.common.core.exception.BaseException;
import net.liangyihui.digitalmarketing.response.CommonResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

import static net.liangyihui.digitalmarketing.constant.ErrorCodeConstant.COMMON_ERROR;

/**
 * @author liu_y
 */
@RestControllerAdvice
public class KyptExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(KyptExceptionHandler.class);
    public static final String DEFAULT_MESSAGE_ = "default message ";

    @Autowired
    private ErrorMessageTranslator errorMessageTranslator;

    @ExceptionHandler(value = {BaseException.class})
    public CommonResponse<Void> baseException(BaseException e, ServletRequest request) {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        return handleException(httpServletRequest, e.getErrorCode(), e.getMessage(), e.getArgs());
    }

//    @ExceptionHandler(value = {PermissionException.class})
//    public CommonResponse<Void> permissionException(PermissionException e, ServletRequest request) {
//        return handleException((HttpServletRequest) request, e.getErrorCode(), e.getMessage(), null);
//    }


    private CommonResponse<Void> handleException(HttpServletRequest request,
                                                 int errorCode,
                                                 String message,
                                                 Object[] args) {
        String uri = request.getRequestURL().toString();
        logger.error("error uri = [ {} ] , errorCode = [ {} ] , message = [ {} ]", uri, errorCode, message);
        return new CommonResponse<>(errorCode, errorMessageTranslator.getMessage(errorCode, args));
    }

    @ExceptionHandler(value = {MethodArgumentNotValidException.class})
    public CommonResponse<Void> argumentNotValid(MethodArgumentNotValidException e, ServletRequest request) {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        StringBuilder message = new StringBuilder();
        BindingResult bindingResult = e.getBindingResult();
        String uri = httpServletRequest.getRequestURL().toString();
        logger.error("argument Not Valid error uri = {} ,message = {}", uri, e.getMessage());

        List<ObjectError> errors = bindingResult.getAllErrors();
        errors.forEach(p -> {
            FieldError fieldError = (FieldError) p;
            message.append(fieldError.getField()).append(":")
                    .append(fieldError.getDefaultMessage()).append(";");
        });

        return new CommonResponse<>(1005003, errorMessageTranslator.getMessage(1005003) + ":" + message);
    }

    @ExceptionHandler(value = {RuntimeException.class})
    public CommonResponse<Void> runtimeException(RuntimeException e, ServletRequest request) {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;

        String uri = httpServletRequest.getRequestURL().toString();
        logger.error("error uri = {}", uri, e);

        return new CommonResponse<>(COMMON_ERROR, errorMessageTranslator.getMessage(-1));
    }

    @ExceptionHandler(value = {Exception.class})
    public CommonResponse<Void> exceptionHandler(Exception e, ServletRequest request) {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;

        String uri = httpServletRequest.getRequestURL().toString();
        logger.error("error uri = {}", uri, e);

        return new CommonResponse<>(COMMON_ERROR, errorMessageTranslator.getMessage(-1));
    }


}
