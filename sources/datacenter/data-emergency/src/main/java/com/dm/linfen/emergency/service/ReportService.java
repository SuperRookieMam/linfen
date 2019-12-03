package com.dm.linfen.emergency.service;

import com.dm.linfen.emergency.entity.Report;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * @author Administrator
 * @Title: ReportService
 * @ProjectName datacenter
 * @Description: TODO
 * @date 2019/7/25 002513:59
 */
public interface ReportService {

	/**
	 * 根据id查询单条数据
	 * 
	 * @param id
	 * @return
	 */
	public Optional<Report> findById(Long id);

	/**
	 * 保存
	 * 
	 * @param report
	 * @return
	 */
	Report save(Report report);

	/**
	 * 修改
	 * 
	 * @param report
	 * @return
	 */
	Report update(Report report);

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
	 * @param report
	 * @param pageable
	 * @return
	 */
	public Page<Report> findReports(Report report, Pageable pageable);
}
