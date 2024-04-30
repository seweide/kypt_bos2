package net.liangyihui.manager.kypt.bos.exception;

import net.liangyihui.digitalmarketing.common.core.exception.BaseException;

import static net.liangyihui.digitalmarketing.constant.ErrorCodeConstant.COMMON_ERROR;

/**
 * @author liu_y
 */
public class CommonBusinessException extends BaseException {

    public CommonBusinessException(String message) {
        super(COMMON_ERROR, message);
    }

    public CommonBusinessException(int errorCode, String message) {
        super(errorCode, message);
    }

    public CommonBusinessException(int errorCode, String message, Object[] args) {
        super(errorCode, message, args);
    }
}
