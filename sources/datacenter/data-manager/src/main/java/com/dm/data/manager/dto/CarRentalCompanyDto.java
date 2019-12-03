package com.dm.data.manager.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.ZonedDateTime;
import java.util.Collections;
import java.util.List;

/**
 * 汽车租赁公司
 *
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class CarRentalCompanyDto extends AbstractRegionDto {
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
     * 资源编码
     */
    private Long id;

    /**
     * 中文名称
     */
    private String chineseName;

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
     * 汽车租赁公司品牌
     */
    private String brand;

    /**
     * 所在区域
     */

    /**
     * 经度
     **/
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
     * 是否认证
     */
    private Boolean authenticationed;

    /**
     * 荣誉称号
     */
    private String titleOfHonor;

    /**
     * 关键字
     */
    private String keywords;

    /**
     * 公司Logo
     */
    private String logo;

    /**
     * 所属公司
     */
    private String company;

    /**
     * 车型
     */
    private String models;

    /**
     * 计费标准
     */
    private String chargeStandard;

    /**
     * 简介
     */
    private String introduction;

    /**
     * 企业工商注册全称
     */
    private String fullNameCompanies;

    /**
     * 营业执照号码
     */
    private String businessLicenseNo;

    /**
     * 企业工商字号
     */
    private String companyIndustry;

    /**
     * 组织机构代码
     */
    private String organizationCode;

    /**
     * 许可证号
     */
    private String license;

    /**
     * 统一社会信用代码
     */
    private String unifiedSocialCreditCode;

    /**
     * 行业代码
     */
    private String industryCode;

    /**
     * 登记机关
     */
    private String registrationAuthority;

    /**
     * 受理单位
     */
    private String acceptUnit;

    /**
     * 成立日期
     */
    private ZonedDateTime setUpDate;

    /**
     * 核准日期
     */
    private ZonedDateTime approvalDate;

    /**
     * 吊销日期
     */
    private ZonedDateTime revocationDate;

    /**
     * 注销日期
     */
    private ZonedDateTime cancellationDate;

    /**
     * 有效期
     */
    private String validityPeriod;

    /**
     * 注册资本
     */
    private Double registeredCapital;

    /**
     * 行业类别
     */
    private String industryCategories;

    /**
     * 法人代表
     */
    private String legalRepresentative;

    /**
     * 经营负责人
     */
    private String operationsManagers;

    /**
     * 从业人数
     */
    private Integer employeesCount;

    /**
     * 应急联系人
     */
    private String emergencyContact;

    /**
     * 应急联系电话
     */
    private String emergencyContactPhoneNumber;

    /**
     * 业务范围
     */
    private String businessScope;

    /**
     * 新浪微博
     */
    private String sinaWeibo;

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
    private String website;

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
    private String businessTimes;

    /**
     * 支持卡种
     */
    private String supportCards;

    /**
     * 支付方式
     */
    private String paymentMethod;

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

    private List<CarDto> cars = Collections.emptyList();

}
