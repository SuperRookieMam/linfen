package com.dm.linfen.root.service;

import com.dm.linfen.root.dto.RecommendLineDto;
import com.dm.linfen.root.entity.RecommendLine;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.Optional;

public interface RecommendLineService {
    RecommendLine save(RecommendLineDto dto);

    Optional<RecommendLine> findById(Long id);

    RecommendLine updateById(Long rId, RecommendLineDto dto);


    void  deleteById(Long id);

    Page<RecommendLine> findPage(Pageable pageable);
}
