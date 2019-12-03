package com.dm.data.manager.repository;

import com.dm.data.manager.entity.LikeNumber;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LikeNumberRepository extends JpaRepository<LikeNumber, Long> {
    /**
     * 统计点赞量
     * 
     * @param no
     * @return
     */
    Integer findCountByResourceId(Long resourceId);

    /**
     * 删除此人对应文章的点赞
     * 
     * @param no
     * @param openId
     * @return
     */
    Integer deleteByResourceIdAndOpenId(Long resourceId, String openId);

    /**
     * 根据文章no和openId查询点赞
     * 
     * @param no
     * @param openId
     * @return
     */

    Optional<LikeNumber> findByResourceIdAndOpenId(Long resourceId, String openId);
}
