package com.dm.data.manager.entity;

import com.dm.data.manager.entity.core.AbstractCurrency;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import java.util.List;

/**
 * 旅行社
 *
 * @author LiDong
 *
 */
@Getter
@Setter
@Entity(name = "travel_agent_field_")
public class TravelAgentcy extends AbstractCurrency<Long> {

    /**
     * 中文全称
     */
    @Column(name = "chinese_full_name_", length = 50)
    private String chineseFullName;

    /**
     * 中文简称
     */
    @Column(name = "chinese_short_name_", length = 20)
    private String chineseShortName;

    /**
     * 拼音名称
     */
    @Column(name = "pinyin_name_", length = 50)
    private String pinyinName;

    /**
     * 英文名称
     */
    @Column(name = "english_name_", length = 100)
    private String englishName;

    /**
     * 经度
     */
    @Column(name = "longitude_")
    private Double longitude;

    /**
     * 纬度
     */
    @Column(name = "latitude_")
    private Double latitude;

    /**
     * 地址
     */
    @Column(name = "address_", length = 200)
    private String address;

    /**
     * 类型
     */
    @Column(name = "type_", length = 50)
    private String type;

    /**
     * 等级
     */
    @Column(name = "level_", length = 20)
    private String level;

    /**
     * 经营业务
     */
    @Column(name = "business_", length = 200)
    private String business;

    /**
     * 服务语种
     */
    @Column(name = "service_language_", length = 200)
    private String serviceLanguage;

    /**
     * 荣誉称号
     */
    @Column(name = "title_of_honor_", length = 200)
    private String titleOfHonor;

    /**
     * 关键字
     */
    @Column(name = "keywords_", length = 200)
    private String keywords;

    /**
     * 标签
     */
    @Column(name = "label_", length = 200)
    private String label;

    /**
     * 旅行社Logo
     */
    @Column(name = "travel_agency_logo_", length = 200)
    private String theTravelAgencyLogo;
    @Column(name = "score_")
    private Double score;

    /**
     * 简介
     */
    @Column(name = "introduction_")
    @Lob
    private String introduction;

    /**
     * 成立日期
     */
    @Column(name = "set_up_the_date_", length = 50)
    private String setUpTheDate;

    /**
     * 工商注册全称
     */
    @Column(name = "industrial_and_commercial_registration_name_", length = 200)
    private String industrialAndCommercialRegistrationName;

    /**
     * 营业执照号码
     */
    @Column(name = "business_license_number_")
    @Lob
    private String businessLicenseNumber;

    /**
     * 组织机构代码
     */
    @Column(name = "organization_code_", length = 200)
    private String organizationCode;

    /**
     * 统一社会信用代码
     */
    @Column(name = "unified_social_credit_code_", length = 200)
    private String unifiedSocialCreditCode;

    /**
     * 法人代表
     */
    @Column(name = "legal_representative_", length = 200)
    private String legalRepresentative;

    /**
     * 旅游合同
     */
    @Column(name = "the_travel_contract_")
    @Lob
    private String theTravelContract;

    /**
     * 保证金金额
     */
    @Column(name = "deposit_amount_", length = 200)
    private String depositAmount;

    /**
     * 应急联系人
     */
    @Column(name = "emergency_contact_", length = 200)
    private String emergencyContact;

    /**
     * 应急联系电话
     */
    @Column(name = "emergency_contact_phone_number_", length = 200)
    private String emergencyContactPhoneNumber;

    /**
     * 所属旅游集团
     */
    @Column(name = "by_travel_group_", length = 200)
    private String byTravelGroup;

    /**
     * 业务范围
     */
    @Column(name = "the_business_scope_")
    @Lob
    private String theBusinessScope;

    /**
     * 旅行社分社
     */
    @Column(name = "travel_agency_bureau_chief_")
    @Lob
    private String theTravelAgencyBureauChief;

    /**
     * 旅行社服务网点
     */
    @Column(name = "travel_agency_service_outlets_")
    @Lob
    private String travelAgencyServiceOutlets;

    /**
     * 新浪微博
     */
    @Column(name = "weibo_", length = 200)
    private String weibo;

    /**
     * 腾讯微博
     */
    @Column(name = "tencent_weibo_", length = 200)
    private String tencentWeibo;

    /**
     * 微信公众账号
     */
    @Column(name = "we_chat_public_account_", length = 200)
    private String weChatPublicAccount;

    /**
     * 微信公众账号二维码
     */
    @Column(name = "we_chat_public_account_qr_code_")
    @Lob
    private String weChatPublicAccountQrCode;

    /**
     * 官网地址
     */
    @Column(name = "the_website_address_")
    @Lob
    private String theWebsiteAddress;

    /**
     * 微网站
     */
    @Column(name = "micro_site_")
    @Lob
    private String microSite;

    /**
     * 安卓版APP下载地址
     */
    @Column(name = "android_app_download_url_")
    @Lob
    private String androidAppDownloadUrl;

    /**
     * 苹果版APP下载地址
     */
    @Column(name = "ios_app_download_url_")
    @Lob
    private String iosAppDownloadUrl;

    /**
     * 投诉电话
     */
    @Column(name = "complaints_", length = 20)
    private String complaints;

    /**
     * 在线投诉地址
     */
    @Column(name = "online_complaints_address_")
    @Lob
    private String onlineComplaintsAddress;

    /**
     * 预订电话
     */
    @Column(name = "reservation_phone_", length = 200)
    private String reservationPhone;

    /**
     * 客服电话
     */
    @Column(name = "customer_service_telephone_", length = 200)
    private String customerServiceTelephone;

    /**
     * 传真
     */
    @Column(name = "fax_", length = 200)
    private String fax;

    /**
     * 电子邮件
     */
    @Column(name = "email_", length = 200)
    private String email;

    /**
     * 营业时间
     */
    @Column(name = "business_hours_", length = 200)
    private String businessHours;

    /**
     * 支持卡种
     */
    @Column(name = "support_of_card_")
    @Lob
    private String supportOfCard;

    /**
     * 支付方式
     */
    @Column(name = "method_of_payment_", length = 200)
    private String methodOfPayment;

    /**
     * 导游人员简介
     */
    @Column(name = "guides_personnel_introduction_")
    @Lob
    private String guidesPersonnelIntroduction;

    /**
     * 图片库
     */
    @Column(name = "the_gallery_")
    @Lob
    @OneToMany

    private List<Image> images;

    /**
     * 视频库
     */
    @OneToMany

    private List<Video> videos;

    /**
     * 音频库
     */

    @OneToMany
    private List<Audio> audios;

    /**
     * 虚拟素材库
     */

    @OneToMany
    private List<VirtualMaterial> virtualMaterials;
    /**
     * 活跃度
     */
    @Column(name = "hot_index_")
    private String hotIndex;
}
