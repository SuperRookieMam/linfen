package com.dm.data.app.entity;

import com.dm.data.app.entity.core.AbstractCore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDate;

/**
 * 行程
 */

@Getter
@Setter
@Entity(name = "trip_")
@Table(name = "trip_")
public class Trip extends AbstractCore<Long> implements Serializable {
    private static final long serialVersionUID = -2029023416128045653L;
    /**
     * 安排
     */
    @Column(name = "arrange_")
    private String arrange;
    /**
     * 酒店名称
     */
    @Column(name = "hotel_name_")
    private String hotelName;
    /**
     * 行程时间
     */
    @Column(name = "trip_time_")
    private LocalDate  tripTime;
}
