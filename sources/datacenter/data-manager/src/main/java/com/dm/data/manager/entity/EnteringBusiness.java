package com.dm.data.manager.entity;

import com.dm.data.manager.entity.core.AbstractCurrency;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

/**
 * 入境人数
 */
@Getter
@Setter
@Entity(name = "etering_business_")
public class EnteringBusiness extends AbstractCurrency<Long> {
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
     * 国家
     */
    @Column(name = "contry_")
    private String contry;
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
     * 数量
     */
    @Column(name = "number_")
    private Integer number;

    /**
     * 游览景区数
     */
    @Column(name = "visit_number_")
    private Integer visitNumber;

    /**
     * 性别
     */
    @Column(name = "sex_")
    private String sex;
    /**
     * 停留时长
     */
    @Column(name = "stop_time_")
    private String stopTime;
    /**
     * 年龄最大
     */
    @Column(name = "age_")
    private String age;

    @OneToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST }, fetch = FetchType.LAZY)
    @JoinColumn(name = "entering_business_consumption_")
    private List<ConsumptionMsg> consumptionMsgs;
}
