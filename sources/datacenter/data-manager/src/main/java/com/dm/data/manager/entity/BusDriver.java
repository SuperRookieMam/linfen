package com.dm.data.manager.entity;

import com.dm.data.manager.entity.core.AbstractCurrency;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;

/**
 * 大巴司机
 * 
 * @author LiDong
 *
 */
@Getter
@Setter
@Entity(name = "bus_driver_")
@Component
public class BusDriver extends AbstractCurrency<Long> {

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
     * 英文姓名
     */
    @Column(name = "the_english_name_", length = 100)
    private String theEnglishName;

    /**
     * 性别
     */
    @Column(name = "gender_", length = 200)
    private String gender;

    /**
     * 出生日期
     */
    @Column(name = "date_of_birth_", length = 200)
    private String dateOfBirth;

    /**
     * 身份证号
     */
    @Column(name = "id_number_", length = 200)
    private String idNumber;

    /**
     * 学历
     */
    @Column(name = "record_of_formal_schooling_", length = 200)
    private String recordOfFormalSchooling;

    /**
     * 民族
     */
    @Column(name = "national_", length = 200)
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
     * 所在地区
     */

    /**
     * 职称
     */
    @Column(name = "the_title_", length = 200)
    private String theTitle;

    /**
     * 驾龄
     */
    @Column(name = "been_driving_", length = 200)
    private Long beenDriving;

    /**
     * 驾驶证号码
     */
    @Column(name = "driver_license_number_", length = 200)
    private String driverLicenseNumber;

    /**
     * 服务语种
     */
    @Column(name = "service_language_", length = 200)
    private String serviceLanguage;

    /**
     * 服务范围
     */
    @Column(name = "service_scope_", length = 200)
    private String serviceScope;

    /**
     * 简介
     */
    @Column(name = "introduction_", length = 200)
    @Lob
    private String introduction;

    /**
     * 工作情况
     */
    @Column(name = "working_condition_")
    @Lob
    private String workingCondition;

}
