package net.liangyihui.manager.kypt.bos.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 协作组
 * </p>
 *
 * @author liangyihui
 * @since 2022-08-03
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class KyptCooperateGroup implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * ID，主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 名称
     */
    private String groupName;

    /**
     * 头像图
     */
    private String picUrl;

    /**
     * 简介
     */
    private String profile;

    /**
     * 亮点
     */
    private String highLight;

    /**
     * 合作范围
     */
    private String scope;

    /**
     * 状态，1:待发布 2:已发布 3:已下架
     */
    private Integer status;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 创建人
     */
    private Integer createBy;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改人
     */
    private Integer updateBy;

    /**
     * 修改时间
     */
    private Date updateTime;

    /**
     * 是否删除，1:删除
     */
    private Integer isDeleted;


}
