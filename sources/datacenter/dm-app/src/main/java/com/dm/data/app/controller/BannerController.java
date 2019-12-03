package com.dm.data.app.controller;

import com.dm.common.dto.TableResult;
import com.dm.data.app.converter.BannerFileConvertor;
import com.dm.data.app.dto.BannerFileDto;
import com.dm.data.app.entity.BannerFile;
import com.dm.data.app.service.BannerFileService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;


import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;

@RestController
@RequestMapping("banners")
@Api(tags = {"banner"})
public class BannerController {
    @Autowired
    private BannerFileService bannerFileService;
    @Autowired
    private BannerFileConvertor bannerFileConvertor;

    @PostMapping
    @ResponseStatus(CREATED)
    @ApiOperation("保存")
    public BannerFileDto save(@RequestBody BannerFileDto data) {
        BannerFile model = bannerFileService.save(data);
        return bannerFileConvertor.toDto(model);
    }

    @GetMapping("{id}")
    public BannerFileDto get(@PathVariable("id") Long id) {
        return bannerFileConvertor.toDto(bannerFileService.findById(id));
    }


    @PutMapping("{id}")
    public BannerFileDto update(@PathVariable("id") Long id, @RequestBody BannerFileDto data) {
        BannerFile model = bannerFileService.update(id, data);
        return bannerFileConvertor.toDto(model);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(NO_CONTENT)
    public void delete(@PathVariable("id") Long id) {
        bannerFileService.delete(id);
    }

    @GetMapping(params = { "draw" })
    public TableResult<BannerFileDto> search(@RequestParam("draw") Long draw,
                                                @PageableDefault Pageable pageable) {
        Page<BannerFile> datas = bannerFileService.find(pageable);
        return TableResult.success(draw, datas, bannerFileConvertor::toDto);
    }
}
