package com.dm.kpi.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;

import com.dm.kpi.core.entity.AbstractDayData;
import com.dm.kpi.core.entity.AbstractIndex;

import lombok.Getter;
import lombok.Setter;

/**
 * @author 1.0
 * @Description:
 * @Auther: hay17
 * @Date: 2018/12/8 11:40
 */

@Getter
@Setter
@Entity(name = "day_health_index")
public class DayHealthIndex  extends AbstractDayData<Integer> {

	/**
	 * 地区id
	 */
	@Column(name = "district_id")
	private String districtId;

	/**
	 * 指数信息,全部存储到json里面每小时抓取一次
	 */
	@Column(name = "info_")
	@Lob
	private String info;

}
