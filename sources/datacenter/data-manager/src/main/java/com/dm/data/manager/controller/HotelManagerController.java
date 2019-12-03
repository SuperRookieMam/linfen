package com.dm.data.manager.controller;

import com.alibaba.fastjson.JSONObject;
import com.dm.common.dto.TableResult;
import com.dm.data.manager.converter.HotelManagerConverter;
import com.dm.data.manager.dto.HotelManagerDto;
import com.dm.data.manager.entity.HotelManager;
import com.dm.data.manager.service.HotelManagerService;
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
@RequestMapping("hotelManagers")
@Api(tags = { "酒店管理" })
public class HotelManagerController extends AbstractController<HotelManagerDto> {

    @Autowired
    private HotelManagerConverter hotelManagerConverter;

    @Autowired
    private HotelManagerService hotelManagerService;

    @Override
    @PostMapping
    @ResponseStatus(CREATED)
    public HotelManagerDto save(@RequestBody HotelManagerDto data) {
        HotelManager model = hotelManagerService.save(data);
        return hotelManagerConverter.toDto(model);
    }

    @GetMapping("{id}")
    public HotelManagerDto get(@PathVariable("id") Long id) {
        Optional<HotelManager> data = hotelManagerService.findById(id);
        return hotelManagerConverter.toDto(data);
    }

    @PutMapping("{id}")
    public HotelManagerDto update(@PathVariable("id") Long id, @RequestBody HotelManagerDto data) {
        HotelManager model = hotelManagerService.update(id, data);
        return hotelManagerConverter.toDto(model);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(NO_CONTENT)
    public void delete(@PathVariable("id") Long id) {
        hotelManagerService.delete(id);
    }

    @Override
    @GetMapping(params = { "draw" })
    public TableResult<HotelManagerDto> search(@RequestParam("draw") Long draw, @CurrentUser UserDetailsDto user,
            @ModelAttribute HotelManagerDto condition, @PageableDefault Pageable pageable) {
        Page<HotelManager> accommodation = hotelManagerService.find(condition, user == null ? null : user.getRegionCode(), pageable);
        return TableResult.success(draw, accommodation, hotelManagerConverter::toDto);
    }

    @Override
    @GetMapping(params = { "api" })
    @ApiOperation(value = "可视化根据参数查询", notes = "getApiList")
    public Object getApiList(@CurrentUser UserDetailsDto user, @RequestParam("params") String jsonStr) {
        JSONObject jsonObject = ParamUtile.paresjson(jsonStr);
        List<HotelManager> list = hotelManagerService.getByPatams(jsonObject, HotelManager.class);
        return jsonObject.containsKey("pageNum")
                ? new PageInfo<HotelManagerDto>(hotelManagerConverter.toDto(list), jsonObject.getIntValue("pageNum"),
                        jsonObject.getIntValue("pageSize"))
                : hotelManagerConverter.toDto(list);
    }

}
