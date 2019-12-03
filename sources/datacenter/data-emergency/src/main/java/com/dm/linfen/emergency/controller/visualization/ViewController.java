package com.dm.linfen.emergency.controller.visualization;

import com.dm.common.dto.TableResult;
import com.dm.common.exception.DataValidateException;
import com.dm.linfen.emergency.entity.Duty;
import com.dm.linfen.emergency.entity.Emergency;
import com.dm.linfen.emergency.service.DutyService;
import com.dm.linfen.emergency.service.EmergencyService;
import com.dm.linfen.emergency.service.HotWordService;
import com.dm.linfen.emergency.service.SentimentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
    * @Author:         温东山
    * @Description:    类作用描述
    * @CreateDate:     2019/9/3 0003 16:38
    * @UpdateUser:     温东山
    * @UpdateDate:     2019/9/3 0003 16:38
    * @history:   修改记录
    * @Version:        1.0
*/
@Api("可视化处理接口类")
@RestController
@RequestMapping("views")
public class ViewController {

	@Autowired
	HotWordService hotWordService;

	@Autowired
	SentimentService sentimentService;

	@Autowired
	private DutyService dutyService;

	@Autowired
	EmergencyService emergencyService;

	/**
	 * 声量统计 前12月
	 *
	 * @return
	 */
	@GetMapping("/volume")
	public Map<String, Object> findVolumeStatistics(@RequestParam("num") Integer num) {
		return sentimentService.findVolumeStatistics(num);
	}

	/**
	 * 媒体来源统计 一年
	 *
	 * @return
	 */
	@GetMapping("/media")
	public List findMediaStatistics() {
		return sentimentService.findMediaStatistics();
	}

	/**
	 * 关键词统计,可以选择 正 负 一年
	 *
	 * @return
	 */
	@GetMapping("/keyword")
	public List findKeywordStatistics(@RequestParam(value = "type", required = false) String type) {
		return hotWordService.findKeywordStatistics(type);
	}

	/**
	 * 按照省统计 年
	 *
	 * @return
	 */
	@GetMapping("/region")
	public List findRegionStatistics() {
		return sentimentService.findRegionStatistics();
	}

	/**
	 * 情感分布 统计正负中性,谁大显示谁
	 *
	 * @return
	 */
	@GetMapping("/sentimentMax")
	public List findSentimentMax() {
		return sentimentService.findSentimentMax();
	}

	/**
	 * 舆情列表
	 *
	 * @return
	 */
	@ApiImplicitParams({
			@ApiImplicitParam(name = "page", dataType = "integer", paramType = "query", value = "Results page you want to retrieve (0..N)"),
			@ApiImplicitParam(name = "size", dataType = "integer", paramType = "query", value = "Number of records per page."),
			@ApiImplicitParam(name = "sort", allowMultiple = true, dataType = "string", paramType = "query", value = "Sorting criteria in the format: property(,asc|desc). Default sort order is ascending. Multiple sort criteria are supported.") })
	@GetMapping("/sentimentList")
	public List findSentimentList(
			@PageableDefault(direction = Sort.Direction.DESC, sort = "createTime") Pageable pageable) {
		return sentimentService.findSentimentList(pageable);
	}

	/**
	 * 排班查询
	 * 
	 * @param dateTime
	 * @return
	 */
	@GetMapping("/duty")
	public Duty find(
			@RequestParam(value = "dateTime", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dateTime) {
		Optional<Duty> duty = dutyService.findByCreateTime(dateTime);
		if (dutyService.findByCreateTime(dateTime).isPresent()) {
			return duty.get();
		}
		return null;
	}

	@GetMapping("/emergency/{id}")
	public Emergency get(@PathVariable("id") Long id) {
		Optional<Emergency> data = emergencyService.findById(id);
		if (!data.isPresent()) {
			throw new DataValidateException("查询数据不存在!");
		}
		return data.get();
	}

	@ApiImplicitParams({
			@ApiImplicitParam(name = "page", dataType = "integer", paramType = "query", value = "Results page you want to retrieve (0..N)"),
			@ApiImplicitParam(name = "size", dataType = "integer", paramType = "query", value = "Number of records per page."),
			@ApiImplicitParam(name = "sort", allowMultiple = true, dataType = "string", paramType = "query", value = "Sorting criteria in the format: property(,asc|desc). Default sort order is ascending. Multiple sort criteria are supported.") })
	@GetMapping("/emergencies")
	public TableResult<Emergency> search(@RequestParam("draw") Long draw,
			@PageableDefault(direction = Sort.Direction.DESC, sort = "createTime") Pageable pageable) {
		Page<Emergency> hotWords = emergencyService.findEmergencys(new Emergency(), pageable);
		return TableResult.success(draw, hotWords);
	}

}
