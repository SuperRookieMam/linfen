package com.dm.kpi.dto;

import com.dm.kpi.core.dto.AbstractHourDataDto;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonAutoDetect(getterVisibility = Visibility.NONE, setterVisibility = Visibility.NONE)
public class HourAqiDataDto extends AbstractHourDataDto<Integer> {

	private static final long serialVersionUID = 727998671166981444L;

	@JsonProperty
	private String districtId;

	@JsonProperty
	private String pointName;

	@JsonProperty
	private String grade;
	/**
	 * 二氧化硫小时浓度
	 */
	@JsonProperty("pSo21h")
	private Float pSo21h;

	/**
	 * 二氧化氮小时浓度
	 */
	@JsonProperty("pNo21h")
	private Float pNo21h;

	/**
	 * 抽样小时浓度
	 */
	@JsonProperty("pO31h")
	private Float pO31h;

	/**
	 * 一氧化碳小时浓度
	 */
	@JsonProperty("pCo1h")
	private Float pCo1h;

	/**
	 * pm10小时平均浓度
	 */
	@JsonProperty("pPm101h")
	private Float pPm101h;

	/**
	 * pm25 小时平均浓度
	 */
	@JsonProperty("pPm251h")
	private Float pPm251h;

	/**
	 * 臭氧8小时滑动平均数
	 */
	@JsonProperty("pO38h")
	private Float pO38h;

	/**
	 * pm10 24小时滑动平均数
	 */
	@JsonProperty("pPm1024h")
	private Float pPm1024h;

	/**
	 * pm25 24小时滑动平均数
	 */
	@JsonProperty("pPm2524h")
	private Float pPm2524h;

	/**
	 * 二氧化硫小时分指数
	 */
	@JsonProperty("iSo21h")
	private Integer iSo21h;

	/**
	 * 二氧化氮小时分指数
	 */
	@JsonProperty("iNo21h")
	private Integer iNo21h;

	/**
	 * 抽样小时分指数
	 */
	@JsonProperty("iO31h")
	private Integer iO31h;

	/**
	 * 一氧化碳小时分指数
	 */
	@JsonProperty("iCo1h")
	private Integer iCo1h;

	/**
	 * pm10小时平均分指数
	 */
	@JsonProperty("iPm101h")
	private Integer iPm101h;

	/**
	 * pm25 小时平均分指数
	 */
	@JsonProperty("iPm251h")
	private Integer iPm251h;

	/**
	 * 臭氧8小时滑动平均数
	 */
	@JsonProperty("iO38h")
	private Integer iO38h;

	/**
	 * pm10 24小时滑动平均数
	 */
	@JsonProperty("iPm1024h")
	private Integer iPm1024h;

	/**
	 * pm25 24小时滑动平均数
	 */
	@JsonProperty("iPm2524h")
	private Integer iPm2524h;

}
