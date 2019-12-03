package com.dm.linfen.emergency.controller;

import com.dm.common.dto.TableResult;
import com.dm.common.exception.DataValidateException;
import com.dm.linfen.emergency.entity.Duty;
import com.dm.linfen.emergency.service.DutyService;
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
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.springframework.http.HttpStatus.CREATED;

/**
 * 舆情相关操作列表,增删改查 duty/duties
 * 
 * @author 温东山
 * @create 2019-07-22 15:51
 **/
@Api("排班处理类")
@RestController
@RequestMapping("duties")
public class DutyController {

	@Autowired
	private DutyService dutyService;

	@PostMapping
	@ResponseStatus(CREATED)
	public Duty save(@RequestBody Duty data) {
		Duty model = dutyService.save(data);
		return model;
	}

	@PostMapping("/batchSave")
	@ResponseStatus(CREATED)
	public void batchSave(@RequestBody List<Duty> data) {
		dutyService.batchSave(data);
	}

	@GetMapping("{id}")
	public Duty get(@PathVariable("id") Long id) {
		Optional<Duty> data = dutyService.findById(id);
		if (!data.isPresent()) {
			throw new DataValidateException("查询数据不存在!");
		}
		return data.get();
	}

	@PutMapping("{id}")
	public Duty update(@PathVariable("id") Long id, @RequestBody Duty data) {
		Duty model = dutyService.update(data);
		return model;
	}

	@DeleteMapping("{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") Long id) {
		dutyService.delete(id);
	}

	@ApiImplicitParams({
			@ApiImplicitParam(name = "page", dataType = "integer", paramType = "query", value = "Results page you want to retrieve (0..N)"),
			@ApiImplicitParam(name = "size", dataType = "integer", paramType = "query", value = "Number of records per page."),
			@ApiImplicitParam(name = "sort", allowMultiple = true, dataType = "string", paramType = "query", value = "Sorting criteria in the format: property(,asc|desc). Default sort order is ascending. Multiple sort criteria are supported.") })
	@GetMapping(params = { "draw" })
	public TableResult<Duty> search(@RequestParam("draw") Long draw, @CurrentUser UserDetailsDto user,
			@RequestParam(value = "startTime", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startTime,
			@RequestParam(value = "endTime", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endTime,
			@PageableDefault(direction = Sort.Direction.DESC, sort = "createTime") Pageable pageable) {
		Page<Duty> dutys = dutyService.findDutys(startTime, endTime, pageable);
		return TableResult.success(draw, dutys);
	}

}
