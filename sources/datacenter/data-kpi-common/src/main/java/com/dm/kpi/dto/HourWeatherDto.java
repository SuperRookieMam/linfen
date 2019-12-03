package com.dm.kpi.dto;

import com.dm.kpi.core.dto.AbstractHourDataDto;

import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class HourWeatherDto extends AbstractHourDataDto<Integer> {
	private static final long serialVersionUID = 2550633062393068114L;

	private String districtId;

	private String pointName;

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
	private String temperature;

	/**
	 * 相对湿度
	 */
	private String humidity;
	/**
	 * 降水量
	 */
	private String precipitation;
	/**
	 * 风力
	 */
	private String windScale;

	/**
	 * 风向
	 */
	private String windDirection;

}
