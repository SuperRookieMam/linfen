package com.dm.data.manager.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Collections;
import java.util.List;

/**
 * 科技文化馆
 *
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class ScienceAndTechnologyCultureCenterDto extends AbstractRegionDto {
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
     * Logo
     */
    private String logo;

    /**
     * 关键字
     */
    private String keywords;

    /**
     * 荣誉称号
     */
    private String titleOfHonor;

    /**
     * 建设时间
     */
    private String theConstructionTime;

    /**
     * 占地面积
     */
    private Long coversOfArea;

    /**
     * 场馆类型
     */
    private String venueType;

    /**
     * 交通方式
     */
    private String modeOfTransport;

    /**
     * 交通描述
     */
    private String trafficDescription;

    /**
     * ` 新浪微博
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
     * 旅游厕所
     */

    private List<TouristToiletDto> touristToilets = Collections.emptyList();

    /**
     * 停车场
     */

    private List<ParkingLotDto> parkingLots = Collections.emptyList();

}
