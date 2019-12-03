package com.dm.data.manager.controller.app;

import com.dm.data.manager.converter.*;
import com.dm.data.manager.service.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("searchs")
@Api(tags = { "app搜索页面" })
public class SearchController {
    @Autowired
    private TouristAttractionsService touristAttractionsService;
    @Autowired
    private TouristAttractionsConverter touristAttractionsConverter;
    @Autowired
    private AccommodationService accommodationService;
    @Autowired
    private AccommodationConverter accommodationConverter;
    @Autowired
    private TeamReportService teamReportService;
    @Autowired
    private TeamReportConverter teamReportConverter;
    @Autowired
    private TouristRouteService touristRouteService;
    @Autowired
    private TouristRouteConverter touristRouteConverter;
    @Autowired
    private RuralTourismService ruralTourismService;
    @Autowired
    private RuralTourismConverter ruralTourismConverter;
    @Autowired
    private DiningPlaceService diningPlaceService;
    @Autowired
    private DiningPlaceConverter diningPlaceConverter;

    @GetMapping("findByName/{search}")
    @ApiOperation("搜索")
    public Map<String, Object> findByName(@PathVariable("search") String search) {
        Map<String, Object> result = new HashMap<>();
        // 景区
        result.put("scenic", touristAttractionsConverter.toDto(touristAttractionsService.findBySearch(search)));
        // 酒店
        result.put("hotel", accommodationConverter.toDto(accommodationService.findBySearch(search)));
        // 团队
        result.put("team", teamReportConverter.toDto(teamReportService.findBySearch(search)));
        // 线路
        result.put("route", touristRouteConverter.toDto(touristRouteService.findBySearch(search)));
        // 乡村旅游
        result.put("ruralTourism", ruralTourismConverter.toDto(ruralTourismService.findBySearch(search)));
        // 餐饮
        result.put("diningPlace", diningPlaceConverter.toDto(diningPlaceService.findBySearch(search)));
        return result;
    }
}
