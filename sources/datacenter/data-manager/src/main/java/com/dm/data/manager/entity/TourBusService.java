package com.dm.data.manager.entity;

import com.dm.data.manager.entity.core.AbstractCurrency;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

/**
 * 旅游大巴班次信息
 *
 * @author LiDong
 *
 */
@Getter
@Setter
@Entity(name = "tour_bus_service_")
public class TourBusService extends AbstractCurrency<Long> {

    /**
     * 车牌号
     */
    @Column(name = "plate_no_", length = 20)
    private String plateNo;

    /**
     * 品牌
     */
    @Column(name = "brand_", length = 20)
    private String brand;

    /**
     * 车型
     */
    @Column(name = "model_", length = 20)
    private String model;

    /**
     * 准载人数
     */
    @Column(name = "accurate_load_count_")
    private Long accurateLoadCount;

    /**
     * 座位数
     */
    @Column(name = "seating_count_")
    private Long seatingCount;

    /**
     * 颜色
     */
    @Column(name = "color_", length = 20)
    private String color;

    /**
     * 发动机号
     */
    @Column(name = "engine_no_", length = 50)
    private String engineNo;

    /**
     * 车架号
     */
    @Column(name = "vin_", length = 50)
    private String vin;

    /**
     * 车籍地
     */
    @Column(name = "car_through_", length = 20)
    private String carThrough;

    /**
     * 主要路线
     */
    @Column(name = "main_lines_", length = 2000)
    private String mainLines;

    /**
     * 出发时间
     */
    @Column(name = "departure_time_", length = 50)
    private String departureTime;

    /**
     * 到达时间
     */
    @Column(name = "arrival_time_", length = 50)
    private String arrivalTime;

    /**
     * 途经城市
     */
    @Column(name = "through_cities_")
    @Lob
    private String throughCities;

    /**
     * 里程
     */
    @Column(name = "mileage_")
    @Lob
    private Long mileage;

    /**
     * 车票说明
     */
    @Column(name = "ticket_noties_")
    @Lob
    private String ticketNoties;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "tour_bus_bus_service_", joinColumns = {
            @JoinColumn(name = "bus_service_", referencedColumnName = "id_") }, inverseJoinColumns = {
                    @JoinColumn(name = "tour_bus_", referencedColumnName = "id_") })
    private List<TourBus> buses;

}
