package com.dm.data.manager.controller;

import com.alibaba.fastjson.JSONObject;
import com.dm.common.dto.TableResult;
import com.dm.data.manager.converter.EnteringPoliceConverter;
import com.dm.data.manager.dto.EnteringPoliceDto;
import com.dm.data.manager.entity.EnteringPolice;
import com.dm.data.manager.service.EnteringPoliceService;
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
@RequestMapping("enteringPolices")
@Api(tags = { "景区时时人数,公安" })
public class EnteringPoliceController extends AbstractController<EnteringPoliceDto> {

    @Autowired
    private EnteringPoliceConverter enteringPoliceConverter;

    @Autowired
    private EnteringPoliceService enteringPoliceService;

    @Override
    @PostMapping
    @ResponseStatus(CREATED)
    public EnteringPoliceDto save(@RequestBody EnteringPoliceDto data) {
        EnteringPolice model = enteringPoliceService.save(data);
        return enteringPoliceConverter.toDto(model);
    }

    @GetMapping("{id}")
    public EnteringPoliceDto get(@PathVariable("id") Long id) {
        Optional<EnteringPolice> data = enteringPoliceService.findById(id);
        return enteringPoliceConverter.toDto(data);
    }

    @PutMapping("{id}")
    public EnteringPoliceDto update(@PathVariable("id") Long id, @RequestBody EnteringPoliceDto data) {
        EnteringPolice model = enteringPoliceService.update(id, data);
        return enteringPoliceConverter.toDto(model);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(NO_CONTENT)
    public void delete(@PathVariable("id") Long id) {
        enteringPoliceService.delete(id);
    }

    @Override
    @GetMapping(params = { "draw" })
    public TableResult<EnteringPoliceDto> search(@RequestParam("draw") Long draw, @CurrentUser UserDetailsDto user,
            @ModelAttribute EnteringPoliceDto condition, @PageableDefault Pageable pageable) {
        Page<EnteringPolice> accommodation = enteringPoliceService.find(condition, user == null ? null : user.getRegionCode(), pageable);
        return TableResult.success(draw, accommodation, enteringPoliceConverter::toDto);
    }

    @Override
    @GetMapping(params = { "api" })
    @ApiOperation(value = "可视化根据参数查询", notes = "getApiList")
    public Object getApiList(@CurrentUser UserDetailsDto user, @RequestParam("params") String jsonStr) {
        JSONObject jsonObject = ParamUtile.paresjson(jsonStr);
        List<EnteringPolice> list = enteringPoliceService.getByPatams(jsonObject, EnteringPolice.class);
        return jsonObject.containsKey("pageNum")
                ? new PageInfo<EnteringPoliceDto>(enteringPoliceConverter.toDto(list),
                        jsonObject.getIntValue("pageNum"), jsonObject.getIntValue("pageSize"))
                : enteringPoliceConverter.toDto(list);
    }
}
