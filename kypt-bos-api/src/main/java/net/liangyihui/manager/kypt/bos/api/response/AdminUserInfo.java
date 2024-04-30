package net.liangyihui.manager.kypt.bos.api.response;

import net.liangyihui.digitalmarketing.request.BaseEntity;

/**
 * @author liu_y
 */
public class AdminUserInfo extends BaseEntity {

    private int id;
    private String userName;
    private String companyName;
    private String logoUrl;
    private String lastUpdateTime;
    /**
     * 权限 0:超管,1:管理员,2:编辑者
     */
    private String authority;

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(String lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
