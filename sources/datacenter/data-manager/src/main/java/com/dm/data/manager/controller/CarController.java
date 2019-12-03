
package com.dm.data.manager.controller;

import com.alibaba.fastjson.JSONObject;
import com.dm.common.dto.TableResult;
import com.dm.data.manager.converter.CarConverter;
import com.dm.data.manager.dto.CarDto;
import com.dm.data.manager.entity.Car;
import com.dm.data.manager.service.CarService;
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
 * 车辆信息控制器
 *
 */
@RestController
@RequestMapping("cars")
@Api(tags = { "车辆信息" })
public class CarController {

    @Autowired
    private CarService carMessageService;

    @Autowired
    private CarConverter carMessageConverter;

    @PostMapping
    @ResponseStatus(CREATED)
    public CarDto save(@RequestBody CarDto data) {
        Car model = carMessageService.save(data);
        return carMessageConverter.toDto(model);
    }

    @GetMapping("{id}")
    public CarDto get(@PathVariable("id") Long id) {
        Optional<Car> data = carMessageService.findById(id);
        return carMessageConverter.toDto(data);
    }

    @PutMapping("{id}")
    public CarDto update(@PathVariable("id") Long id, @RequestBody CarDto data) {
        Car model = carMessageService.update(id, data);
        return carMessageConverter.toDto(model);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(NO_CONTENT)
    public void delete(@PathVariable("id") Long id) {
        carMessageService.delete(id);
    }

    @GetMapping(params = { "draw" })
    public TableResult<CarDto> search(@RequestParam("companyId") Long companyId, @ModelAttribute CarDto condition,
            @CurrentUser UserDetailsDto user, @RequestParam("draw") Long draw, @PageableDefault Pageable pageable) {
        Page<Car> carMessage = carMessageService.find(companyId, condition, pageable);
        return TableResult.success(draw, carMessage, data -> carMessageConverter.toDto(data));
    }

    @GetMapping(params = { "api" })
    @ApiOperation(value = "可视化根据参数查询", notes = "getApiList")
    public Object getApiList(@CurrentUser UserDetailsDto user, @RequestParam("params") String jsonStr) {
        JSONObject jsonObject = ParamUtile.paresjson(jsonStr);
        List<Car> list = carMessageService.getByPatams(jsonObject, Car.class);
        return jsonObject.containsKey("pageNum")
                ? new PageInfo<CarDto>(carMessageConverter.toDto(list), jsonObject.getIntValue("pageNum"),
                        jsonObject.getIntValue("pageSize"))
                : carMessageConverter.toDto(list);
    }
}
