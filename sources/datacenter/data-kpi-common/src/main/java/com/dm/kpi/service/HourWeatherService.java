package com.dm.kpi.service;

import com.dm.kpi.core.service.BaseIndexService;
import com.dm.kpi.dto.HourWeatherDto;
import com.dm.kpi.entity.HourWeather;

import java.util.List;
/**
    * @Author:         温东山
    * @Description:    类作用描述
    * @CreateDate:     2019/9/6 0006 09:17
    * @UpdateUser:     温东山
    * @UpdateDate:     2019/9/6 0006 09:17
    * @history:   修改记录
    * @Version:        1.0
*/
public interface HourWeatherService extends BaseIndexService<HourWeather, HourWeatherDto> {

    /**
     * 按照区域查询最近多少个小时的数据
     * @param num
     * @param districtId
     * @return
     */
    List<HourWeather> findHourWeathers(Integer num, String districtId);
}
