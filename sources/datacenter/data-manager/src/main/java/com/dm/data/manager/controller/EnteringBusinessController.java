package com.dm.data.manager.controller;

import com.alibaba.fastjson.JSONObject;
import com.dm.common.dto.TableResult;
import com.dm.data.manager.converter.EnteringBusinessConverter;
import com.dm.data.manager.dto.EnteringBusinessDto;
import com.dm.data.manager.entity.EnteringBusiness;
import com.dm.data.manager.service.EnteringBusinessService;
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

@RestController
@RequestMapping("enteringBusinesss")
@Api(tags = { "景区时时人数,商业接口" })
public class EnteringBusinessController extends AbstractController<EnteringBusinessDto> {

    @Autowired
    private EnteringBusinessConverter enteringBusinessConverter;

    @Autowired
    private EnteringBusinessService enteringBusinessService;

    @Override
    @PostMapping
    @ResponseStatus(CREATED)
    public EnteringBusinessDto save(@RequestBody EnteringBusinessDto data) {
        EnteringBusiness model = enteringBusinessService.save(data);
        return enteringBusinessConverter.toDto(model);
    }

    @GetMapping("{id}")
    public EnteringBusinessDto get(@PathVariable("id") Long id) {
        Optional<EnteringBusiness> data = enteringBusinessService.findById(id);
        return enteringBusinessConverter.toDto(data);
    }

    @PutMapping("{id}")
    public EnteringBusinessDto update(@PathVariable("id") Long id, @RequestBody EnteringBusinessDto data) {
        EnteringBusiness model = enteringBusinessService.update(id, data);
        return enteringBusinessConverter.toDto(model);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(NO_CONTENT)
    public void delete(@PathVariable("id") Long id) {
        enteringBusinessService.delete(id);
    }

    @Override
    @GetMapping(params = { "draw" })
    public TableResult<EnteringBusinessDto> search(@RequestParam("draw") Long draw, @CurrentUser UserDetailsDto user,
            @ModelAttribute EnteringBusinessDto condition, @PageableDefault Pageable pageable) {
        Page<EnteringBusiness> accommodation = enteringBusinessService.find(condition, user == null ? null : user.getRegionCode(), pageable);
        return TableResult.success(draw, accommodation, enteringBusinessConverter::toDto);
    }

    @Override
    @GetMapping(params = { "api" })
    @ApiOperation(value = "可视化根据参数查询", notes = "getApiList")
    public Object getApiList(@CurrentUser UserDetailsDto user, @RequestParam("params") String jsonStr) {
        JSONObject jsonObject = ParamUtile.paresjson(jsonStr);
        List<EnteringBusiness> list = enteringBusinessService.getByPatams(jsonObject, EnteringBusiness.class);
        return jsonObject.containsKey("pageNum")
                ? new PageInfo<EnteringBusinessDto>(enteringBusinessConverter.toDto(list),
                        jsonObject.getIntValue("pageNum"), jsonObject.getIntValue("pageSize"))
                : enteringBusinessConverter.toDto(list);
    }
}
