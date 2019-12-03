package com.dm.data.app.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class TravelBusDto implements Serializable {
    private Long id;

    /**
     * 时间
     */
    private LocalDate dayTime;
    /**
     * 导游吗
     */
    private String guiderName;
    /**
     * 导游电话
     */
    @Column(name = "guider_tel_")
    private String guiderTell;
    /**
     * 司机名
     */
    private String driverName;
    /**
     * 司机电话
     */
    private String driverTel;
    /**
     * 团队名字
     */
    private String  teamName;
    /**
     * 团队id
     */
    private Long teamId;
    /**
     * 团队人数
     */
    private Integer teamPeopleNum;
    /**
     * 点集合
     */
    List<LocalPointDto> points;
    /**
     * 车牌号
     */
    private String carNum;
}
