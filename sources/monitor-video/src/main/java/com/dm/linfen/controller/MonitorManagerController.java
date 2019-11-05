
package com.dm.linfen.controller;

import com.alibaba.fastjson.JSONObject;
import com.dm.common.dto.TableResult;
import com.dm.linfen.dto.MonitorManagerDto;
import com.dm.linfen.entity.MonitorManager;
import com.dm.security.annotation.CurrentUser;
import com.dm.security.core.userdetails.UserDetailsDto;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Optional;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;

/**
 * 住宿场所控制器
 *
 */
@RestController
@RequestMapping("monitorManagers")
@Api(tags = {"监控中心"})
public class MonitorManagerController extends MAbstractController<MonitorManagerDto> {

	@Autowired
	private com.dm.linfen.service.MonitorManagerService monitorManagerService;

	@Autowired
	private com.dm.linfen.converter.MonitorManagerConverter monitorManagerConverter;

	@Override
	@PostMapping
	@ResponseStatus(CREATED)
	public MonitorManagerDto save(@RequestBody MonitorManagerDto data) {
		MonitorManager model = monitorManagerService.save(data);
		return monitorManagerConverter.toDto(model);
	}

	@GetMapping("{id}")
	public MonitorManagerDto get(@PathVariable("id") Long id) {
		Optional<MonitorManager> data = monitorManagerService.findById(id);
		return monitorManagerConverter.toDto(data);
	}

	@PutMapping("{id}")
	public MonitorManagerDto update(@PathVariable("id") Long id, @RequestBody MonitorManagerDto data) {
		MonitorManager model = monitorManagerService.update(id, data);
		return monitorManagerConverter.toDto(model);
	}

	@DeleteMapping("{id}")
	@ResponseStatus(NO_CONTENT)
	public void delete(@PathVariable("id") Long id) {
		monitorManagerService.delete(id);
	}

	@Override
	@GetMapping(params = { "draw" })
	public TableResult<MonitorManagerDto> search(@RequestParam("draw") Long draw,
												@CurrentUser UserDetailsDto user,
												@ModelAttribute MonitorManagerDto condition,
												@PageableDefault Pageable pageable) {
		Page<MonitorManager> MonitorManager = monitorManagerService.find(condition,user==null?null:user.getRegionCode(), pageable);
		return TableResult.success(draw, MonitorManager, monitorManagerConverter::toDto);
	}

	@GetMapping("canpush")
	public JSONObject canpush(HttpServletRequest request, HttpServletResponse response) {
		JSONObject jsonObject = 	monitorManagerService.pushValidate(request.getParameter("name"), request.getParameter("pushPassword"));
		if (jsonObject.getIntValue("code")!=200){
			response.setStatus(500);
		}
		return jsonObject;
	}

	@GetMapping("transferStream/{id}")
	public JSONObject transferStream(@PathVariable Long id) {
		monitorManagerService.transferStream(id);
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("code",1);
		jsonObject.put("msg","开启成功");
		return jsonObject;
	}

	@GetMapping("turnOff/{id}")
	public JSONObject turnOff(@PathVariable Long id) {
		monitorManagerService.turnOff(id);
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("code",1);
		jsonObject.put("msg","开启成功");
		return jsonObject;
	}

	@GetMapping("transferStreamLocal/{id}")
	public JSONObject transferStreamLocal(@PathVariable Long id) {
		monitorManagerService.transferStreamToLocal(id);
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("code",1);
		jsonObject.put("msg","开启成功");
		return jsonObject;
	}


	@GetMapping(params = { "runlist" })
	public List<MonitorManagerDto> getrunList(@RequestParam("runlist") Long draw) {
		return monitorManagerService.findByRun(true);
	}
}
