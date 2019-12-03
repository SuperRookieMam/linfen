package com.dm.data.manager.dto;

import com.dm.data.manager.enums.NoEnums;
import com.dm.file.dto.FileInfoDto;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

/**
 * 文物租赁dto
 *
 * @author yinjie
 * @date 2019年8月2日14:03:47
 */

@Getter
@Setter
public class CulturalRelicRentDto extends AbstractRegionDto {
    private Long id;
    private String no;
    private String regionCode;
    private NoEnums noEnums;
    private String name;
    private String lendingUnit;
    private String rentalUnit;
    private LocalDate rentalTime;
    private LocalDate returnTime;
    private List<FileInfoDto> imgs;
    private String rentStatus;
    private String description;
    private Integer rentDays;
    private String rentalCode;
    private String lendingCode;
}
