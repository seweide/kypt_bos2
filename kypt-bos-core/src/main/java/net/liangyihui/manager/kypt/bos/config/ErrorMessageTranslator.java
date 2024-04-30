package net.liangyihui.manager.kypt.bos.config;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;
import org.springframework.stereotype.Component;

import java.util.Locale;

/**
 * @author liu_y
 */
@Component
public class ErrorMessageTranslator {

    private static final String DEFAULT_MESSAGE = "哎呀，服务器累趴了...";

    @Autowired
    private MessageSource messageSource;


    public String getMessage(Integer code) {
        if (null == code || code <= 0) {
            return DEFAULT_MESSAGE;
        }
        return getMessage(code, Locale.getDefault(), null);
    }

    public String getMessage(Integer code, Object[] args) {
        if (null == code || code <= 0) {
            return DEFAULT_MESSAGE;
        }
        if (null != args && args.length > 0) {
            return getMessage(code, Locale.getDefault(), args);
        }
        return getMessage(code, Locale.getDefault(), null);
    }

    public String getMessage(Integer code, Locale locale, Object[] args) {
        String msgCode = code + "";
        try {
            String mes = messageSource.getMessage(msgCode, args, Locale.getDefault());
            if (StringUtils.isBlank(mes)) {
                mes = DEFAULT_MESSAGE;
            }
            return mes;
        } catch (NoSuchMessageException e) {
            return DEFAULT_MESSAGE;
        }
    }

}
