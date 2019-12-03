package com.dm.data.manager.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 旅游厕所
 *
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class TouristToiletDto extends AbstractRegionDto {
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
     * 中文名称
     */
    private String fullname;

    /**
     * 中文简称
     */
    private String shortName;

    /**
     * 拼音名称
     */
    private String pinYin;

    /**
     * 英文名称
     */
    private String englishName;

    /**
     * 所在区域
     */
    private String region;

    /**
     * 相关景区
     */
    private String location;

    /**
     * 地址
     */
    private String address;

    /**
     * 厕所等级
     */
    private String touristToiletGrade;

    /**
     * 报警电话
     */
    private String policeStationPhone;

    /**
     * 收费标准
     */
    private String charges;

    /**
     * 相关景区
     */
    private String relatedScenics;
    /**
     * 地理经度
     */
    private Double latitude;

    /**
     * 地理经度
     */
    private Double longitude;
    /**
     * 活跃度
     */
    private String hotIndex;
}
