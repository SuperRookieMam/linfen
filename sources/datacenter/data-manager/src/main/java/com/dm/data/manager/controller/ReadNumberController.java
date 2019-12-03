package com.dm.data.manager.controller;

import com.alibaba.fastjson.JSONObject;
import com.dm.data.manager.entity.ReadNumber;
import com.dm.data.manager.service.ReadNumberService;
import com.dm.data.manager.utile.ParamUtile;
import com.dm.security.annotation.CurrentUser;
import com.dm.security.core.userdetails.UserDetailsDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;

/**
 * @author yinjie
 * @date 2019年8月12日11:17:27 阅读量
 */
@RestController
@RequestMapping("readNumbers")
@Api(tags = { "阅读数量" })
public class ReadNumberController {
    @Autowired
    private ReadNumberService readNumberService;

    @GetMapping("findReadNum/{sourceId}")
    @ApiOperation(value = "根据资源标号查阅读量", notes = "findReadNum")
    public Integer findReadNum(@PathVariable("sourceId") Long sourceId) {
        return readNumberService.findNumberBySourceId(sourceId);
    }

    @PostMapping("addOne/{sourceId}")
    @ApiOperation(value = "阅读量+1", notes = "addOne")
    public ReadNumber addOne(@PathVariable("sourceId") Long sourceId) {
        return readNumberService.addOne(sourceId);
    }

    @GetMapping(params = { "api" })
    @ApiOperation(value = "可视化根据参数查询", notes = "getApiList")
    @ApiIgnore
    public Object getApiList(@CurrentUser UserDetailsDto user, @RequestParam("params") String jsonStr) {
        JSONObject jsonObject = ParamUtile.paresjson(jsonStr);
        List<ReadNumber> list = readNumberService.getByPatams(jsonObject, ReadNumber.class);
        return list;
    }
}
