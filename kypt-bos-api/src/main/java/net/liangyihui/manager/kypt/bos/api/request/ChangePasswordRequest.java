package net.liangyihui.manager.kypt.bos.api.request;

/**
 * @Author ruofa
 * @Date 2021/3/4 16:58
 */
public class ChangePasswordRequest {
    private String oldPassword;
    private String newPassword;

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }
}
