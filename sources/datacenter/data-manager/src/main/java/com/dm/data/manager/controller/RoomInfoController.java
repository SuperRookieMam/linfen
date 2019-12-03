package com.dm.data.manager.controller;

import com.alibaba.fastjson.JSONObject;
import com.dm.common.dto.TableResult;
import com.dm.data.manager.converter.RoomInfoConverter;
import com.dm.data.manager.dto.RoomInfoDto;
import com.dm.data.manager.entity.RoomInfo;
import com.dm.data.manager.service.RoomInfoService;
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
@RequestMapping("roomInfos")
@Api(tags = { "乡村旅游" })
public class RoomInfoController extends AbstractController<RoomInfoDto> {

    @Autowired
    private RoomInfoService roomInfoService;

    @Autowired
    private RoomInfoConverter roomInfoConverter;

    @Override
    @PostMapping
    @ResponseStatus(CREATED)
    public RoomInfoDto save(@RequestBody RoomInfoDto data) {
        RoomInfo model = roomInfoService.save(data);
        return roomInfoConverter.toDto(model);
    }

    @GetMapping("{id}")
    public RoomInfoDto get(@PathVariable("id") Long id) {
        Optional<RoomInfo> data = roomInfoService.findById(id);
        return roomInfoConverter.toDto(data);
    }

    @PutMapping("{id}")
    public RoomInfoDto update(@PathVariable("id") Long id, @RequestBody RoomInfoDto data) {
        RoomInfo model = roomInfoService.update(id, data);
        return roomInfoConverter.toDto(model);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(NO_CONTENT)
    public void delete(@PathVariable("id") Long id) {
        roomInfoService.delete(id);
    }

    @Override
    @GetMapping(params = { "draw" })
    public TableResult<RoomInfoDto> search(@RequestParam("draw") Long draw, @CurrentUser UserDetailsDto user,
            @ModelAttribute RoomInfoDto condition, @PageableDefault Pageable pageable) {
        Page<RoomInfo> tourBus = roomInfoService.find(condition, user == null ? null : user.getRegionCode(), pageable);
        return TableResult.success(draw, tourBus, data -> roomInfoConverter.toDto(data));
    }

    @Override
    @GetMapping(params = { "api" })
    @ApiOperation(value = "可视化根据参数查询", notes = "getApiList")
    public Object getApiList(@CurrentUser UserDetailsDto user, @RequestParam("params") String jsonStr) {
        JSONObject jsonObject = ParamUtile.paresjson(jsonStr);
        List<RoomInfo> list = roomInfoService.getByPatams(jsonObject, RoomInfo.class);
        return jsonObject.containsKey("pageNum")
                ? new PageInfo<RoomInfoDto>(roomInfoConverter.toDto(list), jsonObject.getIntValue("pageNum"),
                        jsonObject.getIntValue("pageSize"))
                : roomInfoConverter.toDto(list);
    }
}
