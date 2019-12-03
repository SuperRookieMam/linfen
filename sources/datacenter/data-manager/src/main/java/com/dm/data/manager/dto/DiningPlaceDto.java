package com.dm.data.manager.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Collections;
import java.util.List;

/**
 * 餐饮场所
 *
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class DiningPlaceDto extends AbstractRegionDto {
    private static final long serialVersionUID = 1L;

    private Double score;

    /**
     * 编号
     */
    public String no;

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
     * 经度
     */
    private Double longitude;
    /**
     * 纬度度
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
     * 档次
     */
    private String theGradeOf;

    /**
     * 餐馆Logo
     */
    private String theRestaurantLogo;

    /**
     * 关键字
     */
    private String keywords;

    /**
     * 标签
     */
    private String label;

    /**
     * 推荐菜
     */
    private String recommendedDishes;

    /**
     * 荣誉资质
     */
    private String honoraryCertificate;

    /**
     * 简介
     */
    private String introduction;

    /**
     * 注册日期
     */
    private String registrationDate;

    /**
     * 工商注册全称
     */
    private String industrialAndCommercialRegistrationName;

    /**
     * 营业执照号码
     */
    private String businessLicenseNumber;

    /**
     * 企业工商字号
     */
    private String companyOfIndustryAndCommerce;

    /**
     * 组织机构代码
     */
    private String organizationCode;

    /**
     * 统一社会信用代码
     */
    private String unifiedSocialCreditCode;

    /**
     * 从业人数
     */
    private String employeesCount;

    /**
     * 法人代表
     */
    private String legalRepresentative;

    /**
     * 经营负责人
     */
    private String operationsManagers;

    /**
     * 应急联系人
     */
    private String emergencyContact;

    /**
     * 应急联系电话
     */
    private String emergencyContactPhoneNumber;

    /**
     * 连锁经营情况
     */
    private String chainOperationSituation;

    /**
     * 品牌
     */
    private String brand;

    /**
     * 管理公司名称
     */
    private String managementOfTheCompanyName;

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
     * 营业时间
     */
    private String businessHours;

    /**
     * 预定电话
     */
    private String dueToThePhone;

    /**
     * 咨询电话
     */
    private String consultingTheTelephone;

    /**
     * 投诉电话
     */
    private String complaints;

    /**
     * 在线投诉地址
     */
    private String onlineComplaintsAddress;

    /**
     * 传真
     */
    private String fax;

    /**
     * Email
     */
    private String email;

    /**
     * 同时就餐人数
     */
    private String atTheSameTimeRepastNumber;

    /**
     * 包间数
     */
    private String numberOfRooms;

    /**
     * 特色菜品
     */
    private String dishesWith;

    /**
     * 人均消费
     */
    private String perCapitaConsumption;

    /**
     * 周边信息
     */
    private String surroundingInformation;

    /**
     * 支持卡种
     */
    private String supportOfCard;

    /**
     * 支付方式
     */
    private String methodOfPayment;

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
    /**
     * 活跃度
     */
    private String hotIndex;
}
