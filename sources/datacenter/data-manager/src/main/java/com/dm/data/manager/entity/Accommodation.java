package com.dm.data.manager.entity;

import com.dm.data.manager.entity.core.AbstractCurrency;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collections;
import java.util.List;

/**
 * 住宿场所
 *
 * @author LiDong
 *
 */
@Getter
@Setter
@Entity(name = "accommodation_")
public class Accommodation extends AbstractCurrency<Long> {

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
    @Column(name = "level_", length = 50)
    private String level;

    /**
     * 提供菜系
     */
    @Column(name = "provide_cuisines_", length = 200)
    private String provideCuisines;

    /**
     * 企业Logo
     */
    @Column(name = "corporate_logo_", length = 200)
    private String corporateLogo;

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
     * 房间类型
     */
    @Column(name = "the_room_type_", length = 50)
    private String theRoomType;

    @Column(name = "contact_user_")
    private String contactUser;

    /**
     * 房间数量
     */
    @Column(name = "the_room_number_")
    private Long theRoomNumber;

    /**
     * 可预订房间
     */
    @Column(name = "can_book_a_room_")
    private Long canBookARoom;

    /**
     * 正常价格
     catering_facilities     */
    @Column(name = "the_normal_price_", length = 200)
    private String theNormalPrice;

    /**
     * 节假日价格
     */
    @Column(name = "holiday_prices_", length = 200)
    private String holidayPrices;

    /**
     * 加床价
     */
    @Column(name = "extra_bed_price_", length = 200)
    private String extraBedPrice;

    /**
     * 服务设施描述
     */
    @Column(name = "services_described_")
    @Lob
    private String servicesDescribed;

    /**
     * 餐饮说明
     */
    @Column(name = "food_and_beverage_show_")
    @Lob
    private String foodAndBeverageShow;

    /**
     * 成立日期
     */
    @Column(name = "set_up_the_date_", length = 200)
    private String setUpTheDate;

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
     * 经营负责人
     */
    @Column(name = "operations_managers_", length = 200)
    private String operationsManagers;

    /**
     * 连锁经营情况
     */
    @Column(name = "chain_operation_situation_")
    @Lob
    private String chainOperationSituation;

    /**
     * 所属行业
     */
    @Column(name = "subordinate_to_the_industry_", length = 200)
    private String subordinateToTheIndustry;

    /**
     * 管理集团
     */
    @Column(name = "management_group_", length = 200)
    private String managementGroup;

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
     * 开业时间
     */
    @Column(name = "the_opening_time_", length = 200)
    private String theOpeningTime;

    /**
     * 最后一次装修时间
     */
    @Column(name = "the_last_time_to_decorate_", length = 200)
    private String theLastTimeToDecorate;

    /**
     * 总客房数
     */
    @Column(name = "the_total_number_of_rooms_")
    private Long theTotalNumberOfRooms;

    /**
     * 总床位数
     */
    @Column(name = "total_beds_")
    private Long totalBeds;

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
     * 咨询电话
     */
    @Column(name = "consulting_the_telephone_", length = 20)
    private String consultingTheTelephone;

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
     * 支持卡种
     */
    @Column(name = "support_of_card_", length = 50)
    private String supportOfCard;

    /**
     * 支付方式
     */
    @Column(name = "method_of_payment_", length = 50)
    private String methodOfPayment;

    /**
     * 宣传语
     */
    @Column(name = "slogan_", length = 200)
    private String slogan;

    /**
     * 周边信息
     */
    @Column(name = "surrounding_information_")
    @Lob
    private String surroundingInformation;

    /**
     * 会议设施和服务
     */
    @Column(name = "meeting_facilities_and_services_")
    @Lob
    private String meetingFacilitiesAndServices;

    /**
     * 餐饮设施和服务
     */
    @Column(name = "catering_facilities_and_services_")
    @Lob
    private String cateringFacilitiesAndServices;

    /**
     * 娱乐设施和服务
     */
    @Column(name = "entertainment_facilities_and_services_")
    @Lob
    private String entertainmentFacilitiesAndServices;

    /**
     * 商务设施和服务
     */
    @Column(name = "business_facilities_and_services_")
    @Lob
    private String businessFacilitiesAndServices;

    /**
     * 停车场
     */

    @OneToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST })
    @JoinColumn(name = "parking_lots_")
    private List<ParkingLot> parkingLots;

    @OneToMany(cascade = { CascadeType.ALL })
    @JoinColumn(name = "accommodation_room_infos_")
    private List<RoomInfo> roomInfos = Collections.emptyList();;
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
     * 评分
     */
    @Column(name = "scored_")
    private Double scored;

    /**
     * 最低价格
     */
    @Column(name = "min_price_")
    private Double minPrice;

    /**
     * 活跃度
     */
    @Column(name = "hot_index_")
    private String hotIndex;
}
