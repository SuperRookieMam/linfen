
package com.dm.data.manager.controller;

import com.alibaba.fastjson.JSONObject;
import com.dm.common.dto.TableResult;
import com.dm.data.manager.converter.TouristToiletConverter;
import com.dm.data.manager.dto.TouristToiletDto;
import com.dm.data.manager.entity.TouristToilet;
import com.dm.data.manager.service.TouristToiletService;
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
 * 旅游厕所控制器
 *
 */
@RestController
@RequestMapping("touristToilets")
@Api(tags = { "旅游厕所" })
public class TouristToiletController extends AbstractController<TouristToiletDto> {

    @Autowired
    private TouristToiletService touristToiletService;

    @Autowired
    private TouristToiletConverter touristToiletConverter;

    @Override
    @PostMapping
    @ResponseStatus(CREATED)
    public TouristToiletDto save(@RequestBody TouristToiletDto data) {
        TouristToilet model = touristToiletService.save(data);
        return touristToiletConverter.toDto(model);
    }

    @GetMapping("{id}")
    public TouristToiletDto get(@PathVariable("id") Long id) {
        Optional<TouristToilet> data = touristToiletService.findById(id);
        return touristToiletConverter.toDto(data);
    }

    @PutMapping("{id}")
    public TouristToiletDto update(@PathVariable("id") Long id, @RequestBody TouristToiletDto data) {
        TouristToilet model = touristToiletService.update(id, data);
        return touristToiletConverter.toDto(model);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(NO_CONTENT)
    public void delete(@PathVariable("id") Long id) {
        touristToiletService.delete(id);
    }

    @Override
    @GetMapping(params = { "draw" })
    public TableResult<TouristToiletDto> search(@RequestParam("draw") Long draw, @CurrentUser UserDetailsDto user,
            @ModelAttribute TouristToiletDto condition, @PageableDefault Pageable pageable) {
        Page<TouristToilet> touristToilet = touristToiletService.find(condition, user == null ? null : user.getRegionCode(), pageable);
        return TableResult.success(draw, touristToilet, data -> touristToiletConverter.toDto(data));
    }

    @Override
    @GetMapping(params = { "api" })
    @ApiOperation(value = "可视化根据参数查询", notes = "getApiList")
    public Object getApiList(@CurrentUser UserDetailsDto user, @RequestParam("params") String jsonStr) {
        JSONObject jsonObject = ParamUtile.paresjson(jsonStr);
        List<TouristToilet> list = touristToiletService.getByPatams(jsonObject, TouristToilet.class);
        return jsonObject.containsKey("pageNum")
                ? new PageInfo<TouristToiletDto>(touristToiletConverter.toDto(list), jsonObject.getIntValue("pageNum"),
                        jsonObject.getIntValue("pageSize"))
                : touristToiletConverter.toDto(list);
    }

    @GetMapping(params = { "compare" })
    @ApiOperation(value = "今年比去年增长", notes = "getCompare")
    public Object getCompare(@CurrentUser UserDetailsDto user) {
        Long aDouble = touristToiletService.getCompare(TouristToilet.class);
        return aDouble;
    }
}
