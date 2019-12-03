package com.dm.data.manager.entity;

import com.dm.data.manager.entity.core.AbstractCurrency;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collections;
import java.util.List;

/**
 * 旅游线路
 *
 * @author LiDong
 *
 */
@Getter
@Setter
@Entity(name = "tourist_route_")
public class TouristRoute extends AbstractCurrency<Long> {

    /**
     * 线路编号
     */
    @Column(name = "no_", length = 200)
    private String no;

    /**
     * 线路名称
     */
    @Column(name = "name_", length = 200)
    private String name;

    /**
     * 线路类型
     */
    @Column(name = "type_", length = 200)
    private String type;

    /**
     * 目的地
     */
    @Column(name = "target_", length = 200)
    private String target;

    /**
     * 目的地类型
     */
    @Column(name = "target_type_", length = 200)
    private String targetType;

    /**
     * 线路天数
     */
    @Column(name = "days_")
    private String days;

    /**
     * 线路图片
     */

    @OneToMany(cascade = CascadeType.ALL)
    private List<Image> images = Collections.emptyList();;

    /**
     * 线路介绍
     */
    @Column(name = "description_")
    @Lob
    private String description;
    /**
     * 价格
     */
    @Column(name = "price_")
    private String price;

    /**
     * 电话
     */
    @Column(name = "phone_")
    private String phone;
    /**
     * 出行方式
     */
    @Column(name = "way_type_")
    private String wayType;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "route_point_")
    private List<PathPoint> pathPoints = Collections.emptyList();

}
