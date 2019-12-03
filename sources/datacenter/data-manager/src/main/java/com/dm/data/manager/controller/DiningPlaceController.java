
package com.dm.data.manager.controller;

import com.alibaba.fastjson.JSONObject;
import com.dm.common.dto.TableResult;
import com.dm.data.manager.converter.DiningPlaceConverter;
import com.dm.data.manager.dto.DiningPlaceDto;
import com.dm.data.manager.entity.DiningPlace;
import com.dm.data.manager.service.DiningPlaceService;
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
 * 餐饮场所控制器
 *
 */
@RestController
@RequestMapping("diningPlaces")
@Api(tags = { "餐饮场所控制器" })
public class DiningPlaceController extends AbstractController<DiningPlaceDto> {

    @Autowired
    private DiningPlaceService diningPlaceService;

    @Autowired
    private DiningPlaceConverter diningPlaceConverter;

    @Override
    @PostMapping
    @ResponseStatus(CREATED)
    public DiningPlaceDto save(@RequestBody DiningPlaceDto data) {
        DiningPlace model = diningPlaceService.save(data);
        return diningPlaceConverter.toDto(model);
    }

    @Override
    @GetMapping(params = { "api" })
    @ApiOperation(value = "可视化根据参数查询", notes = "getApiList")
    public Object getApiList(@CurrentUser UserDetailsDto user, @RequestParam("params") String jsonStr) {
        JSONObject jsonObject = ParamUtile.paresjson(jsonStr);
        List<DiningPlace> list = diningPlaceService.getByPatams(jsonObject, DiningPlace.class);
        return jsonObject.containsKey("pageNum")
                ? new PageInfo<DiningPlaceDto>(diningPlaceConverter.toDto(list), jsonObject.getIntValue("pageNum"),
                        jsonObject.getIntValue("pageSize"))
                : diningPlaceConverter.toDto(list);
    }

    @GetMapping("{id}")
    public DiningPlaceDto get(@PathVariable("id") Long id) {
        Optional<DiningPlace> data = diningPlaceService.findById(id);
        return diningPlaceConverter.toDto(data);
    }

    @PutMapping("{id}")
    public DiningPlaceDto update(@PathVariable("id") Long id, @RequestBody DiningPlaceDto data) {
        DiningPlace model = diningPlaceService.update(id, data);
        return diningPlaceConverter.toDto(model);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(NO_CONTENT)
    public void delete(@PathVariable("id") Long id) {
        diningPlaceService.delete(id);
    }

    @Override
    @GetMapping(params = { "draw" })
    public TableResult<DiningPlaceDto> search(@RequestParam("draw") Long draw, @CurrentUser UserDetailsDto user,
            @ModelAttribute DiningPlaceDto condition, @PageableDefault Pageable pageable) {
        Page<DiningPlace> diningPlace = diningPlaceService.find(condition, user == null ? null : user.getRegionCode(), pageable);
        return TableResult.success(draw, diningPlace, data -> diningPlaceConverter.toDto(data));
    }

    @GetMapping(params = { "compare" })
    @ApiOperation(value = "今年比去年增长", notes = "getCompare")
    public Object getCompare(@CurrentUser UserDetailsDto user) {
        Long aDouble = diningPlaceService.getCompare(DiningPlace.class);
        return aDouble;
    }
}
