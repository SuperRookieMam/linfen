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
 * @create 2019-07-26 09:26
 **/
@Entity(name = "t_emergency")
@Data
@EntityListeners(AuditingEntityListener.class)
public class Emergency {

	@Id
	@Nullable
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	/**
	 * 标题
	 */
	@Column(name = "title_")
	private String title;

	/**
	 * 事件来源
	 */
	@Column(name = "source_")
	private String source;

	/**
	 * 事发地
	 */
	@Column(name = "geographical_")
	private String geographical;

	/**
	 * gps定位坐标经度
	 */
	@Column(name = "longitude_")
	private String longitude;

	/**
	 * gps定位坐标纬度
	 */
	@Column(name = "latitude_")
	private String latitude;

	/**
	 * 内容
	 */
	@Lob
	@Column(name = "content_")
	private String content;

	/**
	 * 上报者(联系人)姓名
	 */
	@Column(name = "report_member_")
	private String reportMember;

	/**
	 * 上报者(联系人)电话
	 */
	@Column(name = "report_telephone")
	private String reportTelephone;

	/**
	 * 企业
	 */
	@Column(name = "enterprise_")
	private String enterprise;

	/**
	 * 事件等级
	 */
	@Column(name = "grade_")
	private Integer grade;

	/**
	 * 事件类型(景区事件,自然灾害,交通事件,其他事件)
	 */
	@Column(name = "type_")
	private String type;

	/**
	 * 图片路径集合grade_
	 */
	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "t_emergency_img")
	private List<FileInfo> imgs;
	/**
	 * 视频路径集合
	 */
	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "t_emergency_video")
	private List<FileInfo> video;

	/**
	 * 音频
	 */
	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "t_emergency_voice")
	private List<FileInfo> voice;

	@ManyToOne
	private Plan plan;

	/**
	 * 处理状态 0未处理 1 已处理
	 */
	@Column(name = "status_")
	private Integer status;

	/**
	 * 处理结果
	 */
	@Column(name = "handle_result")
	private String handleResult;
	/**
	 * 处理人
	 */
	@Column(name = "handle_member")
	private String handleMember;

	/**
	 * 处理时间
	 */
//	@LastModifiedDate
	@Column(name = "handle_time")
	private ZonedDateTime handleTime;

	/**
	 * 上报时间
	 */
	@Column(name = "report_time_")
	private ZonedDateTime reportTime;

	/**
	 * 事件生成时间
	 */
	@CreatedDate
	@Column(name = "create_time_")
	private ZonedDateTime createTime;

}
