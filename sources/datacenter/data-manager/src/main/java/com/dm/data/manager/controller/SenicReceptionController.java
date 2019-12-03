package com.dm.data.manager.controller;

import com.alibaba.fastjson.JSONObject;
import com.dm.common.dto.TableResult;
import com.dm.data.manager.converter.SenicReceptionConverter;
import com.dm.data.manager.dto.SenicReceptionDto;
import com.dm.data.manager.entity.SenicReception;
import com.dm.data.manager.service.SenicReceptionService;
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
@RequestMapping("senicReceptions")
@Api(tags = { "景区接待收入" })
public class SenicReceptionController extends AbstractController<SenicReceptionDto> {

    @Autowired
    private SenicReceptionConverter senicReceptionConverter;

    @Autowired
    private SenicReceptionService senicReceptionService;

    @Override
    @PostMapping
    @ResponseStatus(CREATED)
    public SenicReceptionDto save(@RequestBody SenicReceptionDto data) {
        SenicReception model = senicReceptionService.save(data);
        return senicReceptionConverter.toDto(model);
    }

    @GetMapping("{id}")
    public SenicReceptionDto get(@PathVariable("id") Long id) {
        Optional<SenicReception> data = senicReceptionService.findById(id);
        return senicReceptionConverter.toDto(data);
    }

    @PutMapping("{id}")
    public SenicReceptionDto update(@PathVariable("id") Long id, @RequestBody SenicReceptionDto data) {
        SenicReception model = senicReceptionService.update(id, data);
        return senicReceptionConverter.toDto(model);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(NO_CONTENT)
    public void delete(@PathVariable("id") Long id) {
        senicReceptionService.delete(id);
    }

    @Override
    @GetMapping(params = { "draw" })
    public TableResult<SenicReceptionDto> search(@RequestParam("draw") Long draw, @CurrentUser UserDetailsDto user,
            @ModelAttribute SenicReceptionDto condition, @PageableDefault Pageable pageable) {
        Page<SenicReception> accommodation = senicReceptionService.find(condition, user == null ? null : user.getRegionCode(), pageable);
        return TableResult.success(draw, accommodation, senicReceptionConverter::toDto);
    }

    @Override
    @GetMapping(params = { "api" })
    @ApiOperation(value = "可视化根据参数查询", notes = "getApiList")
    public Object getApiList(@CurrentUser UserDetailsDto user, @RequestParam("params") String jsonStr) {
        JSONObject jsonObject = ParamUtile.paresjson(jsonStr);
        List<SenicReception> list = senicReceptionService.getByPatams(jsonObject, SenicReception.class);
        return jsonObject.containsKey("pageNum")
                ? new PageInfo<SenicReceptionDto>(senicReceptionConverter.toDto(list),
                        jsonObject.getIntValue("pageNum"), jsonObject.getIntValue("pageSize"))
                : senicReceptionConverter.toDto(list);
    }
}
