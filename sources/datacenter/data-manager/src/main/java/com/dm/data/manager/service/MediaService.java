package com.dm.data.manager.service;

import com.dm.data.manager.dto.AudioDto;
import com.dm.data.manager.dto.ImageDto;
import com.dm.data.manager.dto.VideoDto;
import com.dm.data.manager.dto.VirtualMaterialDto;
import com.dm.data.manager.entity.Audio;
import com.dm.data.manager.entity.Image;
import com.dm.data.manager.entity.Video;
import com.dm.data.manager.entity.VirtualMaterial;

import java.util.List;

public interface MediaService {

    public Image toImage(ImageDto image);

    public Video toVideo(VideoDto video);

    public Audio toAudio(AudioDto audio);

    public VirtualMaterial toVirtualMaterial(VirtualMaterialDto virtualMaterial);

    public List<Image> toImage(List<ImageDto> _images);

    public List<Video> toVideo(List<VideoDto> videos);

    public List<Audio> toAudio(List<AudioDto> autdios);

    public List<VirtualMaterial> toVirtualMatrial(List<VirtualMaterialDto> virtualMaterials);

}
