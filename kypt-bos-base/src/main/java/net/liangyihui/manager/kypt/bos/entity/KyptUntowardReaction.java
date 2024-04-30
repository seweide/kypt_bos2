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
 * 不良反应上报
 * </p>
 *
 * @author liangyihui
 * @since 2022-08-03
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class KyptUntowardReaction implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * ID，主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 单位名称
     */
    private String companyName;

    /**
     * 部门类型，全国，省，直辖市
     */
    private String deptType;

    /**
     * 部门
     */
    private String department;

    /**
     * 联系电话
     */
    private String tel;

    /**
     * 传真
     */
    private String fax;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 所在省
     */
    private String prov;

    /**
     * 所在市
     */
    private String city;

    /**
     * 联系地址
     */
    private String address;

    /**
     * 邮编
     */
    private String zipCode;

    /**
     * 状态，1:待发布 2:已发布 3:已下架
     */
    private Integer status;

    /**
     * 备注
     */
    private String comment;

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
