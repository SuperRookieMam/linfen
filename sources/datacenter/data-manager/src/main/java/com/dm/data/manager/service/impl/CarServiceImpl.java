package com.dm.data.manager.service.impl;

import com.dm.data.manager.converter.CarConverter;
import com.dm.data.manager.dto.CarDto;
import com.dm.data.manager.entity.Car;
import com.dm.data.manager.entity.QCar;
import com.dm.data.manager.repository.CarRentalCompanyRepository;
import com.dm.data.manager.repository.CarRepository;
import com.dm.data.manager.service.CarService;
import com.querydsl.core.BooleanBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;
import java.util.Optional;

@Service
public class CarServiceImpl extends AbstractCurrencyServiceImpl<Car> implements CarService {

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private CarConverter carConverter;

    @Autowired
    private CarRentalCompanyRepository carRentalCompanyRepository;

    private QCar qCar = QCar.car;

    @Override
    public Optional<Car> findById(Long id) {
        return carRepository.findById(id);
    }

    @Override
    @Transactional
    public Car save(CarDto data) {
        Car entity = new Car();
        carConverter.copyProperties(entity, data);
        return carRepository.save(entity);
    }

    @Override
    @Transactional
    public Car update(Long id, CarDto data) {
        Car entity = carRepository.getOne(id);
        carConverter.copyProperties(entity, data);
        return entity;
    }

    @Override
    @Transactional
    public void delete(Long id) {
        carRepository.deleteById(id);
    }

    @Override
    public Page<Car> find(Pageable pageable) {
        return carRepository.findAll(pageable);
    }

    @Override
    public Page<Car> find(Long companyId, CarDto condition, Pageable pageable) {
        BooleanBuilder builder = new BooleanBuilder();
        /* builder.and(qCar.company.id.eq(companyId)); */
        if (!Objects.isNull(condition)) {
            if (!Objects.isNull(condition.getPlateNo())) {
                builder.and(qCar.plateNo.containsIgnoreCase(condition.getPlateNo()));
            }
        }
        return carRepository.findAll(builder, pageable);
    }

}
