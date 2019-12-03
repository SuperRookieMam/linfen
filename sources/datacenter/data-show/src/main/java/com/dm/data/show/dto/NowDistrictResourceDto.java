package com.dm.data.show.dto;


import com.dm.kpi.core.dto.AbstractBaseIndexDto;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 各区县旅游资源
 * @author Administrator
 *
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class NowDistrictResourceDto extends AbstractBaseIndexDto<Long> {

	private static final long serialVersionUID = 7848733616095331125L;
	/**
	 * 区县名称
	 */
	private String name;
}
