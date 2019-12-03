
package com.dm.data.manager.controller;

import com.alibaba.fastjson.JSONObject;
import com.dm.common.dto.TableResult;
import com.dm.data.manager.converter.TourismMonitoringCenterConverter;
import com.dm.data.manager.dto.TourismMonitoringCenterDto;
import com.dm.data.manager.entity.TourismMonitoringCenter;
import com.dm.data.manager.service.TourismMonitoringCenterService;
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
 * 旅游监控中心控制器
 *
 */
@RestController
@RequestMapping("tourismMonitoringCenters")
@Api(tags = { "旅游监控中心" })
public class TourismMonitoringCenterController extends AbstractController<TourismMonitoringCenterDto> {

    @Autowired
    private TourismMonitoringCenterService tourismMonitoringCenterService;

    @Autowired
    private TourismMonitoringCenterConverter tourismMonitoringCenterConverter;

    @Override
    @PostMapping
    @ResponseStatus(CREATED)
    public TourismMonitoringCenterDto save(@RequestBody TourismMonitoringCenterDto data) {
        TourismMonitoringCenter model = tourismMonitoringCenterService.save(data);
        return tourismMonitoringCenterConverter.toDto(model);
    }

    @GetMapping("{id}")
    public TourismMonitoringCenterDto get(@PathVariable("id") Long id) {
        Optional<TourismMonitoringCenter> data = tourismMonitoringCenterService.findById(id);
        return tourismMonitoringCenterConverter.toDto(data);
    }

    @PutMapping("{id}")
    public TourismMonitoringCenterDto update(@PathVariable("id") Long id,
            @RequestBody TourismMonitoringCenterDto data) {
        TourismMonitoringCenter model = tourismMonitoringCenterService.update(id, data);
        return tourismMonitoringCenterConverter.toDto(model);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(NO_CONTENT)
    public void delete(@PathVariable("id") Long id) {
        tourismMonitoringCenterService.delete(id);
    }

    @Override
    @GetMapping(params = { "draw" })
    public TableResult<TourismMonitoringCenterDto> search(@RequestParam("draw") Long draw,
            @CurrentUser UserDetailsDto user, @ModelAttribute TourismMonitoringCenterDto condition,
            @PageableDefault Pageable pageable) {
        Page<TourismMonitoringCenter> tourismMonitoringCenter = tourismMonitoringCenterService.find(pageable);
        return TableResult.success(draw, tourismMonitoringCenter, data -> tourismMonitoringCenterConverter.toDto(data));
    }

    @Override
    @GetMapping(params = { "api" })
    @ApiOperation(value = "可视化根据参数查询", notes = "getApiList")
    public Object getApiList(@CurrentUser UserDetailsDto user, @RequestParam("params") String jsonStr) {
        JSONObject jsonObject = ParamUtile.paresjson(jsonStr);
        List<TourismMonitoringCenter> list = tourismMonitoringCenterService.getByPatams(jsonObject,
                TourismMonitoringCenter.class);
        return jsonObject.containsKey("pageNum")
                ? new PageInfo<TourismMonitoringCenterDto>(tourismMonitoringCenterConverter.toDto(list),
                        jsonObject.getIntValue("pageNum"), jsonObject.getIntValue("pageSize"))
                : tourismMonitoringCenterConverter.toDto(list);
    }
}
