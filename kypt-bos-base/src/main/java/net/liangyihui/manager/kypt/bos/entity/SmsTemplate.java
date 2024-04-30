package net.liangyihui.manager.kypt.bos.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author liuyuepeng
 * @since 2021-02-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class SmsTemplate extends Model<SmsTemplate> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 短信模板CODE。
     */
    private String templateCode;

    /**
     * 模板名称。
     */
    private String templateName;

    /**
     * 模板内容。
     */
    private String templateContent;

    /**
     * 模板审核状态。其中：
0：审核中。
1：审核通过。
2：审核失败，请在返回参数Reason中查看审核失败原因。
     */
    private Integer templateStatus;

    /**
     * 短信类型。其中：
0：验证码。
1：短信通知。
2：推广短信。
3：国际/港澳台消息。
     */
    private Integer templateType;

    /**
     * 模版keys
     */
    private String templateKeys;

    /**
     * 签名
     */
    private String signName;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
