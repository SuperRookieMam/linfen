
package com.dm.data.manager.controller;

import com.alibaba.fastjson.JSONObject;
import com.dm.common.dto.TableResult;
import com.dm.data.manager.converter.TouristAttractionsConverter;
import com.dm.data.manager.dto.TouristAttractionsDto;
import com.dm.data.manager.entity.TouristAttractions;
import com.dm.data.manager.service.TouristAttractionsService;
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
 * 旅游景区控制器
 *
 */
@RestController
@RequestMapping("touristAttractions")
@Api(tags = { "旅游景区" })
public class TouristAttractionsController extends AbstractController<TouristAttractionsDto> {

    @Autowired
    private TouristAttractionsService touristAttractionsService;

    @Autowired
    private TouristAttractionsConverter touristAttractionsConverter;

    @Override
    @PostMapping
    @ResponseStatus(CREATED)
    public TouristAttractionsDto save(@RequestBody TouristAttractionsDto data) {
        TouristAttractions model = touristAttractionsService.save(data);
        return touristAttractionsConverter.toDto(model);
    }

    @GetMapping("{id}")
    public TouristAttractionsDto get(@PathVariable("id") Long id) {
        Optional<TouristAttractions> data = touristAttractionsService.findById(id);
        return touristAttractionsConverter.toDto(data);
    }

    @PutMapping("{id}")
    public TouristAttractionsDto update(@PathVariable("id") Long id, @RequestBody TouristAttractionsDto data) {
        TouristAttractions model = touristAttractionsService.update(id, data);
        return touristAttractionsConverter.toDto(model);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(NO_CONTENT)
    public void delete(@PathVariable("id") Long id) {
        touristAttractionsService.delete(id);
    }

    @Override
    @GetMapping(params = { "draw" })
    public TableResult<TouristAttractionsDto> search(@RequestParam("draw") Long draw, @CurrentUser UserDetailsDto user,
            @ModelAttribute TouristAttractionsDto condition, @PageableDefault Pageable pageable) {
        Page<TouristAttractions> touristAttractions = touristAttractionsService.find(condition, user == null ? null : user.getRegionCode(),
                pageable);
        return TableResult.success(draw, touristAttractions, touristAttractionsConverter::toDto);
    }

    @Override
    @GetMapping(params = { "api" })
    @ApiOperation(value = "可视化根据参数查询", notes = "getApiList")
    public Object getApiList(@CurrentUser UserDetailsDto user, @RequestParam("params") String jsonStr) {
        JSONObject jsonObject = ParamUtile.paresjson(jsonStr);
        List<TouristAttractions> list = touristAttractionsService.getByPatams(jsonObject, TouristAttractions.class);
        return jsonObject.containsKey("pageNum")
                ? new PageInfo<TouristAttractionsDto>(touristAttractionsConverter.toDto(list),
                        jsonObject.getIntValue("pageNum"), jsonObject.getIntValue("pageSize"))
                : touristAttractionsConverter.toDto(list);
    }

    @GetMapping(params = { "compare" })
    @ApiOperation(value = "今年比去年增长", notes = "getCompare")
    public Object getCompare(@CurrentUser UserDetailsDto user) {
        Long aDouble = touristAttractionsService.getCompare(TouristAttractions.class);
        return aDouble;
    }
}
