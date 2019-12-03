package com.dm.data.manager.entity;

import com.dm.data.manager.entity.core.AbstractCurrency;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.time.ZonedDateTime;

/**
 * 车辆信息
 *
 * @author LiDong
 *
 */
@Getter
@Setter
@Entity(name = "car_")
public class Car extends AbstractCurrency<Long> {

    /**
     * 车牌号
     */
    @Column(name = "plate_no_", length = 20)
    private String plateNo;

    /**
     * 品牌
     */
    @Column(name = "brand_", length = 50)
    private String brand;

    /**
     * 型号
     */
    @Column(name = "model_", length = 50)
    private String model;

    /**
     * 准载人数
     */
    @Column(name = "accurate_load_count_")
    private Integer accurateLoadCount;

    /**
     * 座位数
     */
    @Column(name = "seating_count_")
    private Integer seatingCount;

    /**
     * 颜色
     */
    @Column(name = "color_", length = 200)
    private String color;

    /**
     * 发动机号
     */
    @Column(name = "engine_no_", length = 200)
    private String engineNo;

    /**
     * 车架号
     */
    @Column(name = "vin_", length = 200)
    private String vin;

    /**
     * 车籍地
     */
    @Column(name = "car_through_", length = 200)
    private String carThrough;

    /**
     * 登记日期
     */
    @Column(name = "registry_date_", length = 200)
    private ZonedDateTime registryDate;

    /**
     * 业主代表
     */
    @Column(name = "representative_owner_", length = 200)
    private String representativeOwner;

    /**
     * 联系人
     */
    @Column(name = "contact_people_", length = 20)
    private String contactPeople;

    /**
     * 联系方式
     */
    @Column(name = "contact_", length = 20)
    private String contact;

    /**
     * 联系地址
     */
    @Column(name = "contact_address_", length = 200)
    private String contactAddress;

    /**
     * 安全行驶里程
     */
    @Column(name = "safe_driving_mileage_")
    private Integer safeDrivingMileage;

    /**
     * 计费标准
     */
    @Column(name = "charge_standard_", length = 200)
    private String chargeStandard;

}
