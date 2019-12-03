package com.dm.data.app.controller;

import com.dm.common.dto.TableResult;
import com.dm.data.app.converter.TravelBusConverter;
import com.dm.data.app.dto.TravelBusDto;
import com.dm.data.app.dto.TravelBusDto;
import com.dm.data.app.entity.ElectronicTravel;
import com.dm.data.app.entity.TravelBus;
import com.dm.data.app.service.TravelBusService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;

@RestController
@RequestMapping("appTravelBus")
@Api(tags = {"旅游巴士"})
public class TravelBusController {
    @Autowired
    private TravelBusService travelBusService;
    @Autowired
    private TravelBusConverter travelBusConverter;

    @PostMapping
    @ResponseStatus(CREATED)
    public TravelBusDto save(@RequestBody TravelBusDto data) {
        TravelBus model = travelBusService.save(data);
        return travelBusConverter.toDto(model);
    }

    @GetMapping("{id}")
    public TravelBusDto get(@PathVariable("id") Long id) {
        return travelBusConverter.toDto(travelBusService.findById(id));
    }

    @PutMapping("{id}")
    public TravelBusDto update(@PathVariable("id") Long id, @RequestBody TravelBusDto data) {
        TravelBus model = travelBusService.update(id, data);
        return travelBusConverter.toDto(model);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(NO_CONTENT)
    public void delete(@PathVariable("id") Long id) {
        travelBusService.delete(id);
    }

    @GetMapping(params = { "draw" })
    public TableResult<TravelBusDto> search(@RequestParam("draw") Long draw,
                                                   @PageableDefault Pageable pageable,
                                                   String search) {
        Page<TravelBus> datas = travelBusService.search(pageable,search);
        return TableResult.success(draw, datas, travelBusConverter::toDto);
    }

    @GetMapping("findByTeamIdAndTime/{id}/{time}")
    public Map<String,Object> findByTeamId(@PathVariable("id") Long id,@PathVariable("time") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate time) {
        Map<String,Object> result=new HashMap<>();
        TravelBus travelBus =travelBusService.findByTeamIdAndTime(id,time);
        if(!Objects.isNull(travelBus)){
            result.put("flag",Boolean.TRUE);
            result.put("data",travelBus);
        }else{
            result.put("flag",Boolean.FALSE);
            result.put("data",null);
        }
        return  result;
    }


    @GetMapping("findByTeamId/{teamId}")
    public List<TravelBusDto> findByTeamId(@PathVariable("teamId") Long teamId) {
      List<TravelBus> travelBuses = travelBusService.findByTeamId(teamId);
      return travelBusConverter.toDto(travelBuses);
    }
}
