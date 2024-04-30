package net.liangyihui.manager.kypt.bos.config;


public interface Constant {
    String MESSAGE_USER_READ_SELF_MESSAGE_ID = "messageId";
    String MESSAGE_USER_READ_SELF_MESSAGE_TYPE = "messageType";
    String MESSAGE_USER_READ_SELF_MESSAGE_TYPE_GROUP = "group";
    String MESSAGE_USER_READ_SELF_MESSAGE_TYPE_CHAT = "chat";


    String CHANNEL_TYPE_E_CHAT = "e-chat";
    String CHANNEL_TYPE_SUB = "sub";

    /**
     * 1:提醒，2:文章，3:视频，4:问答，5:量表 9：随访计划通知
     */
    int CONTENT_TYPE_NOTIFICATION = 1;
    int CONTENT_TYPE_DOC = 2;
    int CONTENT_TYPE_VIDEO = 3;
    int CONTENT_TYPE_Q_A = 4;
    int CONTENT_TYPE_SCALE_FORM = 5;
    int CONTENT_TYPE_DOCTOR = 6;
    int CONTENT_TYPE_FOLLOW_UP = 9;



    /**
     * patient user channel
     */
    String USER_STATUS_ACTIVE = "1";
    String USER_STATUS_NO_ACTIVE = "0";

    Integer SCALE_FORM_READ = 1;
    Integer SCALE_FORM_UN_READ = 0;

    Integer MOBILE_VALID=1;
    Integer MOBILE_UN_VALID=0;
    Integer User_INFO_STATUS_REGISTER=1;
    Integer USER_INFO_STATUS_COMPLETE=2;

    /**
     * chat mode
     */
    String USER_CHAT_MODE_ASK = "ask";
    String USER_CHAT_MODE_REPLAY = "replay";


    /**
     * 患者注册验证码redis前缀
     */
    String PATIENT_USER_REGISTER_PREFIX="patient:user:register:";
    Integer PATIENT_USER_REGISTER_ERROR_CODE=1100000;
    Integer PATIENT_USER_REGISTER_ERROR_CODE_VERIFY=1100001;
    Integer PATIENT_DATE_NOT_FORMAT=1100100;

}
