package com.dm.data.manager.entity;

import com.dm.data.manager.entity.core.AbstractCurrency;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

/**
 * 餐饮场所
 *
 * @author LiDong
 *
 */
@Getter
@Setter
@Entity(name = "dining_place_")
public class DiningPlace extends AbstractCurrency<Long> {

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
    @Column(name = "level_", length = 50)
    private String level;

    /**
     * 档次
     */
    @Column(name = "the_grade_of_", length = 50)
    private String theGradeOf;

    /**
     * 餐馆Logo
     */
    @Column(name = "the_restaurant_logo_", length = 200)
    private String theRestaurantLogo;

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
     * 推荐菜
     */
    @Column(name = "recommended_dishes_", length = 200)
    private String recommendedDishes;

    /**
     * 荣誉资质
     */
    @Column(name = "honorary_certificate_", length = 200)
    private String honoraryCertificate;

    /**
     * 简介
     */
    @Column(name = "introduction_")
    @Lob
    private String introduction;

    /**
     * 注册日期
     */
    @Column(name = "registration_date_", length = 200)
    private String registrationDate;

    /**
     * 工商注册全称
     */
    @Column(name = "industrial_and_commercial_registration_name_", length = 200)
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
     * 从业人数
     */
    @Column(name = "employees_count_", length = 200)
    private String employeesCount;

    /**
     * 法人代表
     */
    @Column(name = "legal_representative_", length = 200)
    private String legalRepresentative;

    /**
     * 经营负责人
     */
    @Column(name = "operations_managers_", length = 200)
    private String operationsManagers;

    /**
     * 应急联系人
     */
    @Column(name = "emergency_contact_", length = 200)
    private String emergencyContact;

    /**
     * 应急联系电话
     */
    @Column(name = "emergency_contact_phone_number_", length = 20)
    private String emergencyContactPhoneNumber;

    /**
     * 连锁经营情况
     */
    @Column(name = "chain_operation_situation_")
    @Lob
    private String chainOperationSituation;

    /**
     * 品牌
     */
    @Column(name = "brand_", length = 200)
    private String brand;

    /**
     * 管理公司名称
     */
    @Column(name = "management_of_the_company_name_", length = 200)
    private String managementOfTheCompanyName;

    /**
     * 交通方式
     */
    @Column(name = "mode_of_transport_", length = 50)
    private String modeOfTransport;

    /**
     * 交通描述
     */
    @Column(name = "traffic_description_")
    @Lob
    private String trafficDescription;

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
    @Column(name = "we_chat_public_account_qr_code_", length = 200)
    private String weChatPublicAccountQrCode;

    /**
     * 官网地址
     */
    @Column(name = "the_website_address_", length = 200)
    private String theWebsiteAddress;

    /**
     * 微网站
     */
    @Column(name = "micro_site_", length = 200)
    private String microSite;

    /**
     * 安卓版APP下载地址
     */
    @Column(name = "android_app_download_url_", length = 200)
    private String androidAppDownloadUrl;

    /**
     * 苹果版APP下载地址
     */
    @Column(name = "ios_app_download_url_", length = 200)
    private String iosAppDownloadUrl;

    /**
     * 营业时间
     */
    @Column(name = "business_hours_", length = 200)
    private String businessHours;

    /**
     * 预定电话
     */
    @Column(name = "due_to_the_phone_", length = 20)
    private String dueToThePhone;

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
     * 同时就餐人数
     */
    @Column(name = "at_the_same_time_repast_number_", length = 200)
    private String atTheSameTimeRepastNumber;

    /**
     * 包间数
     */
    @Column(name = "number_of_rooms_", length = 200)
    private String numberOfRooms;

    /**
     * 特色菜品
     */
    @Column(name = "dishes_with_", length = 200)
    private String dishesWith;

    /**
     * 人均消费
     */
    @Column(name = "per_capita_consumption_", length = 200)
    private String perCapitaConsumption;

    /**
     * 周边信息
     */
    @Column(name = "surrounding_information_")
    @Lob
    private String surroundingInformation;

    /**
     * 支持卡种
     */
    @Column(name = "support_of_card_", length = 50)
    private String supportOfCard;
    @Column(name = "score_")
    private Double score;

    /**
     * 支付方式
     */
    @Column(name = "method_of_payment_", length = 50)
    private String methodOfPayment;

    /**
     * 停车场
     */

    @OneToMany(cascade = CascadeType.ALL)
    private List<ParkingLot> parkingLots;

    /**
     * 图片库
     */

    @OneToMany
    private List<Image> images;

    /**
     * 视频库
     */

    @Column(name = "video_library_", length = 200)
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
