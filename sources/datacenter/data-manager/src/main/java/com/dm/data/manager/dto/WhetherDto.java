package com.dm.data.manager.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WhetherDto extends AbstractRegionDto {
    private static final long serialVersionUID = 6554992559210759909L;
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
     * 天气
     */
    private String whether;

    /**
     * 气温高
     */
    private String temperatureMax;
    /**
     * 气温低
     */
    private String temperatureMin;
    /**
     * 风力
     */
    private String windPower;

    /**
     * 空气质量
     */
    private String airQuality;

    /**
     * 降水量
     */
    private String precipitation;
}
