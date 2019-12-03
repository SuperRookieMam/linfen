package com.dm.data.manager.service.impl;

import com.dm.data.manager.converter.AudioConverter;
import com.dm.data.manager.dto.AudioDto;
import com.dm.data.manager.entity.Audio;
import com.dm.data.manager.repository.AudioRepository;
import com.dm.data.manager.service.AudioService;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AudioServiceImpl extends AbstractCurrencyServiceImpl<Audio> implements AudioService {

    @Autowired
    private AudioRepository audioDatabaseRepository;

    @Autowired
    private AudioConverter audioDatabaseConverter;

    @Override
    public Optional<Audio> findById(Long id) {
        return audioDatabaseRepository.findById(id);
    }

    @Override
    @Transactional
    public Audio save(AudioDto data) {
        Audio entity = new Audio();
        audioDatabaseConverter.copyProperties(entity, data);
        return audioDatabaseRepository.save(entity);
    }

    @Override
    @Transactional
    public Audio update(Long id, AudioDto data) {
        Audio entity = audioDatabaseRepository.getOne(id);
        audioDatabaseConverter.copyProperties(entity, data);
        return entity;
    }

    @Override
    @Transactional
    public void delete(Long id) {
        audioDatabaseRepository.deleteById(id);
    }

    @Override
    public Page<Audio> find(Pageable pageable) {
        return audioDatabaseRepository.findAll(pageable);
    }

    @Override
    public List<Audio> save(List<AudioDto> datas) {
        if (CollectionUtils.isNotEmpty(datas)) {
            List<Audio> audios = datas.stream().map(data -> {
                Audio audio = new Audio();
                audioDatabaseConverter.copyProperties(audio, data);
                return audio;
            }).collect(Collectors.toList());
            return audioDatabaseRepository.saveAll(audios);
        } else {
            return Collections.emptyList();
        }
    }

}
