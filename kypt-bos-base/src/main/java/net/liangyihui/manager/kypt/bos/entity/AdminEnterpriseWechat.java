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
 * 企业微信表
 * </p>
 *
 * @author liuyuepeng
 * @since 2021-02-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class AdminEnterpriseWechat extends Model<AdminEnterpriseWechat> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键 主键Id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 企业Id 企业Id
     */
    private Integer enterpriseId;

    /**
     * 企业微信名称 企业微信名称
     */
    private String enterpriseWechatName;

    /**
     * 企业微信密钥Id 企业微信密钥Id
     */
    private String chatCorpId;

    /**
     * 企业微信密钥 企业微信密钥
     */
    private String chatCorpSecret;
    /**
     * 获取token的url
     */
    private String accessTokenUrl;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
