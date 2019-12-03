package com.dm.data.manager.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * 消费信息
 */
@Getter
@Setter
public class ConsumptionMsgDto extends AbstractRegionDto {
    private static final long serialVersionUID = -5591883459008653057L;
    /**
     * 资源编码
     */
    private Long id;
    /**
     * 年
     */
    private Integer year;

    /**
     * 月
     */
    private Integer month;

    /**
     * 日
     */
    private Integer day;

    /**
     * 时
     */
    private Integer houre;

    /**
     * 事件
     */
    private LocalDateTime time;
    /**
     * 手机号
     */
    private String mobile;
    /**
     * 支付方式
     */
    private String type;

    /**
     * 消费商家
     */
    private String business;

    /**
     * 消费金额
     */
    private String money;
}
