package com.dm.data.manager.entity;

import com.dm.data.manager.entity.core.AbstractCurrency;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity(name = "team_report_")
public class TeamReport extends AbstractCurrency<Long> {
    /**
     * 团队名称
     */
    @Column(name = "team_name_")
    private String teamName;
    /**
     * 旅游社团名字
     */
    @Column(name = "travel_agentcy_name_")
    private String travelAgentcyName;
    /**
     * 旅游社团电话
     */
    @Column(name = "travel_agentcy_mobile_")
    private String travelAgentcyMobile;
    /**
     * 导游名字
     */
    @Column(name = "guid_name_")
    private String guidName;
    /**
     * 导游电话
     */
    @Column(name = "guid_mobile_")
    private String guidMobile;
    /**
     * 车牌号
     */
    @Column(name = "car_num_")
    private String carnum;
    /**
     * 司机电话
     */
    @Column(name = "driver_mobile_")
    private String driverMobile;
    /**
     * 司机name
     */
    @Column(name = "driver_name_")
    private String driverName;
    /**
     * 团队人数
     */
    @Column(name = "member_numbers_")
    private Integer teamNumbers;
    /**
     * 出团时间
     */
    @Column(name = "start_time_")
    private LocalDateTime startTime;

    /**
     * 结束时间
     */
    @Column(name = "end_time_")
    private LocalDateTime endTime;

    /**
     * 团队状态
     */
    @Column(name = "state_")
    private String state;

    @OneToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinColumn(name = "members")
    private List<TeamMember> members;

    @Column(name = "description_")
    private String desc;

    @Column(name = "scenic_")
    private String scenic;

//    /**
//     * 导游
//     * */
//    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
//    @JoinColumn(name = "tourGuide_")
//    private TourGuide tourGuide;
//    /**
//     * 旅行社
//     * */
//    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
//    @JoinColumn(name = "travela_gentcy_")
//    private TravelAgentcy travelAgentcy;
//    /**
//     * 大巴信息
//     * */
//    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
//    @JoinColumn(name = "tourBus_")
//    private TourBus tourBus;
//    /**
//     * 大巴司机
//     * */
//    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
//    @JoinColumn(name = "bus_driver_")
//    private BusDriver busDriver;
//
//

}
