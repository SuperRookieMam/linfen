package com.dm.linfen.root.dto;

import lombok.Data;

import java.io.Serializable;

@Data
@Deprecated
public class RecommendLineDto implements Serializable {
	private static final long serialVersionUID = 7225363477172406147L;

	private Long id;

	private String name;

	private String routesId;

	private String scenicIds;
	// 状态
	private Boolean status;
	// 优先级
	private Integer priority;

}
