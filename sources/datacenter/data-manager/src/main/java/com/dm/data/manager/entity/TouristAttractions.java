package com.dm.data.manager.entity;

import com.dm.data.manager.entity.core.AbstractCurrency;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

/**
 * 旅游景区
 *
 * @author LiDong
 *
 */
@Getter
@Setter
@Entity(name = "tourist_attractions_")
public class TouristAttractions extends AbstractCurrency<Long> {

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
     * 中文别名
     */
    @Column(name = "chinese_nicknames_", length = 50)
    private String chineseNicknames;

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
     * 荣誉称号
     */
    @Column(name = "title_of_honor_", length = 200)
    private String titleOfHonor;

    /**
     * 景区等级
     */
    @Column(name = "area_level_", length = 20)
    private String areaLevel;

    /**
     * 评级时间
     */
    @Column(name = "rating_time_", length = 20)
    private String ratingTime;

    /**
     * 景区类型
     */
    @Column(name = "scenic_spot_type_", length = 50)
    private String scenicSpotType;

    /**
     * 景区管理机构
     */
    @Column(name = "scenic_management_", length = 50)
    private String scenicManagement;

    /**
     * 景区Logo
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
     * 景区特色
     */
    @Column(name = "characteristic_")
    @Lob
    private String characteristic;

    /**
     * 类型
     */
    @Column(name = "type_", length = 50)
    private String type;

    /**
     * 起止时间
     */
    @Column(name = "start_stop_time_", length = 200)
    private String startStopTime;

    /**
     * 价格
     */
    @Column(name = "price_", length = 10)
    private String price;

    /**
     * 说明
     */
    @Column(name = "instructions_")
    @Lob
    private String instructions;

    /**
     * 购买方式
     */
    @Column(name = "buying_patterns_")
    @Lob
    private String buyingPatterns;

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
     * 腾讯微博
     */
    @Column(name = "contact_man_", length = 200)
    private String contactMan;
    /**
     * 腾讯微博
     */
    @Column(name = "contact_mobile_", length = 200)
    private String contactMobile;

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
    @Column(name = "fax_", length = 20)
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
    @Column(name = "financial_network_")
    @Lob
    private String financialNetwork;

    /**
     * 支持卡种
     */
    @Column(name = "support_of_card_")
    @Lob
    private String supportOfCard;

    /**
     * 支付方式
     */
    @Column(name = "method_of_payment_")
    @Lob
    private String methodOfPayment;

    /**
     * 建议游玩季节
     */
    @Column(name = "recommended_play_season_", length = 200)
    private String recommendedPlaySeason;

    /**
     * 人均消费
     */
    @Column(name = "per_capita_consumption_", length = 200)
    private String perCapitaConsumption;

    /**
     * 景区旅游项目
     */
    @Column(name = "tourism_project_")
    @Lob
    private String tourismProject;

    /**
     * 推荐旅游线路
     */
    @Column(name = "recommended_travel_")
    @Lob
    private String recommendedTravel;

    /**
     * 旅游提示
     */
    @Column(name = "travel_tips_")
    @Lob
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
    @Column(name = "tourism_activities_")
    @Lob
    private String tourismActivities;

    /**
     * 工作时间
     */
    @Column(name = "working_time_", length = 20)
    private String workingTime;

    /**
     * 咨询电话
     */
    @Column(name = "consulting_the_telephone_", length = 20)
    private String consultingTheTelephone;

    /**
     * 服务内容
     */
    @Column(name = "the_service_content_")
    @Lob
    private String theServiceContent;

    /**
     * 设施设备
     */
    @Column(name = "facilities_")
    @Lob
    private String facilities;

    /**
     * 设施设备
     */
    @Column(name = "home_pic_")
    private String homePic;

    /**
     * 首图位置
     */
    @Column(name = "home_type_")
    private Integer homeType = 0;

    @Column(name = "show_")
    private Boolean show = false;

    /**
     * 旅游厕所
     */

    @OneToMany(cascade = CascadeType.ALL)
    private List<TouristToilet> tourismToilet;

    /**
     * 停车场
     */

    @OneToMany(cascade = CascadeType.ALL)
    private List<ParkingLot> parkingLots;

    /**
     * 景区示意图
     */
    @Column(name = "the_scenic_spot_diagram_")
    @Lob
    private String theScenicSpotDiagram;

    /**
     * 景区导览图
     */
    @Column(name = "the_scenic_spot_tour_figure_")
    @Lob
    private String theScenicSpotTourFigure;

    /**
     * 景区讲解员
     */
    @OneToMany(cascade = CascadeType.ALL)
    @Column(name = "tourist_guides_")
    private List<TouristGuide> touristGuides;
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
     * 景点基本信息
     */
    @Column(name = "attractions_basic_information_")
    @Lob
    private String attractionsBasicInformation;

    /**
     * 舒适度
     */
    @Column(name = "comfort_leve_")
    private String comfortLeve;

    /**
     * 推荐指数
     */
    @Column(name = "recommendation_")
    private String recommendation;

    /**
     * 开业时间
     */
    @Column(name = "ropening_day_")
    private String openingDay;

    /**
     * 活跃度
     */
    @Column(name = "hot_index_")
    private String hotIndex;
}
