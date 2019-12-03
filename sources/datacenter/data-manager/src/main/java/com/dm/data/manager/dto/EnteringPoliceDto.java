package com.dm.data.manager.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Collections;
import java.util.List;

/**
 * 入境人数
 */
@Getter
@Setter
public class EnteringPoliceDto extends AbstractRegionDto {
    private static final long serialVersionUID = -3829426839380829527L;
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
     * 国家
     */
    private String contry;
    /**
     * 省
     */
    private String province;
    /**
     * 市
     */
    private String city;
    /**
     * 区
     */
    private String area;

    /**
     * 景区
     */
    private String scenic;
    /**
     * 数量
     */
    private Integer number;

    /**
     * 游览景区数
     */
    private Integer visitNumber;

    /**
     * 性别
     */
    private String sex;
    /**
     * 停留时长
     */
    private String stopTime;
    /**
     * 年龄最大
     */
    private String age;

    private List<ConsumptionMsgDto> consumptionMsgs = Collections.emptyList();
}
