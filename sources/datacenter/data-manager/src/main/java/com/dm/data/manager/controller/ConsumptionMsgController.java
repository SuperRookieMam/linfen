package com.dm.data.manager.controller;

import com.alibaba.fastjson.JSONObject;
import com.dm.common.dto.TableResult;
import com.dm.data.manager.converter.ConsumptionMsgConverter;
import com.dm.data.manager.dto.ConsumptionMsgDto;
import com.dm.data.manager.entity.ConsumptionMsg;
import com.dm.data.manager.service.ConsumptionMsgService;
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
@RequestMapping("consumptionMsgs")
@Api(tags = { "时时人数，消费信息" })
public class ConsumptionMsgController extends AbstractController<ConsumptionMsgDto> {

    @Autowired
    private ConsumptionMsgConverter consumptionMsgConverter;

    @Autowired
    private ConsumptionMsgService consumptionMsgService;

    @Override
    @PostMapping
    @ResponseStatus(CREATED)
    public ConsumptionMsgDto save(@RequestBody ConsumptionMsgDto data) {
        ConsumptionMsg model = consumptionMsgService.save(data);
        return consumptionMsgConverter.toDto(model);
    }

    @Override
    @GetMapping(params = { "api" })
    @ApiOperation(value = "可视化根据参数查询", notes = "getApiList")
    public Object getApiList(@CurrentUser UserDetailsDto user, @RequestParam("params") String jsonStr) {
        JSONObject jsonObject = ParamUtile.paresjson(jsonStr);
        List<ConsumptionMsg> list = consumptionMsgService.getByPatams(jsonObject, ConsumptionMsg.class);
        return jsonObject.containsKey("pageNum")
                ? new PageInfo<ConsumptionMsgDto>(consumptionMsgConverter.toDto(list),
                        jsonObject.getIntValue("pageNum"), jsonObject.getIntValue("pageSize"))
                : consumptionMsgConverter.toDto(list);
    }

    @GetMapping("{id}")
    public ConsumptionMsgDto get(@PathVariable("id") Long id) {
        Optional<ConsumptionMsg> data = consumptionMsgService.findById(id);
        return consumptionMsgConverter.toDto(data);
    }

    @PutMapping("{id}")
    public ConsumptionMsgDto update(@PathVariable("id") Long id, @RequestBody ConsumptionMsgDto data) {
        ConsumptionMsg model = consumptionMsgService.update(id, data);
        return consumptionMsgConverter.toDto(model);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(NO_CONTENT)
    public void delete(@PathVariable("id") Long id) {
        consumptionMsgService.delete(id);
    }

    @Override
    @GetMapping(params = { "draw" })
    public TableResult<ConsumptionMsgDto> search(@RequestParam("draw") Long draw, @CurrentUser UserDetailsDto user,
            @ModelAttribute ConsumptionMsgDto condition, @PageableDefault Pageable pageable) {
        Page<ConsumptionMsg> accommodation = consumptionMsgService.find(condition, user == null ? null : user.getRegionCode(), pageable);
        return TableResult.success(draw, accommodation, consumptionMsgConverter::toDto);
    }
}
