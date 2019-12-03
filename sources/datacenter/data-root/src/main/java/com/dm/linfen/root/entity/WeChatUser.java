package com.dm.linfen.root.entity;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @author yinjie
 * @desc 微信用户
 * @date  2019年7月23日14:25:12
 */
@Data
@Entity(name = "t_wechat_user_")
public class WeChatUser implements Serializable {
    private static final long serialVersionUID = 7109556756822116448L;
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id_")
    private Long id;
    //微信名
    @Column(name = "wechat_name_")
    private String weChatName;
    @Column(name = "open_id_")
    private String openId;
    //注册时间
    @Column(name = "register_time_")
    @CreatedDate
    private ZonedDateTime registerTime;
    //最后登录时间
    @Column(name = "last_login_time_")
    @DateTimeFormat(iso= DateTimeFormat.ISO.DATE_TIME)
    @LastModifiedDate
    private ZonedDateTime lastLoginTime;
    //姓名
    @Column(name = "name_")
    private  String name;
    //性别
    @Column(name = "sex_")
    private Boolean sex;
    //生日
    @Column(name = "birthday_")
    @DateTimeFormat(iso= DateTimeFormat.ISO.DATE)
    private LocalDate birthday;
    //户口所在地
    @Column(name = "residence_")
    private String  residence;
    @OneToMany
    @JoinTable(name="t_line_wechat_user_",
            joinColumns = {@JoinColumn(name = "wechat_user_id_",referencedColumnName = "id_")})
    private List<RecommendLine> recommendLines=new ArrayList<>();


}
