package com.dm.data.app.service.impl;

import com.dm.data.app.converter.LocalPointConverter;
import com.dm.data.app.converter.TravelBusConverter;
import com.dm.data.app.dto.LocalPointDto;
import com.dm.data.app.dto.TravelBusDto;
import com.dm.data.app.entity.LocalPoint;
import com.dm.data.app.entity.QTravelBus;
import com.dm.data.app.entity.TravelBus;
import com.dm.data.app.repository.LocalPointRepository;
import com.dm.data.app.repository.TravelBusRepository;
import com.dm.data.app.service.TravelBusService;
import com.querydsl.core.BooleanBuilder;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class TravelBusServiceImpl implements TravelBusService {
    @Autowired
    private TravelBusConverter travelBusConverter;
    @Autowired
    private LocalPointConverter localPointConverter;

    @Autowired
    private TravelBusRepository travelBusRepository;

    private final QTravelBus qTravelBus =QTravelBus.travelBus;
    @Autowired
    private LocalPointRepository localPointRepository;
    @Override
    @Transactional
    public TravelBus save(TravelBusDto dto) {
        TravelBus travelBus=new TravelBus();
        travelBusConverter.copyProperties(travelBus,dto);
        travelBus=copyValue(travelBus,dto);
        return travelBusRepository.save(travelBus);
    }

    @Override
    @Transactional
    public TravelBus update(Long id, TravelBusDto dto) {
        Optional<TravelBus> optionalTravelBus=travelBusRepository.findById(id);
        if(optionalTravelBus.isPresent()){
            TravelBus travelBus=optionalTravelBus.get();
            travelBusConverter.copyProperties(travelBus,dto);
            travelBus=copyValue(travelBus,dto);
            return travelBusRepository.saveAndFlush(travelBus);
        }

        return null;
    }


    @Override
    public TravelBus findById(Long id) {
        Optional<TravelBus> optionalTravelBus=travelBusRepository.findById(id);
        if(optionalTravelBus.isPresent()){
            return optionalTravelBus.get();
        }
        return null;
    }

    @Override
    @Transactional
    public void delete(Long id) {
        travelBusRepository.deleteById(id);
    }

    @Override
    public TravelBus findByTeamIdAndTime(Long teamId, LocalDate time) {
        Optional<TravelBus> optionalTravelBus =travelBusRepository.findByTeamIdAndDayTime(teamId,time);
        if(optionalTravelBus.isPresent()){
            return optionalTravelBus.get();
        }
        return null;
    }

    @Override
    public List<TravelBus> findByTeamId(Long teamId) {
        return travelBusRepository.findByTeamId(teamId);
    }

    @Override
    public Page<TravelBus> search(Pageable pageable, String search) {
        BooleanBuilder builder = new BooleanBuilder();
        if(StringUtils.isNotBlank(search)){
            builder.and(qTravelBus.guiderName.containsIgnoreCase(search)
                    .or(qTravelBus.driverName.containsIgnoreCase(search))
                    .or(qTravelBus.carNum.containsIgnoreCase(search)));
        }

        return travelBusRepository.findAll(builder,pageable);
    }

    private  TravelBus copyValue(TravelBus travelBus,TravelBusDto dto){
      travelBus=travelBusConverter.copyProperties(travelBus,dto);
      if(CollectionUtils.isNotEmpty(dto.getPoints())){
            LocalPoint localPoint=new LocalPoint();
            List<LocalPoint> localPointlist=new ArrayList<>();
            for(LocalPointDto localPointDto :dto.getPoints()){
                if(!Objects.isNull(localPointDto.getId())){
                    localPoint =localPointRepository.getOne(localPointDto.getId());
                }
                localPointlist.add(localPointConverter.copyProperties(localPoint,localPointDto));
            }
          travelBus.setPoints(localPointlist);
      }

        return  travelBus;
    }
}
