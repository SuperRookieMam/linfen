package com.dm.linfen.emergency.service;

import com.dm.linfen.emergency.entity.HotWord;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * @author 温东山
 * @create 2019-07-22 17:15
 **/
public interface HotWordService {

	/**
	 * 根据id查询单条数据
	 * 
	 * @param id
	 * @return
	 */
	public Optional<HotWord> findById(Long id);

	/**
	 * 保存
	 * 
	 * @param hotWord
	 * @return
	 */
	HotWord save(HotWord hotWord);

	/**
	 * 修改
	 * 
	 * @param hotWord
	 * @return
	 */
	HotWord update(HotWord hotWord);

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
	 * @param hotWord
	 * @param pageable
	 * @return
	 */
	public Page<HotWord> findHotWords(HotWord hotWord, Pageable pageable);

	/**
	 * 热词统计
	 * 
	 * @param type
	 * @return
	 */
	public List<Map<String, String>> findKeywordStatistics(String type);
}
