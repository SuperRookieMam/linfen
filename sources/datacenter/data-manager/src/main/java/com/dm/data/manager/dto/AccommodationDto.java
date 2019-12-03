package com.dm.data.manager.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Collections;
import java.util.List;

/**
 * 住宿场所
 *
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class AccommodationDto extends AbstractRegionDto {
    private static final long serialVersionUID = 1L;

    /**
     * 编号
     */
    public String no;

    /**
     * 资源编码
     */
    private Long id;
    /**
     * 联系人
     */
    private String contactUser;

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
     * 经度
     */
    private Double longitude;

    /**
     * 纬度
     */
    private Double latitude;

    /**
     * 地址
     */
    private String address;

    /**
     * 类型
     */
    private String type;

    /**
     * 等级
     */
    private String level;

    /**
     * 提供菜系
     */
    private String provideCuisines;

    /**
     * 企业Logo
     */
    private String corporateLogo;

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
     * 房间类型
     */
    private String theRoomType;

    /**
     * 房间数量
     */
    private Long theRoomNumber;

    /**
     * 可预订房间
     */
    private Long canBookARoom;

    /**
     * 正常价格
     */
    private String theNormalPrice;

    /**
     * 节假日价格
     */
    private String holidayPrices;

    /**
     * 加床价
     */
    private String extraBedPrice;

    /**
     * 服务设施描述
     */
    private String servicesDescribed;

    /**
     * 餐饮说明
     */
    private String foodAndBeverageShow;

    /**
     * 成立日期
     */
    private String setUpTheDate;

    /**
     * 工商注册全称
     */
    private String industrialAndCommercialRegistrationName;

    /**
     * 营业执照号码
     */
    private String businessLicenseNumber;

    /**
     * 组织机构代码
     */
    private String organizationCode;

    /**
     * 统一社会信用代码
     */
    private String unifiedSocialCreditCode;

    /**
     * 法人代表
     */
    private String legalRepresentative;

    /**
     * 经营负责人
     */
    private String operationsManagers;

    /**
     * 连锁经营情况
     */
    private String chainOperationSituation;

    /**
     * 所属行业
     */
    private String subordinateToTheIndustry;

    /**
     * 管理集团
     */
    private String managementGroup;

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
     * 官网地址
     */
    private String theWebsiteAddress;

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
     * 开业时间
     */
    private String theOpeningTime;

    /**
     * 最后一次装修时间
     */
    private String theLastTimeToDecorate;

    /**
     * 总客房数
     */
    private Long theTotalNumberOfRooms;

    /**
     * 总床位数
     */
    private Long totalBeds;

    /**
     * 投诉电话
     */
    private String complaints;

    /**
     * 在线投诉地址
     */
    private String onlineComplaintsAddress;

    /**
     * 咨询电话
     */
    private String consultingTheTelephone;

    /**
     * 传真
     */
    private String fax;

    /**
     * 电子邮件
     */
    private String email;

    /**
     * 支持卡种
     */
    private String supportOfCard;

    /**
     * 支付方式
     */
    private String methodOfPayment;

    /**
     * 宣传语
     */
    private String slogan;

    /**
     * 周边信息
     */
    private String surroundingInformation;

    /**
     * 会议设施和服务
     */
    private String meetingFacilitiesAndServices;

    /**
     * 餐饮设施和服务
     */
    private String cateringFacilitiesAndServices;

    /**
     * 娱乐设施和服务
     */
    private String entertainmentFacilitiesAndServices;

    /**
     * 商务设施和服务
     */
    private String businessFacilitiesAndServices;

    /**
     * 停车场
     */

    private List<ParkingLotDto> parkingLots = Collections.emptyList();

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

    private List<RoomInfoDto> roomInfos = Collections.emptyList();

    private Double scored;

    private Double minPrice;

    /**
     * 活跃度
     */
    private String hotIndex;
}
