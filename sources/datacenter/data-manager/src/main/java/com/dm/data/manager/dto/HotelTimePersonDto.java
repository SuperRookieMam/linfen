package com.dm.data.manager.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HotelTimePersonDto extends AbstractRegionDto {
    private static final long serialVersionUID = -1591746638191674793L;
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
     * 酒店名称
     */
    private String hotelName;

    /**
     * 酒店等级
     */
    private String level;
    /**
     * 景区
     */
    private String scenic;
    /**
     * 数量
     */
    private Integer number;
    /**
     * 性别
     */
    private String sex;
    /**
     * 年龄段
     */
    private String ageMax;
    /**
     * 年龄段
     */
    private String ageMin;
}
