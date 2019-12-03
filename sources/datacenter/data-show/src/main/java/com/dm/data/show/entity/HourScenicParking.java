package com.dm.data.show.entity;

import javax.persistence.Entity;

import com.dm.kpi.core.entity.AbstractHourData;

import lombok.Getter;
import lombok.Setter;

/**
 * 每小时景区停车位
 * @author Administrator
 *
 */
@Getter
@Setter
@Entity
public class HourScenicParking extends AbstractHourData<Long> {

	/**
	 * 景区名称
	 */
	private String name;
}
