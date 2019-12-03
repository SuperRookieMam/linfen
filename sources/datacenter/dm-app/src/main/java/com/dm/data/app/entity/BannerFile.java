package com.dm.data.app.entity;

import com.dm.data.app.entity.core.AbstractCore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Copyright (c) 2019 江苏云智网络科技股份有限公司版权所有
 * @author: 尹杰
 * @Date: 2019/9/12 17:05
 * @Description:banner 图
 * @History
 */
@Getter
@Setter
@Entity(name = "t_banner_file_")
@Table(name = "t_banner_file_")
public class BannerFile extends AbstractCore<Long> implements Serializable {


    private static final long serialVersionUID = -2632828028039537402L;
    /**
     * 图片路径集合
     */
    @Column(name="file_id_")
    private String  fileId;
    /**
     * 顺序
     */
    @Column(name="order_num_")
    private Integer orderNum;
    /**
     * 名字
     */
    @Column(name="name_")
    private String name;
}
