package com.dm.data.manager.entity;

import com.dm.data.manager.entity.core.AbstractCurrency;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;

/**
 * 旅游监控中心
 * 
 * @author LiDong
 *
 */
@Getter
@Setter
@Entity(name = "tourism_monitoring_center_")
public class TourismMonitoringCenter extends AbstractCurrency<Long> {

    /**
     * 监控点名称
     */
    @Column(name = "monitor_point_name_", length = 50)
    private String monitorPointName;

    /**
     * 所属部门
     */
    @Column(name = "subordinate_departments_", length = 200)
    private String subordinateDepartments;

    /**
     * 链接地址
     */
    @Column(name = "the_link_address_")
    private String theLinkAddress;

    /**
     * 端口
     */
    @Column(name = "port_")
    private String port;

    /**
     * 用户名
     */
    @Column(name = "the_user_name_")
    private String theUserName;

    /**
     * 密码
     */
    @Column(name = "password_")
    private String password;

    /**
     * 所在地区
     */

    /**
     * 地理位置
     */

    /*** 经度 */
    @Column(name = "longitude_")
    private Double longitude;
    /*** 纬度 */
    @Column(name = "latitude_")
    private Double latitude;

    /**
     * 地址
     */
    @Column(name = "address_")
    private String address;

    /**
     * 序列号
     */
    @Column(name = "the_serial_number_")
    private String theSerialNumber;

    /**
     * 品牌
     */
    @Column(name = "brand_")
    private String brand;

    /**
     * 大屏显示
     */
    @Column(name = "display_")
    private String display;

    /**
     * 播放方式
     */
    @Column(name = "play_the_way_")
    private String playTheWay;

    /**
     * 是否主要视频
     */
    @Column(name = "whether_the_main_video_")
    private String whetherTheMainVideo;

    /**
     * 清晰度
     */
    @Column(name = "clarity_")
    private String clarity;

    /**
     * 类型
     */
    @Column(name = "type_")
    private String type;

    /**
     * 视频图片
     */
    @Column(name = "video_images_")
    private String videoImages;

    /**
     * 简介
     */
    @Column(name = "introduction_")
    @Lob
    private String introduction;

}
