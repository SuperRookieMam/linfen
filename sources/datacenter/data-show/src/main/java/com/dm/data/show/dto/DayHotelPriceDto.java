package com.dm.data.show.dto;


import com.dm.kpi.core.dto.AbstractDayDataDto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class DayHotelPriceDto extends AbstractDayDataDto<Float> {

	private static final long serialVersionUID = 8129019139157543365L;
	
	private String name;
}
