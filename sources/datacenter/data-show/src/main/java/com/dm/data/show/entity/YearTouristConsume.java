package com.dm.data.show.entity;

import javax.persistence.Entity;

import com.dm.kpi.core.entity.AbstractYearData;

import lombok.Getter;
import lombok.Setter;

/**
 * 每年游客消费分析
 * @author Administrator
 *
 */
@Getter
@Setter
@Entity
public class YearTouristConsume extends AbstractYearData<Long> {

	/**
	 * 消费类型
	 * 2000以下、2000-3000、3000-4000、4000-5000、5000-6000、6000以上
	 */
	private String name;
}
