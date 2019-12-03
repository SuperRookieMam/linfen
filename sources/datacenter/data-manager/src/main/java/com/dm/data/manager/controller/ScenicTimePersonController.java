package com.dm.data.manager.controller;

import com.alibaba.fastjson.JSONObject;
import com.dm.common.dto.TableResult;
import com.dm.data.manager.converter.ScenicTimePersonConverter;
import com.dm.data.manager.dto.ScenicTimePersonDto;
import com.dm.data.manager.entity.ScenicTimePerson;
import com.dm.data.manager.service.ScenicTimePersonService;
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
@RequestMapping("scenicTimePersons")
@Api(tags = { "景区实施人数" })
public class ScenicTimePersonController extends AbstractController<ScenicTimePersonDto> {

    @Autowired
    private ScenicTimePersonConverter scenicTimePersonConverter;

    @Autowired
    private ScenicTimePersonService scenicTimePersonService;

    @Override
    @PostMapping
    @ResponseStatus(CREATED)
    public ScenicTimePersonDto save(@RequestBody ScenicTimePersonDto data) {
        ScenicTimePerson model = scenicTimePersonService.save(data);
        return scenicTimePersonConverter.toDto(model);
    }

    @GetMapping("{id}")
    public ScenicTimePersonDto get(@PathVariable("id") Long id) {
        Optional<ScenicTimePerson> data = scenicTimePersonService.findById(id);
        return scenicTimePersonConverter.toDto(data);
    }

    @PutMapping("{id}")
    public ScenicTimePersonDto update(@PathVariable("id") Long id, @RequestBody ScenicTimePersonDto data) {
        ScenicTimePerson model = scenicTimePersonService.update(id, data);
        return scenicTimePersonConverter.toDto(model);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(NO_CONTENT)
    public void delete(@PathVariable("id") Long id) {
        scenicTimePersonService.delete(id);
    }

    @Override
    @GetMapping(params = { "draw" })
    public TableResult<ScenicTimePersonDto> search(@RequestParam("draw") Long draw, @CurrentUser UserDetailsDto user,
            @ModelAttribute ScenicTimePersonDto condition, @PageableDefault Pageable pageable) {
        Page<ScenicTimePerson> accommodation = scenicTimePersonService.find(condition, user == null ? null : user.getRegionCode(), pageable);
        return TableResult.success(draw, accommodation, scenicTimePersonConverter::toDto);
    }

    @Override
    @GetMapping(params = { "api" })
    @ApiOperation(value = "可视化根据参数查询", notes = "getApiList")
    public Object getApiList(@CurrentUser UserDetailsDto user, @RequestParam("params") String jsonStr) {
        JSONObject jsonObject = ParamUtile.paresjson(jsonStr);
        List<ScenicTimePerson> list = scenicTimePersonService.getByPatams(jsonObject, ScenicTimePerson.class);
        return jsonObject.containsKey("pageNum")
                ? new PageInfo<ScenicTimePersonDto>(scenicTimePersonConverter.toDto(list),
                        jsonObject.getIntValue("pageNum"), jsonObject.getIntValue("pageSize"))
                : scenicTimePersonConverter.toDto(list);
    }
}
