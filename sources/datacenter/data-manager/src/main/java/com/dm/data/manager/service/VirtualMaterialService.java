package com.dm.data.manager.service;

import com.dm.data.manager.dto.VirtualMaterialDto;
import com.dm.data.manager.entity.VirtualMaterial;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface VirtualMaterialService extends ApiService<VirtualMaterial> {

    public Optional<VirtualMaterial> findById(Long id);

    public VirtualMaterial save(VirtualMaterialDto data);

    public VirtualMaterial update(Long id, VirtualMaterialDto data);

    public void delete(Long id);

    public Page<VirtualMaterial> find(Pageable pageable);

    public List<VirtualMaterial> save(List<VirtualMaterialDto> datas);
}
