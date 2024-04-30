package net.liangyihui.manager.kypt.bos.enums;

public enum  MsgDocLinkType {
    H5("h5"),
    MINIPROGRAM("miniprogram");

    private String code;

    MsgDocLinkType(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
