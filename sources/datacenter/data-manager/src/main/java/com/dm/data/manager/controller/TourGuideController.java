
package com.dm.data.manager.controller;

import com.alibaba.fastjson.JSONObject;
import com.dm.common.dto.TableResult;
import com.dm.data.manager.converter.TourGuideConverter;
import com.dm.data.manager.dto.TourGuideDto;
import com.dm.data.manager.entity.TourGuide;
import com.dm.data.manager.service.TourGuideService;
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

/**
 * 导游控制器
 *
 */
@RestController
@RequestMapping("tourGuides")
@Api(tags = { "景区导游" })
public class TourGuideController extends AbstractController<TourGuideDto> {

    @Autowired
    private TourGuideService tourGuideService;

    @Autowired
    private TourGuideConverter tourGuideConverter;

    @Override
    @PostMapping
    @ResponseStatus(CREATED)
    public TourGuideDto save(@RequestBody TourGuideDto data) {
        TourGuide model = tourGuideService.save(data);
        return tourGuideConverter.toDto(model);
    }

    @GetMapping("{id}")
    public TourGuideDto get(@PathVariable("id") Long id) {
        Optional<TourGuide> data = tourGuideService.findById(id);
        return tourGuideConverter.toDto(data);
    }

    @PutMapping("{id}")
    public TourGuideDto update(@PathVariable("id") Long id, @RequestBody TourGuideDto data) {
        TourGuide model = tourGuideService.update(id, data);
        return tourGuideConverter.toDto(model);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(NO_CONTENT)
    public void delete(@PathVariable("id") Long id) {
        tourGuideService.delete(id);
    }

    @Override
    @GetMapping(params = { "draw" })
    public TableResult<TourGuideDto> search(@RequestParam("draw") Long draw, @CurrentUser UserDetailsDto user,
            @ModelAttribute TourGuideDto condition, @PageableDefault Pageable pageable) {
        Page<TourGuide> tourGuide = tourGuideService.find(condition, user == null ? null : user.getRegionCode(), pageable);
        return TableResult.success(draw, tourGuide, data -> tourGuideConverter.toDto(data));
    }

    @Override
    @GetMapping(params = { "api" })
    @ApiOperation(value = "可视化根据参数查询", notes = "getApiList")
    public Object getApiList(@CurrentUser UserDetailsDto user, @RequestParam("params") String jsonStr) {
        JSONObject jsonObject = ParamUtile.paresjson(jsonStr);
        List<TourGuide> list = tourGuideService.getByPatams(jsonObject, TourGuide.class);
        return jsonObject.containsKey("pageNum")
                ? new PageInfo<TourGuideDto>(tourGuideConverter.toDto(list), jsonObject.getIntValue("pageNum"),
                        jsonObject.getIntValue("pageSize"))
                : tourGuideConverter.toDto(list);
    }
}
