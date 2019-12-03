package com.dm.data.manager.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 大巴司机
 * 
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class BusDriverDto extends AbstractRegionDto {
    private static final long serialVersionUID = 1L;

    /**
     * 中文姓名
     */
    private String chineseName;
    private Long id;

    /**
     * 拼音
     */
    private String pinyin;

    /**
     * 英文姓名
     */
    private String theEnglishName;

    /**
     * 性别
     */
    private String gender;

    /**
     * 出生日期
     */
    private String dateOfBirth;

    /**
     * 身份证号
     */
    private String idNumber;

    /**
     * 学历
     */
    private String recordOfFormalSchooling;

    /**
     * 民族
     */
    private String national;

    /**
     * 联系方式
     */
    private String contact;

    /**
     * 家庭住址
     */
    private String homeAddress;

    /**
     * 所在地区
     */

    /**
     * 职称
     */
    private String theTitle;

    /**
     * 驾龄
     */
    private Long beenDriving;

    /**
     * 驾驶证号码
     */
    private String driverLicenseNumber;

    /**
     * 服务语种
     */
    private String serviceLanguage;

    /**
     * 服务范围
     */
    private String serviceScope;

    /**
     * 简介
     */
    private String introduction;

    /**
     * 工作情况
     */
    private String workingCondition;

}
