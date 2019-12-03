package com.dm.data.manager.controller;

import com.dm.common.dto.TableResult;
import com.dm.data.manager.converter.CulturalRelicRentConverter;
import com.dm.data.manager.dto.CulturalRelicRentDto;
import com.dm.data.manager.service.CulturalRelicRentService;
import com.dm.security.core.userdetails.UserDetailsDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import static org.springframework.http.HttpStatus.CREATED;

/**
 * 文物租赁接口
 *
 * @author yinjie
 * @date 2019年8月2日14:27:47
 */
@RestController
@RequestMapping("culturalRelicRents")
@Api(tags = { "文物租赁接口" })
public class CulturalRelicRentController {
    @Autowired
    private CulturalRelicRentConverter culturalRelicRentConverter;
    @Autowired
    private CulturalRelicRentService culturalRelicRentService;

    @GetMapping
    @ApiOperation("通过条件查询")
    public TableResult<CulturalRelicRentDto> find(Long draw, @ApiIgnore UserDetailsDto user, String search,
            Pageable pageable, String status) {
        return TableResult.success(draw, culturalRelicRentService.find(pageable, search, status),
                culturalRelicRentConverter::toDto);
    }

    @PostMapping
    @ResponseStatus(CREATED)
    @ApiOperation("保存")
    public CulturalRelicRentDto save(@RequestBody CulturalRelicRentDto dto) {
        return culturalRelicRentConverter.toDto(culturalRelicRentService.save(dto));
    }

    @DeleteMapping("{id}")
    @ApiOperation("删除")
    public void delete(@PathVariable("id") Long id) {
        culturalRelicRentService.delete(id);
    }

    @GetMapping("{id}")
    @ApiOperation("通过id查询")
    public CulturalRelicRentDto findById(@PathVariable("id") Long id) {
        return culturalRelicRentConverter.toDto(culturalRelicRentService.findById(id));
    }

    @PutMapping("{id}")
    @ApiOperation("x")
    public CulturalRelicRentDto update(@PathVariable("id") Long id, @RequestBody CulturalRelicRentDto dto) {
        return culturalRelicRentConverter.toDto(culturalRelicRentService.update(id, dto));
    }

    @GetMapping("findCountByRentStatus/{status}")
    public Integer findCountByRentStatus(@PathVariable("status") Boolean status) {
        return culturalRelicRentService.findCountByRentStatus(status);
    }

}
