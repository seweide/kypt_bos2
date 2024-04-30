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
 * boss管理员用户表
 * </p>
 *
 * @author liuyuepeng
 * @since 2021-02-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class AdminBossUser extends Model<AdminBossUser> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键Id boos user id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 登陆名 登陆名
     */
    private String loginName;

    /**
     * 手机号码 手机号
     */
    private String mobile;

    /**
     * 密码 密码
     */
    private String password;

    /**
     * 类型 super:超级管理员
     */
    private String userType;

    /**
     * 创建时间 创建时间
     */
    private LocalDateTime createTime;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
