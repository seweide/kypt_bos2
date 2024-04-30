package net.liangyihui.manager.kypt.bos.enums;

/**
 * sms:短信 wechat-sub:公众号 e-chat:企业微信
 */
public enum MsgSendChannel {
    SMS("sms"),
    WECHAT_SUB("wechat-sub"),
    E_CHAT("e-chat"),
    ASSISTANT("assistant");
    private String code;

    MsgSendChannel(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
