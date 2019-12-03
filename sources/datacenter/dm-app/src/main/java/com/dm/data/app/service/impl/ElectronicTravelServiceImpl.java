package com.dm.data.app.service.impl;

import com.dm.data.app.converter.ElectronicTravelConverter;
import com.dm.data.app.converter.TripConverter;
import com.dm.data.app.dto.ElectronicTravelDto;
import com.dm.data.app.dto.TripDto;
import com.dm.data.app.entity.ElectronicTravel;
import com.dm.data.app.entity.QElectronicTravel;
import com.dm.data.app.entity.Trip;
import com.dm.data.app.repository.ElectronicTravelRepository;
import com.dm.data.app.repository.TripRepository;
import com.dm.data.app.service.ElectronicTravelService;
import com.querydsl.core.BooleanBuilder;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ElectronicTravelServiceImpl implements ElectronicTravelService {
    @Autowired
    private ElectronicTravelRepository electronicTravelRepository;
    @Autowired
    private ElectronicTravelConverter electronicTravelConverter;
    @Autowired
    private TripConverter tripConverter;

    @Autowired
    private TripRepository tripRepository;

    private final QElectronicTravel qElectronicTravel=QElectronicTravel.electronicTravel;
    @Override
    @Transactional
    public ElectronicTravel save(ElectronicTravelDto dto) {
        ElectronicTravel electronicTravel=new ElectronicTravel();
        electronicTravel= copyValue(electronicTravel,dto);
        return electronicTravelRepository.save(electronicTravel);
    }

    @Override
    @Transactional
    public ElectronicTravel update(Long id, ElectronicTravelDto dto) {
        Optional<ElectronicTravel> optional=electronicTravelRepository.findById(id);
        if(optional.isPresent()){
            ElectronicTravel electronicTravel=optional.get();
            electronicTravel= copyValue(electronicTravel,dto);
            return electronicTravelRepository.saveAndFlush(electronicTravel);
        }
        return null;
    }


    @Override
    @Transactional
    public void delete(Long id) {
        electronicTravelRepository.deleteById(id);
    }

    @Override
    public ElectronicTravel findById(Long id) {
        Optional<ElectronicTravel> optional=electronicTravelRepository.findById(id);
        if(optional.isPresent()){
            return  optional.get();
        }
        return null;
    }

    @Override
    public Page<ElectronicTravel> search(Pageable pageable, String search) {
        BooleanBuilder builder = new BooleanBuilder();

        // 这段代码过滤可见区域
        if (StringUtils.isNotEmpty(search)) {
            builder.and(qElectronicTravel.guiderName.containsIgnoreCase(search).
                    or(qElectronicTravel.travelName.containsIgnoreCase(search)));
        }
        return electronicTravelRepository.findAll(builder,pageable);
    }

    private ElectronicTravel copyValue(ElectronicTravel electronicTravel ,ElectronicTravelDto dto){
        electronicTravelConverter.copyProperties(electronicTravel,dto);
        if(CollectionUtils.isNotEmpty(dto.getTrips())){
            Trip trip=new Trip();
            List<Trip> trips=new ArrayList<>();
            for(TripDto tripDto :dto.getTrips()){
                if(!Objects.isNull(tripDto.getId())){
                    trip=tripRepository.getOne(tripDto.getId());
                }
                trips.add(tripConverter.copyProperties(trip,tripDto));
            }
            electronicTravel.setTrips(trips);
        }
        return electronicTravel;
    }

    @Override
    public ElectronicTravel findByTeamId(Long teamId) {
        Optional<ElectronicTravel> optionalElectronicTravel =electronicTravelRepository.findByTeamId(teamId);
        if(optionalElectronicTravel.isPresent()){
            return optionalElectronicTravel.get();
        }
        return null;
    }
}
