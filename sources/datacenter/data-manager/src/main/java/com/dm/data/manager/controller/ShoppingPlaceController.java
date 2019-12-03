
package com.dm.data.manager.controller;

import com.alibaba.fastjson.JSONObject;
import com.dm.common.dto.TableResult;
import com.dm.data.manager.converter.ShoppingPlaceConverter;
import com.dm.data.manager.dto.ShoppingPlaceDto;
import com.dm.data.manager.entity.ShoppingPlace;
import com.dm.data.manager.service.ShoppingPlaceService;
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
 * 购物场所控制器
 *
 */
@RestController
@RequestMapping("shoppingPlaces")
@Api(tags = { "购物场所" })
public class ShoppingPlaceController extends AbstractController<ShoppingPlaceDto> {

    @Autowired
    private ShoppingPlaceService shoppingPlaceWordService;

    @Autowired
    private ShoppingPlaceConverter shoppingPlaceWordConverter;

    @Override
    @PostMapping
    @ResponseStatus(CREATED)
    public ShoppingPlaceDto save(@RequestBody ShoppingPlaceDto data) {
        ShoppingPlace model = shoppingPlaceWordService.save(data);
        return shoppingPlaceWordConverter.toDto(model);
    }

    @GetMapping("{id}")
    public ShoppingPlaceDto get(@PathVariable("id") Long id) {
        Optional<ShoppingPlace> data = shoppingPlaceWordService.findById(id);
        return shoppingPlaceWordConverter.toDto(data);
    }

    @PutMapping("{id}")
    public ShoppingPlaceDto update(@PathVariable("id") Long id, @RequestBody ShoppingPlaceDto data) {
        ShoppingPlace model = shoppingPlaceWordService.update(id, data);
        return shoppingPlaceWordConverter.toDto(model);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(NO_CONTENT)
    public void delete(@PathVariable("id") Long id) {
        shoppingPlaceWordService.delete(id);
    }

    @Override
    @GetMapping(params = { "draw" })
    public TableResult<ShoppingPlaceDto> search(@RequestParam("draw") Long draw, @CurrentUser UserDetailsDto user,
            @ModelAttribute ShoppingPlaceDto condition, @PageableDefault Pageable pageable) {
        Page<ShoppingPlace> shoppingPlaceWord = shoppingPlaceWordService.find(condition, user == null ? null : user.getRegionCode(),
                pageable);
        return TableResult.success(draw, shoppingPlaceWord, data -> shoppingPlaceWordConverter.toDto(data));
    }

    @Override
    @GetMapping(params = { "api" })
    @ApiOperation(value = "可视化根据参数查询", notes = "getApiList")
    public Object getApiList(@CurrentUser UserDetailsDto user, @RequestParam("params") String jsonStr) {
        JSONObject jsonObject = ParamUtile.paresjson(jsonStr);
        List<ShoppingPlace> list = shoppingPlaceWordService.getByPatams(jsonObject, ShoppingPlace.class);
        return jsonObject.containsKey("pageNum")
                ? new PageInfo<ShoppingPlaceDto>(shoppingPlaceWordConverter.toDto(list),
                        jsonObject.getIntValue("pageNum"), jsonObject.getIntValue("pageSize"))
                : shoppingPlaceWordConverter.toDto(list);
    }

    @GetMapping(params = { "compare" })
    @ApiOperation(value = "今年比去年增长", notes = "getCompare")
    public Object getCompare(@CurrentUser UserDetailsDto user) {
        Long aDouble = shoppingPlaceWordService.getCompare(ShoppingPlace.class);
        return aDouble;
    }
}
