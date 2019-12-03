package com.dm.data.app.entity;

import com.dm.data.app.entity.core.AbstractCore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

/**
 * 旅游大巴
 */
@Getter
@Setter
@Entity(name = "travel_bus_")
@Table(name = "travel_bus_")
public class TravelBus extends AbstractCore<Long> implements Serializable {
    private static final long serialVersionUID = -5303101126777669973L;
    /**
     * 时间
     */
    @Column(name = "day_time_")
    private LocalDate dayTime;
    /**
     * 导游吗
     */
    @Column(name = "guider_name_")
    private String guiderName;
    /**
     * 导游电话
     */
    @Column(name = "guider_tel_")
    private String guiderTell;
    /**
     * 司机名
     */
    @Column(name = "driver_name_")
    private String driverName;
    /**
     * 司机电话
     */
    @Column(name = "driver_tel_")
    private String driverTel;
    /**
     * 团队名字
     */
    @Column(name = "team_name_")
    private String  teamName;

    /**
     * 团队id
     */
    @Column(name="team_id_")
    private Long teamId;
    /**
     * 团队人数
     */
    @Column(name = "team_people_num_")
    private Integer teamPeopleNum;
    /**
     * 车牌号
     */
    @Column(name="car_num_")
    private String carNum;

    @OneToMany(cascade = {CascadeType.ALL})
    @JoinColumn(name = "points")
    private List<LocalPoint> points;
}
