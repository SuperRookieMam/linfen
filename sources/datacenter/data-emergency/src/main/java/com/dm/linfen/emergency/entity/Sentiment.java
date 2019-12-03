package com.dm.linfen.emergency.entity;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.io.Serializable;
import java.time.ZonedDateTime;

/**
 * @Description: 舆情实体类
 * @Author: 温东山
 * @CreateDate: 2018/12/18 0018 16:20
 * @UpdateUser: 温东山
 * @UpdateDate: 2018/12/18 0018 16:20
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
@Entity(name = "t_sentiment")
@Data
@EntityListeners(AuditingEntityListener.class)
public class Sentiment implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Nullable
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	/**
	 * 作者
	 */
	@Column(name = "author_name_")
	private String authorName;
	/**
	 * 标题
	 */
	@Column(name = "title_")
	private String title;

	/**
	 * 内容如果需要可以使用es 存汉字版本,字段一般不存在数据库中
	 */
	@Lob
	@Column(name = "content_", columnDefinition = "text")
	private String content;

	/**
	 * 图片地址
	 */
	@Column(name = "image_")
	private String image;

	/**
	 * 媒体类型 新闻 微信 论坛 贴吧
	 */
	@Column(name = "media_type_")
	private String mediaType;

	/**
	 * 采集时间
	 */
	@CreatedDate
	@Column(name = "create_time_")
	private ZonedDateTime createTime;

	/**
	 * 情感类型,正(1) 中性(0) 负(-1) 类型
	 */
	@Column(name = "sentiment_type_")
	private String sentimentType;

	/**
	 * 声量走势,敏感(1),非敏感(0)
	 */
	@Column(name = "volume_")
	private String volume;

	/**
	 * 来源什么网站比如微博 百度等
	 */
	@Column(name = "source_")
	private String source;

	/**
	 * 浏览数
	 */
	@Column(name = "view_count")
	private Integer viewCount;

	/**
	 * 城市
	 */
	@Column(name = "city_")
	private String city;
	/**
	 * 区县
	 */
	@Column(name = "county_")
	private String county;
	/**
	 * 省
	 */
	@Column(name = "province_")
	private String province;

	/**
	 * 是否已经添加到es环境标示 0标示未插入数据库 1标示插入
	 */
	@Column(name = "es_")
	private Integer es;

}