package net.liangyihui.manager.kypt.bos.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 项目
 * </p>
 *
 * @author liangyihui
 * @since 2022-08-03
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class KyptProject implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * ID，主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 项目名称
     */
    private String name;

    /**
     * 是否IIT研究，0:否 1:是
     */
    private Integer isIit;

    /**
     * 发布状态，1:待发布 2:已发布 3:已下架
     */
    private Integer releaseStatus;

    /**
     * 登记号
     */
    private String registerNo;

    /**
     * 试验状态，1:进行中(2:尚未招募 3:招募中 4:招募完成) 5:已完成 6:暂停 7:终止
     */
    private Integer status;

    /**
     * 首次公示时间
     */
    private Date firstPublicTime;

    /**
     * 试验完成日期
     */
    private String endTime;

    /**
     * 合作方式，1:研究合作 2:患者招募
     */
    private Integer cooperationWay;

    /**
     * 是否可合作咨询，0:否 1:是
     */
    private Integer isConsult;

    /**
     * 协作组ID
     */
    private Integer groupId;

    /**
     * 药物名称
     */
    private String drugName;

    /**
     * 药物代号
     */
    private String drugNo;

    /**
     * 药物类型，1:中药/天然药物 2:化学药物 3:生物制品
     */
    private Integer drugType;

    /**
     * 备案号
     */
    private String recordNo;

    /**
     * 适应证描述
     */
    private String indicationDescription;

    /**
     * 试验专业题目
     */
    private String proSubject;

    /**
     * 试验通俗题目
     */
    private String commonSubject;

    /**
     * 试验方案编号
     */
    private String schemeNo;

    /**
     * 试验目的
     */
    private String purpose;

    /**
     * 试验分类
     */
    private String trialClass;

    /**
     * 试验分期，1:I期 2:II期 3:III期 4:IV期 5:BE 6:其他
     */
    private Integer stage;

    /**
     * 设计类型，1:单臂试验 2:平行分组 3:交叉设计
     */
    private Integer designType;

    /**
     * 随机化，1:随机化 2:非随机化
     */
    private Integer random;

    /**
     * 试验范围，1:国内试验 2:国际试验
     */
    private Integer scope;

    /**
     * 盲法，1:单盲 2:双盲 3:非盲
     */
    private Integer blindMethod;

    /**
     * 受试者年龄
     */
    private String patientAge;

    /**
     * 受试者性别，1:男 2:女 3:男女不限
     */
    private Integer patientSex;

    /**
     * 是否有健康受试者，0:无 1:有
     */
    private Integer hasHealthPatient;

    /**
     * 目标入组人数
     */
    private String targetEnrollmentNumber;

    /**
     * 实际入组总人数
     */
    private String actualEnrollmentNumber;

    /**
     * 入选标准
     */
    @TableField("Inclusion_criteria")
    private String inclusionCriteria;

    /**
     * 排除标准
     */
    private String exclusionCriteria;

    /**
     * 靶点
     */
    private String targets;

    /**
     * 瘤种
     */
    private String disease;

    /**
     * 是否早期研究，0:否 1:是
     */
    private Integer isEarlyStage;

    /**
     * 开发来源，1:自主研发 2:合作研发
     */
    private Integer source;

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
