package com.dm.data.manager.controller;

import com.alibaba.fastjson.JSONObject;
import com.dm.data.manager.entity.LikeNumber;
import com.dm.data.manager.service.LikeNumberService;
import com.dm.data.manager.utile.ParamUtile;
import com.dm.security.annotation.CurrentUser;
import com.dm.security.core.userdetails.UserDetailsDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;

/**
 * @author yinjie
 * @date 2019年8月12日11:17:27 点赞
 */
@RestController
@RequestMapping("likeNumbers")
@Api(tags = { "点赞" })
public class LikeNumberController {
    @Autowired
    private LikeNumberService likeNumberService;

    @PostMapping("{resourceId}/{openId}")
    @ResponseStatus(CREATED)
    @ApiOperation("保存")
    public LikeNumber save(@PathVariable Long resourceId, @PathVariable("openId") String openId) {
        return likeNumberService.save(resourceId, openId);
    }

    @DeleteMapping("{resourceId}/{openId}")
    @ResponseStatus(NO_CONTENT)
    @ApiOperation("删除")
    public void delete(@PathVariable("resourceId") Long resourceId, @PathVariable("openId") String openId) {
        likeNumberService.delete(resourceId, openId);
    }

    @GetMapping("findCountByNo")
    public Integer findCountByNo(@PathVariable("resourceId") Long resourceId) {
        return likeNumberService.findCountByResourceId(resourceId);
    }

    @GetMapping
    public LikeNumber findByNoAndOpenId(@PathVariable("resourceId") Long resourceId,
            @PathVariable("openId") String openId) {
        return likeNumberService.findByResourceIdAndOpenId(resourceId, openId);
    }

    @GetMapping(params = { "api" })
    @ApiOperation(value = "可视化根据参数查询", notes = "getApiList")
    @ApiIgnore
    public Object getApiList(@CurrentUser UserDetailsDto user, @RequestParam("params") String jsonStr) {
        JSONObject jsonObject = ParamUtile.paresjson(jsonStr);
        List<LikeNumber> list = likeNumberService.getByPatams(jsonObject, LikeNumber.class);
        return list;
    }
}
