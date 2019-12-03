package com.dm.data.app.entity;

import com.dm.data.app.entity.core.AbstractCore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

/**
 * 电子行程单
 * @author Administrator
 */
@Getter
@Setter
@Entity(name = "electronic_travel_")
@Table(name = "electronic_travel_")
public class ElectronicTravel  extends AbstractCore<Long> implements Serializable {
    private static final long serialVersionUID = 2322463692373328314L;
    /**
     * 行程名字
     */
    @Column(name = "travel_name_", length = 200)
    private String travelName;
    /**
     * 标签
     */
    @Column(name = "label_")
    private String label;
    /**
     * 导游姓名
     */
    @Column(name="guider_name_")
    private String guiderName;
    /**
     * 团队人数
     */
    @Column(name="people_num_")
    private Integer peopleNum;
    /**
     * 旅游开始时间
     */
    @Column(name="travel_start_")
    private LocalDate travelStart;
    /**
     * 旅游结束时间
     */
    @Column(name="travel_end_")
    private LocalDate travelEnd;



    @OneToMany(cascade = {CascadeType.ALL})
    @JoinColumn(name = "trip")
    private List<Trip> trips;

    /**
     * 团队id
     */
    @Column(name="team_id_")
    private Long teamId;
    /**
     * 团队名
     */
    @Column(name="team_name_")
    private String teamName;

}
