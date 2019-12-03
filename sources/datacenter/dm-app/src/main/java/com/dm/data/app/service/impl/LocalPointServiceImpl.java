package com.dm.data.app.service.impl;

import com.dm.data.app.converter.LocalPointConverter;
import com.dm.data.app.dto.LocalPointDto;
import com.dm.data.app.entity.LocalPoint;
import com.dm.data.app.repository.LocalPointRepository;
import com.dm.data.app.service.LocalPointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class LocalPointServiceImpl implements LocalPointService {
    @Autowired
    private LocalPointRepository localPointRepository;
    @Autowired
    private LocalPointConverter localPointConverter;
    @Override
    @Transactional
    public LocalPoint save(LocalPointDto dto) {
        LocalPoint localPoint=new LocalPoint();
        localPointConverter.copyProperties(localPoint,dto);
        return localPointRepository.save(localPoint);
    }

    @Override
    @Transactional
    public LocalPoint update(Long id, LocalPointDto dto) {
        Optional<LocalPoint> optionalLocalPoint=localPointRepository.findById(id);
        if(optionalLocalPoint.isPresent()){
            LocalPoint localPoint=optionalLocalPoint.get();
            localPointConverter.copyProperties(localPoint,dto);
            return localPointRepository.saveAndFlush(localPoint);
        }
        return null;
    }

    @Override
    public LocalPoint findById(Long id) {
        Optional<LocalPoint> optionalLocalPoint=localPointRepository.findById(id);
        if(optionalLocalPoint.isPresent()){
            return  optionalLocalPoint.get();
        }
        return null;
    }

    @Override
    @Transactional
    public void delete(Long id) {
        localPointRepository.deleteById(id);
    }

    @Override
    public Page<LocalPoint> search(Pageable pageable, String search) {
        return localPointRepository.findAll(pageable);
    }
}
