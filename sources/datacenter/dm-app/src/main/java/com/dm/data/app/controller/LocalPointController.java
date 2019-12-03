package com.dm.data.app.controller;

import com.dm.data.app.converter.LocalPointConverter;
import com.dm.data.app.dto.LocalPointDto;
import com.dm.data.app.entity.LocalPoint;
import com.dm.data.app.service.LocalPointService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("localPoints")
@Api(tags = {"车的坐标"})
public class LocalPointController {
    @Autowired
    private LocalPointService localPointService;
    @Autowired
    private LocalPointConverter localPointConverter;

    @PostMapping
    @ResponseStatus(CREATED)
    public LocalPointDto save(@RequestBody LocalPointDto data) {
        LocalPoint model = localPointService.save(data);
        return localPointConverter.toDto(model);
    }

    @GetMapping("{id}")
    public LocalPointDto get(@PathVariable("id") Long id) {
        return localPointConverter.toDto(localPointService.findById(id));
    }

    @PutMapping("{id}")
    public LocalPointDto update(@PathVariable("id") Long id, @RequestBody LocalPointDto data) {
        LocalPoint model = localPointService.update(id, data);
        return localPointConverter.toDto(model);
    }

    @DeleteMapping("{id}")
    public void deleteByid(@PathVariable("id") Long id) {
        localPointService.delete(id);
    }
}
