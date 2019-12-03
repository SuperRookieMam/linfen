package com.dm.kpi.service.impl;

import com.dm.common.converter.AbstractConverter;
import com.dm.kpi.converter.HourAqiDataConverter;
import com.dm.kpi.core.service.impl.BaseIndexServiceImpl;
import com.dm.kpi.dto.HourAqiDataDto;
import com.dm.kpi.entity.HourAqi;
import com.dm.kpi.entity.QHourAqi;
import com.dm.kpi.repository.HourAqiRepository;
import com.dm.kpi.service.HourAqiService;
import com.dm.security.core.userdetails.UserDetailsDto;
import com.querydsl.core.BooleanBuilder;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Objects;

@Service
public class HourAqiServiceImpl extends BaseIndexServiceImpl<HourAqi, HourAqiDataDto> implements HourAqiService {

    @Autowired
    private HourAqiRepository hourAqiRepository;

    @Autowired
    private HourAqiDataConverter hourAqiConverter;

    private final QHourAqi qHourAqi = QHourAqi.hourAqi;

    @Override
    protected JpaRepository<HourAqi, Long> getRepository() {
        return hourAqiRepository;
    }

    @Override
    protected QuerydslPredicateExecutor<HourAqi> getQuerydsl() {
        return hourAqiRepository;
    }

    @Override
    protected AbstractConverter<HourAqi, HourAqiDataDto> getConverter() {
        return hourAqiConverter;
    }

    @Override
    protected HourAqi newModel() {
        return new HourAqi();
    }

    @Override
    protected BooleanBuilder searchCondition(UserDetailsDto user, String keywords, HourAqiDataDto dto) {
        BooleanBuilder query = new BooleanBuilder();
        if (!Objects.isNull(user)) {
            String regionCode = user.getRegionCode();
            if (StringUtils.isNotBlank(regionCode)) {
                query.and(qHourAqi.regionCode.startsWith(StringUtils.stripEnd(user.getRegionCode(), "0")));
            }
        }
        if (StringUtils.isNoneBlank(keywords)) {
            query.and(qHourAqi.regionCode.containsIgnoreCase(keywords)
                    .or(qHourAqi.regionName.containsIgnoreCase(keywords))
                    .or(qHourAqi.pointName.containsIgnoreCase(keywords)));
        }
        return query;
    }

    @Override
    public List<HourAqi> findHourAqis(Integer num, String districtId) {
        ZonedDateTime zonedDateTime = ZonedDateTime.now().withMinute(0).withSecond(0).withNano(0).minusHours(num);
        return hourAqiRepository.findByDistrictIdAndCurrentDate(districtId, zonedDateTime);
    }
}
