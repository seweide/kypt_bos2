package net.liangyihui.manager.kypt.bos.enums;


/**
 * 消息类型txt:文字,
 * image:图片,
 * template:模版消息,
 * customer-txt:客服文本消息,
 * customer-image,
 * customer-txt-image,
 * patient-guide:患者指南,
 * patient-document:文章资讯
 */
public enum MsgType {
    TXT("txt"),
    IMAGE("image"),
    TEMPLATE("template"),
    CUSTOMER_TXT("customer-txt"),
    CUSTOMER_IMAGE("customer-image"),
    CUSTOMER_TXT_IMAGE("customer-txt-image"),
    PATIENT_GUIDE("patient-guide"),
    PATIENT_DOCUMENT("patient-document"),
    UN_KNOW("un-know");

    private String code;

    MsgType(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public static MsgType parse(String code){
        for(MsgType msgType:MsgType.values()){
            if(msgType.code.equals(code)){
                return msgType;
            }
        }
        return UN_KNOW;
    }
}
