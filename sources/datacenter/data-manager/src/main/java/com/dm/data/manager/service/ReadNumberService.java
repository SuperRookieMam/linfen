package com.dm.data.manager.service;

import com.dm.data.manager.entity.ReadNumber;

/**
 * 阅读量service
 *
 * @author yinjie
 * @date 2019年8月12日13:51:55
 */

public interface ReadNumberService extends ApiService<ReadNumber> {
    /**
     * 通过资源编号查找阅读量 无就新增
     *
     * @param no
     * @return
     */
    Integer findNumberBySourceId(Long id);

    /**
     * 阅读量+1
     *
     * @param no
     * @return
     */
    ReadNumber addOne(Long id);
}
