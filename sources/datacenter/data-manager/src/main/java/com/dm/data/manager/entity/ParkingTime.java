package com.dm.data.manager.entity;

import com.dm.data.manager.entity.core.AbstractCurrency;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;

@Getter
@Setter
@Entity(name = "parking_time_")
public class ParkingTime extends AbstractCurrency<Long> {
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
     * 总量
     */
    @Column(name = "total_number_")
    private Integer totalNumber;

    /**
     * 使用量
     */
    @Column(name = "use_number_")
    private Integer useNumber;
}
