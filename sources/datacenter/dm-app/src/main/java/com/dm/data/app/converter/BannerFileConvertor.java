package com.dm.data.app.converter;

import com.dm.common.converter.AbstractConverter;
import com.dm.data.app.dto.BannerFileDto;
import com.dm.data.app.entity.BannerFile;
import org.springframework.stereotype.Component;

/**
 * Copyright (c) 2019 江苏云智网络科技股份有限公司版权所有
 * @author: 尹杰
 * @Date: 2019/9/16 10:14
 * @Description:
 * @History
 */
@Component
public class BannerFileConvertor extends AbstractConverter<BannerFile, BannerFileDto> {
    @Override
    protected BannerFileDto toDtoActual(BannerFile model) {
        BannerFileDto dto =new BannerFileDto();
        dto.setId(model.getId());
       dto.setFileId(model.getFileId());
        dto.setOrderNum(model.getOrderNum());
        dto.setName(model.getName());
        return dto;
    }

    @Override
    public BannerFile copyProperties(BannerFile model, BannerFileDto dto) {
        model.setOrderNum(dto.getOrderNum());
        model.setFileId(dto.getFileId());
        model.setName(dto.getName());
        return model;
    }
}
