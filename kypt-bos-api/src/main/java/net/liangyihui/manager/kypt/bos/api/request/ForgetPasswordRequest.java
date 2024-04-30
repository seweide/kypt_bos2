package net.liangyihui.manager.kypt.bos.api.request;

/**
 * @Author ruofa
 * @Date 2021/3/8 16:56
 */
public class ForgetPasswordRequest {
    private String mobile;
    private String newPassword;
    private String captcha;

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getCaptcha() {
        return captcha;
    }

    public void setCaptcha(String captcha) {
        this.captcha = captcha;
    }
}
