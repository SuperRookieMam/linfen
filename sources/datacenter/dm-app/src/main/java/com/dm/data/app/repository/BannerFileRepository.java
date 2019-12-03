package com.dm.data.app.repository;

import com.dm.data.app.entity.BannerFile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

/**
 * Copyright (c) 2019 江苏云智网络科技股份有限公司版权所有
 *
 * @author: 尹杰
 * @Date: 2019/9/12 17:36
 * @Description:
 * @History
 */
public interface BannerFileRepository
        extends JpaRepository<BannerFile, Long>,
        QuerydslPredicateExecutor<BannerFile> {
}
