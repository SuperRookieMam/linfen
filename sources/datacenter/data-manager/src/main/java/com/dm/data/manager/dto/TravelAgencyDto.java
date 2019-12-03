package com.dm.data.manager.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * 旅行社
 *
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class TravelAgencyDto extends AbstractRegionDto {
    private static final long serialVersionUID = 1L;
    /**
     * 评分
     */
    private Double score;
    private Long id;
    /**
     * 资源编码
     */
    public String no;

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
     * 类型
     */
    private String type;

    /**
     * 等级
     */
    private String level;

    /**
     * 经营业务
     */
    private String business;

    /**
     * 服务语种
     */
    private String serviceLanguage;

    /**
     * 荣誉称号
     */
    private String titleOfHonor;

    /**
     * 关键字
     */
    private String keywords;

    /**
     * 标签
     */
    private String label;

    /**
     * 旅行社Logo
     */
    private String theTravelAgencyLogo;

    /**
     * 简介
     */
    private String introduction;

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
     * 旅游合同
     */
    private String theTravelContract;

    /**
     * 保证金金额
     */
    private String depositAmount;

    /**
     * 应急联系人
     */
    private String emergencyContact;

    /**
     * 应急联系电话
     */
    private String emergencyContactPhoneNumber;

    /**
     * 所属旅游集团
     */
    private String byTravelGroup;

    /**
     * 业务范围
     */
    private String theBusinessScope;

    /**
     * 旅行社分社
     */
    private String theTravelAgencyBureauChief;

    /**
     * 旅行社服务网点
     */
    private String travelAgencyServiceOutlets;

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
     * 投诉电话
     */
    private String complaints;

    /**
     * 在线投诉地址
     */
    private String onlineComplaintsAddress;

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
     * 营业时间
     */
    private String businessHours;

    /**
     * 支持卡种
     */
    private String supportOfCard;

    /**
     * 支付方式
     */
    private String methodOfPayment;

    /**
     * 导游人员简介
     */
    private String guidesPersonnelIntroduction;

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
