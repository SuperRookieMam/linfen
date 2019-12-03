package com.dm.data.manager.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Collections;
import java.util.List;

/**
 * 旅游景区
 *
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class TouristAttractionsDto extends AbstractRegionDto {
    private static final long serialVersionUID = 1L;

    /**
     * 编号
     */
    public String no;

    /**
     * 省会编码
     */

    /**
     * 城市编码
     */
    /** 区划名称 **/

    /**
     * 区县编码
     */

    /**
     * 资源编码
     */
    private Long id;

    /**
     * 中文全称
     */
    private String chineseFullName;

    /**
     * 中文简称
     */
    private String chineseShortName;

    /**
     * 中文别名
     */
    private String chineseNicknames;

    /**
     * 拼音名称
     */
    private String pinyinName;

    /**
     * 英文名称
     */
    private String englishName;

    /**
     * 所在区域
     */

    /**
     * 地理位置
     */
    /** 经度 **/
    private Double longitude;
    /** 纬度度 **/
    private Double latitude;

    /**
     * 地址
     */
    private String address;

    /**
     * 荣誉称号
     */
    private String titleOfHonor;

    /**
     * 景区等级
     */
    private String areaLevel;

    /**
     * 评级时间
     */
    private String ratingTime;

    /**
     * 景区类型
     */
    private String scenicSpotType;

    /**
     * 景区管理机构
     */
    private String scenicManagement;

    /**
     * 景区Logo
     */
    private String logo;

    /**
     * 关键字
     */
    private String keywords;

    /**
     * 标签
     */
    private String label;

    /**
     * 简介
     */
    private String introduction;

    /**
     * 景区特色
     */
    private String characteristic;

    /**
     * 类型
     */
    private String type;

    /**
     * 起止时间
     */
    private String startStopTime;

    /**
     * 价格
     */
    private String price;

    /**
     * 说明
     */
    private String instructions;

    /**
     * 购买方式
     */
    private String buyingPatterns;

    /**
     * 交通方式
     */
    private String modeOfTransport;

    /**
     * 交通描述
     */
    private String trafficDescription;

    /**
     * 新浪微博
     */
    private String weibo;

    /**
     * 腾讯微博
     */
    private String tencentWeibo;

    /**
     * 微信公众账号
     */
    private String weChatPublicAccount;

    /**
     * 微信公众账号二维码
     */
    private String weChatPublicAccountQrCode;

    /**
     * 官网网站
     */
    private String officialWebSite;

    /**
     * 微网站
     */
    private String microSite;

    /**
     * 安卓版APP下载地址
     */
    private String androidAppDownloadUrl;

    /**
     * 苹果版APP下载地址
     */
    private String iosAppDownloadUrl;

    /**
     * 投诉电话
     */
    private String complaints;

    /**
     * 在线投诉地址
     */
    private String onlineComplaintsAddress;

    /**
     * 救援电话
     */
    private String rescueTheTelephone;

    /**
     * 预订电话
     */
    private String reservationPhone;

    /**
     * 客服电话
     */
    private String customerServiceTelephone;

    /**
     * 传真
     */
    private String fax;

    /**
     * Email
     */
    private String email;

    /**
     * 开放时间
     */
    private String openTime;

    /**
     * 最大承载量
     */
    private Long largestCapacity;

    /**
     * 游览时长
     */
    private String theVisitingTime;

    /**
     * 总停车位
     */
    private Long totalParkingSpaces;

    /**
     * 金融网点
     */
    private String financialNetwork;

    /**
     * 支持卡种
     */
    private String supportOfCard;

    /**
     * 支付方式
     */
    private String methodOfPayment;

    /**
     * 建议游玩季节
     */
    private String recommendedPlaySeason;

    /**
     * 人均消费
     */
    private String perCapitaConsumption;

    /**
     * 景区旅游项目
     */
    private String tourismProject;

    /**
     * 推荐旅游线路
     */
    private String recommendedTravel;

    /**
     * 旅游提示
     */
    private String travelTips;

    /**
     * 适合人群
     */
    private String suitsTheCrowd;

    /**
     * 周边信息
     */
    private String surroundingInformation;

    /**
     * 旅游活动
     */
    private String tourismActivities;

    /**
     * 工作时间
     */
    private String workingTime;

    /**
     * 咨询电话
     */
    private String consultingTheTelephone;

    /**
     * 服务内容
     */
    private String theServiceContent;

    /**
     * 设施设备
     */
    private String facilities;

    /**
     * 景区讲解员
     *//*
        * private String theScenicAreaTheNarrator;
        */
    /**
     * 景区讲解员
     */

    private List<TouristGuideDto> touristGuides = Collections.emptyList();
    /**
     * 旅游厕所
     */

    private List<TouristToiletDto> tourismToilet = Collections.emptyList();

    /**
     * 停车场
     */

    private List<ParkingLotDto> parkingLots = Collections.emptyList();

    /**
     * 景区示意图
     */
    private String theScenicSpotDiagram;

    /**
     * 景区导览图
     */
    private String theScenicSpotTourFigure;

    /**
     * 图片库
     */
    private List<ImageDto> images;

    /**
     * 视频库
     */

    private List<VideoDto> videos;

    /**
     * 音频库
     */

    private List<AudioDto> audios;

    /**
     * 虚拟素材库
     */

    private List<VirtualMaterialDto> virtualMaterials;

    /**
     * 景点基本信息
     */
    private String attractionsBasicInformation;

    private String homePic;
    /**
     * 首图位置
     */
    private Integer homeType;

    private Boolean show = false;

    /**
     * 舒适度
     */
    private String comfortLeve;

    /**
     * 推荐指数
     */
    private String recommendation;

    /**
     * 开业时间
     */
    private String openingDay;

    /**
     * 腾讯微博
     */
    private String contactMan;
    /**
     * 腾讯微博
     */
    private String contactMobile;

    /**
     * 活跃度
     */
    private String hotIndex;
}
