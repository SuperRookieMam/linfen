
package com.dm.data.manager.controller;

import com.alibaba.fastjson.JSONObject;
import com.dm.common.dto.TableResult;
import com.dm.data.manager.converter.TouristCommodityConverter;
import com.dm.data.manager.dto.TouristCommodityDto;
import com.dm.data.manager.entity.TouristCommodity;
import com.dm.data.manager.service.TouristCommodityService;
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
 * 旅游商品控制器
 *
 */
@RestController
@RequestMapping("touristCommoditys")
@Api(tags = { "旅游商品" })
public class TouristCommodityController extends AbstractController<TouristCommodityDto> {

    @Autowired
    private TouristCommodityService touristCommodityService;

    @Autowired
    private TouristCommodityConverter touristCommodityConverter;

    @Override
    @PostMapping
    @ResponseStatus(CREATED)
    public TouristCommodityDto save(@RequestBody TouristCommodityDto data) {
        TouristCommodity model = touristCommodityService.save(data);
        return touristCommodityConverter.toDto(model);
    }

    @GetMapping("{id}")
    public TouristCommodityDto get(@PathVariable("id") Long id) {
        Optional<TouristCommodity> data = touristCommodityService.findById(id);
        return touristCommodityConverter.toDto(data);
    }

    @PutMapping("{id}")
    public TouristCommodityDto update(@PathVariable("id") Long id, @RequestBody TouristCommodityDto data) {
        TouristCommodity model = touristCommodityService.update(id, data);
        return touristCommodityConverter.toDto(model);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(NO_CONTENT)
    public void delete(@PathVariable("id") Long id) {
        touristCommodityService.delete(id);
    }

    @Override
    @GetMapping(params = { "draw" })
    public TableResult<TouristCommodityDto> search(@RequestParam("draw") Long draw, @CurrentUser UserDetailsDto user,
            @ModelAttribute TouristCommodityDto condition, @PageableDefault Pageable pageable) {
        Page<TouristCommodity> touristCommodity = touristCommodityService.find(condition, pageable);
        return TableResult.success(draw, touristCommodity, data -> touristCommodityConverter.toDto(data));
    }

    @Override
    @GetMapping(params = { "api" })
    @ApiOperation(value = "可视化根据参数查询", notes = "getApiList")
    public Object getApiList(@CurrentUser UserDetailsDto user, @RequestParam("params") String jsonStr) {
        JSONObject jsonObject = ParamUtile.paresjson(jsonStr);
        List<TouristCommodity> list = touristCommodityService.getByPatams(jsonObject, TouristCommodity.class);
        return jsonObject.containsKey("pageNum")
                ? new PageInfo<TouristCommodityDto>(touristCommodityConverter.toDto(list),
                        jsonObject.getIntValue("pageNum"), jsonObject.getIntValue("pageSize"))
                : touristCommodityConverter.toDto(list);
    }
}
