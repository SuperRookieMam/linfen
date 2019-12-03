package com.dm.linfen.emergency.controller;

import com.dm.common.dto.TableResult;
import com.dm.common.exception.DataValidateException;
import com.dm.linfen.emergency.entity.Sentiment;
import com.dm.linfen.emergency.service.SentimentService;
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
@Api("舆情处理类")
@RestController
@RequestMapping("sentiments")
public class SentimentController {

	@Autowired
	private SentimentService sentimentService;

	@PostMapping
	@ResponseStatus(CREATED)
	public Sentiment save(@RequestBody Sentiment data) {
		Sentiment model = sentimentService.save(data);
		return model;
	}

	@GetMapping("{id}")
	public Sentiment get(@PathVariable("id") Long id) {
		Optional<Sentiment> data = sentimentService.findById(id);
		if (!data.isPresent()) {
			throw new DataValidateException("查询数据不存在!");
		}
		return data.get();
	}

	@PutMapping("{id}")
	public Sentiment update(@PathVariable("id") Long id, @RequestBody Sentiment data) {
		Sentiment model = sentimentService.update(data);
		return model;
	}

	@DeleteMapping("{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") Long id) {
		sentimentService.delete(id);
	}

	@ApiImplicitParams({
			@ApiImplicitParam(name = "page", dataType = "integer", paramType = "query", value = "Results page you want to retrieve (0..N)"),
			@ApiImplicitParam(name = "size", dataType = "integer", paramType = "query", value = "Number of records per page."),
			@ApiImplicitParam(name = "sort", allowMultiple = true, dataType = "string", paramType = "query", value = "Sorting criteria in the format: property(,asc|desc). Default sort order is ascending. Multiple sort criteria are supported.") })
	@GetMapping(params = { "draw" })
	public TableResult<Sentiment> search(@RequestParam("draw") Long draw, @CurrentUser UserDetailsDto user,
			@ModelAttribute Sentiment sentiment,
			@PageableDefault(direction = Sort.Direction.DESC, sort = "createTime") Pageable pageable) {
		Page<Sentiment> sentiments = sentimentService.findSentiments(sentiment, pageable);
		return TableResult.success(draw, sentiments);
	}

}
