package com.dm.linfen.collection.dto;

import com.fasterxml.jackson.annotation.JsonSetter;

import lombok.Getter;
import lombok.Setter;
/**
    * @Author:         温东山
    * @Description:    抓取的指数dto
    * @CreateDate:     2019/9/5 0005 16:29
    * @UpdateUser:     温东山
    * @UpdateDate:     2019/9/5 0005 16:29
    * @history:   修改记录
    * @Version:        1.0
*/
@Getter
@Setter
public class HourAqiFetchDto {

	@JsonSetter("t1")
	private Integer value;

	private String pointName;

	private String grade;
	/**
	 * 二氧化硫小时浓度
	 */
	@JsonSetter("t9")
	private Float pSo21h;

	/**
	 * 二氧化氮小时浓度
	 */
	@JsonSetter("t6")
	private Float pNo21h;

	/**
	 * 臭氧小时浓度
	 */
	@JsonSetter("t7")
	private Float pO31h;

	/**
	 * 一氧化碳小时浓度
	 */
	@JsonSetter("t5")
	private Float pCo1h;

	/**
	 * pm10小时平均浓度
	 */
	@JsonSetter("t4")
	private Float pPm101h;

	/**
	 * pm25 小时平均浓度
	 */
	@JsonSetter("t3")
	private Float pPm251h;

	/**
	 * 臭氧8小时滑动平均数
	 */
	private Float pO38h;

	/**
	 * pm10 24小时滑动平均数
	 */
	private Float pPm1024h;

	/**
	 * pm25 24小时滑动平均数
	 */
	private Float pPm2524h;

	/**
	 * 二氧化硫小时分指数
	 */
	private Integer iSo21h;

	/**
	 * 二氧化氮小时分指数
	 */
	private Integer iNo21h;

	/**
	 * 抽样小时分指数
	 */
	private Integer iO31h;

	/**
	 * 一氧化碳小时分指数
	 */
	private Integer iCo1h;

	/**
	 * pm10小时平均分指数
	 */
	private Integer iPm101h;

	/**
	 * pm25 小时平均分指数
	 */
	private Integer iPm251h;

	/**
	 * 臭氧8小时滑动平均数
	 */
	private Integer iO38h;

	/**
	 * pm10 24小时滑动平均数
	 */
	private Integer iPm1024h;

	/**
	 * pm25 24小时滑动平均数
	 */
	private Integer iPm2524h;

	private Integer time;
}
