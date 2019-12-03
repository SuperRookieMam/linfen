package com.dm.data.manager.controller;

import com.alibaba.fastjson.JSONObject;
import com.dm.common.dto.TableResult;
import com.dm.data.manager.converter.TouristConsultConverter;
import com.dm.data.manager.dto.TouristConsultDto;
import com.dm.data.manager.entity.LikeNumber;
import com.dm.data.manager.entity.TouristConsult;
import com.dm.data.manager.service.LikeNumberService;
import com.dm.data.manager.service.ReadNumberService;
import com.dm.data.manager.service.TouristConsultService;
import com.dm.data.manager.utile.PageInfo;
import com.dm.data.manager.utile.ParamUtile;
import com.dm.security.annotation.CurrentUser;
import com.dm.security.core.userdetails.UserDetailsDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;

@RestController
@RequestMapping("touristConsults")
@Api(tags = { "旅游咨询" })
public class TouristConsultController extends AbstractController<TouristConsultDto> {
    @Autowired
    private LikeNumberService likeNumberService;

    @Autowired
    private TouristConsultConverter touristConsultConverter;

    @Autowired
    private TouristConsultService touristConsultService;
    @Autowired
    private ReadNumberService readNumberService;

    @Override
    @PostMapping
    @ResponseStatus(CREATED)
    public TouristConsultDto save(@RequestBody TouristConsultDto data) {
        TouristConsult model = touristConsultService.save(data);
        return touristConsultConverter.toDto(model);
    }

    @GetMapping("{id}")
    public TouristConsultDto get(@PathVariable("id") Long id) {
        Optional<TouristConsult> data = touristConsultService.findById(id);
        return touristConsultConverter.toDto(data);
    }

    @PutMapping("{id}")
    public TouristConsultDto update(@PathVariable("id") Long id, @RequestBody TouristConsultDto data) {
        TouristConsult model = touristConsultService.update(id, data);
        return touristConsultConverter.toDto(model);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(NO_CONTENT)
    public void delete(@PathVariable("id") Long id) {
        touristConsultService.delete(id);
    }

    @Override
    @GetMapping(params = { "draw" })
    public TableResult<TouristConsultDto> search(@RequestParam("draw") Long draw, @CurrentUser UserDetailsDto user,
            @ModelAttribute TouristConsultDto condition, @PageableDefault Pageable pageable) {
        Page<TouristConsult> touristConsults = touristConsultService.find(condition, user == null ? null : user.getRegionCode(), pageable);
        List<TouristConsultDto> dtos = touristConsultConverter.toDto(touristConsults);
        for (TouristConsultDto dto : dtos) {
            dto.setReadNum(readNumberService.findNumberBySourceId(dto.getId()));
        }
        Page<TouristConsultDto> page = new PageImpl<TouristConsultDto>(dtos, pageable, dtos.size());
        return TableResult.success(draw, page);
    }

    @Override
    @GetMapping(params = { "api" })
    @ApiOperation(value = "可视化根据参数查询", notes = "getApiList")
    public Object getApiList(@CurrentUser UserDetailsDto user, @RequestParam("params") String jsonStr) {
        JSONObject jsonObject = ParamUtile.paresjson(jsonStr);
        List<TouristConsult> list = touristConsultService.getByPatams(jsonObject, TouristConsult.class);
        List<TouristConsultDto> dtos = touristConsultConverter.toDto(list);
        for (TouristConsultDto dto : dtos) {
            dto.setReadNum(readNumberService.findNumberBySourceId(dto.getId()));
        }
        return jsonObject.containsKey("pageNum")
                ? new PageInfo<TouristConsultDto>(dtos, jsonObject.getIntValue("pageNum"),
                        jsonObject.getIntValue("pageSize"))
                : dtos;
    }

    @GetMapping("wechat/touristConsult")
    @ApiOperation(value = "有是否点赞的旅游资源", notes = "getApiList")
    public Object getTouristConsult(@CurrentUser UserDetailsDto user, @RequestParam("openId") String openId,
            @RequestParam("params") String jsonStr) {
        JSONObject jsonObject = ParamUtile.paresjson(jsonStr);
        List<TouristConsult> list = touristConsultService.getByPatams(jsonObject, TouristConsult.class);
        List<TouristConsultDto> dtos = touristConsultConverter.toDto(list);
        for (TouristConsultDto dto : dtos) {
            dto.setReadNum(readNumberService.findNumberBySourceId(dto.getId()));
            LikeNumber likeNumber = likeNumberService.findByResourceIdAndOpenId(dto.getId(), openId);
            if (!Objects.isNull(likeNumber)) {
                dto.setLike(true);
            } else {
                dto.setLike(false);
            }
        }
        return jsonObject.containsKey("pageNum")
                ? new PageInfo<TouristConsultDto>(dtos, jsonObject.getIntValue("pageNum"),
                        jsonObject.getIntValue("pageSize"))
                : dtos;
    }
}
