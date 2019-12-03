package com.dm.data.app.service;

import com.dm.data.app.dto.BannerFileDto;
import com.dm.data.app.entity.BannerFile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Copyright (c) 2019 江苏云智网络科技股份有限公司版权所有
 *
 * @author: 尹杰
 * @Date: 2019/9/16 10:17
 * @Description:
 * @History
 */
public interface BannerFileService {
    /**
     * 保存
     * @param dto
     * @return
     */
    BannerFile save(BannerFileDto dto);

    /**
     * 删除
     * @param id
     */
    void delete(Long id);

    /**
     * 修改
     * @param id
     * @param dto
     * @return
     */
    BannerFile update(Long id,BannerFileDto dto);

    /**
     * 分页查找
     * @param pageable
     * @return
     */
    Page<BannerFile> find(Pageable pageable);

    BannerFile findById(Long id);
}
