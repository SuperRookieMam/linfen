package com.dm.data.manager.dto;

import com.dm.file.dto.FileInfoDto;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * 导游
 *
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class TourGuideDto extends AbstractRegionDto {
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
     * 性别
     */
    private String gender;

    /**
     * 省会编码
     */

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
     * 证件照
     */
    private String profilePicture;

    /**
     * 导游类型
     */
    private String theGuideType;

    /**
     * 当前团队
     */
    private String nowTeam;

    /**
     * 导游等级
     */
    private String theGuideRanks;

    /**
     * 服务语种
     */
    private String serviceLanguage;

    /**
     * 所在地区
     */

    /**
     * 导游员简介
     */
    private String introductionTourGuide;

    /**
     * 导游证号码
     */
    private String legallyNumber;

    /**
     * 导游证发证日期
     */
    private String turnedTheReleaseDate;

    /**
     * 资格证号
     */
    private String qualificationCardNumber;

    /**
     * 资格证发证日期
     */
    private String certificateIssuanceDate;

    /**
     * 许可证号
     */
    private String license;

    /**
     * 导游IC卡号
     */
    private String theTourGuideIcCardNumber;

    /**
     * 导游卡号
     */
    private String theTourGuideCardNumber;

    /**
     * 挂靠单位
     */
    private String attachedUnits;

    /**
     * 挂靠单位类型
     */
    private String theAffiliatedUnitType;

    /**
     * 总分值
     */
    private String totalValue;

    /**
     * 被扣分值
     */
    private String deductionScore;

    /**
     * 擅长讲解城市
     */
    private String goodAtInterpretationOfTheCity;

    /**
     * 擅长讲解景区
     */
    private String goodAtInterpretationOfTheScenicSpot;

    /**
     * 擅长带团线路
     */
    private String goodAtLineOfTour;

    /**
     * 工作情况
     */
    private String workingCondition;

    private List<FileInfoDto> headImgs;

}
