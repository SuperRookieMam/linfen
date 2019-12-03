package com.dm.data.manager.entity;

import com.dm.data.manager.entity.core.AbstractCurrency;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * 酒店管理
 */
@Getter
@Setter
@Entity(name = "hotel_manager_")
public class HotelManager extends AbstractCurrency<Long> {

    /**
     * 日期
     */
    @Column(name = "current_date_")
    private LocalDate currentDate;

    /**
     * 酒店名称
     */
    @Column(name = "hotel_name_")
    private String hotelName;

    /**
     * 价格
     */
    @Column(name = "price_")
    private Float price;

    /**
     * 昨日价格
     */
    @Column(name = "old_price_")
    private Float oldPrice;

    /**
     * 评分
     */
    @Column(name = "score_")
    private Float score;

    /**
     * 周平均评分
     */
    @Column(name = "avg_score_")
    private Float avgScore;

}
