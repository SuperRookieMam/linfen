package com.dm.data.show.entity;

import javax.persistence.Entity;

import com.dm.kpi.core.entity.AbstractHourData;

import lombok.Getter;
import lombok.Setter;

/**
 * 每小时景区舒适度
 * @author Administrator
 *
 */
@Getter
@Setter
@Entity
public class HourScenicComfort extends AbstractHourData<Float> {

	/**
	 * 景区名称
	 */
	private String name;
}
