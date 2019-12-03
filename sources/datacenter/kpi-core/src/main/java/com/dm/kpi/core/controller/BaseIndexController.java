package com.dm.kpi.core.controller;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;

import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.dm.common.converter.AbstractConverter;
import com.dm.common.dto.TableResult;
import com.dm.kpi.core.service.BaseIndexService;
import com.dm.security.annotation.CurrentUser;
import com.dm.security.core.userdetails.UserDetailsDto;

public abstract class BaseIndexController<M, DTO> {

	protected abstract AbstractConverter<M, DTO> getConverter();

	protected abstract BaseIndexService<M, DTO> getService();

	@PostMapping
	@ResponseStatus(CREATED)
	public DTO save(@RequestBody DTO data) {
		return getConverter().toDto(getService().save(data));
	}

	@GetMapping("{id}")
	public DTO get(@PathVariable("id") Long id) {
		return getConverter().toDto(getService().findById(id));
	}

	@DeleteMapping("{id}")
	@ResponseStatus(NO_CONTENT)
	public void delete(@PathVariable("id") Long id) {
		getService().deleteById(id);
	}

	@PutMapping("{id}")
	@ResponseStatus(CREATED)
	public DTO update(@PathVariable("id") Long id, @RequestBody DTO data) {
		return getConverter().toDto(getService().update(id, data));
	}

	@GetMapping(params = { "draw" })
	public TableResult<DTO> search(@RequestParam("draw") Long draw,
			@CurrentUser UserDetailsDto user,
			@RequestParam(value = "keywords", required = false) String keywords,
			@ModelAttribute DTO dto,
			@PageableDefault Pageable pageable) {
		try {
			return TableResult.success(draw,
					getService().search(user,keywords, dto, pageable), getConverter()::toDto);
//			if (StringUtils.isBlank(keywords)) {
//				return TableResult.success(draw,
//						getService().search(pageable), getConverter()::toDto);
//			} else {
//				return TableResult.success(draw,
//						getService().search(keywords, pageable), getConverter()::toDto);
//			}

		} catch (Exception e) {
			return TableResult.failure(draw, pageable, e.getMessage());
		}

	}
}
