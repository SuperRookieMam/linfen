package com.dm.linfen.emergency.controller;

import com.dm.common.dto.TableResult;
import com.dm.common.exception.DataValidateException;
import com.dm.linfen.emergency.entity.Report;
import com.dm.linfen.emergency.service.ReportService;
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
@Api("上报处理类")
@RestController
@RequestMapping("reports")
public class ReportController {

	@Autowired
	ReportService reportService;

	@PostMapping
	@ResponseStatus(CREATED)
	public Report save(@RequestBody Report data) {
		Report model = reportService.save(data);
		return model;
	}

	@GetMapping("{id}")
	public Report get(@PathVariable("id") Long id) {
		Optional<Report> data = reportService.findById(id);
		if (!data.isPresent()) {
			throw new DataValidateException("查询数据不存在!");
		}
		return data.get();
	}

	@PutMapping("{id}")
	public Report update(@PathVariable("id") Long id, @RequestBody Report data) {
		Report model = reportService.update(data);
		return model;
	}

	@DeleteMapping("{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") Long id) {
		reportService.delete(id);
	}

	@ApiImplicitParams({
			@ApiImplicitParam(name = "page", dataType = "integer", paramType = "query", value = "Results page you want to retrieve (0..N)"),
			@ApiImplicitParam(name = "size", dataType = "integer", paramType = "query", value = "Number of records per page."),
			@ApiImplicitParam(name = "sort", allowMultiple = true, dataType = "string", paramType = "query", value = "Sorting criteria in the format: property(,asc|desc). Default sort order is ascending. Multiple sort criteria are supported.") })
	@GetMapping(params = { "draw" })
	public TableResult<Report> search(@RequestParam("draw") Long draw, @CurrentUser UserDetailsDto user,
			@ModelAttribute Report report,
			@PageableDefault(direction = Sort.Direction.DESC, sort = "createTime") Pageable pageable) {
		Page<Report> hotWords = reportService.findReports(report, pageable);
		return TableResult.success(draw, hotWords);
	}

}
