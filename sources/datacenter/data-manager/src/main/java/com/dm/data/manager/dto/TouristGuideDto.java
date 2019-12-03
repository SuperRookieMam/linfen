package com.dm.data.manager.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 景区讲解员
 * 
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class TouristGuideDto extends AbstractRegionDto {
    private static final long serialVersionUID = 1L;

    /**
     * 中文姓名
     */
    private String chineseName;

    /**
     * 拼音
     */
    private String pinyin;

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

    private Long id;
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
     * 服务语种
     */
    private String serviceLanguage;

    /**
     * 简介
     */
    private String introduction;

    /**
     * 工作情况
     */
    private String workingCondition;

}
