
package com.dm.data.manager.controller;

import com.alibaba.fastjson.JSONObject;
import com.dm.common.dto.TableResult;
import com.dm.data.manager.converter.CarRentalCompanyConverter;
import com.dm.data.manager.dto.CarRentalCompanyDto;
import com.dm.data.manager.entity.CarRentalCompany;
import com.dm.data.manager.service.CarRentalCompanyService;
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
 * 汽车租赁公司控制器
 *
 */
@RestController
@RequestMapping("carRentalEnterpises")
@Api(tags = { "汽车租赁" })
public class CarRentalCompanyController extends AbstractController<CarRentalCompanyDto> {

    @Autowired
    private CarRentalCompanyService carRentalService;

    @Autowired
    private CarRentalCompanyConverter carRentalConverter;

    @Override
    @PostMapping
    @ResponseStatus(CREATED)
    public CarRentalCompanyDto save(@RequestBody CarRentalCompanyDto data) {
        CarRentalCompany model = carRentalService.save(data);
        return carRentalConverter.toDto(model);
    }

    @Override
    @GetMapping(params = { "api" })
    @ApiOperation(value = "可视化根据参数查询", notes = "getApiList")
    public Object getApiList(@CurrentUser UserDetailsDto user, @RequestParam("params") String jsonStr) {
        JSONObject jsonObject = ParamUtile.paresjson(jsonStr);
        List<CarRentalCompany> list = carRentalService.getByPatams(jsonObject, CarRentalCompany.class);
        return jsonObject.containsKey("pageNum")
                ? new PageInfo<CarRentalCompanyDto>(carRentalConverter.toDto(list), jsonObject.getIntValue("pageNum"),
                        jsonObject.getIntValue("pageSize"))
                : carRentalConverter.toDto(list);
    }

    @GetMapping("{id}")
    public CarRentalCompanyDto get(@PathVariable("id") Long id) {
        Optional<CarRentalCompany> data = carRentalService.findById(id);
        return carRentalConverter.toDto(data);
    }

    @PutMapping("{id}")
    public CarRentalCompanyDto update(@PathVariable("id") Long id, @RequestBody CarRentalCompanyDto data) {
        CarRentalCompany model = carRentalService.update(id, data);
        return carRentalConverter.toDto(model);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(NO_CONTENT)
    public void delete(@PathVariable("id") Long id) {
        carRentalService.delete(id);
    }

    @Override
    @GetMapping(params = { "draw" })
    public TableResult<CarRentalCompanyDto> search(@RequestParam("draw") Long draw, @CurrentUser UserDetailsDto user,
            @ModelAttribute CarRentalCompanyDto condition, @PageableDefault Pageable pageable) {
        Page<CarRentalCompany> carRental = carRentalService.find(condition, user == null ? null : user.getRegionCode(), pageable);
        return TableResult.success(draw, carRental, data -> carRentalConverter.toDto(data));
    }
}
