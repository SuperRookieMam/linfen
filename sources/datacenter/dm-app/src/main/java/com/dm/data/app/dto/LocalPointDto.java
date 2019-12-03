package com.dm.data.app.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import java.io.Serializable;
import java.time.LocalDateTime;
@Getter
@Setter
public class LocalPointDto implements Serializable {
    private Long id;

    /**
     * 经度
     */
    private String longitude;
    /**
     * 纬度
     */
    private String latitude;
    /**
     * 时间点
     */
    private LocalDateTime timePoint;
}
