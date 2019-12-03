package com.dm.linfen.emergency.entity;

import com.dm.file.entity.FileInfo;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.List;

/**
 * @author 温东山
 * @create 2019-07-25 09:38
 **/
@Entity(name = "t_report")
@Data
@EntityListeners(AuditingEntityListener.class)
public class Report {

	@Id
	@Nullable
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	/**
	 * 上报时间
	 */
	@CreatedDate
	@Column(name = "creat_time_")
	private ZonedDateTime createTime;
	/**
	 * 标题
	 */
	@Column(name = "title_")
	private String title;

	/**
	 * 企业
	 */
	@Column(name = "enterprise_")
	private String enterprise;

	/**
	 * 上报者姓名
	 */
	@Column(name = "report_member_")
	private String reportMember;

	/**
	 * 上报者电话
	 */
	@Column(name = "report_telephone")
	private String reportTelephone;

	/**
	 * 事发地
	 */
	@Column(name = "geographical_")
	private String geographical;
	/**
	 * 经度
	 */
	@Column(name = "longitude_")
	private String longitude;

	/**
	 * 纬度
	 */
	@Column(name = "latitude_")
	private String latitude;

	/**
	 * 图片路径集合
	 */
	@OneToMany
	@JoinTable(name = "t_report_img")
	private List<FileInfo> imgs;
	/**
	 * 视频路径集合
	 */
	@OneToMany
	@JoinTable(name = "t_report_video")
	private List<FileInfo> video;

	/**
	 * 音频
	 */
	@OneToMany
	@JoinTable(name = "t_report_voice")
	private List<FileInfo> voice;
	/**
	 * 内容
	 */
	@Lob
	@Column(name = "content_")
	private String content;

	/**
	 * 处理状态 0未处理 1 已处理 2 转应急
	 */
	@Column(name = "status_")
	private Integer status;

}
