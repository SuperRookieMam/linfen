package com.dm.data.manager.entity;

import com.dm.data.manager.entity.core.AbstractCurrency;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;

@Getter
@Setter
@Entity(name = "hotel_time_person_")
public class HotelTimePerson extends AbstractCurrency<Long> {
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
     * 酒店名称
     */
    @Column(name = "hotel_name_")
    private String hotelName;

    /**
     * 酒店等级
     */
    @Column(name = "level_")
    private String level;
    /**
     * 景区
     */
    @Column(name = "scenic_")
    private String scenic;
    /**
     * 数量
     */
    @Column(name = "number_")
    private Integer number;
    /**
     * 性别
     */
    @Column(name = "sex_")
    private String sex;
    /**
     * 年龄段
     */
    @Column(name = "age_max_")
    private String ageMax;
    /**
     * 年龄段
     */
    @Column(name = "age_min_")
    private String ageMin;
}
