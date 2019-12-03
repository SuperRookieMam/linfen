
package com.dm.data.manager.controller;

import com.alibaba.fastjson.JSONObject;
import com.dm.common.dto.TableResult;
import com.dm.data.manager.converter.ScienceAndTechnologyCultureCenterConverter;
import com.dm.data.manager.dto.ScienceAndTechnologyCultureCenterDto;
import com.dm.data.manager.entity.ScienceAndTechnologyCultureCenter;
import com.dm.data.manager.service.ScienceAndTechnologyCultureCenterService;
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
 * 科技文化馆控制器
 *
 */
@RestController
@RequestMapping("scienceAndTechnologyCultureCenters")
@Api(tags = { "科技文化馆" })
public class ScienceAndTechnologyCultureCenterController
        extends AbstractController<ScienceAndTechnologyCultureCenterDto> {

    @Autowired
    private ScienceAndTechnologyCultureCenterService scienceAndTechnologyCultureCenterService;

    @Autowired
    private ScienceAndTechnologyCultureCenterConverter scienceAndTechnologyCultureCenterConverter;

    @Override
    @PostMapping
    @ResponseStatus(CREATED)
    public ScienceAndTechnologyCultureCenterDto save(@RequestBody ScienceAndTechnologyCultureCenterDto data) {
        ScienceAndTechnologyCultureCenter model = scienceAndTechnologyCultureCenterService.save(data);
        return scienceAndTechnologyCultureCenterConverter.toDto(model);
    }

    @GetMapping("{id}")
    public ScienceAndTechnologyCultureCenterDto get(@PathVariable("id") Long id) {
        Optional<ScienceAndTechnologyCultureCenter> data = scienceAndTechnologyCultureCenterService.findById(id);
        return scienceAndTechnologyCultureCenterConverter.toDto(data);
    }

    @PutMapping("{id}")
    public ScienceAndTechnologyCultureCenterDto update(@PathVariable("id") Long id,
            @RequestBody ScienceAndTechnologyCultureCenterDto data) {
        ScienceAndTechnologyCultureCenter model = scienceAndTechnologyCultureCenterService.update(id, data);
        return scienceAndTechnologyCultureCenterConverter.toDto(model);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(NO_CONTENT)
    public void delete(@PathVariable("id") Long id) {
        scienceAndTechnologyCultureCenterService.delete(id);
    }

    @Override
    @GetMapping(params = { "draw" })
    public TableResult<ScienceAndTechnologyCultureCenterDto> search(@RequestParam("draw") Long draw,
            @CurrentUser UserDetailsDto user, @ModelAttribute ScienceAndTechnologyCultureCenterDto condition,
            @PageableDefault Pageable pageable) {
        Page<ScienceAndTechnologyCultureCenter> scienceAndTechnologyCultureCenter = scienceAndTechnologyCultureCenterService
                .find(condition, user == null ? null : user.getRegionCode(), pageable);
        return TableResult.success(draw, scienceAndTechnologyCultureCenter,
                data -> scienceAndTechnologyCultureCenterConverter.toDto(data));
    }

    @Override
    @GetMapping(params = { "api" })
    @ApiOperation(value = "可视化根据参数查询", notes = "getApiList")
    public Object getApiList(@CurrentUser UserDetailsDto user, @RequestParam("params") String jsonStr) {
        JSONObject jsonObject = ParamUtile.paresjson(jsonStr);
        List<ScienceAndTechnologyCultureCenter> list = scienceAndTechnologyCultureCenterService.getByPatams(jsonObject,
                ScienceAndTechnologyCultureCenter.class);
        return jsonObject.containsKey("pageNum")
                ? new PageInfo<>(scienceAndTechnologyCultureCenterConverter.toDto(list),
                        jsonObject.getIntValue("pageNum"), jsonObject.getIntValue("pageSize"))
                : scienceAndTechnologyCultureCenterConverter.toDto(list);
    }
}
