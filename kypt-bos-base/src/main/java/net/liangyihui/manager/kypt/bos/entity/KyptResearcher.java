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
 * 研究者
 * </p>
 *
 * @author liangyihui
 * @since 2022-08-03
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class KyptResearcher implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * ID，主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 姓名
     */
    private String name;

    /**
     * 研究中心ID
     */
    private Integer centerId;

    /**
     * 研究中心名称
     */
    private String centerName;

    /**
     * 研究团队ID
     */
    private Integer teamId;

    /**
     * 研究团队名称
     */
    private String teamName;

    /**
     * 状态，1:待发布 2:已发布 3:已下架
     */
    private Integer status;

    /**
     * 科室
     */
    private String department;

    /**
     * 具体身份，1:医生 2:护士 3:肿瘤专科护士 4:药剂师 5:物理师 6:康复师 7:营养师 8:健康管理师 9:其他
     */
    private Integer typeChild;

    /**
     * 职称，具体身份为1：1:住院医师 2:主治医师 3:副主任医师 4:主任医师 具体身份为2/3：1:护士 2:护师 3:主管护师 4:副主任护师 5:主任护师 具体身份为4: 1:药士 2:药师 3:主管药师 4:副主任药师 5:主任药师 其他身份通用： 1:初级 2:中级 3:副高级 4:高级 5:其他
     */
    private Integer title;

    /**
     * 专业名称
     */
    private String majorName;

    /**
     * 职责
     */
    private String duty;

    /**
     * 电话
     */
    private String tel;

    /**
     * 优势
     */
    private String advantage;

    /**
     * 简介
     */
    private String profile;

    /**
     * 门诊时间，A0:周一全天 A1:周一上午 A2:周一下午 B0:周二全天 B1:周二上午 B2:周二下午 C0:周三全天 C1:周三上午 C2:周三下午 D0:周四全天 D1:周四上午 D2:周四下午 E0:周五全天 E1:周五上午 E2:周五下午 F0:周六全天 F1:周六上午 F2:周六下午 G0:周日全天 G1:周日上午 G2:周日下午 多个以 英文”,“分隔
     */
    private String consultingHours;

    /**
     * 头像
     */
    private String picUrl;

    /**
     * 身份证明
     */
    private String identityUrl;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 地址
     */
    private String address;

    /**
     * 邮编
     */
    private String postCode;

    /**
     * 中心排序
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
