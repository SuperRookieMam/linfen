package com.dm.linfen.collection.dto;

import java.util.List;

import lombok.Data;

/**
    * @Author:         温东山
    * @Description:    组装bean
    * @CreateDate:      16:30
    * @UpdateUser:     温东山
    * @UpdateDate:      16:30
    * @history:   修改记录
    * @Version:        1.0
*/
@Data
public class HourAqiFetchResult {
	private String station;
	private String name;
	private List<HourAqiFetchDto> data;
}
