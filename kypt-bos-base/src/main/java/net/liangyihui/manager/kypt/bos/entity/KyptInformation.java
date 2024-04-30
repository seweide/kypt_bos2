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
 * 资讯
 * </p>
 *
 * @author liangyihui
 * @since 2022-08-03
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class KyptInformation implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * ID，主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 题目
     */
    private String title;

    /**
     * 分类，1:资讯 2:讲堂 3:肿瘤黑科技 4:研值有约
     */
    private Integer type;

    /**
     * 图片
     */
    private String picUrl;

    /**
     * 内容
     */
    private String content;

    /**
     * 文章ID，document_basic表的ID
     */
    private Integer docId;

    /**
     * 咨询链接
     */
    private String informationUrl;

    /**
     * 发布时间
     */
    private Date publishTime;

    /**
     * 讲师ID
     */
    private Integer lecturerId;

    /**
     * 浏览数
     */
    private Integer readAmount;

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
