
package com.dm.data.manager.controller;

import com.alibaba.fastjson.JSONObject;
import com.dm.common.dto.TableResult;
import com.dm.data.manager.converter.AudioConverter;
import com.dm.data.manager.dto.AudioDto;
import com.dm.data.manager.entity.Audio;
import com.dm.data.manager.service.AudioService;
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
 * 音频库控制器
 *
 */
@RestController
@RequestMapping("audios")
@Api(tags = { "音频库" })
public class AudioController /* extends AbstractController<AudioDto> */ {

    @Autowired
    private AudioService audioDatabaseService;

    @Autowired
    private AudioConverter audioDatabaseConverter;

    @PostMapping
    @ResponseStatus(CREATED)
    public List<AudioDto> save(@RequestBody List<AudioDto> datas) {
        List<Audio> model = audioDatabaseService.save(datas);
        return audioDatabaseConverter.toDto(model);
    }

    @GetMapping("{id}")
    public AudioDto get(@PathVariable("id") Long id) {
        Optional<Audio> data = audioDatabaseService.findById(id);
        return audioDatabaseConverter.toDto(data);
    }

    @PutMapping("{id}")
    public AudioDto update(@PathVariable("id") Long id, @RequestBody AudioDto data) {
        Audio model = audioDatabaseService.update(id, data);
        return audioDatabaseConverter.toDto(model);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(NO_CONTENT)
    public void delete(@PathVariable("id") Long id) {
        audioDatabaseService.delete(id);
    }

    @GetMapping(params = { "draw" })
    public TableResult<AudioDto> search(@RequestParam("draw") Long draw, @CurrentUser UserDetailsDto user,
            @ModelAttribute AudioDto condition, @PageableDefault Pageable pageable) {
        Page<Audio> audioDatabase = audioDatabaseService.find(pageable);
        return TableResult.success(draw, audioDatabase, audioDatabaseConverter::toDto);
    }

    @GetMapping(params = { "api" })
    @ApiOperation(value = "可视化根据参数查询", notes = "getApiList")
    public Object getApiList(@CurrentUser UserDetailsDto user, @RequestParam("params") String jsonStr) {
        JSONObject jsonObject = ParamUtile.paresjson(jsonStr);
        List<Audio> list = audioDatabaseService.getByPatams(jsonObject, Audio.class);
        return jsonObject.containsKey("pageNum")
                ? new PageInfo<AudioDto>(audioDatabaseConverter.toDto(list), jsonObject.getIntValue("pageNum"),
                        jsonObject.getIntValue("pageSize"))
                : audioDatabaseConverter.toDto(list);
    }
}
