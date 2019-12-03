package com.dm.data.app.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
public class TripDto implements Serializable {
    private Long id;
    /**
     * 安排
     */
    private String arrange;
    /**
     * 酒店名称
     */
    private String hotelName;
    /**
     * 行程时间
     */
    private LocalDate tripTime;
}
