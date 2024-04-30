package net.liangyihui.manager.kypt.bos.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 患者管理员用户表
 * </p>
 *
 * @author liuyuepeng
 * @since 2021-02-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class AdminUser extends Model<AdminUser> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键Id 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 用户姓名 用户姓名
     */
    private String adminName;

    /**
     * 手机号 手机号
     */
    private String mobile;

    /**
     * 企业Id 企业编号主键
     */
    private Integer enterpriseId;

    /**
     * 密码 密码
     */
    private String password;

    /**
     * 状态 no-active:未开通
     * active：开通
     */
    private String status;

    /**
     * 权限 0:超管,1:管理员,2:编辑者
     */
    private String authority;

    /**
     * 创建人 Boss创建人
     */
    private Integer createBUserId;

    /**
     * 最后一次登陆时间
     */
    private LocalDateTime lastLoginTime;
    /**
     * 创建时间 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新人 最后跟新人
     */
    private Integer updateBUserId;

    /**
     * 最后更新时间 最后更新时间
     */
    private LocalDateTime lastUpdateTime;

    /**
     * 系统消息是否阅读0：未读 1：已读
     */
    private Integer isRead;

    /**
     *
     * @return
     */
    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
