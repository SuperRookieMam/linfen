package com.dm.data.manager.service;

import com.dm.data.manager.dto.CarRentalCompanyDto;
import com.dm.data.manager.entity.CarRentalCompany;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface CarRentalCompanyService extends ApiService<CarRentalCompany> {

    public Optional<CarRentalCompany> findById(Long id);

    public CarRentalCompany save(CarRentalCompanyDto data);

    public CarRentalCompany update(Long id, CarRentalCompanyDto data);

    public void delete(Long id);

    public Page<CarRentalCompany> find(Pageable pageable);

    public Page<CarRentalCompany> find(CarRentalCompanyDto condition, String regionCode, Pageable pageable);
}
