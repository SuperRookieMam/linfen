package com.dm.linfen.emergency.service;

import com.dm.linfen.emergency.entity.Duty;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

/**
 * @author 温东山
 * @create 2019-07-24 10:55
 **/
public interface DutyService {

	/**
	 * 根据id查询数据
	 *
	 * @param id
	 * @return
	 */
	Optional<Duty> findById(Long id);

	/**
	 * 根据时间查询获取数据
	 *
	 * @param localDate
	 * @return
	 */
	Optional<Duty> findByCreateTime(LocalDate localDate);

	/**
	 * 批量保存
	 *
	 * @param dutys
	 */
	public void batchSave(List<Duty> dutys);

	/**
	 * 保存
	 * 
	 * @param duty
	 * @return
	 */
	public Duty save(Duty duty);

	/**
	 * 修改
	 *
	 * @param duty
	 * @return
	 */
	Duty update(Duty duty);

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
	 * @param startTime
	 * @param endTime
	 * @param pageable
	 * @return
	 */
	public Page<Duty> findDutys(LocalDate startTime, LocalDate endTime, Pageable pageable);

}
