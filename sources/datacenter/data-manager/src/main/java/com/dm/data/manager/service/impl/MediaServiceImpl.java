package com.dm.data.manager.service.impl;

import com.dm.data.manager.dto.AudioDto;
import com.dm.data.manager.dto.ImageDto;
import com.dm.data.manager.dto.VideoDto;
import com.dm.data.manager.dto.VirtualMaterialDto;
import com.dm.data.manager.entity.*;
import com.dm.data.manager.repository.AudioRepository;
import com.dm.data.manager.repository.ImageRepository;
import com.dm.data.manager.repository.VideoRepository;
import com.dm.data.manager.repository.VirtualMaterialRepository;
import com.dm.data.manager.service.MediaService;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class MediaServiceImpl implements MediaService {

    @Autowired
    private ImageRepository imageRepository;

    @Autowired
    private VideoRepository videoReopsitory;

    @Autowired
    private AudioRepository audioRepository;

    @Autowired
    private VirtualMaterialRepository virtualMaterialRepository;

    @Override
    public List<Image> toImage(List<ImageDto> _images) {
        if (CollectionUtils.isNotEmpty(_images)) {
            return _images.stream().map(this::toImage).filter(Objects::nonNull).collect(Collectors.toList());
        } else {
            return Collections.emptyList();
        }
    }

    @Override
    public Image toImage(ImageDto image) {
        if (!Objects.isNull(image) && !Objects.isNull(image.getId())) {
            return imageRepository.getOne(image.getId());
        } else {
            return null;
        }

    }

    @Override
    public Video toVideo(VideoDto video) {
        if (!Objects.isNull(video) && !Objects.isNull(video.getId())) {
            return videoReopsitory.getOne(video.getId());
        } else {
            return null;
        }
    }

    @Override
    public Audio toAudio(AudioDto audio) {
        if (!Objects.isNull(audio) && !Objects.isNull(audio.getId())) {
            return audioRepository.getOne(audio.getId());
        } else {
            return null;
        }
    }

    @Override
    public VirtualMaterial toVirtualMaterial(VirtualMaterialDto virtualMaterial) {
        if (!Objects.isNull(virtualMaterial) && !Objects.isNull(virtualMaterial.getId())) {
            return virtualMaterialRepository.getOne(virtualMaterial.getId());
        } else {
            return null;
        }
    }

    @Override
    public List<Video> toVideo(List<VideoDto> videos) {
        if (CollectionUtils.isNotEmpty(videos)) {
            return videos.stream().map(this::toVideo).filter(Objects::nonNull).collect(Collectors.toList());
        } else {
            return Collections.emptyList();
        }
    }

    @Override
    public List<Audio> toAudio(List<AudioDto> autdios) {
        if (CollectionUtils.isNotEmpty(autdios)) {
            return autdios.stream().map(this::toAudio).filter(Objects::nonNull).collect(Collectors.toList());
        } else {
            return Collections.emptyList();
        }
    }

    @Override
    public List<VirtualMaterial> toVirtualMatrial(List<VirtualMaterialDto> virtualMaterials) {
        if (CollectionUtils.isNotEmpty(virtualMaterials)) {
            return virtualMaterials.stream().map(this::toVirtualMaterial).filter(Objects::nonNull)
                    .collect(Collectors.toList());
        } else {
            return Collections.emptyList();
        }
    }

}
