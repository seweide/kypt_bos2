package net.liangyihui.manager.kypt.bos.bo;

import net.liangyihui.digitalmarketing.request.BaseEntity;
import net.liangyihui.manager.kypt.bos.entity.AdminUser;

import java.time.format.DateTimeFormatter;

/**
 * 操作者用户信息
 *
 * @author liu_y
 */
public class UserInfo extends BaseEntity {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    private int userId;

    /**
     * 用户姓名
     */
    private String adminName;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 企业Id 企业编号主键
     */
    private int enterpriseId;

    /**
     * 状态
     * no-active:未开通
     * active：开通
     */
    private String status;

    private String lastLoginTime;

    private String lastUpdateTime;

    public UserInfo() {
    }

    public UserInfo(AdminUser user) {
        this.userId = user.getId();
        this.adminName = user.getAdminName();
        this.mobile = user.getMobile();
        this.enterpriseId = user.getEnterpriseId();
        this.status = user.getStatus();
        if (null != user.getLastUpdateTime()) {
            this.lastUpdateTime = user.getLastUpdateTime().format(FORMATTER);
        }
        if (null != user.getLastLoginTime()) {
            this.lastLoginTime = user.getLastLoginTime().format(FORMATTER);
        }
    }

    public String getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(String lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public String getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(String lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = Math.toIntExact(userId);
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public int getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(long enterpriseId) {
        this.enterpriseId = Math.toIntExact(enterpriseId);
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
