package com.dm.data.manager.entity;

import com.dm.data.manager.entity.core.AbstractCurrency;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;

@Getter
@Setter
@Entity(name = "whether_")
public class Whether extends AbstractCurrency<Long> {

    /**
     * 年
     */
    @Column(name = "year_")
    private Integer year;

    /**
     * 月
     */
    @Column(name = "month_")
    private Integer month;

    /**
     * 日
     */
    @Column(name = "day_")
    private Integer day;

    /**
     * 时
     */
    @Column(name = "houre_")
    private Integer houre;

    /**
     * 省
     */
    @Column(name = "province_")
    private String province;

    /**
     * 市
     */
    @Column(name = "city_")
    private String city;

    /**
     * 区
     */
    @Column(name = "area_")
    private String area;

    /**
     * 景区
     */
    @Column(name = "scenic_")
    private String scenic;

    /**
     * 天气
     */
    @Column(name = "whether_")
    private String whether;

    /**
     * 气温高
     */
    @Column(name = "temperature_max_")
    private String temperatureMax;
    /**
     * 气温低
     */
    @Column(name = "temperature_min_")
    private String temperatureMin;
    /**
     * 风力
     */
    @Column(name = "wind_power_")
    private String windPower;

    /**
     * 空气质量
     */
    @Column(name = "air_quality_")
    private String airQuality;

    /**
     * 降水量
     */
    @Column(name = "precipitation_")
    private String precipitation;
}
