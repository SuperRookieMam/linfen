package com.dm.data.manager.service.impl;

import com.dm.data.manager.converter.TouristRouteConverter;
import com.dm.data.manager.dto.TouristRouteDto;
import com.dm.data.manager.entity.QTouristRoute;
import com.dm.data.manager.entity.TouristRoute;
import com.dm.data.manager.repository.TouristRouteRepository;
import com.dm.data.manager.service.MediaService;
import com.dm.data.manager.service.TouristRouteService;
import com.querydsl.core.BooleanBuilder;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class TouristRouteServiceImpl extends AbstractCurrencyServiceImpl<TouristRoute> implements TouristRouteService {

    @Autowired
    private TouristRouteRepository touristRouteRepository;

    @Autowired
    private TouristRouteConverter touristRouteConverter;
    @Autowired
    private MediaService mediaService;

    private final QTouristRoute qTouristRoute = QTouristRoute.touristRoute;

    @Override
    public Optional<TouristRoute> findById(Long id) {
        return touristRouteRepository.findById(id);
    }

    @Override
    @Transactional
    public TouristRoute save(TouristRouteDto data) {
        TouristRoute entity = new TouristRoute();
        touristRouteConverter.copyProperties(entity, data);
        entity.setImages(mediaService.toImage(data.getImages()));
        return touristRouteRepository.save(entity);
    }

    @Override
    @Transactional
    public TouristRoute update(Long id, TouristRouteDto data) {
        TouristRoute entity = touristRouteRepository.getOne(id);
        touristRouteConverter.copyProperties(entity, data);
        return entity;
    }

    @Override
    @Transactional
    public void delete(Long id) {
        touristRouteRepository.deleteById(id);
    }

    @Override
    public Page<TouristRoute> find(Pageable pageable) {
        return touristRouteRepository.findAll(pageable);
    }

    @Override
    public Page<TouristRoute> find(TouristRouteDto condition, Pageable pageable) {
        BooleanBuilder builder = new BooleanBuilder();
        String fullName = condition.getName();
        if (StringUtils.isNotBlank(fullName)) {
            builder.and(qTouristRoute.no.containsIgnoreCase(fullName))
                    .or(qTouristRoute.name.containsIgnoreCase(fullName))
                    .or(qTouristRoute.type.containsIgnoreCase(fullName))
                    .or(qTouristRoute.days.containsIgnoreCase(fullName));
        }

        return touristRouteRepository.findAll(builder, pageable);
    }

    @Override
    public List<TouristRoute> randomThree() {
        return touristRouteRepository.randomThree();
    }

    @Override
    public List<TouristRoute> findBySearch(String search) {
        return touristRouteRepository.findByNameContains(search);
    }
}
