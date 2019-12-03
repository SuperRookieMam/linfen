package com.dm.data.manager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dm.data.manager.entity.VirtualMaterial;

public interface VirtualMaterialRepository extends JpaRepository<VirtualMaterial, Long> {

}
