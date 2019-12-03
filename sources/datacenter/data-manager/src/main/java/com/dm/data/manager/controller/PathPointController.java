package com.dm.data.manager.controller;

import com.alibaba.fastjson.JSONObject;
import com.dm.common.dto.TableResult;
import com.dm.data.manager.converter.PathPointConverter;
import com.dm.data.manager.dto.PathPointDto;
import com.dm.data.manager.entity.PathPoint;
import com.dm.data.manager.service.PathPointService;
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
@RequestMapping("pathPoints")
@Api(tags = { "时时停车数" })
public class PathPointController extends AbstractController<PathPointDto> {
    @Autowired
    private PathPointConverter pathPointConverter;

    @Autowired
    private PathPointService pathPointService;

    @Override
    @PostMapping
    @ResponseStatus(CREATED)
    public PathPointDto save(@RequestBody PathPointDto data) {
        PathPoint model = pathPointService.save(data);
        return pathPointConverter.toDto(model);
    }

    @GetMapping("{id}")
    public PathPointDto get(@PathVariable("id") Long id) {
        Optional<PathPoint> data = pathPointService.findById(id);
        return pathPointConverter.toDto(data);
    }

    @PutMapping("{id}")
    public PathPointDto update(@PathVariable("id") Long id, @RequestBody PathPointDto data) {
        PathPoint model = pathPointService.update(id, data);
        return pathPointConverter.toDto(model);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(NO_CONTENT)
    public void delete(@PathVariable("id") Long id) {
        pathPointService.delete(id);
    }

    @Override
    @GetMapping(params = { "draw" })
    public TableResult<PathPointDto> search(@RequestParam("draw") Long draw, @CurrentUser UserDetailsDto user,
            @ModelAttribute PathPointDto condition, @PageableDefault Pageable pageable) {
        Page<PathPoint> accommodation = pathPointService.find(condition, user == null ? null : user.getRegionCode(), pageable);
        return TableResult.success(draw, accommodation, pathPointConverter::toDto);
    }

    @Override
    @GetMapping(params = { "api" })
    @ApiOperation(value = "可视化根据参数查询", notes = "getApiList")
    public Object getApiList(@CurrentUser UserDetailsDto user, @RequestParam("params") String jsonStr) {
        JSONObject jsonObject = ParamUtile.paresjson(jsonStr);
        List<PathPoint> list = pathPointService.getByPatams(jsonObject, PathPoint.class);
        return jsonObject.containsKey("pageNum")
                ? new PageInfo<PathPointDto>(pathPointConverter.toDto(list), jsonObject.getIntValue("pageNum"),
                        jsonObject.getIntValue("pageSize"))
                : pathPointConverter.toDto(list);
    }
}
