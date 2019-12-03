package com.dm.data.manager.entity;

import com.dm.data.manager.entity.core.AbstractCurrency;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collections;
import java.util.List;

@Getter
@Setter
@Entity(name = "room_info_")
public class RoomInfo extends AbstractCurrency<Long> {
    /**
     * 房间类型
     */
    @Column(name = "room_type_", length = 50)
    private String roomType;

    /**
     * 房间数量
     */
    @Column(name = "room_number_")
    private Long roomNumber;

    /**
     * 可预订房间
     */
    @Column(name = "book_a_room_")
    private Long canBookARoom;

    /**
     * 正常价格
     */
    @Column(name = "normal_price_", length = 200)
    private String normalPrice;

    /**
     * 节假日价格
     */
    @Column(name = "holiday_prices_", length = 200)
    private String holidayPrices;

    /**
     * 加床价
     */
    @Column(name = "extra_bed_price_", length = 200)
    private String extraBedPrice;

    /**
     * 服务设施描述
     */
    @Column(name = "services_described_")
    @Lob
    private String servicesDescribed;

    /**
     * 餐饮说明
     */
    @Column(name = "eat_description_")
    @Lob
    private String eatDescription;

    /**
     * 酒店Id
     */
    @Column(name = "accommodation_id_")
    private Long accommodationId;

    /**
     * 简介
     */
    @Column(name = "description_")
    @Lob
    private String description;

    /**
     * 图片库
     */
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "images_")
    private List<Image> images = Collections.emptyList();

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "videos_")
    private List<Video> videos = Collections.emptyList();
}
