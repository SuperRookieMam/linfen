package com.dm.linfen.emergency.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * 未来天气情况
 * 
 * @author hay17
 */
@Data
@Entity(name = "t_future_weather")
public class FutureWeather {

	/**
	 * 自增id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	/**
	 * 数据采集时间
	 */
	@Column(name = "date_")
	private LocalDate date;
	/**
	 * 地区id
	 */
	@Column(name = "district_id")
	private String districtId;
	/**
	 * 地区名称
	 */
	@Column(name = "district_name")
	private String districtName;
	/**
	 * 今天
	 */
	@Column(name = "today_")
	private String today;

	/**
	 * 第二天
	 */
	@Column(name = "second_day_")
	private String secondDay;

	/**
	 * 第三天
	 */
	@Column(name = "third_day_")
	private String thirdDay;

	/**
	 * 第四天
	 */
	@Column(name = "forth_day_")
	private String forthDay;
	/**
	 * 第五天
	 */
	@Column(name = "fifth_day_")
	private String fifthDay;
	/**
	 * 第六天
	 */
	@Column(name = "sixth_day_")
	private String sixthDay;
	/**
	 * 第一天
	 */
	@Column(name = "seventh_day_")
	private String seventhDay;

}
