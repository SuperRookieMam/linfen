package com.dm.linfen.root.entity;


import lombok.Data;
import javax.persistence.*;
import java.io.Serializable;

/**
 * @author yinjie
 * @desc 推荐线路
 * @date  2019年7月19日15:21:47
 */
@Data
@Entity(name = "t_recommend_line_")
public class RecommendLine implements Serializable {
    private static final long serialVersionUID = 3979673462546878303L;


    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id_")
    private Long id;

    @Column(name = "name_")
    private String name;

    //路线id
    @Column(name = "routes_id_")
    private String  routesId;
    //j景区ids
    @Column(name = "scenic_id_")
    private String scenicIds;
    // 状态
    @Column(name="status_")
    private Boolean status;
    // 优先级
    @Column(name="priority_")
    private Integer priority;
}
