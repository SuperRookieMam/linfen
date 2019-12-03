package com.dm.data.manager.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 旅游监控中心
 * 
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class TourismMonitoringCenterDto extends AbstractRegionDto {
    private static final long serialVersionUID = 1L;

    /**
     * 编号
     */
    public String no;

    /**
     * 省会编码
     */

    /**
     * 城市编码
     */
    /** 区划名称 **/

    /**
     * 区县编码
     */

    /**
     * 资源编码
     */
    private Long id;

    /**
     * 监控点名称
     */
    private String monitorPointName;

    /**
     * 所属部门
     */
    private String subordinateDepartments;

    /**
     * 链接地址
     */
    private String theLinkAddress;

    /**
     * 端口
     */
    private String port;

    /**
     * 用户名
     */
    private String theUserName;

    /**
     * 密码
     */
    private String password;

    /**
     * 所在地区
     */

    /**
     * 地理位置
     */
    /** 经度 **/
    private Double longitude;
    /** 纬度度 **/
    private Double latitude;

    /**
     * 地址
     */
    private String address;

    /**
     * 序列号
     */
    private String theSerialNumber;

    /**
     * 品牌
     */
    private String brand;

    /**
     * 大屏显示
     */
    private String display;

    /**
     * 播放方式
     */
    private String playTheWay;

    /**
     * 是否主要视频
     */
    private String whetherTheMainVideo;

    /**
     * 清晰度
     */
    private String clarity;

    /**
     * 类型
     */
    private String type;

    /**
     * 视频图片
     */
    private String videoImages;

    /**
     * 简介
     */
    private String introduction;

}
