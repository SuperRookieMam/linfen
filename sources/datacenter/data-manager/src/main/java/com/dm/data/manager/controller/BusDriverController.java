
package com.dm.data.manager.controller;

import com.alibaba.fastjson.JSONObject;
import com.dm.common.dto.TableResult;
import com.dm.data.manager.converter.BusDriverConverter;
import com.dm.data.manager.dto.BusDriverDto;
import com.dm.data.manager.entity.BusDriver;
import com.dm.data.manager.service.BusDriverService;
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
 * 大巴司机控制器
 *
 */
@RestController
@RequestMapping("busDrivers")
@Api(tags = { "大巴司机控" })
public class BusDriverController extends AbstractController<BusDriverDto> {

    @Autowired
    private BusDriverService busDriverService;

    @Autowired
    private BusDriverConverter busDriverConverter;

    @Override
    @PostMapping
    @ResponseStatus(CREATED)
    public BusDriverDto save(@RequestBody BusDriverDto data) {
        BusDriver model = busDriverService.save(data);
        return busDriverConverter.toDto(model);
    }

    @GetMapping("{id}")
    public BusDriverDto get(@PathVariable("id") Long id) {
        Optional<BusDriver> data = busDriverService.findById(id);
        return busDriverConverter.toDto(data);
    }

    @PutMapping("{id}")
    public BusDriverDto update(@PathVariable("id") Long id, @RequestBody BusDriverDto data) {
        BusDriver model = busDriverService.update(id, data);
        return busDriverConverter.toDto(model);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(NO_CONTENT)
    public void delete(@PathVariable("id") Long id) {
        busDriverService.delete(id);
    }

    @Override
    @GetMapping(params = { "draw" })
    public TableResult<BusDriverDto> search(@RequestParam("draw") Long draw, @CurrentUser UserDetailsDto user,
            @ModelAttribute BusDriverDto condition, @PageableDefault Pageable pageable) {
        Page<BusDriver> busDriver = busDriverService.find(condition, user == null ? null : user.getRegionCode(), pageable);
        return TableResult.success(draw, busDriver, data -> busDriverConverter.toDto(data));
    }

    @Override
    @GetMapping(params = { "api" })
    @ApiOperation(value = "可视化根据参数查询", notes = "getApiList")
    public Object getApiList(@CurrentUser UserDetailsDto user, @RequestParam("params") String jsonStr) {
        JSONObject jsonObject = ParamUtile.paresjson(jsonStr);
        List<BusDriver> list = busDriverService.getByPatams(jsonObject, BusDriver.class);
        return jsonObject.containsKey("pageNum")
                ? new PageInfo<BusDriverDto>(busDriverConverter.toDto(list), jsonObject.getIntValue("pageNum"),
                        jsonObject.getIntValue("pageSize"))
                : busDriverConverter.toDto(list);
    }
}
