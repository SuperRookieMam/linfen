
package com.dm.data.manager.controller;

import com.alibaba.fastjson.JSONObject;
import com.dm.common.dto.TableResult;
import com.dm.data.manager.converter.RuralTourismConverter;
import com.dm.data.manager.dto.RuralTourismDto;
import com.dm.data.manager.entity.RuralTourism;
import com.dm.data.manager.service.RuralTourismService;
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
 * 乡村旅游控制器
 *
 */
@RestController
@RequestMapping("ruralTourisms")
@Api(tags = { "乡村旅游" })
public class RuralTourismController extends AbstractController<RuralTourismDto> {

    @Autowired
    private RuralTourismService ruralTourismService;

    @Autowired
    private RuralTourismConverter ruralTourismConverter;

    @Override
    @PostMapping
    @ResponseStatus(CREATED)
    public RuralTourismDto save(@RequestBody RuralTourismDto data) {
        RuralTourism model = ruralTourismService.save(data);
        return ruralTourismConverter.toDto(model);
    }

    @GetMapping("{id}")
    public RuralTourismDto get(@PathVariable("id") Long id) {
        Optional<RuralTourism> data = ruralTourismService.findById(id);
        return ruralTourismConverter.toDto(data);
    }

    @PutMapping("{id}")
    public RuralTourismDto update(@PathVariable("id") Long id, @RequestBody RuralTourismDto data) {
        RuralTourism model = ruralTourismService.update(id, data);
        return ruralTourismConverter.toDto(model);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(NO_CONTENT)
    public void delete(@PathVariable("id") Long id) {
        ruralTourismService.delete(id);
    }

    @Override
    @GetMapping(params = { "draw" })
    public TableResult<RuralTourismDto> search(@RequestParam("draw") Long draw, @CurrentUser UserDetailsDto user,
            @ModelAttribute RuralTourismDto condition, @PageableDefault Pageable pageable) {
        Page<RuralTourism> ruralTourism = ruralTourismService.find(condition, user == null ? null : user.getRegionCode(), pageable);
        return TableResult.success(draw, ruralTourism, data -> ruralTourismConverter.toDto(data));
    }

    @Override
    @GetMapping(params = { "api" })
    @ApiOperation(value = "可视化根据参数查询", notes = "getApiList")
    public Object getApiList(@CurrentUser UserDetailsDto user, @RequestParam("params") String jsonStr) {
        JSONObject jsonObject = ParamUtile.paresjson(jsonStr);
        List<RuralTourism> list = ruralTourismService.getByPatams(jsonObject, RuralTourism.class);
        return jsonObject.containsKey("pageNum")
                ? new PageInfo<RuralTourismDto>(ruralTourismConverter.toDto(list), jsonObject.getIntValue("pageNum"),
                        jsonObject.getIntValue("pageSize"))
                : ruralTourismConverter.toDto(list);
    }
}
