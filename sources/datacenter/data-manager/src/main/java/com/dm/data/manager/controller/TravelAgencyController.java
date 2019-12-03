
package com.dm.data.manager.controller;

import com.alibaba.fastjson.JSONObject;
import com.dm.common.dto.TableResult;
import com.dm.data.manager.converter.TravelAgencyConverter;
import com.dm.data.manager.dto.TravelAgencyDto;
import com.dm.data.manager.entity.TravelAgentcy;
import com.dm.data.manager.service.TravelAgencyService;
import com.dm.data.manager.utile.PageInfo;
import com.dm.data.manager.utile.ParamUtile;
import com.dm.security.annotation.CurrentUser;
import com.dm.security.core.userdetails.UserDetailsDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;

/**
 * 旅行社控制器
 *
 */
@RestController
@RequestMapping({ "travelAgentFields", "travelAgencies" })
@Api(tags = { "旅行社" })
public class TravelAgencyController extends AbstractController<TravelAgencyDto> {

    @Autowired
    private TravelAgencyService travelAgentFieldService;

    @Autowired
    private TravelAgencyConverter travelAgentFieldConverter;

    @Override
    @PostMapping
    @ResponseStatus(CREATED)
    public TravelAgencyDto save(@RequestBody TravelAgencyDto data) {
        TravelAgentcy model = travelAgentFieldService.save(data);
        return travelAgentFieldConverter.toDto(model);
    }

    @GetMapping("{id}")
    public TravelAgencyDto get(@PathVariable("id") Long id) {
        Optional<TravelAgentcy> data = travelAgentFieldService.findById(id);
        return travelAgentFieldConverter.toDto(data);
    }

    @PutMapping("{id}")
    public TravelAgencyDto update(@PathVariable("id") Long id, @RequestBody TravelAgencyDto data) {
        TravelAgentcy model = travelAgentFieldService.update(id, data);
        return travelAgentFieldConverter.toDto(model);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(NO_CONTENT)
    public void delete(@PathVariable("id") Long id) {
        travelAgentFieldService.delete(id);
    }

    @Override
    @GetMapping(params = { "draw" })
    public TableResult<TravelAgencyDto> search(@RequestParam("draw") Long draw, @CurrentUser UserDetailsDto user,
            @ModelAttribute TravelAgencyDto condition, @PageableDefault Pageable pageable) {
        Page<TravelAgentcy> travelAgentField = travelAgentFieldService.find(condition, user == null ? null : user.getRegionCode(), pageable);
        return TableResult.success(draw, travelAgentField, data -> travelAgentFieldConverter.toDto(data));
    }

    @Override
    @GetMapping(params = { "api" })
    @ApiOperation(value = "可视化根据参数查询", notes = "getApiList")
    public Object getApiList(@CurrentUser UserDetailsDto user, @RequestParam("params") String jsonStr) {
        JSONObject jsonObject = ParamUtile.paresjson(jsonStr);
        List<TravelAgentcy> list = travelAgentFieldService.getByPatams(jsonObject, TravelAgentcy.class);
        return jsonObject.containsKey("pageNum")
                ? new PageInfo<TravelAgencyDto>(travelAgentFieldConverter.toDto(list),
                        jsonObject.getIntValue("pageNum"), jsonObject.getIntValue("pageSize"))
                : travelAgentFieldConverter.toDto(list);
    }

    @GetMapping(params = { "compare" })
    @ApiOperation(value = "今年比去年增长", notes = "getCompare")
    public Object getCompare(@CurrentUser UserDetailsDto user) {
        Long aDouble = travelAgentFieldService.getCompare(TravelAgentcy.class);
        return aDouble;
    }
}
