package net.liangyihui.manager.kypt.bos.service.third;

import com.alibaba.fastjson.annotation.JSONField;

public class SendSmsResponse {

    @JSONField(name = "Message")
    private String message;

    @JSONField(name = "RequestId")
    private String requestId;

    @JSONField(name = "BizId")
    private String bizId;

    @JSONField(name = "Code")
    private String code;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getBizId() {
        return bizId;
    }

    public void setBizId(String bizId) {
        this.bizId = bizId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
