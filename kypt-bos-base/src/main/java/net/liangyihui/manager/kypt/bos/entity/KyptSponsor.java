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
 * 申办方
 * </p>
 *
 * @author liangyihui
 * @since 2022-08-03
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class KyptSponsor implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * ID，主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 名称
     */
    private String name;

    /**
     * 头像图
     */
    private String picUrl;

    /**
     * 网站
     */
    private String website;

    /**
     * 试验区域，1:中国 2:全球多中心
     */
    private Integer region;

    /**
     * 开发来源，1:自主研发 2:合作研发
     */
    private Integer source;

    /**
     * 状态，1:待发布 2:已发布 3:已下架
     */
    private Integer status;

    /**
     * 联系人
     */
    private String linkman;

    /**
     * 联系电话
     */
    private String tel;

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
     * 治疗领域
     */
    private String cureArea;

    /**
     * 亮点
     */
    private String highLight;

    /**
     * 简介
     */
    private String profile;

    /**
     * 研发概况图
     */
    private String rdUrl;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 试验阶段
     */
    private String stage;

    /**
     * 药物类型
     */
    private String drugType;

    /**
     * 靶点
     */
    private String targets;

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
