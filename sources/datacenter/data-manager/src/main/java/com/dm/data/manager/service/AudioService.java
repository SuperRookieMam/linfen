package com.dm.data.manager.service;

import com.dm.data.manager.dto.AudioDto;
import com.dm.data.manager.entity.Audio;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface AudioService extends ApiService<Audio> {

    public Optional<Audio> findById(Long id);

    public Audio save(AudioDto data);

    public Audio update(Long id, AudioDto data);

    public void delete(Long id);

    public Page<Audio> find(Pageable pageable);

    public List<Audio> save(List<AudioDto> datas);
}
