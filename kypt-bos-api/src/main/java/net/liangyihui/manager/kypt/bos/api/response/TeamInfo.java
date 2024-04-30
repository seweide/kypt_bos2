package net.liangyihui.manager.kypt.bos.api.response;

import net.liangyihui.digitalmarketing.request.BaseEntity;

/**
 * @Author ruofa
 * @Date 2021/3/5 10:04
 */
public class TeamInfo extends BaseEntity {
    private int id;
    private String name;
    private String mobile;
    private String createTime;
    private String authority;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }
}
