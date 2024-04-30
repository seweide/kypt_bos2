package net.liangyihui.manager.kypt.bos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;

import java.util.Locale;

public abstract class AbstractBaseController {

    @Autowired
    private MessageSource messageSource;

    protected String getMessage(Integer code) {
        return getMessage(code, Locale.getDefault());
    }

    protected String getMessage(Integer code, Locale locale) {
        String msgCode = code + "";
        return messageSource.getMessage(msgCode, null, Locale.getDefault());
    }
}
