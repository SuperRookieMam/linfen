package com.dm.linfen.root.service.impl;

import com.dm.linfen.root.converter.WeChatUserConverter;
import com.dm.linfen.root.dto.WeChatUserDto;
import com.dm.linfen.root.entity.QWeChatUser;
import com.dm.linfen.root.entity.RecommendLine;
import com.dm.linfen.root.entity.WeChatUser;
import com.dm.linfen.root.repository.WeChatUserRepository;
import com.dm.linfen.root.service.RecommendLineService;
import com.dm.linfen.root.service.WeChatUserService;
import com.querydsl.core.BooleanBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.ZonedDateTime;
import java.util.*;

/**
 * @author yinjie
 * @date 2019年7月23日15:20:43
 */
@Service
public class WeChatUserServiceImpl implements WeChatUserService {
	@Autowired
	private WeChatUserRepository weChatUserRepository;
	@Autowired
	private RecommendLineService recommendLineService;
	@Autowired
	private WeChatUserConverter weChatUserConverter;
	private final QWeChatUser qWeChatUser = QWeChatUser.weChatUser;

	@Override
	@Transactional
	public WeChatUser save(WeChatUserDto dto) {
		WeChatUser weChatUser = new WeChatUser();
		weChatUserConverter.copyProperties(weChatUser, dto);
		weChatUser.setRecommendLines(getLines(dto.getRecommendLines()));
		weChatUser.setRegisterTime(ZonedDateTime.now());
		return weChatUserRepository.save(weChatUser);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		weChatUserRepository.deleteById(id);
	}

	@Override
	public WeChatUser findById(Long id) {
		Optional<WeChatUser> optional = weChatUserRepository.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		} else {
			return null;
		}
	}

	@Override
	@Transactional
	public WeChatUser update(Long id, WeChatUserDto dto) {
		Optional<WeChatUser> optional = weChatUserRepository.findById(id);
		if (optional.isPresent()) {
			WeChatUser weChatUser = optional.get();
			weChatUserConverter.copyProperties(weChatUser, dto);
			weChatUser.setRecommendLines(getLines(dto.getRecommendLines()));
			return weChatUserRepository.save(weChatUser);
		} else {
			throw new IllegalArgumentException("改id对象不存在");
		}
	}

	@Override
	public Page<WeChatUser> find(String search, Pageable pageable) {
		BooleanBuilder builder = new BooleanBuilder();
		if (!Objects.isNull(search)) {
			builder.and(
					qWeChatUser.weChatName.containsIgnoreCase(search).or(qWeChatUser.name.containsIgnoreCase(search)));
		}
		return weChatUserRepository.findAll(builder, pageable);
	}

	@Override
	@Transactional
	public WeChatUser lastLogin(String openId) {
		Optional<WeChatUser> weChatUser = weChatUserRepository.findByOpenId(openId);
		if (weChatUser.isPresent()) {
			WeChatUser weChatUser1 = weChatUser.get();
			weChatUser1.setLastLoginTime(ZonedDateTime.now());
			return weChatUserRepository.saveAndFlush(weChatUser.get());
		} else {
			WeChatUser weChatUser1 = new WeChatUser();
			weChatUser1.setRegisterTime(ZonedDateTime.now());
			weChatUser1.setOpenId(openId);
			return weChatUserRepository.saveAndFlush(weChatUser1);
		}

	}

	@Override
	public WeChatUser findByOpenId(String openId) {
		Optional<WeChatUser> weChatUser = weChatUserRepository.findByOpenId(openId);
		if (weChatUser.isPresent()) {
			return weChatUser.get();
		}
		return null;
	}

	private List<RecommendLine> getLines(List<Map<String, Object>> maps) {
		List<RecommendLine> recommendLines = new ArrayList<>();
		for (Map<String, Object> map : maps) {
			Optional<RecommendLine> optional = recommendLineService.findById(Long.valueOf(map.get("id").toString()));
			if (optional.isPresent()) {
				recommendLines.add(optional.get());
			} else {
				recommendLines.add(null);
			}
		}
		return recommendLines;
	}
}
