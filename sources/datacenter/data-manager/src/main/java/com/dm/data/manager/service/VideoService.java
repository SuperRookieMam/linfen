package com.dm.data.manager.service;

import com.dm.data.manager.dto.VideoDto;
import com.dm.data.manager.entity.Video;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface VideoService extends ApiService<Video> {

    public Optional<Video> findById(Long id);

    public Video save(VideoDto data);

    public Video update(Long id, VideoDto data);

    public void delete(Long id);

    public Page<Video> find(Pageable pageable);

    public List<Video> save(List<VideoDto> datas);

    Page<Video> find(VideoDto condition, String regionCode, Pageable pageable);
}
