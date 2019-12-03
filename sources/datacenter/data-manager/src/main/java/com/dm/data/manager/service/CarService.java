package com.dm.data.manager.service;

import com.dm.data.manager.dto.CarDto;
import com.dm.data.manager.entity.Car;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface CarService extends ApiService<Car> {

    public Optional<Car> findById(Long id);

    public Car save(CarDto data);

    public Car update(Long id, CarDto data);

    public void delete(Long id);

    public Page<Car> find(Pageable pageable);

    public Page<Car> find(Long companyId, CarDto condition, Pageable pageable);
}
