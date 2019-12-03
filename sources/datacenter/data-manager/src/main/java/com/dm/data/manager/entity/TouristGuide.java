package com.dm.data.manager.entity;

import com.dm.data.manager.entity.core.AbstractCurrency;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;

/**
 * 景区讲解员
 * 
 * @author LiDong
 *
 */
@Getter
@Setter
@Entity(name = "tourist_guide_")
public class TouristGuide extends AbstractCurrency<Long> {

    /**
     * 中文姓名
     */
    @Column(name = "chinese_name_", length = 50)
    private String chineseName;

    /**
     * 拼音
     */
    @Column(name = "pinyin_", length = 50)
    private String pinyin;

    /**
     * 性别
     */
    @Column(name = "gender_", length = 20)
    private String gender;

    /**
     * 出生日期
     */
    @Column(name = "date_of_birth_", length = 50)
    private String dateOfBirth;

    /**
     * 身份证号
     */
    @Column(name = "id_number_", length = 20)
    private String idNumber;

    /**
     * 学历
     */
    @Column(name = "record_of_formal_schooling_", length = 50)
    private String recordOfFormalSchooling;

    /**
     * 民族
     */
    @Column(name = "national_", length = 50)
    private String national;

    /**
     * 联系方式
     */
    @Column(name = "contact_", length = 20)
    private String contact;

    /**
     * 家庭住址
     */
    @Column(name = "home_address_", length = 200)
    private String homeAddress;

    /**
     * 服务语种
     */
    @Column(name = "service_language_", length = 200)
    private String serviceLanguage;

    /**
     * 所在地区
     */

    /**
     * 简介
     */
    @Column(name = "introduction_")
    @Lob
    private String introduction;

    /**
     * 工作情况
     */
    @Column(name = "working_condition_")
    @Lob
    private String workingCondition;

}
