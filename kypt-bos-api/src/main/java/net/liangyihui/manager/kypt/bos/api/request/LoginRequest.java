package net.liangyihui.manager.kypt.bos.api.request;

import net.liangyihui.digitalmarketing.request.BaseEntity;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * @author liu_y
 */
public class LoginRequest extends BaseEntity {
    @Size(max = 11, min = 11)
    private String mobile;
    @NotBlank
    private String passWord;

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
}
