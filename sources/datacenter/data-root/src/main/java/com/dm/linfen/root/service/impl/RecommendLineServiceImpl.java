package com.dm.linfen.root.service.impl;

import com.dm.linfen.root.converter.RecommendLineConverter;
import com.dm.linfen.root.entity.QRecommendLine;
import com.dm.linfen.root.repository.RecommendLineRepository;
import com.dm.linfen.root.dto.RecommendLineDto;
import com.dm.linfen.root.entity.RecommendLine;
import com.dm.linfen.root.service.RecommendLineService;
import com.querydsl.core.BooleanBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * @author yinjie
 * @date 2019年7月22日09:43:20
 */
@Service
public class RecommendLineServiceImpl implements RecommendLineService {

	@Autowired
	private RecommendLineRepository recommendLineRepository;

	@Autowired
	private RecommendLineConverter recommendLineConverter;

	private final QRecommendLine qRecommendLine = QRecommendLine.recommendLine;

	@Override
	@Transactional
	public RecommendLine save(RecommendLineDto dto) {
		RecommendLine recommendLin = new RecommendLine();
		recommendLineConverter.copyProperties(recommendLin, dto);
		return recommendLineRepository.saveAndFlush(recommendLin);
	}

	@Override
	public Optional<RecommendLine> findById(Long id) {
		return recommendLineRepository.findById(id);
	}

	@Override
	@Transactional
	public RecommendLine updateById(Long rId, RecommendLineDto dto) {
		RecommendLine recommendLin = recommendLineRepository.getOne(rId);
		recommendLineConverter.copyProperties(recommendLin, dto);
		return recommendLineRepository.saveAndFlush(recommendLin);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		recommendLineRepository.deleteById(id);
	}

	@Override
	public Page<RecommendLine> findPage(Pageable pageable) {
		BooleanBuilder builder = new BooleanBuilder();
		return recommendLineRepository.findAll(builder, pageable);
	}

}
