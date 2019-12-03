package com.dm.linfen.collection.service.impl;

import com.dm.kpi.entity.HourWeather;
import com.dm.kpi.repository.HourWeatherRepository;
import com.dm.linfen.collection.dto.HourWeatherFetchDto;
import com.dm.linfen.collection.entity.District;
import com.dm.linfen.collection.service.HourWeatherExtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author 温东山
 * @create 2019-09-05 14:08
 **/
@Service
public class HourWeatherServiceExtImpl implements HourWeatherExtService {


    @Autowired
    HourWeatherRepository hourWeatherRepository;

    @Override
    public void saveOrUpdate(List<HourWeatherFetchDto> datas, ZonedDateTime start, District district) {
        ZonedDateTime current = start.withMinute(0).withSecond(0).withNano(0);
        int length = datas.size();
        List<HourWeather> results = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            HourWeatherFetchDto from = datas.get(i);
            current = current.withHour(from.getTime());
            if (current.getHour() == 0 && i > 0) {
                current = current.plusDays(1);
            }
            HourWeather d = null;
            Optional<HourWeather> optionalD = hourWeatherRepository.findByRegionCodeAndPointNameAndCurrentDate(district.getRegionCode(),
                    district.getRegionName(), current);
            if (optionalD.isPresent()) {
                d = optionalD.get();
            } else {
                d = new HourWeather();
            }
            d.setCurrentDate(current);
            d.setValue(from.getValue());
            d.setRegionCode(district.getRegionCode());
            d.setRegionName(district.getRegionName());
            d.setPointName(district.getName());
            d.setDistrictId(district.getDistrictId());
            d.setHumidity(from.getHumidity());
            d.setPrecipitation(from.getPrecipitation());
            d.setTemperature(from.getTemperature());
            d.setWindDirection(from.getWindDirection());
            d.setWindScale(from.getWindScale());
            results.add(d);
        }
        hourWeatherRepository.saveAll(results);
    }
}
