package com.dm.data.manager.service.impl;

import com.dm.data.manager.entity.LikeNumber;
import com.dm.data.manager.repository.LikeNumberRepository;
import com.dm.data.manager.service.LikeNumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * @author yinjie
 * @date 2019年8月12日11:04:27
 */
@Service
public class LikeNumberServiceImpl extends ApiServiceImpl<LikeNumber> implements LikeNumberService {
    @Autowired
    private LikeNumberRepository likeNumberRepository;

    @Override
    @Transactional
    public LikeNumber save(Long resourceId, String openId) {
        LikeNumber likeNumber = new LikeNumber();
        likeNumber.setResourceId(resourceId);
        likeNumber.setOpenId(openId);
        return likeNumberRepository.save(likeNumber);
    }

    @Override
    @Transactional
    public void delete(Long resourceId, String openId) {
        likeNumberRepository.deleteByResourceIdAndOpenId(resourceId, openId);
    }

    @Override
    public Integer findCountByResourceId(Long resourceId) {
        return likeNumberRepository.findCountByResourceId(resourceId);
    }

    @Override
    public LikeNumber findByResourceIdAndOpenId(Long resourceId, String openId) {
        Optional<LikeNumber> likeNumber = likeNumberRepository.findByResourceIdAndOpenId(resourceId, openId);
        if (likeNumber.isPresent()) {
            return likeNumber.get();
        } else {
            return null;
        }
    }
}
