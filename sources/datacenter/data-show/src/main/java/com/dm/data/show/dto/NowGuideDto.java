package com.dm.data.show.dto;


import com.dm.kpi.core.dto.AbstractBaseIndexDto;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 导游类别统计
 * @author Administrator
 *
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class NowGuideDto extends AbstractBaseIndexDto<Long> {

	private static final long serialVersionUID = -1567299534255475786L;
	/**
	 * 导游类别
	 * 特级、高级、中级、初级
	 */
	private String name;
}
