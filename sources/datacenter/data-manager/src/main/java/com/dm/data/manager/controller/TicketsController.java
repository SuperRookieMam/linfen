package com.dm.data.manager.controller;

import com.alibaba.fastjson.JSONObject;
import com.dm.common.dto.TableResult;
import com.dm.data.manager.converter.TicketsConverter;
import com.dm.data.manager.dto.TicketsDto;
import com.dm.data.manager.entity.Tickets;
import com.dm.data.manager.service.TicketsService;
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
@RequestMapping("ticketss")
@Api(tags = { "门票管理" })
public class TicketsController extends AbstractController<TicketsDto> {

    @Autowired
    private TicketsConverter ticketsConverter;

    @Autowired
    private TicketsService ticketsService;

    @Override
    @PostMapping
    @ResponseStatus(CREATED)
    public TicketsDto save(@RequestBody TicketsDto data) {
        Tickets model = ticketsService.save(data);
        return ticketsConverter.toDto(model);
    }

    @GetMapping("{id}")
    public TicketsDto get(@PathVariable("id") Long id) {
        Optional<Tickets> data = ticketsService.findById(id);
        return ticketsConverter.toDto(data);
    }

    @PutMapping("{id}")
    public TicketsDto update(@PathVariable("id") Long id, @RequestBody TicketsDto data) {
        Tickets model = ticketsService.update(id, data);
        return ticketsConverter.toDto(model);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(NO_CONTENT)
    public void delete(@PathVariable("id") Long id) {
        ticketsService.delete(id);
    }

    @Override
    @GetMapping(params = { "draw" })
    public TableResult<TicketsDto> search(@RequestParam("draw") Long draw, @CurrentUser UserDetailsDto user,
            @ModelAttribute TicketsDto condition, @PageableDefault Pageable pageable) {
        Page<Tickets> accommodation = ticketsService.find(condition, user == null ? null : user.getRegionCode(), pageable);
        return TableResult.success(draw, accommodation, ticketsConverter::toDto);
    }

    @Override
    @GetMapping(params = { "api" })
    @ApiOperation(value = "可视化根据参数查询", notes = "getApiList")
    public Object getApiList(@CurrentUser UserDetailsDto user, @RequestParam("params") String jsonStr) {
        JSONObject jsonObject = ParamUtile.paresjson(jsonStr);
        List<Tickets> list = ticketsService.getByPatams(jsonObject, Tickets.class);
        return jsonObject.containsKey("pageNum")
                ? new PageInfo<TicketsDto>(ticketsConverter.toDto(list), jsonObject.getIntValue("pageNum"),
                        jsonObject.getIntValue("pageSize"))
                : ticketsConverter.toDto(list);
    }
}
