package com.dm.kpi.service;

import com.dm.kpi.core.service.BaseIndexService;
import com.dm.kpi.dto.DayHealthIndexDto;
import com.dm.kpi.entity.DayHealthIndex;

import java.time.LocalDate;

/**
 * @author Administrator
 * @Title: HealthIndexService
 * @ProjectName datacenter
 * @Description: TODO
 * @date 2019/9/5 000516:18
 */
public interface DayHealthIndexService extends BaseIndexService<DayHealthIndex, DayHealthIndexDto>{

    DayHealthIndex findByCurrentDateAndDistrictId(LocalDate localDate, String districtId);

    DayHealthIndex save(DayHealthIndex model);

}
