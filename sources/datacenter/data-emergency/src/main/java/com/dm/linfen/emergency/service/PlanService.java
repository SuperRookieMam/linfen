package com.dm.linfen.emergency.service;

import com.dm.linfen.emergency.entity.Plan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * @author 温东山
 * @create 2019-07-25 15:33
 **/
public interface PlanService {

	/**
	 * 根据id查询单条数据
	 * 
	 * @param id
	 * @return
	 */
	public Optional<Plan> findById(Long id);

	/**
	 * 保存
	 * 
	 * @param plan
	 * @return
	 */
	Plan save(Plan plan);

	/**
	 * 修改
	 * 
	 * @param plan
	 * @return
	 */
	Plan update(Plan plan);

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
	 * @param plan
	 * @param pageable
	 * @return
	 */
	public Page<Plan> findPlans(Plan plan, Pageable pageable);
}
