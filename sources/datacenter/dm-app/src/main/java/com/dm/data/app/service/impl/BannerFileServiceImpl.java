package com.dm.data.app.service.impl;

import com.dm.data.app.converter.BannerFileConvertor;
import com.dm.data.app.dto.BannerFileDto;
import com.dm.data.app.entity.BannerFile;
import com.dm.data.app.repository.BannerFileRepository;
import com.dm.data.app.service.BannerFileService;
import com.dm.file.repository.FileInfoRepository;
import com.querydsl.core.BooleanBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;
import java.util.Optional;

/**
 * Copyright (c) 2019 江苏云智网络科技股份有限公司版权所有
 * @author: 尹杰
 * @Date: 2019/9/16 10:27
 * @Description:
 * @History
 */
@Service
public class BannerFileServiceImpl implements BannerFileService {
    @Autowired
    private BannerFileRepository bannerFileRepository;
    @Autowired
    private BannerFileConvertor bannerFileConvertor;
    @Autowired
    private FileInfoRepository fileInfoRepository;
    @Override
    @Transactional
    public BannerFile save(BannerFileDto dto) {
        BannerFile bannerFile =new BannerFile();
        bannerFile= bannerFileConvertor.copyProperties(bannerFile,dto);
        return bannerFileRepository.save(bannerFile);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        bannerFileRepository.deleteById(id);
    }

    @Override
    @Transactional
    public BannerFile update(Long id, BannerFileDto dto) {
        Optional<BannerFile> bannerFileOptional =bannerFileRepository.findById(id);
        if(bannerFileOptional.isPresent()){
            BannerFile bannerFile =bannerFileOptional.get();
            bannerFile= bannerFileConvertor.copyProperties(bannerFile,dto);
            return bannerFileRepository.saveAndFlush(bannerFile);
        }
        return null;
    }

    @Override
    public Page<BannerFile> find(Pageable pageable) {
        BooleanBuilder builder = new BooleanBuilder();
        return bannerFileRepository.findAll(builder,pageable);
    }

    @Override
    public BannerFile findById(Long id) {
        Optional<BannerFile> bannerFileOptional =bannerFileRepository.findById(id);
        if(bannerFileOptional.isPresent()){
            return bannerFileOptional.get();
        }
        return null;
    }
}
