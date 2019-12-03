package com.dm.kpi.entity;

import com.dm.kpi.core.entity.AbstractHourData;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * 小时天气情况 <br>
 * 
 * value存储温度
 * 
 * @author LiDong
 *
 */
@Getter
@Setter
@Entity(name = "hour_whether_")
@Table(uniqueConstraints = { @UniqueConstraint(columnNames = { "region_code_", "point_name_", "current_date_" }) })
public class HourWeather extends AbstractHourData<Integer> {

	@Column(name = "district_id_")
	private String districtId;

	/**
	 * 点位,可能是景区，可能是地域，也可能是其它的
	 */
	@Column(name = "point_name_")
	private String pointName;

	/**
	 * 天气
	 */
	@Column(name = "weather_")
	private String whether;

	/**
	 * 气温高
	 */
	@Column(name = "temp_max_")
	private String tempMax;

	/**
	 * 气温低
	 */
	@Column(name = "temp_min_")
	private String tempMin;

	/**
	 * 温度
	 */
	@Column(name = "temperature_")
	private String temperature;

	/**
	 * 相对湿度
	 */
	@Column(name = "humidity_")
	private String humidity;
	/**
	 * 降水量
	 */
	@Column(name = "precipitation_")
	private String precipitation;
	/**
	 * 风力
	 */
	@Column(name = "wind_scale_")
	private String windScale;

	/**
	 * 风向
	 */
	@Column(name = "wind_direction_")
	private String windDirection;

}
