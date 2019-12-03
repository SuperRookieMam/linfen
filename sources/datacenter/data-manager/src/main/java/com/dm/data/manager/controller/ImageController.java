
package com.dm.data.manager.controller;

import com.alibaba.fastjson.JSONObject;
import com.dm.common.dto.TableResult;
import com.dm.data.manager.converter.ImageConverter;
import com.dm.data.manager.dto.ImageDto;
import com.dm.data.manager.entity.Image;
import com.dm.data.manager.service.ImageService;
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
 * 图片库控制器
 *
 */
@RestController
@RequestMapping("images")
@Api(tags = { "图片库" })
public class ImageController /* extends AbstractController<ImageDto> */ {

    @Autowired
    private ImageService imageDatabaseService;

    @Autowired
    private ImageConverter imageDatabaseConverter;

    @PostMapping
    @ResponseStatus(CREATED)
    public List<ImageDto> save(@RequestBody List<ImageDto> datas) {
        List<Image> models = imageDatabaseService.save(datas);
        return imageDatabaseConverter.toDto(models);
    }

    @GetMapping("{id}")
    public ImageDto get(@PathVariable("id") Long id) {
        Optional<Image> data = imageDatabaseService.findById(id);
        return imageDatabaseConverter.toDto(data);
    }

    @PutMapping("{id}")
    public ImageDto update(@PathVariable("id") Long id, @RequestBody ImageDto data) {
        Image model = imageDatabaseService.update(id, data);
        return imageDatabaseConverter.toDto(model);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(NO_CONTENT)
    public void delete(@PathVariable("id") Long id) {
        imageDatabaseService.delete(id);
    }

    @GetMapping(params = { "draw" })
    public TableResult<ImageDto> search(@RequestParam("draw") Long draw, @CurrentUser UserDetailsDto user,
            @ModelAttribute ImageDto condition, @PageableDefault Pageable pageable) {
        Page<Image> imageDatabase = imageDatabaseService.find(condition, user == null ? null : user.getRegionCode(), pageable);
        return TableResult.success(draw, imageDatabase, data -> imageDatabaseConverter.toDto(data));
    }

    @GetMapping(params = { "api" })
    @ApiOperation(value = "可视化根据参数查询", notes = "getApiList")
    public Object getApiList(@CurrentUser UserDetailsDto user, @RequestParam("params") String jsonStr) {
        JSONObject jsonObject = ParamUtile.paresjson(jsonStr);
        List<Image> list = imageDatabaseService.getByPatams(jsonObject, Image.class);
        return jsonObject.containsKey("pageNum")
                ? new PageInfo<ImageDto>(imageDatabaseConverter.toDto(list), jsonObject.getIntValue("pageNum"),
                        jsonObject.getIntValue("pageSize"))
                : imageDatabaseConverter.toDto(list);
    }
}
