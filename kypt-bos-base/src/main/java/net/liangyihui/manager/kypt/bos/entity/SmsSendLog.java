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
 * 
 * </p>
 *
 * @author liuyuepeng
 * @since 2021-02-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class SmsSendLog extends Model<SmsSendLog> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "ID", type = IdType.AUTO)
    private Long id;

    /**
     * 发送内容
     */
    private String content;

    /**
     * 发送号码
     */
    private String phoneNumber;

    /**
     * 发送类型 verification：验证码，register:注册
     */
    private String smsType;

    /**
     * 发送时间
     */
    private LocalDateTime sendTime;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
