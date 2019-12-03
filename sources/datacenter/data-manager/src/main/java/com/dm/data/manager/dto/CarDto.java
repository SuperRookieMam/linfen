package com.dm.data.manager.dto;

import lombok.Data;

import java.time.ZonedDateTime;

/**
 * 车辆信息
 *
 */
@Data
public class CarDto extends AbstractRegionDto {
    private static final long serialVersionUID = 1L;

    private Long id;

    /**
     * 车牌号
     */
    private String plateNo;

    /**
     * 品牌
     */
    private String brand;

    /**
     * 型号
     */
    private String model;

    /**
     * 准载人数
     */
    private Integer accurateLoadCount;

    /**
     * 座位数
     */
    private Integer seatingCount;

    /**
     * 颜色
     */
    private String color;

    /**
     * 发动机号
     */
    private String engineNo;

    /**
     * 车架号
     */
    private String vin;

    /**
     * 车籍地
     */
    private String carThrough;

    /**
     * 登记日期
     */
    private ZonedDateTime registryDate;

    /**
     * 业主代表
     */
    private String representativeOwner;

    /**
     * 联系人
     */
    private String contactPeople;

    /**
     * 联系方式
     */
    private String contact;

    /**
     * 联系地址
     */
    private String contactAddress;

    /**
     * 安全行驶里程
     */
    private Integer safeDrivingMileage;

    /**
     * 计费标准
     */
    private String chargeStandard;

}
