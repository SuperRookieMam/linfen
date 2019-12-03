package com.dm.linfen.collection.dto;

import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HourWeatherFetchDto {

	private String districtId;

	private String pointName;

	@JsonSetter("t1")
	private Integer value;

	private Integer time;

	/**
	 * 天气
	 */
	private String whether;

	/**
	 * 气温高
	 */
	private String tempMax;

	/**
	 * 气温低
	 */
	private String tempMin;

	/**
	 * 温度
	 */
	@JsonSetter("t15")
	private String temperature;

	/**
	 * 相对湿度
	 */
	@JsonSetter("t12")
	private String humidity;
	/**
	 * 降水量
	 */
	@JsonSetter("t13")
	private String precipitation;
	/**
	 * 风力
	 */
	@JsonSetter("t11")
	private String windScale;

	/**
	 * 风向
	 */
	@JsonSetter("t14")
	private String windDirection;

}
