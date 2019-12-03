package com.dm.data.manager.entity;

import com.dm.data.manager.entity.core.AbstractCurrency;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.Collections;
import java.util.List;

/**
 * 汽车租赁公司
 *
 * @author LiDong
 *
 */
@Getter
@Setter
@Entity(name = "car_rental_company_")
public class CarRentalCompany extends AbstractCurrency<Long> {

    /**
     * 中文名称
     */
    @Column(name = "chinese_name_", length = 50)
    private String chineseName;

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
     * 汽车租赁公司品牌
     */
    @Column(name = "brand_", length = 50)
    private String brand;

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
     * 是否认证
     */
    @Column(name = "authenticationed_")
    private Boolean authenticationed;

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
     * 公司Logo
     */
    @Column(name = "logo", length = 200)
    private String logo;

    /**
     * 所属公司
     */
    @Column(name = "company_", length = 200)
    private String company;

    /**
     * 车型
     */
    @Column(name = "models_", length = 200)
    private String models;

    /**
     * 计费标准
     */
    @Column(name = "charge_standard_", length = 200)
    private String chargeStandard;

    /**
     * 简介
     */
    @Column(name = "introduction_")
    @Lob
    private String introduction;

    /**
     * 企业工商注册全称
     */
    @Column(name = "full_name_companies_", length = 50)
    private String fullNameCompanies;

    /**
     * 营业执照号码
     */
    @Column(name = "business_license_no_", length = 200)
    private String businessLicenseNo;

    /**
     * 企业工商字号
     */
    @Column(name = "company_industry_", length = 200)
    private String companyIndustry;

    /**
     * 组织机构代码
     */
    @Column(name = "organization_code_", length = 50)
    private String organizationCode;

    /**
     * 许可证号
     */
    @Column(name = "license_", length = 50)
    private String license;

    /**
     * 统一社会信用代码
     */
    @Column(name = "unified_social_credit_code_", length = 50)
    private String unifiedSocialCreditCode;

    /**
     * 行业代码
     */
    @Column(name = "industry_code_", length = 200)
    private String industryCode;

    /**
     * 登记机关
     */
    @Column(name = "registration_authority_", length = 200)
    private String registrationAuthority;

    /**
     * 受理单位
     */
    @Column(name = "accept_unit_", length = 200)
    private String acceptUnit;

    /**
     * 成立日期
     */
    @Column(name = "set_up_date_", length = 200)
    private ZonedDateTime setUpDate;

    /**
     * 核准日期
     */
    @Column(name = "approval_date_", length = 200)
    private ZonedDateTime approvalDate;

    /**
     * 吊销日期
     */
    @Column(name = "revocation_date_", length = 200)
    private ZonedDateTime revocationDate;

    /**
     * 注销日期
     */
    @Column(name = "cancellation_date_", length = 200)
    private ZonedDateTime cancellationDate;

    /**
     * 有效期
     */
    @Column(name = "validity_period_", length = 200)
    private String validityPeriod;

    /**
     * 注册资本
     */
    @Column(name = "registered_capital_")
    private Double registeredCapital;

    /**
     * 行业类别
     */
    @Column(name = "industry_categories_", length = 50)
    private String industryCategories;

    /**
     * 法人代表
     */
    @Column(name = "legal_representative_", length = 20)
    private String legalRepresentative;

    /**
     * 经营负责人
     */
    @Column(name = "operations_managers_", length = 20)
    private String operationsManagers;

    /**
     * 从业人数
     */
    @Column(name = "employees_count_")
    private Integer employeesCount;

    /**
     * 应急联系人
     */
    @Column(name = "emergency_contact_", length = 20)
    private String emergencyContact;

    /**
     * 应急联系电话
     */
    @Column(name = "emergency_contact_phone_number_", length = 20)
    private String emergencyContactPhoneNumber;

    /**
     * 业务范围
     */
    @Column(name = "business_scope_")
    @Lob
    private String businessScope;

    /**
     * 新浪微博
     */
    @Column(name = "sina_weibo_", length = 200)
    private String sinaWeibo;

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
    @Column(name = "website_", length = 200)
    private String website;

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
     * 投诉电话
     */
    @Column(name = "complaints_", length = 20)
    private String complaints;

    /**
     * 客服电话
     */
    @Column(name = "customer_service_telephone_", length = 20)
    private String customerServiceTelephone;

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
     * 营业时间
     */
    @Column(name = "business_times_", length = 200)
    private String businessTimes;

    /**
     * 支持卡种
     */
    @Column(name = "support_cards_", length = 200)
    private String supportCards;

    /**
     * 支付方式
     */
    @Column(name = "payment_method_", length = 200)
    private String paymentMethod;

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

    /**
     * 车辆信息
     */

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "cars_")
    private List<Car> cars = Collections.emptyList();

}
