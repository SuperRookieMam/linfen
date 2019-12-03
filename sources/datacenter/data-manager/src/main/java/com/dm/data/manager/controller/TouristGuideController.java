
package com.dm.data.manager.controller;

import com.alibaba.fastjson.JSONObject;
import com.dm.common.dto.TableResult;
import com.dm.data.manager.converter.TouristGuideConverter;
import com.dm.data.manager.dto.TouristGuideDto;
import com.dm.data.manager.entity.TouristGuide;
import com.dm.data.manager.service.TouristGuideService;
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
 * 景区讲解员控制器
 *
 */
@RestController
@RequestMapping("touristGuides")
@Api(tags = { "景区解说员" })
public class TouristGuideController extends AbstractController<TouristGuideDto> {

    @Autowired
    private TouristGuideService touristGuideService;

    @Autowired
    private TouristGuideConverter touristGuideConverter;

    @Override
    @PostMapping
    @ResponseStatus(CREATED)
    public TouristGuideDto save(@RequestBody TouristGuideDto data) {
        System.out.println("111111");
        TouristGuide model = touristGuideService.save(data);
        return touristGuideConverter.toDto(model);
    }

    @GetMapping("{id}")
    public TouristGuideDto get(@PathVariable("id") Long id) {
        Optional<TouristGuide> data = touristGuideService.findById(id);
        return touristGuideConverter.toDto(data);
    }

    @PutMapping("{id}")
    public TouristGuideDto update(@PathVariable("id") Long id, @RequestBody TouristGuideDto data) {
        TouristGuide model = touristGuideService.update(id, data);
        return touristGuideConverter.toDto(model);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(NO_CONTENT)
    public void delete(@PathVariable("id") Long id) {
        touristGuideService.delete(id);
    }

    @Override
    @GetMapping(params = { "draw" })
    public TableResult<TouristGuideDto> search(@RequestParam("draw") Long draw, @CurrentUser UserDetailsDto user,
            @ModelAttribute TouristGuideDto condition, @PageableDefault Pageable pageable) {
        Page<TouristGuide> touristGuide = touristGuideService.find(condition, user == null ? null : user.getRegionCode(), pageable);
        return TableResult.success(draw, touristGuide, data -> touristGuideConverter.toDto(data));
    }

    @Override
    @GetMapping(params = { "api" })
    @ApiOperation(value = "可视化根据参数查询", notes = "getApiList")
    public Object getApiList(@CurrentUser UserDetailsDto user, @RequestParam("params") String jsonStr) {
        JSONObject jsonObject = ParamUtile.paresjson(jsonStr);
        List<TouristGuide> list = touristGuideService.getByPatams(jsonObject, TouristGuide.class);
        return jsonObject.containsKey("pageNum")
                ? new PageInfo<TouristGuideDto>(touristGuideConverter.toDto(list), jsonObject.getIntValue("pageNum"),
                        jsonObject.getIntValue("pageSize"))
                : touristGuideConverter.toDto(list);
    }
}
