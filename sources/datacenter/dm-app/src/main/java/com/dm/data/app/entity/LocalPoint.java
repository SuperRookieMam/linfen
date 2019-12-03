package com.dm.data.app.entity;

import com.dm.data.app.entity.core.AbstractCore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 电子行程单
 */
@Getter
@Setter
@Entity(name = "point_")
@Table(name = "point_")
public class LocalPoint extends AbstractCore<Long>  implements Serializable {
    private static final long serialVersionUID = 6899344305154700713L;
    /**
     * 经度
     */
    @Column(name = "longitude_")
    private String longitude;
    /**
     * 纬度
     */
    @Column(name = "latitude_")
    private String latitude;
    /**
     * 时间点
     */
    @Column(name = "time_point_")
    private LocalDateTime  timePoint;
}
