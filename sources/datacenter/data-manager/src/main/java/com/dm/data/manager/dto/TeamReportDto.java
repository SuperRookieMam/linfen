package com.dm.data.manager.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

@Getter
@Setter
public class TeamReportDto extends AbstractRegionDto {
    private static final long serialVersionUID = -2725929601400274865L;
    private Long id;
    /**
     * 团队名称
     */
    private String teamName;
    /**
     * 旅游社团名字
     */
    private String travelAgentcyName;
    /**
     * 旅游社团电话
     */
    private String travelAgentcyMobile;
    /**
     * 导游名字
     */
    private String guidName;
    /**
     * 导游电话
     */
    private String guidMobile;
    /**
     * 车牌号
     */
    private String carnum;
    /**
     * 司机电话
     */
    private String driverMobile;
    /**
     * 司机name
     */
    private String driverName;
    /**
     * 团队人数
     */
    private Integer teamNumbers;
    /**
     * 出团时间
     */
    private LocalDateTime startTime;

    /**
     * 结束时间
     */
    private LocalDateTime endTime;

    /**
     * 团队状态
     */
    private String state;

    private List<TeamMemberDto> members = Collections.emptyList();

    private String desc;

    private String scenic;
//    /**
//     * 导游
//     * */
//    private TourGuideDto tourGuide;
//
//    private TravelAgencyDto travelAgentcy;
//
//    private TourBusDto tourBus;
//
//    private BusDriverDto busDriver;
//
}
