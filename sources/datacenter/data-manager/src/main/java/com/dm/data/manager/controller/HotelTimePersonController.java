package com.dm.data.manager.controller;

import com.alibaba.fastjson.JSONObject;
import com.dm.common.dto.TableResult;
import com.dm.data.manager.converter.HotelTimePersonConverter;
import com.dm.data.manager.dto.HotelTimePersonDto;
import com.dm.data.manager.entity.HotelTimePerson;
import com.dm.data.manager.service.HotelTimePersonService;
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
@RequestMapping("hotelTimePersons")
@Api(tags = { "酒店时时数据" })
public class HotelTimePersonController extends AbstractController<HotelTimePersonDto> {

    @Autowired
    private HotelTimePersonConverter hotelTimePersonConverter;

    @Autowired
    private HotelTimePersonService hotelTimePersonService;

    @Override
    @PostMapping
    @ResponseStatus(CREATED)
    public HotelTimePersonDto save(@RequestBody HotelTimePersonDto data) {
        HotelTimePerson model = hotelTimePersonService.save(data);
        return hotelTimePersonConverter.toDto(model);
    }

    @GetMapping("{id}")
    public HotelTimePersonDto get(@PathVariable("id") Long id) {
        Optional<HotelTimePerson> data = hotelTimePersonService.findById(id);
        return hotelTimePersonConverter.toDto(data);
    }

    @PutMapping("{id}")
    public HotelTimePersonDto update(@PathVariable("id") Long id, @RequestBody HotelTimePersonDto data) {
        HotelTimePerson model = hotelTimePersonService.update(id, data);
        return hotelTimePersonConverter.toDto(model);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(NO_CONTENT)
    public void delete(@PathVariable("id") Long id) {
        hotelTimePersonService.delete(id);
    }

    @Override
    @GetMapping(params = { "draw" })
    public TableResult<HotelTimePersonDto> search(@RequestParam("draw") Long draw, @CurrentUser UserDetailsDto user,
            @ModelAttribute HotelTimePersonDto condition, @PageableDefault Pageable pageable) {
        Page<HotelTimePerson> accommodation = hotelTimePersonService.find(condition, user == null ? null : user.getRegionCode(), pageable);
        return TableResult.success(draw, accommodation, hotelTimePersonConverter::toDto);
    }

    @Override
    @GetMapping(params = { "api" })
    @ApiOperation(value = "可视化根据参数查询", notes = "getApiList")
    public Object getApiList(@CurrentUser UserDetailsDto user, @RequestParam("params") String jsonStr) {
        JSONObject jsonObject = ParamUtile.paresjson(jsonStr);
        List<HotelTimePerson> list = hotelTimePersonService.getByPatams(jsonObject, HotelTimePerson.class);
        return jsonObject.containsKey("pageNum")
                ? new PageInfo<HotelTimePersonDto>(hotelTimePersonConverter.toDto(list),
                        jsonObject.getIntValue("pageNum"), jsonObject.getIntValue("pageSize"))
                : hotelTimePersonConverter.toDto(list);
    }
}
