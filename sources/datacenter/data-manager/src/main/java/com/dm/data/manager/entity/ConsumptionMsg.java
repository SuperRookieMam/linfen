package com.dm.data.manager.entity;

import com.dm.data.manager.entity.core.AbstractCurrency;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.time.LocalDateTime;

/**
 * 消费信息
 */
@Getter
@Setter
@Entity(name = "consumption_msg_")
public class ConsumptionMsg extends AbstractCurrency<Long> {
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
     * 事件
     */
    @Column(name = "time_")
    private LocalDateTime time;
    /**
     * 手机号
     */
    @Column(name = "mobile_")
    private String mobile;
    /**
     * 支付方式
     */
    @Column(name = "type_")
    private String type;

    /**
     * 消费商家
     */
    @Column(name = "business_")
    private String business;

    /**
     * 消费金额
     */
    @Column(name = "money_")
    private String money;
}
