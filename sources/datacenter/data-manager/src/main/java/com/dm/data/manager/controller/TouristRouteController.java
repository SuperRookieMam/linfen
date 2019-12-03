
package com.dm.data.manager.controller;

import com.alibaba.fastjson.JSONObject;
import com.dm.common.dto.TableResult;
import com.dm.data.manager.converter.TouristRouteConverter;
import com.dm.data.manager.dto.TouristRouteDto;
import com.dm.data.manager.entity.TouristRoute;
import com.dm.data.manager.service.TouristRouteService;
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
 * 旅游线路控制器
 *
 */
@RestController
@RequestMapping("touristRoutes")
@Api(tags = { "旅游路线" })
public class TouristRouteController extends AbstractController<TouristRouteDto> {

    @Autowired
    private TouristRouteService touristRouteService;

    @Autowired
    private TouristRouteConverter touristRouteConverter;

    @Override
    @PostMapping
    @ResponseStatus(CREATED)
    public TouristRouteDto save(@RequestBody TouristRouteDto data) {
        TouristRoute model = touristRouteService.save(data);
        return touristRouteConverter.toDto(model);
    }

    @GetMapping("{id}")
    public TouristRouteDto get(@PathVariable("id") Long id) {
        Optional<TouristRoute> data = touristRouteService.findById(id);
        return touristRouteConverter.toDto(data);
    }

    @PutMapping("{id}")
    public TouristRouteDto update(@PathVariable("id") Long id, @RequestBody TouristRouteDto data) {
        TouristRoute model = touristRouteService.update(id, data);
        return touristRouteConverter.toDto(model);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(NO_CONTENT)
    public void delete(@PathVariable("id") Long id) {
        touristRouteService.delete(id);
    }

    @Override
    @GetMapping(params = { "draw" })
    public TableResult<TouristRouteDto> search(@RequestParam("draw") Long draw, @CurrentUser UserDetailsDto user,
            @ModelAttribute TouristRouteDto condition, @PageableDefault Pageable pageable) {
        Page<TouristRoute> touristRoute = touristRouteService.find(condition, pageable);
        return TableResult.success(draw, touristRoute, data -> touristRouteConverter.toDto(data));
    }

    @Override
    @GetMapping(params = { "api" })
    @ApiOperation(value = "可视化根据参数查询", notes = "getApiList")
    public Object getApiList(@CurrentUser UserDetailsDto user, @RequestParam("params") String jsonStr) {
        JSONObject jsonObject = ParamUtile.paresjson(jsonStr);
        List<TouristRoute> list = touristRouteService.getByPatams(jsonObject, TouristRoute.class);
        return jsonObject.containsKey("pageNum")
                ? new PageInfo<TouristRouteDto>(touristRouteConverter.toDto(list), jsonObject.getIntValue("pageNum"),
                        jsonObject.getIntValue("pageSize"))
                : touristRouteConverter.toDto(list);
    }

    @GetMapping("randThree")
    @ApiOperation(value = "随机三个", notes = "随机三个")
    public List<TouristRouteDto> randThree() {
        List<TouristRoute> touristRoutes = touristRouteService.randomThree();
        return touristRouteConverter.toDto(touristRoutes);
    }
}
