package com.dm.data.manager.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * 环保数据，空气质量
 */
@Getter
@Setter
public class AirQualityDto extends AbstractRegionDto {
    private static final long serialVersionUID = 2894961473831603751L;
    /**
     * 资源编码
     */
    private Long id;
    /**
     * 年
     */
    private Integer year;

    /**
     * 月
     */
    private Integer month;

    /**
     * 日
     */
    private Integer day;

    /**
     * 时
     */
    private Integer houre;
    /**
     * 省
     */
    private String province;
    /**
     * 市
     */
    private String city;
    /**
     * 区
     */
    private String area;

    /**
     * 景区
     */
    private String scenic;

    /**
     * 指数
     */
    private String aqi;
    /**
     * 等级
     */
    private String leve;

    /**
     * pm2.5
     */
    private String pm2;

    /**
     * pm2.5
     */
    private String pm10;

    /**
     * 污染度
     */
    private String contaminate;
}
