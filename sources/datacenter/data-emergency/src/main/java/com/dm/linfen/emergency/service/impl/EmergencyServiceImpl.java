package com.dm.linfen.emergency.service.impl;

import com.dm.common.exception.DataValidateException;
import com.dm.linfen.emergency.entity.Emergency;
import com.dm.linfen.emergency.entity.QEmergency;
import com.dm.linfen.emergency.repository.EmergencyRepository;
import com.dm.linfen.emergency.service.EmergencyService;
import com.querydsl.core.BooleanBuilder;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * @author 温东山
 * @create 2019-07-26 10:10
 **/
@Service
public class EmergencyServiceImpl implements EmergencyService {

	@Autowired
	private EmergencyRepository emergencyRepository;

	final static QEmergency QEMERGENCY = QEmergency.emergency;

	@Override
	public Optional<Emergency> findById(Long id) {
		return emergencyRepository.findById(id);
	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	public Emergency save(Emergency emergency) {
		return emergencyRepository.save(emergency);
	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	public Emergency update(Emergency emergency) {
		if (emergency == null || emergency.getId() == null) {
			throw new DataValidateException("保存数据不能为null!");
		}
		if (!emergencyRepository.findById(emergency.getId()).isPresent()) {
			throw new DataValidateException("数据不存在!");
		}
		return emergencyRepository.saveAndFlush(emergency);
	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	public void delete(Long id) {
		emergencyRepository.deleteById(id);
	}

	@Override
	public Page<Emergency> findEmergencys(Emergency emergency, Pageable pageable) {

		BooleanBuilder builder = new BooleanBuilder();
		if (StringUtils.isNotBlank(emergency.getTitle())) {
			builder.and(QEMERGENCY.title.containsIgnoreCase(emergency.getTitle()));
		}
		if (emergency.getStatus() != null) {
			builder.and(QEMERGENCY.status.eq(emergency.getStatus()));
		}
		if (emergency.getType() != null) {
			builder.and(QEMERGENCY.type.eq(emergency.getType()));
		}

		return emergencyRepository.findAll(builder, pageable);
	}
}
