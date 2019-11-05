package com.dm.linfen.service;

import com.alibaba.fastjson.JSONObject;
import com.dm.linfen.dto.MonitorManagerDto;
import com.dm.linfen.entity.MonitorManager;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface MonitorManagerService {

	public Optional<MonitorManager> findById(Long id);

	public MonitorManager save(MonitorManagerDto data);

	public MonitorManager update(Long id, MonitorManagerDto data);

	public void delete(Long id);

	List<MonitorManagerDto>  findByRun(Boolean run);

	public Page<MonitorManager> find(MonitorManagerDto condition, String regionCode, Pageable pageable);

	JSONObject pushValidate(String roomNumber, String password);

	List<MonitorManagerDto> findAll();

	void transferStream(Long id);

    void transferStreamToLocal(Long id);

    void turnOff(Long id);
}
