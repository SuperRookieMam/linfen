package com.dm.data.manager.entity;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.io.Serializable;

/**
 * 点赞量
 *
 * @author yinjie
 * @date 2019年8月12日11:00:15
 */
@Getter
@Setter
@Entity(name = "like_num_")
public class LikeNumber implements Serializable {

    private static final long serialVersionUID = -4544099827495406412L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 资源编号
     */
    @Column(name = "no_")
    private Long resourceId;
    /**
     * 用户
     */
    @Column(name = "open_id_")
    private String openId;
}
