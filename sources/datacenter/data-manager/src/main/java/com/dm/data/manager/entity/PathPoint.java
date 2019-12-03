package com.dm.data.manager.entity;

import com.dm.data.manager.entity.core.AbstractCurrency;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;

@Getter
@Setter
@Entity(name = "path_point_")
public class PathPoint extends AbstractCurrency<Long> {

    /**
     * 点名称
     */
    @Column(name = "name_", length = 100)
    private String name;

    /**
     * 经度
     */
    @Column(name = "longitude_")
    private Double longitude;

    /**
     * 纬度
     */
    @Column(name = "latitude_")
    private Double latitude;
}
