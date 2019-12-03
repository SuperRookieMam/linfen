package com.dm.data.app.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class ElectronicTravelDto implements Serializable {
    private Long id;
    /**
     * 行程名字
     */
    private String travelName;
    /**
     * 标签
     */

    private String label;
    /**
     * 导游姓名
     */
    private String guiderName;
    /**
     * 团队人数
     */
    private Integer peopleNum;
    /**
     * 旅游开始时间
     */
    private LocalDate travelStart;
    /**
     * 旅游结束时间
     */
    private LocalDate travelEnd;
    /**
     * 团队id
     */
    private Long teamId;
    /**
     * 团队名
     */
    private String teamName;

    private List<TripDto> trips;
}
