package com.dm.data.manager.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TeamMemberDto extends AbstractRegionDto {
    private static final long serialVersionUID = -6369874776353908357L;

    private Long id;
    /**
     * 团员姓名
     */
    private String memberName;
    /**
     * 手机
     */
    private String mobile;
    /**
     * 身份证号码
     */
    private String carNumber;
}
