package com.dm.linfen.root.controller;

import com.dm.common.dto.TableResult;
import com.dm.linfen.root.converter.RecommendLineConverter;
import com.dm.linfen.root.dto.RecommendLineDto;
import com.dm.linfen.root.entity.RecommendLine;
import com.dm.linfen.root.service.RecommendLineService;
import com.dm.security.annotation.CurrentUser;
import com.dm.security.core.userdetails.UserDetailsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.CREATED;

/**
 * 推荐线路控制器
 *
 */
@RestController
@RequestMapping("recommendLines")
public class RecommendLineController {
    @Autowired
    private RecommendLineService recommendLineService;
    @Autowired
    private RecommendLineConverter recommendLineConverter;
    @GetMapping("{id}")
    public RecommendLineDto findById(@PathVariable("id") Long id){
      return recommendLineConverter.toDto(recommendLineService.findById(id));
    }
    @PostMapping
    @ResponseStatus(CREATED)
    public RecommendLineDto save(@RequestBody RecommendLineDto dto){
        return recommendLineConverter.toDto(recommendLineService.save(dto));
    }



    @DeleteMapping("{id}")
    public void save(@PathVariable("id") Long id){
        recommendLineService.deleteById(id);
    }

    @PutMapping("{id}")
    public RecommendLineDto update(@PathVariable("id") Long id,@RequestBody RecommendLineDto dto){
        return recommendLineConverter.toDto(recommendLineService.updateById(id,dto));
    }

    @GetMapping(params = { "draw" })
    public TableResult<RecommendLineDto> search(@RequestParam("draw") Long draw, @CurrentUser UserDetailsDto user,
                                           @PageableDefault Pageable pageable) {
        Page<RecommendLine> recommendLines = recommendLineService.findPage(pageable);
        return TableResult.success(draw, recommendLines, recommendLineConverter::toDto);
    }
}
