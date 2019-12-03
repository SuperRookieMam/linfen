package com.dm.data.app.controller;

import com.dm.common.dto.TableResult;
import com.dm.data.app.converter.ElectronicTravelConverter;
import com.dm.data.app.dto.ElectronicTravelDto;
import com.dm.data.app.entity.ElectronicTravel;
import com.dm.data.app.service.ElectronicTravelService;
import com.dm.security.annotation.CurrentUser;
import com.dm.security.core.userdetails.UserDetailsDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;

@RestController
@RequestMapping("electronicTravels")
@Api(tags = {"电子行程"})
public class ElectronicTravelController {
    @Autowired
    private ElectronicTravelService electronicTravelService;
    @Autowired
    private ElectronicTravelConverter electronicTravelConverter;

    @PostMapping
    @ResponseStatus(CREATED)
    @ApiOperation("保存")
    public ElectronicTravelDto save(@RequestBody ElectronicTravelDto data) {
        ElectronicTravel model = electronicTravelService.save(data);
        return electronicTravelConverter.toDto(model);
    }

    @GetMapping("{id}")
    public ElectronicTravelDto get(@PathVariable("id") Long id) {
        return electronicTravelConverter.toDto(electronicTravelService.findById(id));
    }

    @GetMapping("findByTeamId/{id}")
    public Map<String,Object> findByTeamId(@PathVariable("id") Long id) {
        Map<String,Object> result=new HashMap<>();
        ElectronicTravel electronicTravel =electronicTravelService.findByTeamId(id);
        if(!Objects.isNull(electronicTravel)){
            result.put("flag",Boolean.TRUE);
            result.put("data",electronicTravel);
        }else{
            result.put("flag",Boolean.FALSE);
            result.put("data",null);
        }
        return  result;
    }

    @PutMapping("{id}")
    public ElectronicTravelDto update(@PathVariable("id") Long id, @RequestBody ElectronicTravelDto data) {
        ElectronicTravel model = electronicTravelService.update(id, data);
        return electronicTravelConverter.toDto(model);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(NO_CONTENT)
    public void delete(@PathVariable("id") Long id) {
        electronicTravelService.delete(id);
    }

    @GetMapping(params = { "draw" })
    public TableResult<ElectronicTravelDto> search(@RequestParam("draw") Long draw,
                                                @PageableDefault Pageable pageable,
                                                   String search) {
        Page<ElectronicTravel> datas = electronicTravelService.search(pageable,search);
        return TableResult.success(draw, datas, electronicTravelConverter::toDto);
    }
}
