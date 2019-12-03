package com.dm.linfen.emergency.service;

import com.dm.linfen.emergency.entity.Sentiment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * @author 温东山
 * @create 2019-07-22 15:54
 **/
public interface SentimentService {
	/**
	 * 根据id查询单条数据
	 * 
	 * @param id
	 * @return
	 */
	public Optional<Sentiment> findById(Long id);

	/**
	 * 保存
	 * 
	 * @param sentiment
	 * @return
	 */
	Sentiment save(Sentiment sentiment);

	/**
	 * 修改
	 * 
	 * @param sentiment
	 * @return
	 */
	Sentiment update(Sentiment sentiment);

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
	 * @param sentiment
	 * @param pageable
	 * @return
	 */
	public Page<Sentiment> findSentiments(Sentiment sentiment, Pageable pageable);

	/**
	 * 查询声量统计
	 * 
	 * @param id
	 * @return
	 */
	public Map<String, Object> findVolumeStatistics(Integer id);

	/**
	 * 查询媒体类型
	 * 
	 * @return
	 */
	public List<Map<String, String>> findMediaStatistics();

	/**
	 * 按照省分组查询统计
	 * 
	 * @return
	 */
	public List<Map<String, String>> findRegionStatistics();

	/**
	 * 情感分组
	 * 
	 * @return
	 */
	public List<Map<String, String>> findSentimentMax();

	/**
	 * 情感分组
	 * 
	 * @param pageable
	 * @return
	 */
	public List<Map<String, String>> findSentimentList(Pageable pageable);

}
