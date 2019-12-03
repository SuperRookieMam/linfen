package com.dm.linfen.emergency.service;

import com.dm.linfen.emergency.entity.Emergency;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * @author 温东山
 * @create 2019-07-26 10:07
 **/
public interface EmergencyService {

	/**
	 * 根据id查询单条数据
	 * 
	 * @param id
	 * @return
	 */
	public Optional<Emergency> findById(Long id);

	/**
	 * 保存
	 * 
	 * @param emergency
	 * @return
	 */
	Emergency save(Emergency emergency);

	/**
	 * 修改
	 * 
	 * @param emergency
	 * @return
	 */
	Emergency update(Emergency emergency);

	/**
	 * 删除
	 * 
	 * @param id
	 * @return
	 */
	void delete(Long id);

	/**
	 * 条件查询列表
	 * 
	 * @param emergency
	 * @param pageable
	 * @return
	 */
	public Page<Emergency> findEmergencys(Emergency emergency, Pageable pageable);
}
