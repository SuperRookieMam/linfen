package com.dm.data.manager.controller;

import com.alibaba.fastjson.JSONObject;
import com.dm.common.dto.TableResult;
import com.dm.data.manager.converter.ParkingTimeConverter;
import com.dm.data.manager.dto.ParkingTimeDto;
import com.dm.data.manager.entity.ParkingTime;
import com.dm.data.manager.service.ParkingTimeService;
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
@RequestMapping("parkingTimes")
@Api(tags = { "时时停车数" })
public class ParkingTimeController extends AbstractController<ParkingTimeDto> {

    @Autowired
    private ParkingTimeConverter parkingTimeConverter;

    @Autowired
    private ParkingTimeService parkingTimeService;

    @Override
    @PostMapping
    @ResponseStatus(CREATED)
    public ParkingTimeDto save(@RequestBody ParkingTimeDto data) {
        ParkingTime model = parkingTimeService.save(data);
        return parkingTimeConverter.toDto(model);
    }

    @GetMapping("{id}")
    public ParkingTimeDto get(@PathVariable("id") Long id) {
        Optional<ParkingTime> data = parkingTimeService.findById(id);
        return parkingTimeConverter.toDto(data);
    }

    @PutMapping("{id}")
    public ParkingTimeDto update(@PathVariable("id") Long id, @RequestBody ParkingTimeDto data) {
        ParkingTime model = parkingTimeService.update(id, data);
        return parkingTimeConverter.toDto(model);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(NO_CONTENT)
    public void delete(@PathVariable("id") Long id) {
        parkingTimeService.delete(id);
    }

    @Override
    @GetMapping(params = { "draw" })
    public TableResult<ParkingTimeDto> search(@RequestParam("draw") Long draw, @CurrentUser UserDetailsDto user,
            @ModelAttribute ParkingTimeDto condition, @PageableDefault Pageable pageable) {
        Page<ParkingTime> accommodation = parkingTimeService.find(condition, user == null ? null : user.getRegionCode(), pageable);
        return TableResult.success(draw, accommodation, parkingTimeConverter::toDto);
    }

    @Override
    @GetMapping(params = { "api" })
    @ApiOperation(value = "可视化根据参数查询", notes = "getApiList")
    public Object getApiList(@CurrentUser UserDetailsDto user, @RequestParam("params") String jsonStr) {
        JSONObject jsonObject = ParamUtile.paresjson(jsonStr);
        List<ParkingTime> list = parkingTimeService.getByPatams(jsonObject, ParkingTime.class);
        return jsonObject.containsKey("pageNum")
                ? new PageInfo<ParkingTimeDto>(parkingTimeConverter.toDto(list), jsonObject.getIntValue("pageNum"),
                        jsonObject.getIntValue("pageSize"))
                : parkingTimeConverter.toDto(list);
    }
}
