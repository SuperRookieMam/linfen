package com.dm.kpi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dm.common.converter.AbstractConverter;
import com.dm.kpi.converter.HourAqiDataConverter;
import com.dm.kpi.core.controller.BaseIndexController;
import com.dm.kpi.core.service.BaseIndexService;
import com.dm.kpi.dto.HourAqiDataDto;
import com.dm.kpi.entity.HourAqi;
import com.dm.kpi.service.HourAqiService;

@RestController
@RequestMapping("hourAqis")
public class HourAqiController extends BaseIndexController<HourAqi, HourAqiDataDto>{

	@Autowired
	private HourAqiService aqiService;

	@Autowired
	private HourAqiDataConverter aqiConverter;
	
	@Override
	protected AbstractConverter<HourAqi, HourAqiDataDto> getConverter() {
		return aqiConverter;
	}

	@Override
	protected BaseIndexService<HourAqi, HourAqiDataDto> getService() {
		return aqiService;
	}
	
	 /**
     * 一氧化碳 so3等指标信息
     *
     * @param num        查询未来前多少小时时间
     * @param districtId 区域id
     * @return
     */
    @GetMapping("/hourAqi")
    public List<HourAqiDataDto> findHourAqis(@RequestParam("num") Integer num,
                                      @RequestParam("districtId") String districtId) {
    	List<HourAqi> models = aqiService.findHourAqis(num, districtId);
        return aqiConverter.toDto(models);
    }

}
