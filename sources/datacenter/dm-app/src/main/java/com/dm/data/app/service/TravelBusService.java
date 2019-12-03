package com.dm.data.app.service;

import com.dm.data.app.dto.TravelBusDto;
import com.dm.data.app.entity.TravelBus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;
import java.util.List;

public interface TravelBusService {

    TravelBus save(TravelBusDto dto);

    TravelBus update(Long id,TravelBusDto dto);

    TravelBus findById(Long id);

    void delete(Long id);

    Page<TravelBus>  search(Pageable pageable,String search);

    TravelBus findByTeamIdAndTime(Long teamId, LocalDate time);

    List<TravelBus> findByTeamId(Long teamId);

}
