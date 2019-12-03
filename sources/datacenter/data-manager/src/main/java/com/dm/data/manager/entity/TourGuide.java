package com.dm.data.manager.entity;

import com.dm.data.manager.entity.core.AbstractCurrency;
import com.dm.file.entity.FileInfo;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

/**
 * 导游
 *
 * @author LiDong
 *
 */
@Getter
@Setter
@Entity(name = "tour_guide_")
public class TourGuide extends AbstractCurrency<Long> {

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
     * 当前团队
     */
    @Column(name = "now_team_", length = 50)
    private String nowTeam;

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

    @OneToMany(cascade = { CascadeType.ALL })
    @JoinTable(name = "t_tour_guide_img")
    private List<FileInfo> headImgs;
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
    @Column(name = "contact_", length = 200)
    private String contact;

    /**
     * 家庭住址
     */
    @Column(name = "home_address_", length = 200)
    private String homeAddress;

    /**
     * 证件照
     */
    @Column(name = "profile_picture_", length = 200)
    private String profilePicture;

    /**
     * 导游类型
     */
    @Column(name = "the_guide_type_", length = 200)
    private String theGuideType;

    /**
     * 导游等级
     */
    @Column(name = "the_guide_ranks_", length = 20)
    private String theGuideRanks;

    /**
     * 服务语种
     */
    @Column(name = "service_language_", length = 200)
    private String serviceLanguage;

    /**
     * 所在地区
     */

    /**
     * 导游员简介
     */
    @Column(name = "introduction_")
    @Lob
    private String introductionTourGuide;

    /**
     * 导游证号码
     */
    @Column(name = "legally_number_", length = 200)
    private String legallyNumber;

    /**
     * 导游证发证日期
     */
    @Column(name = "turned_the_release_date_", length = 200)
    private String turnedTheReleaseDate;

    /**
     * 资格证号
     */
    @Column(name = "qualification_card_number_", length = 200)
    private String qualificationCardNumber;

    /**
     * 资格证发证日期
     */
    @Column(name = "certificate_issuance_date_", length = 200)
    private String certificateIssuanceDate;

    /**
     * 许可证号
     */
    @Column(name = "license_", length = 200)
    private String license;

    /**
     * 导游IC卡号
     */
    @Column(name = "the_tour_guide_ic_card_number_", length = 200)
    private String theTourGuideIcCardNumber;

    /**
     * 导游卡号
     */
    @Column(name = "the_tour_guide_card_number_", length = 200)
    private String theTourGuideCardNumber;

    /**
     * 挂靠单位
     */
    @Column(name = "attached_units_", length = 200)
    private String attachedUnits;

    /**
     * 挂靠单位类型
     */
    @Column(name = "the_affiliated_unit_type_", length = 200)
    private String theAffiliatedUnitType;

    /**
     * 总分值
     */
    @Column(name = "total_value_", length = 200)
    private String totalValue;

    /**
     * 被扣分值
     */
    @Column(name = "deduction_score_", length = 200)
    private String deductionScore;

    /**
     * 擅长讲解城市
     */
    @Column(name = "good_at_interpretation_of_the_city_")
    @Lob
    private String goodAtInterpretationOfTheCity;

    /**
     * 擅长讲解景区
     */
    @Column(name = "good_at_interpretation_of_the_scenic_spot_")
    @Lob
    private String goodAtInterpretationOfTheScenicSpot;

    /**
     * 擅长带团线路
     */
    @Column(name = "good_at_line_of_tour_")
    @Lob
    private String goodAtLineOfTour;

    /**
     * 工作情况
     */
    @Column(name = "working_condition_")
    @Lob
    private String workingCondition;

}
