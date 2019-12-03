
package com.dm.data.manager.controller;

import com.alibaba.fastjson.JSONObject;
import com.dm.common.dto.TableResult;
import com.dm.data.manager.converter.TourBusServiceConverter;
import com.dm.data.manager.dto.TourBusServiceDto;
import com.dm.data.manager.entity.TourBusService;
import com.dm.data.manager.service.TourBusServiceService;
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
 * 旅游大巴班次信息控制器
 *
 */
@RestController
@RequestMapping("tourBusServices")
@Api(tags = { "旅游大巴班次信息" })
public class TourBusServiceController {

    @Autowired
    private TourBusServiceService tourBusServiceService;

    @Autowired
    private TourBusServiceConverter tourBusServiceConverter;

    @PostMapping
    @ResponseStatus(CREATED)
    public TourBusServiceDto save(@RequestBody TourBusServiceDto data) {
        TourBusService model = tourBusServiceService.save(data);
        return tourBusServiceConverter.toDto(model);
    }

    @GetMapping("{id}")
    public TourBusServiceDto get(@PathVariable("id") Long id) {
        Optional<TourBusService> data = tourBusServiceService.findById(id);
        return tourBusServiceConverter.toDto(data);
    }

    @PutMapping("{id}")
    public TourBusServiceDto update(@PathVariable("id") Long id, @RequestBody TourBusServiceDto data) {
        TourBusService model = tourBusServiceService.update(id, data);
        return tourBusServiceConverter.toDto(model);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(NO_CONTENT)
    public void delete(@PathVariable("id") Long id) {
        tourBusServiceService.delete(id);
    }

    @GetMapping(params = { "draw" })
    public TableResult<TourBusServiceDto> search(@RequestParam("busId") Long busId, @CurrentUser UserDetailsDto user,
            @ModelAttribute TourBusServiceDto condition, @RequestParam("draw") Long draw,
            @PageableDefault Pageable pageable) {
        Page<TourBusService> tourBusService = tourBusServiceService.find(busId, condition, pageable);
        return TableResult.success(draw, tourBusService, data -> tourBusServiceConverter.toDto(data));
    }

    @GetMapping(params = { "api" })
    @ApiOperation(value = "可视化根据参数查询", notes = "getApiList")
    public Object getApiList(@CurrentUser UserDetailsDto user, @RequestParam("params") String jsonStr) {
        JSONObject jsonObject = ParamUtile.paresjson(jsonStr);
        List<TourBusService> list = tourBusServiceService.getByPatams(jsonObject, TourBusService.class);
        return jsonObject.containsKey("pageNum")
                ? new PageInfo<TourBusServiceDto>(tourBusServiceConverter.toDto(list),
                        jsonObject.getIntValue("pageNum"), jsonObject.getIntValue("pageSize"))
                : tourBusServiceConverter.toDto(list);
    }
}
