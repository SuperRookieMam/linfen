
package com.dm.data.manager.controller;

import com.alibaba.fastjson.JSONObject;
import com.dm.common.dto.TableResult;
import com.dm.data.manager.converter.TourBusConverter;
import com.dm.data.manager.dto.TourBusDto;
import com.dm.data.manager.entity.TourBus;
import com.dm.data.manager.service.TourBusService;
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
 * 旅游大巴控制器
 *
 */
@RestController
@RequestMapping("tourBuses")
@Api(tags = { "旅游大巴" })
public class TourBusController extends AbstractController<TourBusDto> {

    @Autowired
    private TourBusService tourBusService;

    @Autowired
    private TourBusConverter tourBusConverter;

    @Override
    @PostMapping
    @ResponseStatus(CREATED)
    public TourBusDto save(@RequestBody TourBusDto data) {
        TourBus model = tourBusService.save(data);
        return tourBusConverter.toDto(model);
    }

    @GetMapping("{id}")
    public TourBusDto get(@PathVariable("id") Long id) {
        Optional<TourBus> data = tourBusService.findById(id);
        return tourBusConverter.toDto(data);
    }

    @PutMapping("{id}")
    public TourBusDto update(@PathVariable("id") Long id, @RequestBody TourBusDto data) {
        TourBus model = tourBusService.update(id, data);
        return tourBusConverter.toDto(model);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(NO_CONTENT)
    public void delete(@PathVariable("id") Long id) {
        tourBusService.delete(id);
    }

    @Override
    @GetMapping(params = { "draw" })
    public TableResult<TourBusDto> search(@RequestParam("draw") Long draw, @CurrentUser UserDetailsDto user,
            @ModelAttribute TourBusDto condition, @PageableDefault Pageable pageable) {
        Page<TourBus> tourBus = tourBusService.find(condition, user == null ? null : user.getRegionCode(), pageable);
        return TableResult.success(draw, tourBus, data -> tourBusConverter.toDto(data));
    }

    @Override
    @GetMapping(params = { "api" })
    @ApiOperation(value = "可视化根据参数查询", notes = "getApiList")
    public Object getApiList(@CurrentUser UserDetailsDto user, @RequestParam("params") String jsonStr) {
        JSONObject jsonObject = ParamUtile.paresjson(jsonStr);
        List<TourBus> list = tourBusService.getByPatams(jsonObject, TourBus.class);
        return jsonObject.containsKey("pageNum")
                ? new PageInfo<TourBusDto>(tourBusConverter.toDto(list), jsonObject.getIntValue("pageNum"),
                        jsonObject.getIntValue("pageSize"))
                : tourBusConverter.toDto(list);
    }
}
