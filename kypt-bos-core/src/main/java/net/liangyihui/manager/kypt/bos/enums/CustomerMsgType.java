package net.liangyihui.manager.kypt.bos.enums;

public enum  CustomerMsgType {
    TXT("txt"),
    MiniProgram("miniProgram"),
    IMAGE("image");

    private String code;

    CustomerMsgType(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }


}
