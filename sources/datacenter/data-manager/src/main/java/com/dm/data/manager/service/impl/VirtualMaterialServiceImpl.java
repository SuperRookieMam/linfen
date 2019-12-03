package com.dm.data.manager.service.impl;

import com.dm.data.manager.converter.VirtualMaterialConverter;
import com.dm.data.manager.dto.VirtualMaterialDto;
import com.dm.data.manager.entity.VirtualMaterial;
import com.dm.data.manager.repository.VirtualMaterialRepository;
import com.dm.data.manager.service.VirtualMaterialService;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class VirtualMaterialServiceImpl extends AbstractCurrencyServiceImpl<VirtualMaterial>
        implements VirtualMaterialService {

    @Autowired
    private VirtualMaterialRepository virtualMaterialRepository;

    @Autowired
    private VirtualMaterialConverter virtualMaterialConverter;

    @Override
    public Optional<VirtualMaterial> findById(Long id) {
        return virtualMaterialRepository.findById(id);
    }

    @Override
    @Transactional
    public VirtualMaterial save(VirtualMaterialDto data) {
        VirtualMaterial entity = new VirtualMaterial();
        virtualMaterialConverter.copyProperties(entity, data);
        return virtualMaterialRepository.save(entity);
    }

    @Override
    @Transactional
    public List<VirtualMaterial> save(List<VirtualMaterialDto> datas) {
        if (CollectionUtils.isNotEmpty(datas)) {
            List<VirtualMaterial> materials = datas.stream().map(data -> {
                VirtualMaterial material = new VirtualMaterial();
                virtualMaterialConverter.copyProperties(material, data);
                return material;
            }).collect(Collectors.toList());
            return virtualMaterialRepository.saveAll(materials);
        } else {
            return Collections.emptyList();
        }
    }

    @Override
    @Transactional
    public VirtualMaterial update(Long id, VirtualMaterialDto data) {
        VirtualMaterial entity = virtualMaterialRepository.getOne(id);
        virtualMaterialConverter.copyProperties(entity, data);
        return entity;
    }

    @Override
    @Transactional
    public void delete(Long id) {
        virtualMaterialRepository.deleteById(id);
    }

    @Override
    public Page<VirtualMaterial> find(Pageable pageable) {
        return virtualMaterialRepository.findAll(pageable);
    }

}
