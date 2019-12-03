package com.dm.linfen.root.dto;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Data
public class WeChatUserDto implements Serializable {

	private static final long serialVersionUID = -3277072139245203914L;
	
	private Long id;
	// 微信名
	private String weChatName;
	// 注册时间
	private ZonedDateTime registerTime;
	// 最后登录时间
	private ZonedDateTime lastLoginTime;
	// 姓名
	private String name;
	// 性别
	private Boolean sex;
	// 生日
	private LocalDate birthday;
	// 户口所在地
	private String residence;
	private String openId;
	private List<Map<String, Object>> recommendLines = new ArrayList<>();
}
