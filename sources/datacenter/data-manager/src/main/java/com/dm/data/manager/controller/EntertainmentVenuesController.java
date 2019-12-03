
package com.dm.data.manager.controller;

import com.alibaba.fastjson.JSONObject;
import com.dm.common.dto.TableResult;
import com.dm.data.manager.converter.EntertainmentVenuesConverter;
import com.dm.data.manager.dto.EntertainmentVenuesDto;
import com.dm.data.manager.entity.EntertainmentVenues;
import com.dm.data.manager.service.EntertainmentVenuesService;
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

import static org.springframework.http.HttpStatus.NO_CONTENT;

/**
 * 娱乐场所控制器
 *
 */
@RestController
@RequestMapping("entertainmentVenuess")
@Api(tags = { "娱乐场所" })
public class EntertainmentVenuesController extends AbstractController<EntertainmentVenuesDto> {

    @Autowired
    private EntertainmentVenuesService entertainmentVenuesService;

    @Autowired
    private EntertainmentVenuesConverter entertainmentVenuesConverter;

    @Override
    @PostMapping
    public EntertainmentVenuesDto save(@RequestBody EntertainmentVenuesDto data) {
        EntertainmentVenues model = entertainmentVenuesService.save(data);
        return entertainmentVenuesConverter.toDto(model);
    }

    @GetMapping("{id}")
    public EntertainmentVenuesDto get(@PathVariable("id") Long id) {
        Optional<EntertainmentVenues> data = entertainmentVenuesService.findById(id);
        return entertainmentVenuesConverter.toDto(data);
    }

    @PutMapping("{id}")
    public EntertainmentVenuesDto update(@PathVariable("id") Long id, @RequestBody EntertainmentVenuesDto data) {
        EntertainmentVenues model = entertainmentVenuesService.update(id, data);
        return entertainmentVenuesConverter.toDto(model);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(NO_CONTENT)
    public void delete(@PathVariable("id") Long id) {
        entertainmentVenuesService.delete(id);
    }

    @Override
    @GetMapping(params = { "draw" })
    public TableResult<EntertainmentVenuesDto> search(@RequestParam("draw") Long draw, @CurrentUser UserDetailsDto user,
            @ModelAttribute EntertainmentVenuesDto condition, @PageableDefault Pageable pageable) {
        Page<EntertainmentVenues> entertainmentVenues = entertainmentVenuesService.find(condition, user == null ? null : user.getRegionCode(), pageable);
        return TableResult.success(draw, entertainmentVenues, data -> entertainmentVenuesConverter.toDto(data));
    }

    @Override
    @GetMapping(params = { "api" })
    @ApiOperation(value = "可视化根据参数查询", notes = "getApiList")
    public Object getApiList(@CurrentUser UserDetailsDto user, @RequestParam("params") String jsonStr) {
        JSONObject jsonObject = ParamUtile.paresjson(jsonStr);
        List<EntertainmentVenues> list = entertainmentVenuesService.getByPatams(jsonObject, EntertainmentVenues.class);
        return jsonObject.containsKey("pageNum")
                ? new PageInfo<EntertainmentVenuesDto>(entertainmentVenuesConverter.toDto(list),
                        jsonObject.getIntValue("pageNum"), jsonObject.getIntValue("pageSize"))
                : entertainmentVenuesConverter.toDto(list);
    }

    @GetMapping(params = { "compare" })
    @ApiOperation(value = "今年比去年增长", notes = "getCompare")
    public Object getCompare(@CurrentUser UserDetailsDto user) {
        Long aDouble = entertainmentVenuesService.getCompare(EntertainmentVenues.class);
        return aDouble;
    }
}
