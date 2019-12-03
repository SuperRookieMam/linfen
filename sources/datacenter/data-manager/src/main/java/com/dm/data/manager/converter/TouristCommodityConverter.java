package com.dm.data.manager.converter;

import com.dm.data.manager.dto.TouristCommodityDto;
import com.dm.data.manager.entity.TouristCommodity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TouristCommodityConverter extends AbstractBaseConverter<TouristCommodity, TouristCommodityDto> {
    @Autowired
    private ImageConverter imageConverter;
    @Autowired
    private VideoConverter videoConverter;

    @Override
    protected TouristCommodityDto toDtoActual(TouristCommodity model) {
        TouristCommodityDto dto = super.toDtoActual(model);
        dto.setId(model.getId());
        dto.setFullname(model.getFullname());
        dto.setShortName(model.getShortName());
        dto.setPinYin(model.getPinYin());
        dto.setEnglishName(model.getEnglishName());
        dto.setType(model.getType());
        dto.setDescription(model.getDescription());
        dto.setNote(model.getNote());
        dto.setPropt(model.getPropt());
        dto.setLogisticsPrompt(model.getLogisticsPrompt());
        dto.setRecommendedBrand(model.getRecommendedBrand());
        dto.setRecommendedShop(model.getRecommendedShop());
        dto.setImages(imageConverter.toDto(model.getImages()));
        dto.setVideos(videoConverter.toDto(model.getVideos()));
        /*
         * dto.setPics(model.getPics()); dto.setVideos(model.getVideos());
         */
        return dto;
    }

    @Override
    public TouristCommodity copyProperties(TouristCommodity model, TouristCommodityDto dto) {
        model = super.copyProperties(model, dto);
        model.setFullname(dto.getFullname());
        model.setShortName(dto.getShortName());
        model.setPinYin(dto.getPinYin());
        model.setEnglishName(dto.getEnglishName());
        model.setType(dto.getType());
        model.setDescription(dto.getDescription());
        model.setNote(dto.getNote());
        model.setPropt(dto.getPropt());
        model.setLogisticsPrompt(dto.getLogisticsPrompt());
        model.setRecommendedBrand(dto.getRecommendedBrand());
        model.setRecommendedShop(dto.getRecommendedShop());
        /*
         * model.setPics(dto.getPics()); model.setVideos(dto.getVideos());
         */
        return model;
    }

    @Override
    protected TouristCommodityDto getDto() {
        return new TouristCommodityDto();
    }
}
