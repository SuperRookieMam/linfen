package com.dm.data.manager.dto;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

/**
 * 酒店管理
 */
@Getter
@Setter
public class HotelManagerDto extends AbstractRegionDto {
    private static final long serialVersionUID = 8724257930993419604L;
    /**
     * 资源编码
     */
    private Long id;

    /**
     * 日期
     */
    private LocalDate currentDate;

    /**
     * 酒店名称
     */
    private String hotelName;

    /**
     * 价格
     */
    private Float price;

    /**
     * 昨日价格
     */
    private Float oldPrice;

    /**
     * 评分
     */
    private Float score;

    /**
     * 周平均评分
     */
    private Float avgScore;

}
