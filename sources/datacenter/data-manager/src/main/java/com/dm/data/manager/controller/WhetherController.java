package com.dm.data.manager.controller;

import com.alibaba.fastjson.JSONObject;
import com.dm.common.dto.TableResult;
import com.dm.data.manager.converter.WhetherConverter;
import com.dm.data.manager.dto.WhetherDto;
import com.dm.data.manager.entity.Whether;
import com.dm.data.manager.service.WhetherService;
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

@RestController
@RequestMapping("whethers")
@Api(tags = { "天气" })
public class WhetherController extends AbstractController<WhetherDto> {

    @Autowired
    private WhetherConverter whetherConverter;

    @Autowired
    private WhetherService whetherService;

    @Override
    @PostMapping
    @ResponseStatus(CREATED)
    public WhetherDto save(@RequestBody WhetherDto data) {
        Whether model = whetherService.save(data);
        return whetherConverter.toDto(model);
    }

    @GetMapping("{id}")
    public WhetherDto get(@PathVariable("id") Long id) {
        Optional<Whether> data = whetherService.findById(id);
        return whetherConverter.toDto(data);
    }

    @PutMapping("{id}")
    public WhetherDto update(@PathVariable("id") Long id, @RequestBody WhetherDto data) {
        Whether model = whetherService.update(id, data);
        return whetherConverter.toDto(model);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(NO_CONTENT)
    public void delete(@PathVariable("id") Long id) {
        whetherService.delete(id);
    }

    @Override
    @GetMapping(params = { "draw" })
    public TableResult<WhetherDto> search(@RequestParam("draw") Long draw, @CurrentUser UserDetailsDto user,
            @ModelAttribute WhetherDto condition, @PageableDefault Pageable pageable) {
        Page<Whether> accommodation = whetherService.find(condition, user == null ? null : user.getRegionCode(), pageable);
        return TableResult.success(draw, accommodation, whetherConverter::toDto);
    }

    @Override
    @GetMapping(params = { "api" })
    @ApiOperation(value = "可视化根据参数查询", notes = "getApiList")
    public Object getApiList(@CurrentUser UserDetailsDto user, @RequestParam("params") String jsonStr) {
        JSONObject jsonObject = ParamUtile.paresjson(jsonStr);
        List<Whether> list = whetherService.getByPatams(jsonObject, Whether.class);
        return jsonObject.containsKey("pageNum")
                ? new PageInfo<WhetherDto>(whetherConverter.toDto(list), jsonObject.getIntValue("pageNum"),
                        jsonObject.getIntValue("pageSize`"))
                : whetherConverter.toDto(list);
    }
}
