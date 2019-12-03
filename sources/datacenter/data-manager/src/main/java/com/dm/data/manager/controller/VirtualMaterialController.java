
package com.dm.data.manager.controller;

import com.dm.common.dto.TableResult;
import com.dm.data.manager.converter.VirtualMaterialConverter;
import com.dm.data.manager.dto.VirtualMaterialDto;
import com.dm.data.manager.entity.VirtualMaterial;
import com.dm.data.manager.service.VirtualMaterialService;
import com.dm.security.annotation.CurrentUser;
import com.dm.security.core.userdetails.UserDetailsDto;
import io.swagger.annotations.Api;
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
 * 虚拟素材控制器
 *
 */
@RestController
@RequestMapping("virtualMaterials")
@Api(tags = { "虚拟素材库" })
public class VirtualMaterialController /* extends AbstractController<VirtualMaterialDto> */ {

    @Autowired
    private VirtualMaterialService virtualMaterialService;

    @Autowired
    private VirtualMaterialConverter virtualMaterialConverter;

    @PostMapping
    @ResponseStatus(CREATED)
    public List<VirtualMaterialDto> save(@RequestBody List<VirtualMaterialDto> data) {
        List<VirtualMaterial> model = virtualMaterialService.save(data);
        return virtualMaterialConverter.toDto(model);
    }

    @GetMapping("{id}")
    public VirtualMaterialDto get(@PathVariable("id") Long id) {
        Optional<VirtualMaterial> data = virtualMaterialService.findById(id);
        return virtualMaterialConverter.toDto(data);
    }

    @PutMapping("{id}")
    public VirtualMaterialDto update(@PathVariable("id") Long id, @RequestBody VirtualMaterialDto data) {
        VirtualMaterial model = virtualMaterialService.update(id, data);
        return virtualMaterialConverter.toDto(model);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(NO_CONTENT)
    public void delete(@PathVariable("id") Long id) {
        virtualMaterialService.delete(id);
    }

    @GetMapping(params = { "draw" })
    public TableResult<VirtualMaterialDto> search(@RequestParam("draw") Long draw, @CurrentUser UserDetailsDto user,
            @ModelAttribute VirtualMaterialDto condition, @PageableDefault Pageable pageable) {
        Page<VirtualMaterial> virtualMaterial = virtualMaterialService.find(pageable);
        return TableResult.success(draw, virtualMaterial, data -> virtualMaterialConverter.toDto(data));
    }
}
