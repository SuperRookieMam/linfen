package com.dm.linfen.root.service;

import com.dm.linfen.root.dto.WeChatUserDto;
import com.dm.linfen.root.entity.WeChatUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @author  yinjie
 * @date  2019年7月23日15:20:43
 */
public interface WeChatUserService {

    WeChatUser save(WeChatUserDto dto);

    void  deleteById(Long id);

    WeChatUser findById(Long id);

    WeChatUser update(Long id,WeChatUserDto dto);

    Page<WeChatUser> find(String search,Pageable pageable);

    WeChatUser lastLogin(String  openId);

    WeChatUser findByOpenId(String openId);
}
