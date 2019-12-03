package com.dm.kpi.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.dm.kpi.core.entity.AbstractDayData;

import lombok.Getter;
import lombok.Setter;

/**
 * 未来天气情况
 * 
 * @author 温东山
 */
@Getter
@Setter
@Entity(name = "day_weather_")
public class DayWeather extends AbstractDayData<Integer> {

	/**
	 * 地区id
	 */
	@Column(name = "district_id")
	private String districtId;

	/**
	 * 未来时间
	 */
	@Column(name = "future_date_")
	private LocalDate futureDate;

	/**
	 * 多云转小雨
	 */
	@Column(name = "weather_")
	private String weather;

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
	 * 白天风向
	 */
	@Column(name = "day_wind_direction_")
	private String dayWindDirection;

	/**
	 * 晚间风向
	 */
	@Column(name = "night_wind_direction_")
	private String nightWindDirection;

	/**
	 * 风力
	 */
	@Column(name = "wind_scale_")
	private String windScale;







}
