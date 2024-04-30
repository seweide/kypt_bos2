package net.liangyihui.manager.kypt.bos.enums;

public enum MiniProgramContentType {
    DOCTOR_HOMEPAGE("doctor-homepage"),
    TEAM_HOMEPAGE("team-homepage"),
    DEPT_HOMEPAGE("dept-homepage"),
    UNION_HOSPITAL_HOMEPAGE("union-hospital-homepage"),
    CLINIC_CENTER("clinic-center"),
    MDT("mdt"),
    INQUIRY_TWO("inquiry-two"),
    REPORT_READ("report-read"),
    DOCUMENT("document"),
    OPEN_CLASS("open-class"),
    NONE("");
    private String code;


    public static MiniProgramContentType parse(String code){
       for(MiniProgramContentType miniProgramContentType : MiniProgramContentType.values()){
           if(miniProgramContentType.getCode().equals(code)){
               return miniProgramContentType;
           }
       }
       return NONE;
    }


    private String  initUrl(String url,Integer messageId,String env){
        StringBuilder sb = new StringBuilder(url);
        if(url.indexOf("?")!=-1){
            sb.append("&");
        }else {
            sb.append("?");
        }
        sb.append("messageId=").append(messageId);
        sb.append("&mode=").append(env);
        sb.append("&project=patient-manager");
        return sb.toString();
    }


    MiniProgramContentType(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public String getPagePath(String id){
        if(this.equals(DOCTOR_HOMEPAGE)){
            return "pages/doctorhomepage?id="+id;
        }else if(this.equals(TEAM_HOMEPAGE)){
            return "pages/teamhomepage?id="+id;
        }else if(this.equals(DEPT_HOMEPAGE)){
            return "pages/depthomepage?id="+id;
        }else if(this.equals(UNION_HOSPITAL_HOMEPAGE)){
            return "pages/unionhomepage?id="+id;
        }else if(this.equals(CLINIC_CENTER)){
            return "pages/clinicCenter?id="+id;
        }else if(this.equals(MDT)){
            return "pages/clinicMeetsInfo?type=1&selfparams=hjgl001";
        }else if(this.equals(INQUIRY_TWO)){
            return "freeClinic/pages/inquiryTwo?type=3&fromDocId="+id;
        }else if(this.equals(REPORT_READ)){
            return "pages/reportRead";
        }else if(this.equals(DOCUMENT)){
            return "pages/webView?id="+id;
        }else if(this.equals(OPEN_CLASS)){
            return "freeClinic/pages/live?id="+id;
        }
        return "";
    }


}
