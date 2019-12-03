package com.dm.linfen.emergency.entity;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * @Description: 热词管理
 * @Author: 温东山
 * @CreateDate: 2019/7/22 0022 17:12
 * @UpdateUser: 温东山
 * @UpdateDate: 2019/7/22 0022 17:12
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
@Entity(name = "t_hot_word")
@Data
@EntityListeners(AuditingEntityListener.class)
public class HotWord {

	@Id
	@Nullable
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	/**
	 * 热词
	 */
	@Column(name = "keyword_")
	private String keyword;

	/**
	 * 热词分类
	 */
	@Column(name = "type_")
	private String type;

	/**
	 * 采集时间
	 */
	@CreatedDate
	@Column(name = "create_time_")
	private LocalDate createTime;

}
