package com.dm.kpi.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.dm.kpi.core.entity.AbstractHourData;

import lombok.Getter;
import lombok.Setter;

/**
 * Copyright (c) 2019 江苏云智网络科技股份有限公司版权所有 <br>
 * 
 * @author 李东
 * @CreateDate 2019年9月5日
 */
@Entity(name = "hour_aqi_")
@Getter
@Setter
@Table(uniqueConstraints = { @UniqueConstraint(columnNames = { "region_code_", "point_name_", "current_date_" }) })
public class HourAqi extends AbstractHourData<Integer> {

	@Column(name = "district_id_")
	private String districtId;

	/**
	 * 点位名称
	 */
	@Column(name = "point_name_", length = 200)
	private String pointName;

	/**
	 * 空气质量等级 优、良、轻度、中度等
	 */
	@Column(name = "grade_", length = 20)
	private String grade;

	/**
	 * 二氧化硫小时浓度
	 */
	@Column(name = "p_so2_1h_")
	private Float pSo21h;

	/**
	 * 二氧化氮小时浓度
	 */
	@Column(name = "p_no2_1h_")
	private Float pNo21h;

	/**
	 * 臭氧小时浓度
	 */
	@Column(name = "p_o3_1h_")
	private Float pO31h;

	/**
	 * 一氧化碳小时浓度
	 */
	@Column(name = "p_co_1h_")
	private Float pCo1h;

	/**
	 * pm10小时平均浓度
	 */
	@Column(name = "p_pm10_1h_")
	private Float pPm101h;

	/**
	 * pm25 小时平均浓度
	 */
	@Column(name = "p_pm25_1h_")
	private Float pPm251h;

	/**
	 * 臭氧8小时滑动平均数
	 */
	@Column(name = "p_o3_8h_")
	private Float pO38h;

	/**
	 * pm10 24小时滑动平均数
	 */
	@Column(name = "p_pm10_24h_")
	private Float pPm1024h;

	/**
	 * pm25 24小时滑动平均数
	 */
	@Column(name = "p_pm25_24h_")
	private Float pPm2524h;

	/**
	 * 二氧化硫小时分指数
	 */
	@Column(name = "i_so2_1h_")
	private Integer iSo21h;

	/**
	 * 二氧化氮小时分指数
	 */
	@Column(name = "i_no2_1h_")
	private Integer iNo21h;

	/**
	 * 抽样小时分指数
	 */
	@Column(name = "i_o3_1h_")
	private Integer iO31h;

	/**
	 * 一氧化碳小时分指数
	 */
	@Column(name = "i_co_1h_")
	private Integer iCo1h;

	/**
	 * pm10小时平均分指数
	 */
	@Column(name = "i_pm10_1h_")
	private Integer iPm101h;

	/**
	 * pm25 小时平均分指数
	 */
	@Column(name = "i_pm25_1h_")
	private Integer iPm251h;

	/**
	 * 臭氧8小时滑动平均数
	 */
	@Column(name = "i_o3_8h_")
	private Integer iO38h;

	/**
	 * pm10 24小时滑动平均数
	 */
	@Column(name = "i_pm10_24h_")
	private Integer iPm1024h;

	/**
	 * pm25 24小时滑动平均数
	 */
	@Column(name = "i_pm25_24h_")
	private Integer iPm2524h;

}
