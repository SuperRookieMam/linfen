package com.dm.linfen.emergency.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * 环境信息 小时版 实时 或 过去时
 * 
 * @author hay17
 */
@Data
@Entity(name = "t_environment_hour")
public class EnvironmentHour {

	/**
	 * 自增id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	/**
	 * 日期 例如： 2018121008
	 */
	@Column(name = "date_")
	private String date;
	/**
	 * 地区id
	 */
	@Column(name = "district_id_")
	private String districtId;
	/**
	 * 地区名称
	 */
	@Column(name = "district_name_")
	private String districtName;
	/**
	 * 空气质量
	 */
	@Column(name = "air_quality_")
	private String airQuality;

	/**
	 * pm10
	 */
	@Column(name = "pm10_")
	private String pm10;
	/**
	 * CO
	 */
	@Column(name = "co_")
	private String co;
	/**
	 * NO2
	 */
	@Column(name = "no2_")
	private String no2;
	/**
	 * 臭氧O3
	 */
	@Column(name = "ozone_")
	private String ozone;
	/**
	 * SO2
	 */
	@Column(name = "so2_")
	private String so2;
	/**
	 * pm2.5
	 */
	@Column(name = "pm25_")
	private String pm25;
	/**
	 * 风力
	 */
	@Column(name = "wind_power_")
	private String windPower;
	/**
	 * 相对湿度
	 */
	@Column(name = "humidity_")
	private String humidity;
	/**
	 * 降雨量
	 */
	@Column(name = "rainfall_")
	private String rainfall;
	/**
	 * 风向
	 */
	@Column(name = "wind_direction_")
	private String windDirection;
	/**
	 * 温度
	 */
	@Column(name = "temperature_")
	private String temperature;

}
