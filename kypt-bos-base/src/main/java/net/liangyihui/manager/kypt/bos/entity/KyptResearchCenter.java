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
 * 研究中心
 * </p>
 *
 * @author liangyihui
 * @since 2022-08-03
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class KyptResearchCenter implements Serializable {

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
     * 统一社会信用代码
     */
    private String creditCode;

    /**
     * 中心logo
     */
    private String logo;

    /**
     * 国家
     */
    private String country;

    /**
     * 所在省
     */
    private String prov;

    /**
     * 所在市
     */
    private String city;

    /**
     * 等级，1:三特 2:三甲 3:三乙 4:三丙 5:二甲 6:二乙 7:二丙 8:一甲 9:一乙 10:一丙
     */
    private Integer level;

    /**
     * 状态，1:待发布 2:已发布 3:已下架
     */
    private Integer status;

    /**
     * 是否入驻平台，0:否 1:是
     */
    private Integer isSettled;

    /**
     * 是否极速启动，0:否 1:是
     */
    private Integer isQuickStart;

    /**
     * 医院类型，1:I期病房 2:II/III期病房 3:药物备案 4:药械备案  多个以英文“,”分隔
     */
    private String centerType;

    /**
     * 优势
     */
    private String advantage;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 是否可合作咨询，0:否 1:是
     */
    private Integer isConsult;

    /**
     * 简介
     */
    private String profile;

    /**
     * 地址
     */
    private String address;

    /**
     * 联系电话
     */
    private String tel;

    /**
     * 官网
     */
    private String website;

    /**
     * 是否有遗传办递交经验，0:无 1:有
     */
    private Integer geHasExperience;

    /**
     * 遗传办联系人
     */
    private String geLinkman;

    /**
     * 遗传办联系人职位
     */
    private String gePosition;

    /**
     * 遗传办联系电话
     */
    private String geTel;

    /**
     * 遗传办联系人邮箱
     */
    private String geEmail;

    /**
     * 遗传办联系地址
     */
    private String geAddress;

    /**
     * 遗传办本院递交费用
     */
    private String geCharge;

    /**
     * 是否可以牵头递交遗传办，0:否 1:是
     */
    private Integer geCanDeliver;

    /**
     * 遗传办申请所需时间
     */
    private String geRequiredTime;

    /**
     * 机构办地址
     */
    private String orAddress;

    /**
     * 机构接待时间
     */
    private String orReceptionTime;

    /**
     * 机构电话
     */
    private String orTel;

    /**
     * 机构邮箱
     */
    private String orEmail;

    /**
     * 机构传真
     */
    private String orFax;

    /**
     * 机构项目资料递交网站
     */
    private String orProjectDeliverUrl;

    /**
     * 机构项目承接要求
     */
    private Integer orUndertakingRequirement;

    /**
     * 机构网址
     */
    private String orWebsite;

    /**
     * 机构资质
     */
    private String orQualification;

    /**
     * 机构简介
     */
    private String orProfile;

    /**
     * 机构文件存储收费年限
     */
    private Integer orStorageCostYear;

    /**
     * 机构合同审核特殊要求
     */
    private String orSpecialRequirement;

    /**
     * 机构合同签署流程
     */
    private String orContractFlow;

    /**
     * 机构定稿合同所需时间
     */
    private String orContractRequiredTime;

    /**
     * 机构开票单位全称
     */
    private String orBilledBy;

    /**
     * 机构单位账号
     */
    private Integer orAccount;

    /**
     * 机构单位开户行
     */
    private String orBank;

    /**
     * 机构单位开户支行
     */
    private String orBranch;

    /**
     * 机构市内清算行号
     */
    private Integer orUrbanClearingBankNo;

    /**
     * 机构市外清算行号
     */
    private Integer orSuburbanClearingBankNo;

    /**
     * 机构其他要求
     */
    private String orOtherRequirement;

    /**
     * 是否有医学伦理委员会，0:无 1:有
     */
    private Integer hasEthicsCommittee;

    /**
     * 伦理办地址
     */
    private String ecAddress;

    /**
     * 伦理接待时间
     */
    private String ecReceptionTime;

    /**
     * 伦理电话
     */
    private String ecTel;

    /**
     * 伦理邮箱
     */
    private String ecEmail;

    /**
     * 伦理传真
     */
    private String ecFax;

    /**
     * 伦理项目资料递交网站
     */
    private String ecProjectDeliverUrl;

    /**
     * 伦理资料递交网站
     */
    private String ecEthicsDeliverUrl;

    /**
     * 是否可以接受中心伦理，0:否 1:是
     */
    private Integer ecAcceptCenterEthics;

    /**
     * 伦理网址
     */
    private String ecWebsite;

    /**
     * 递交伦理审核材料前是否需立项，0:否 1:是
     */
    private Integer ecDeliverNeedItem;

    /**
     * 伦理委员会是否需要提供牵头单位伦理批件，0:否 1:是
     */
    private Integer ecNeedProvideEthics;

    /**
     * 对伦理审查文件要求
     */
    private String ecRequirement;

    /**
     * 伦理上会材料递交是否要求上传电子版，0:否 1:是
     */
    private Integer ecNeedUploadElectronic;

    /**
     * 伦理对电子版要求
     */
    private String ecElectronicRequirement;

    /**
     * 伦理其他说明
     */
    private String ecOtherExplain;

    /**
     * 伦理召开频率
     */
    private String ecFrequency;

    /**
     * 在伦理委员会开会前多长时间递交文件
     */
    private String ecTimeBeforeMeeting;

    /**
     * 会议通过后一般多久可以获得批件
     */
    private String ecTimeAfterMeeting;

    /**
     * 伦理审查是否需要支付费用，0:否 1:是
     */
    private Integer ecNeedPayCharge;

    /**
     * 伦理首次上会费用
     */
    private String ecFirstMeetingCharge;

    /**
     * 伦理后续上会费用
     */
    private String ecNextMeetingCharge;

    /**
     * 伦理快审费用
     */
    private String ecQuickReviewCharge;

    /**
     * 伦理备案费用
     */
    private String ecRecordCharge;

    /**
     * 伦理费用是否含税，0:否 1:是
     */
    private Integer ecChargeHasTax;

    /**
     * 伦理费用税点
     */
    private Integer ecChargeTax;

    /**
     * 伦理发票类型
     */
    private String ecInvoiceType;

    /**
     * 伦理发票附件
     */
    private String ecInvoiceAttachment;

    /**
     * 伦理费用支付要求
     */
    private String ecPaymentRequirement;

    /**
     * 伦理开票单位全称
     */
    private String ecBilledBy;

    /**
     * 伦理单位账号
     */
    private String ecAccount;

    /**
     * 伦理单位开户行
     */
    private String ecBank;

    /**
     * 伦理单位开户支行
     */
    private String ecBranch;

    /**
     * 伦理市内清算行号
     */
    private String ecUrbanClearingBankNo;

    /**
     * 伦理市外清算行号
     */
    private String ecSuburbanClearingBankNo;

    /**
     * 伦理其他要求
     */
    private String ecOtherRequirement;

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
     * 是否删除，
     */
    private Integer isDeleted;


}
