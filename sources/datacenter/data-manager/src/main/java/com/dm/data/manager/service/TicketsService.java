package com.dm.data.manager.service;

import com.dm.data.manager.dto.TicketsDto;
import com.dm.data.manager.entity.Tickets;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface TicketsService extends ApiService<Tickets> {
    Optional<Tickets> findById(Long id);

    Tickets save(TicketsDto data);

    Tickets update(Long id, TicketsDto data);

    void delete(Long id);

    Page<Tickets> find(TicketsDto condition, String regionCode, Pageable pageable);

    List<Tickets> findBySearch(String search);

}
