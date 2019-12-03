package com.dm.data.manager.service;

import com.dm.data.manager.entity.LikeNumber;

/**
 * 点赞量service
 * 
 * @author yinjie
 * @date 2019年8月12日11:01:12
 */
public interface LikeNumberService extends ApiService<LikeNumber> {
    /**
     * 增加点赞
     * 
     * @param no
     * @param openId
     */
    LikeNumber save(Long resourceId, String openId);

    /**
     * 取消点赞
     * 
     * @param no
     * @param openId
     */
    void delete(Long resourceId, String openId);

    /**
     * 统计点赞量
     * 
     * @param no
     * @return
     */
    Integer findCountByResourceId(Long resourceId);

    /**
     * 根据文章no和openId查询点赞
     * 
     * @param no
     * @param openId
     * @return
     */
    LikeNumber findByResourceIdAndOpenId(Long resourceId, String openId);
}
