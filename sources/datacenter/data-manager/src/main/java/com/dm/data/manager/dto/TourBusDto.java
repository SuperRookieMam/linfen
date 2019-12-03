package com.dm.data.manager.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.ZonedDateTime;
import java.util.Collections;
import java.util.List;

/**
 * 旅游大巴
 *
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class TourBusDto extends AbstractRegionDto {
    private static final long serialVersionUID = 1L;

    /**
     * 编号
     */
    public String no;

    /**
     * 省会编码
     */

    /** 区划名称 **/

    /**
     * 资源编码
     */
    private Long id;

    /**
     * 车牌号
     */
    private String plateNo;

    /** 经度 **/
    private Double longitude;

    /** 纬度度 **/
    private Double latitude;

    /**
     * 地址
     */
    private String address;

    /**
     * 大巴专线Logo
     */
    private String logo;

    /**
     * 客车级别
     */
    private String level;

    /**
     * 客车类型
     */
    private String carType;

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
     * 运输类型
     */
    private String transportationType;

    /**
     * 经济类型
     */
    private String economicType;

    /**
     * 业户编码
     */
    private String establishmentCode;

    /**
     * 技术等级
     */
    private String technicalGrade;

    /**
     * 安全行驶里程
     */
    private Integer safeDrivingMileage;

    /**
     * 技术开始有效期
     */
    private String technologyStartValidityPeriod;

    /**
     * 技术结束有效期
     */
    private String technologyEndValidityPeriod;

    /**
     * 速度
     */
    private String speed;

    /**
     * 简介
     */
    private String introduction;

    /**
     * 咨询电话
     */
    private String consultingPhoneNumber;

    /**
     * 投诉电话
     */
    private String complaintsPhoneNumber;

    /**
     * 在线投诉地址
     */
    private String onlineComplaintsAddress;

    /**
     * 是否支持网络购票
     */
    private Boolean onlineTicketable;

    /**
     * 购票地址
     */
    private String ticketAddress;

    /**
     * 购票电话
     */
    private String ticketPhoneNumber;

    /**
     * 周边信息
     */
    private String surroundingInformation;

    private List<TourBusServiceDto> buses = Collections.emptyList();
}
