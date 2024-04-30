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
 * 企业表
 * </p>
 *
 * @author liuyuepeng
 * @since 2021-02-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class AdminEnterprise extends Model<AdminEnterprise> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键Id 主键Id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 企业名称 企业名称
     */
    private String enterpriseName;

    /**
     * 企业LOGO 企业logo路径
     */
    private String enterpriseLogo;

    /**
     * 医院等级 医院等级，与app端保持一致
     */
    private String enterpriseLevel;

    /**
     * 管理员ID 管理员Id
     */
    private Integer adminUserId;

    /**
     * 创建人 创建人boosid
     */
    private Integer createBUserId;

    /**
     * 创建时间 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 最后更新人 最后更新人
     */
    private Integer updateBUserId;

    /**
     * 最后更时间 最后更新时间
     */
    private String lastUpdateTime;

    /**
     * 企业绑定医院id
     */
    private Integer hospitalId;

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
