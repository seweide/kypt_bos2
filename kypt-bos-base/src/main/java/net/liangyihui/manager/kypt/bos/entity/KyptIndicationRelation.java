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
 * 适应证关联
 * </p>
 *
 * @author liangyihui
 * @since 2022-08-03
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class KyptIndicationRelation implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * ID，主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 类型，1:研究中心 2:协作组 3:申办方 4:项目 5:研究者
     */
    private Integer type;

    /**
     * 关联ID，type=1，为研究中心的ID；type=2，为协作组的ID；type=3，为申办方的ID；type=4，为项目的ID；type=5，为研究者的ID；
     */
    private Integer relationId;

    /**
     * 适应证ID
     */
    private Integer indicationId;

    /**
     * 适应证
     */
    private String indication;

    /**
     * 平均入组
     */
    private Integer averageEnrollment;

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
