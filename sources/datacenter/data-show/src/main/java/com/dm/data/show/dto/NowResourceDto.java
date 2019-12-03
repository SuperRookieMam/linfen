package com.dm.data.show.dto;


import com.dm.kpi.core.dto.AbstractBaseIndexDto;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 全市旅游资源
 * @author Administrator
 *
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class NowResourceDto extends AbstractBaseIndexDto<Long> {

	private static final long serialVersionUID = 8518358282216245097L;
	/**
	 * 资源名称
	 */
	private String name;
}
