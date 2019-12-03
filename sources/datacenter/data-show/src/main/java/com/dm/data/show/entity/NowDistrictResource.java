package com.dm.data.show.entity;

import javax.persistence.Entity;

import com.dm.kpi.core.entity.AbstractIndex;

import lombok.Getter;
import lombok.Setter;

/**
 * 各区县旅游资源
 * @author Administrator
 *
 */
@Getter
@Setter
@Entity
public class NowDistrictResource extends AbstractIndex<Long> {

	/**
	 * 区县名称
	 */
	private String name;
}
