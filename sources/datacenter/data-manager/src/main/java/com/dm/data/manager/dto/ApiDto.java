package com.dm.data.manager.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApiDto extends AbstractRegionDto {

    private int code;

    private String msg;

    private Object data;

    public static ApiDto success(Object data) {
        ApiDto resultDto = new ApiDto();
        resultDto.setCode(0);
        resultDto.setMsg("操作成功");
        resultDto.setData(data);
        return resultDto;
    }

    public static ApiDto error(Object data) {
        ApiDto resultDto = new ApiDto();
        resultDto.setCode(1);
        resultDto.setMsg("操作失败");
        resultDto.setData(data);
        return resultDto;
    }
}
