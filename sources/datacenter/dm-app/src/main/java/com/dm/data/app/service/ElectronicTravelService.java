package com.dm.data.app.service;

import com.dm.data.app.dto.ElectronicTravelDto;
import com.dm.data.app.entity.ElectronicTravel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ElectronicTravelService {

    ElectronicTravel save(ElectronicTravelDto dto);

    ElectronicTravel update(Long id,ElectronicTravelDto dto);

    void delete(Long id);

    ElectronicTravel findById(Long id);

    ElectronicTravel findByTeamId(Long teamId);

    Page<ElectronicTravel>  search(Pageable pageable,String search);
}
