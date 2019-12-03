package com.dm.data.manager.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import lombok.Data;

import java.util.List;

/**
 * 旅游大巴班次信息
 *
 */
@Data
public class TourBusServiceDto extends AbstractRegionDto {
    private static final long serialVersionUID = 1L;

    private Long id;

    @JsonProperty(access = Access.WRITE_ONLY)
    private List<TourBusDto> buses;

    /**
     * 车牌号
     */
    private String plateNo;

    /**
     * 品牌
     */
    private String brand;

    /**
     * 车型
     */
    private String model;

    /**
     * 准载人数
     */
    private Long accurateLoadCount;

    /**
     * 座位数
     */
    private Long seatingCount;

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
     * 主要路线
     */
    private String mainLines;

    /**
     * 出发时间
     */
    private String departureTime;

    /**
     * 到达时间
     */
    private String arrivalTime;

    /**
     * 途经城市
     */
    private String throughCities;

    /**
     * 里程
     */
    private Long mileage;

    /**
     * 车票说明
     */
    private String ticketNotice;

}
