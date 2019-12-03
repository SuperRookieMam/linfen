package com.dm.data.manager.dto;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

/**
 * 门票管理
 */
@Getter
@Setter
public class TicketsDto extends AbstractRegionDto {
    private static final long serialVersionUID = 244195823313333244L;
    /**
     * 资源编码
     */
    private Long id;

    /**
     * 日期
     */
    private LocalDate currentDate;

    /**
     * 景区
     */
    private String scenic;

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
