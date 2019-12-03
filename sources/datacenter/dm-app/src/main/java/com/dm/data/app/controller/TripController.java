package com.dm.data.app.controller;

import com.dm.data.app.converter.TripConverter;
import com.dm.data.app.dto.TripDto;
import com.dm.data.app.entity.TravelBus;
import com.dm.data.app.entity.Trip;
import com.dm.data.app.service.TripService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("trips")
@Api(tags = {"行程"})
public class TripController {
    @Autowired
    private TripService tripService;
    @Autowired
    private TripConverter tripConverter;
    @PostMapping
    @ResponseStatus(CREATED)
    public TripDto save(@RequestBody TripDto data) {
        Trip model = tripService.save(data);
        return tripConverter.toDto(model);
    }

    @GetMapping("{id}")
    public TripDto get(@PathVariable("id") Long id) {
        return tripConverter.toDto(tripService.findById(id));
    }

    @PutMapping("{id}")
    public TripDto update(@PathVariable("id") Long id, @RequestBody TripDto data) {
        Trip model = tripService.update(id, data);
        return tripConverter.toDto(model);
    }

    @DeleteMapping("{id}")
    public void deleteByid(@PathVariable("id") Long id) {
        tripService.delete(id);
    }
}
