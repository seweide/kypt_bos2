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
 * 咨询
 * </p>
 *
 * @author liangyihui
 * @since 2022-08-03
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class KyptConsult implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * ID，主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 类型，1:CRO/SMO 2:免费EDC 3:咨询对接 4:中心调研
     */
    private Integer type;

    /**
     * 姓名
     */
    private String name;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 性别，1:男 2:女
     */
    private Integer sex;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 单位
     */
    private String company;

    /**
     * 职务
     */
    private String job;

    /**
     * 医院编码
     */
    private Integer hospitalId;

    /**
     * 医院名称
     */
    private String hospitalName;

    /**
     * 科室编码
     */
    private Integer deptId;

    /**
     * 科室名称
     */
    private String deptName;

    /**
     * 职称，1:住院医师 2:主治医师 3:副主任医师 4:主任医师
     */
    private Integer title;

    /**
     * 需求说明
     */
    private String requirement;

    /**
     * 备注
     */
    private String comment;

    /**
     * 创建时间
     */
    private Date createTime;


}
