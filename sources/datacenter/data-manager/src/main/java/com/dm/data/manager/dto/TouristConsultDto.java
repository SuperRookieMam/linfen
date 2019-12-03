package com.dm.data.manager.dto;

import com.dm.file.dto.FileInfoDto;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

/**
 * 旅游咨询
 */
@Getter
@Setter
public class TouristConsultDto extends AbstractRegionDto {
    private static final long serialVersionUID = -2967003039787200468L;
    /**
     * 资源编码
     */
    private Long id;
    /**
     * 标题
     */
    private String titile;
    /**
     * 来源
     */
    private String source;
    /**
     * 咨询简介
     */
    private String description;

    private String html;
    /**
     * 咨询,活动,攻略,旅游行程路线
     */
    private String type;

    private List<FileInfoDto> imgs;

    private String creatUser;

    private LocalDate creatTime;

    private Integer readNum;

    private Boolean like;

}
