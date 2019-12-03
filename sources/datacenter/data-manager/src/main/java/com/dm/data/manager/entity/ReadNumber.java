package com.dm.data.manager.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Entity(name = "read_num_")
public class ReadNumber implements Serializable {
    private static final long serialVersionUID = 535517141337676684L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 资源编号
     */
    @Column(name = "no_")
    private Long sourceId;

    /**
     * 阅读次数
     */
    @Column(name = "number_")
    private Integer number = 0;

}
