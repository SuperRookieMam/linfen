package com.dm.linfen.emergency.controller;

import com.dm.common.dto.TableResult;
import com.dm.common.exception.DataValidateException;
import com.dm.linfen.emergency.entity.HotWord;
import com.dm.linfen.emergency.service.HotWordService;
import com.dm.security.annotation.CurrentUser;
import com.dm.security.core.userdetails.UserDetailsDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

import static org.springframework.http.HttpStatus.CREATED;

/**
 * 舆情相关操作列表,增删改查
 *
 * @author 温东山
 * @create 2019-07-22 15:51
 **/
@Api("热词处理类")
@RestController
@RequestMapping("hotWords")
public class HotWordController {

	@Autowired
	private HotWordService hotWordService;

	@PostMapping
	@ResponseStatus(CREATED)
	public HotWord save(@RequestBody HotWord data) {
		HotWord model = hotWordService.save(data);
		return model;
	}

	@GetMapping("{id}")
	public HotWord get(@PathVariable("id") Long id) {
		Optional<HotWord> data = hotWordService.findById(id);
		if (!data.isPresent()) {
			throw new DataValidateException("查询数据不存在!");
		}
		return data.get();
	}

	@PutMapping("{id}")
	public HotWord update(@PathVariable("id") Long id, @RequestBody HotWord data) {
		HotWord model = hotWordService.update(data);
		return model;
	}

	@DeleteMapping("{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") Long id) {
		hotWordService.delete(id);
	}

	@ApiImplicitParams({
			@ApiImplicitParam(name = "page", dataType = "integer", paramType = "query", value = "Results page you want to retrieve (0..N)"),
			@ApiImplicitParam(name = "size", dataType = "integer", paramType = "query", value = "Number of records per page."),
			@ApiImplicitParam(name = "sort", allowMultiple = true, dataType = "string", paramType = "query", value = "Sorting criteria in the format: property(,asc|desc). Default sort order is ascending. Multiple sort criteria are supported.") })
	@GetMapping(params = { "draw" })
	public TableResult<HotWord> search(@RequestParam("draw") Long draw, @CurrentUser UserDetailsDto user,
			@ModelAttribute HotWord hotWord,
			@PageableDefault(direction = Sort.Direction.DESC, sort = "createTime") Pageable pageable) {
		Page<HotWord> hotWords = hotWordService.findHotWords(hotWord, pageable);
		return TableResult.success(draw, hotWords);
	}

}
