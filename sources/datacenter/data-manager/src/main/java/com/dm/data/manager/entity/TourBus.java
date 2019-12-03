package com.dm.data.manager.entity;

import com.dm.data.manager.entity.core.AbstractCurrency;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.List;

/**
 * 旅游大巴
 *
 * @author LiDong
 *
 */
@Getter
@Setter
@Entity(name = "tour_bus_")
public class TourBus extends AbstractCurrency<Long> {

    /**
     * 车牌号
     */
    @Column(name = "plate_no_", length = 20)
    private String plateNo;

    /*** 经度 */
    @Column(name = "longitude_")
    private Double longitude;

    /*** 纬度 */
    @Column(name = "latitude_")
    private Double latitude;

    /**
     * 地址
     */
    @Column(name = "address_", length = 200)
    private String address;

    /**
     * 大巴专线Logo
     */
    @Column(name = "logo_", length = 200)
    private String logo;

    /**
     * 客车级别
     */
    @Column(name = "level_", length = 20)
    private String level;

    /**
     * 客车类型
     */
    @Column(name = "car_type_", length = 20)
    private String carType;

    /**
     * 登记日期
     */
    @Column(name = "registry_date_")
    private ZonedDateTime registryDate;

    /**
     * 业主代表
     */
    @Column(name = "representative_owner_", length = 50)
    private String representativeOwner;

    /**
     * 联系人
     */
    @Column(name = "contact_people_", length = 50)
    private String contactPeople;

    /**
     * 联系方式
     */
    @Column(name = "contact_", length = 200)
    private String contact;

    /**
     * 联系地址
     */
    @Column(name = "contact_address_", length = 200)
    private String contactAddress;

    /**
     * 运输类型
     */
    @Column(name = "transportation_type_", length = 50)
    private String transportationType;

    /**
     * 经济类型
     */
    @Column(name = "economic_type_", length = 50)
    private String economicType;

    /**
     * 业户编码
     */
    @Column(name = "establishment_code_", length = 50)
    private String establishmentCode;

    /**
     * 技术等级
     */
    @Column(name = "technical_grade_", length = 20)
    private String technicalGrade;

    /**
     * 安全行驶里程
     */
    @Column(name = "safe_driving_mileage_")
    private Integer safeDrivingMileage;

    /**
     * 技术开始有效期
     */
    @Column(name = "technology_start_validity_period_", length = 50)
    private String technologyStartValidityPeriod;

    /**
     * 技术结束有效期
     */
    @Column(name = "technology_end_validity_period_", length = 50)
    private String technologyEndValidityPeriod;

    /**
     * 速度
     */
    @Column(name = "speed_", length = 20)
    private String speed;

    /**
     * 简介
     */
    @Column(name = "introduction_")
    @Lob
    private String introduction;

    /**
     * 咨询电话
     */
    @Column(name = "consulting_phone_number_", length = 20)
    private String consultingPhoneNumber;

    /**
     * 投诉电话
     */
    @Column(name = "complaints_phone_number_", length = 20)
    private String complaintsPhoneNumber;

    /**
     * 在线投诉地址
     */
    @Column(name = "online_complaints_address_", length = 200)
    private String onlineComplaintsAddress;

    /**
     * 是否支持网络购票
     */
    @Column(name = "online_ticketable_")
    private Boolean onlineTicketable;

    /**
     * 购票地址
     */
    @Column(name = "ticket_address_", length = 200)
    private String ticketAddress;

    /**
     * 购票电话
     */
    @Column(name = "ticket_phone_number_", length = 20)
    private String ticketPhoneNumber;

    /**
     * 周边信息
     */
    @Column(name = "surrounding_information_", length = 200)
    private String surroundingInformation;

    /**
     * 旅游大巴班次信息
     */
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "tour_bus_bus_service_", joinColumns = {
            @JoinColumn(name = "tour_bus_", referencedColumnName = "id_") }, inverseJoinColumns = {
                    @JoinColumn(name = "bus_service_", referencedColumnName = "id_") })
    private List<TourBusService> buses;

}
