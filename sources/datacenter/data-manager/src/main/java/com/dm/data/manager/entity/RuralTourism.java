package com.dm.data.manager.entity;

import com.dm.data.manager.entity.core.AbstractCurrency;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

/**
 * 乡村旅游
 *
 * @author LiDong
 *
 */
@Getter
@Setter
@Entity(name = "rural_tourism_")
public class RuralTourism extends AbstractCurrency<Long> {

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
     * 所在区域
     */

    /**
     * 地理位置
     */

    /*** 经度 */
    @Column(name = "longitude_")
    private Double longitude;
    /*** 纬度 */
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
     * Logo
     */
    @Column(name = "logo_", length = 200)
    private String logo;

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
     * 简介
     */
    @Column(name = "introduction_")
    @Lob
    private String introduction;

    /**
     * 旅游特色
     */
    @Column(name = "tourism_features_", length = 200)
    private String tourismFeatures;

    /**
     * 注册日期
     */
    @Column(name = "registration_date_", length = 200)
    private String registrationDate;

    /**
     * 工商注册全称
     */
    @Column(name = "industrial_and_commercial_registration_name_", length = 50)
    private String industrialAndCommercialRegistrationName;

    /**
     * 营业执照号码
     */
    @Column(name = "business_license_number_", length = 200)
    private String businessLicenseNumber;

    /**
     * 企业工商字号
     */
    @Column(name = "company_of_industry_and_commerce_", length = 200)
    private String companyOfIndustryAndCommerce;

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
     * 经营负责人
     */
    @Column(name = "operations_managers_", length = 200)
    private String operationsManagers;

    /**
     * 从业人数
     */
    @Column(name = "employees_count_", length = 200)
    private String employeesCount;

    /**
     * 应急联系人
     */
    @Column(name = "emergency_contact_")
    private String emergencyContact;

    /**
     * 应急联系电话
     */
    @Column(name = "emergency_contact_phone_number_", length = 20)
    private String emergencyContactPhoneNumber;

    /**
     * 交通方式
     */
    @Column(name = "mode_of_transport_")
    private String modeOfTransport;

    /**
     * 交通描述
     */
    @Column(name = "traffic_description_")
    private String trafficDescription;

    /**
     * 新浪微博
     */
    @Column(name = "weibo_")
    private String weibo;

    /**
     * 腾讯微博
     */
    @Column(name = "tencent_weibo_")
    private String tencentWeibo;

    /**
     * 微信公众账号
     */
    @Column(name = "we_chat_public_account_")
    private String weChatPublicAccount;

    /**
     * 微信公众账号二维码
     */
    @Column(name = "we_chat_public_account_qr_code_")
    private String weChatPublicAccountQrCode;

    /**
     * 官方网站
     */
    @Column(name = "official_website_")
    private String officialWebsite;

    /**
     * 微网站
     */
    @Column(name = "micro_site_")
    private String microSite;

    /**
     * 安卓版APP下载地址
     */
    @Column(name = "android_app_download_url_")
    private String androidAppDownloadUrl;

    /**
     * 苹果版APP下载地址
     */
    @Column(name = "ios_app_download_url_")
    private String iosAppDownloadUrl;

    /**
     * 咨询电话
     */
    @Column(name = "consulting_the_telephone_", length = 20)
    private String consultingTheTelephone;

    /**
     * 投诉电话
     */
    @Column(name = "complaints_", length = 20)
    private String complaints;

    /**
     * 在线投诉地址
     */
    @Column(name = "online_complaints_address_", length = 200)
    private String onlineComplaintsAddress;

    /**
     * 传真
     */
    @Column(name = "fax_", length = 200)
    private String fax;

    /**
     * Email
     */
    @Column(name = "email_", length = 200)
    private String email;

    /**
     * 建议游玩季节
     */
    @Column(name = "recommended_play_season_", length = 200)
    private String recommendedPlaySeason;

    /**
     * 周边信息
     */
    @Column(name = "surrounding_information_", length = 200)
    private String surroundingInformation;

    /**
     * 同时就餐人数
     */
    @Column(name = "at_the_same_time_repast_number_")
    private Long atTheSameTimeRepastNumber;

    /**
     * 营业时间
     */
    @Column(name = "business_hours_", length = 200)
    private String businessHours;

    /**
     * 营业面积
     */
    @Column(name = "a_business_area_of_")
    private Long aBusinessAreaOf;

    /**
     * 人均消费
     */
    @Column(name = "per_capita_consumption_", length = 200)
    private String perCapitaConsumption;

    /**
     * 支持卡种
     */
    @Column(name = "support_of_card_", length = 50)
    private String supportOfCard;

    /**
     * 支付方式
     */
    @Column(name = "method_of_payment_", length = 50)
    private String methodOfPayment;

    @OneToMany(cascade = CascadeType.ALL)
    private List<ParkingLot> parkingLots;

    @OneToMany(cascade = CascadeType.ALL)
    private List<TouristToilet> touristToilets;
    /**
     * 图片库
     */

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

}
