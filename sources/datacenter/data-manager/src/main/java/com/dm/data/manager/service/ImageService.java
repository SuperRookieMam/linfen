package com.dm.data.manager.service;

import com.dm.data.manager.dto.ImageDto;
import com.dm.data.manager.entity.Image;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ImageService extends ApiService<Image> {

    public Optional<Image> findById(Long id);

    public Image save(ImageDto data);

    public Image update(Long id, ImageDto data);

    public void delete(Long id);

    public Page<Image> find(Pageable pageable);

    public List<Image> save(List<ImageDto> datas);

    Page<Image> find(ImageDto condition, String regionCode, Pageable pageable);
}
