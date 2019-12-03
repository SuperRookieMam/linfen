package com.dm.data.manager.entity;

import com.dm.data.manager.entity.core.AbstractCurrency;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

/**
 * 科技文化馆
 *
 * @author LiDong
 *
 */
@Getter
@Setter
@Entity(name = "science_and_technology_culture_center_")
public class ScienceAndTechnologyCultureCenter extends AbstractCurrency<Long> {

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
     * 荣誉称号
     */
    @Column(name = "title_of_honor_", length = 200)
    private String titleOfHonor;

    /**
     * 建设时间
     */
    @Column(name = "the_construction_time_", length = 200)
    private String theConstructionTime;

    /**
     * 占地面积
     */
    @Column(name = "covers_of_area_", length = 200)
    private Long coversOfArea;

    /**
     * 场馆类型
     */
    @Column(name = "venue_type_", length = 50)
    private String venueType;

    /**
     * 交通方式
     */
    @Column(name = "mode_of_transport_", length = 50)
    private String modeOfTransport;

    /**
     * 交通描述
     */
    @Column(name = "traffic_description_", length = 50)
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
     * 官网网站
     */
    @Column(name = "official_web_site_", length = 200)
    private String officialWebSite;

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
     * 在线投诉地址
     */
    @Column(name = "online_complaints_address_", length = 200)
    private String onlineComplaintsAddress;

    /**
     * 救援电话
     */
    @Column(name = "rescue_the_telephone_", length = 20)
    private String rescueTheTelephone;

    /**
     * 预订电话
     */
    @Column(name = "reservation_phone_", length = 20)
    private String reservationPhone;

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
     * 开放时间
     */
    @Column(name = "open_time_", length = 200)
    private String openTime;

    /**
     * 最大承载量
     */
    @Column(name = "largest_capacity_")
    private Long largestCapacity;

    /**
     * 游览时长
     */
    @Column(name = "the_visiting_time_", length = 200)
    private String theVisitingTime;

    /**
     * 总停车位
     */
    @Column(name = "total_parking_spaces_")
    private Long totalParkingSpaces;

    /**
     * 金融网点
     */
    @Column(name = "financial_network_", length = 200)
    private String financialNetwork;

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
     * 旅游提示
     */
    @Column(name = "travel_tips_", length = 200)
    private String travelTips;

    /**
     * 适合人群
     */
    @Column(name = "suits_the_crowd_", length = 200)
    private String suitsTheCrowd;

    /**
     * 周边信息
     */
    @Column(name = "surrounding_information_")
    @Lob
    private String surroundingInformation;

    /**
     * 旅游活动
     */
    @Column(name = "tourism_activities_", length = 200)
    private String tourismActivities;

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
     * 旅游厕所
     */

    @OneToMany(cascade = CascadeType.ALL)
    private List<TouristToilet> touristToilets;

    /**
     * 停车场
     */

    @OneToMany(cascade = CascadeType.ALL)
    private List<ParkingLot> parkingLots;

}
