package com.dm.data.app.service.impl;

import com.dm.data.app.converter.TripConverter;
import com.dm.data.app.dto.TripDto;
import com.dm.data.app.entity.Trip;
import com.dm.data.app.repository.TripRepository;
import com.dm.data.app.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class TripServiceImpl implements TripService {
    @Autowired
    private TripRepository tripRepository;
    @Autowired
    private TripConverter tripConverter;
    @Override
    @Transactional
    public Trip save(TripDto dto) {
        Trip trip=new Trip();
        tripConverter.copyProperties(trip,dto);
        return tripRepository.save(trip);
    }

    @Override
    @Transactional
    public Trip update(Long id, TripDto dto) {
        Optional<Trip> optionalTrip=tripRepository.findById(id);
        if(optionalTrip.isPresent()){
            Trip trip=optionalTrip.get();
            tripConverter.copyProperties(trip,dto);
            return tripRepository.saveAndFlush(trip);
        }
        return null;
    }

    @Override
    public Trip findById(Long id) {
        Optional<Trip> optionalTrip=tripRepository.findById(id);
        if(optionalTrip.isPresent()){
            return optionalTrip.get();
        }
        return null;
    }

    @Override
    @Transactional
    public void delete(Long id) {
        tripRepository.deleteById(id);
    }

    @Override
    public Page<Trip> search(Pageable pageable, String search) {
        return null;
    }
}
