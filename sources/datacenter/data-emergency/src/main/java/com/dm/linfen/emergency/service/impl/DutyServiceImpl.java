package com.dm.linfen.emergency.service.impl;

import com.dm.common.exception.DataValidateException;
import com.dm.linfen.emergency.entity.Duty;
import com.dm.linfen.emergency.entity.QDuty;
import com.dm.linfen.emergency.repository.DutyRepository;
import com.dm.linfen.emergency.service.DutyService;
import com.querydsl.core.BooleanBuilder;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author 温东山
 * @create 2019-07-24 10:58
 **/
@Service
public class DutyServiceImpl implements DutyService {

	@Autowired
	DutyRepository dutyRepository;

	final static QDuty QDUTY = QDuty.duty;

	@Override
	public Optional<Duty> findById(Long id) {
		return dutyRepository.findById(id);
	}

	@Override
	public Optional<Duty> findByCreateTime(LocalDate localDate) {
		return dutyRepository.findByCreateTime(localDate);
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void batchSave(List<Duty> dutys) {
		/**
		 * 批量保存的时候先删除存在的数据,重新插入
		 */
		if (CollectionUtils.isNotEmpty(dutys)) {
			List<LocalDate> collect = dutys.stream().map(Duty::getCreateTime).collect(Collectors.toList());
			for (LocalDate localDate : collect) {
				dutyRepository.deleteByCreateTime(localDate);
			}
		}
		dutyRepository.saveAll(dutys);
	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	public Duty save(Duty duty) {
		Duty param = new Duty();
		param.setCreateTime(duty.getCreateTime());
		Optional<Duty> one = dutyRepository.findOne(Example.of(param));
		if (one.isPresent()) {
			throw new DataValidateException("当前时间段已经存在值班人员了,请切换其他时间!");
		}
		return dutyRepository.save(duty);
	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	public Duty update(Duty duty) {
		if (duty == null || duty.getId() == null) {
			throw new DataValidateException("数据不存在!");
		}
		Optional<Duty> byId = dutyRepository.findById(duty.getId());
		if (!byId.isPresent()) {
			throw new DataValidateException("数据不存在!");
		}
		return dutyRepository.saveAndFlush(duty);
	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	public void delete(Long id) {
		dutyRepository.deleteById(id);
	}

	@Override
	public Page<Duty> findDutys(LocalDate startTime, LocalDate endTime, Pageable pageable) {
		BooleanBuilder builder = new BooleanBuilder();
		if (startTime != null) {
			builder.and(QDUTY.createTime.goe(startTime));
		}
		if (endTime != null) {
			builder.and(QDUTY.createTime.loe(endTime));
		}
		return dutyRepository.findAll(builder, pageable);
	}
}
