
package com.dm.data.manager.controller;

import com.alibaba.fastjson.JSONObject;
import com.dm.common.dto.TableResult;
import com.dm.data.manager.converter.VideoConverter;
import com.dm.data.manager.dto.VideoDto;
import com.dm.data.manager.entity.Video;
import com.dm.data.manager.service.VideoService;
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
 * 视频库控制器
 *
 */
@RestController
@RequestMapping("videos")
@Api(tags = { "视频库" })
public class VideoController /* extends AbstractController<VideoDto> */ {

    @Autowired
    private VideoService videoDatabaseService;

    @Autowired
    private VideoConverter videoDatabaseConverter;

    @PostMapping
    @ResponseStatus(CREATED)
    public List<VideoDto> save(@RequestBody List<VideoDto> datas) {
        List<Video> model = videoDatabaseService.save(datas);
        return videoDatabaseConverter.toDto(model);
    }

    @GetMapping("{id}")
    public VideoDto get(@PathVariable("id") Long id) {
        Optional<Video> data = videoDatabaseService.findById(id);
        return videoDatabaseConverter.toDto(data);
    }

    @PutMapping("{id}")
    public VideoDto update(@PathVariable("id") Long id, @RequestBody VideoDto data) {
        Video model = videoDatabaseService.update(id, data);
        return videoDatabaseConverter.toDto(model);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(NO_CONTENT)
    public void delete(@PathVariable("id") Long id) {
        videoDatabaseService.delete(id);
    }

    @GetMapping(params = { "draw" })
    public TableResult<VideoDto> search(@RequestParam("draw") Long draw, @CurrentUser UserDetailsDto user,
            @ModelAttribute VideoDto condition, @PageableDefault Pageable pageable) {
        Page<Video> videoDatabase = videoDatabaseService.find(condition, user == null ? null : user.getRegionCode(), pageable);
        return TableResult.success(draw, videoDatabase, data -> videoDatabaseConverter.toDto(data));
    }

    @GetMapping(params = { "api" })
    @ApiOperation(value = "可视化根据参数查询", notes = "getApiList")
    public Object getApiList(@CurrentUser UserDetailsDto user, @RequestParam("params") String jsonStr) {
        JSONObject jsonObject = ParamUtile.paresjson(jsonStr);
        List<Video> list = videoDatabaseService.getByPatams(jsonObject, Video.class);
        return jsonObject.containsKey("pageNum")
                ? new PageInfo<VideoDto>(videoDatabaseConverter.toDto(list), jsonObject.getIntValue("pageNum"),
                        jsonObject.getIntValue("pageSize"))
                : videoDatabaseConverter.toDto(list);
    }
}
