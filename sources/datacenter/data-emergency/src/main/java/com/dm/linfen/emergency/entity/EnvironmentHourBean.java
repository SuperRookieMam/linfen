package com.dm.linfen.emergency.entity;

import lombok.Data;

/**
 * 环境信息 小时版 实时 或 过去时
 * 
 * @author hay17
 */
@Data
public class EnvironmentHourBean {

	/**
	 * 日期 例如： 2018121008
	 */
	private String date;
	/**
	 * 地区id
	 */
	private String districtId;
	/**
	 * 地区名称
	 */
	private String districtName;

	private String time;
	/**
	 * 空气质量
	 */
	private String t1;
	private String t2;
	private String t3;
	/**
	 * pm10
	 */
	private String t4;
	/**
	 * CO
	 */
	private String t5;
	/**
	 * NO2
	 */
	private String t6;
	/**
	 * 臭氧
	 */
	private String t7;
	private String t8;
	/**
	 * SO2
	 */
	private String t9;
	/**
	 * pm2.5
	 */
	private String t10;
	/**
	 * 风力
	 */
	private String t11;
	/**
	 * 相对湿度
	 */
	private String t12;
	/**
	 * 降雨量
	 */
	private String t13;
	/**
	 * 风向
	 */
	private String t14;
	/**
	 * 温度
	 */
	private String t15;

}
