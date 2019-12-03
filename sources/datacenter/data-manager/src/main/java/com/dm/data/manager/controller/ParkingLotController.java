
package com.dm.data.manager.controller;

import com.alibaba.fastjson.JSONObject;
import com.dm.common.dto.TableResult;
import com.dm.data.manager.converter.ParkingLotConverter;
import com.dm.data.manager.dto.ParkingLotDto;
import com.dm.data.manager.entity.ParkingLot;
import com.dm.data.manager.service.ParkingLotService;
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
 * 停车场控制器
 *
 */
@RestController
@RequestMapping("parkingLots")
@Api(tags = { "停车场" })
public class ParkingLotController extends AbstractController<ParkingLotDto> {

    @Autowired
    private ParkingLotService parkingLotService;

    @Autowired
    private ParkingLotConverter parkingLotConverter;

    @Override
    @PostMapping
    @ResponseStatus(CREATED)
    public ParkingLotDto save(@RequestBody ParkingLotDto data) {
        ParkingLot model = parkingLotService.save(data);
        return parkingLotConverter.toDto(model);
    }

    @GetMapping("{id}")
    public ParkingLotDto get(@PathVariable("id") Long id) {
        Optional<ParkingLot> data = parkingLotService.findById(id);
        return parkingLotConverter.toDto(data);
    }

    @PutMapping("{id}")
    public ParkingLotDto update(@PathVariable("id") Long id, @RequestBody ParkingLotDto data) {
        ParkingLot model = parkingLotService.update(id, data);
        return parkingLotConverter.toDto(model);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(NO_CONTENT)
    public void delete(@PathVariable("id") Long id) {
        parkingLotService.delete(id);
    }

    @Override
    @GetMapping(params = { "draw" })
    public TableResult<ParkingLotDto> search(@RequestParam("draw") Long draw, @CurrentUser UserDetailsDto user,
            @ModelAttribute ParkingLotDto condition, @PageableDefault Pageable pageable) {
        Page<ParkingLot> parkingLot = parkingLotService.find(condition, user == null ? null : user.getRegionCode(), pageable);
        return TableResult.success(draw, parkingLot, data -> parkingLotConverter.toDto(data));
    }

    @Override
    @GetMapping(params = { "api" })
    @ApiOperation(value = "可视化根据参数查询", notes = "getApiList")
    public Object getApiList(@CurrentUser UserDetailsDto user, @RequestParam("params") String jsonStr) {
        JSONObject jsonObject = ParamUtile.paresjson(jsonStr);
        List<ParkingLot> list = parkingLotService.getByPatams(jsonObject, ParkingLot.class);
        return jsonObject.containsKey("pageNum")
                ? new PageInfo<ParkingLotDto>(parkingLotConverter.toDto(list), jsonObject.getIntValue("pageNum"),
                        jsonObject.getIntValue("pageSize"))
                : parkingLotConverter.toDto(list);
    }

    @GetMapping(params = { "compare" })
    @ApiOperation(value = "今年比去年增长", notes = "getCompare")
    public Object getCompare(@CurrentUser UserDetailsDto user) {
        Long aDouble = parkingLotService.getCompare(ParkingLot.class);
        return aDouble;
    }
}
