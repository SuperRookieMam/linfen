package com.dm.data.show.entity;

import javax.persistence.Entity;

import com.dm.kpi.core.entity.AbstractYearData;

import lombok.Getter;
import lombok.Setter;

/**
 * 每年媒体来源数量
 * @author Administrator
 *
 */
@Getter
@Setter
@Entity
public class YearMedia extends AbstractYearData<Long> {

	/**
	 * 媒体类型
	 * 微博、外媒、新闻等
	 */
	private String name;
}
