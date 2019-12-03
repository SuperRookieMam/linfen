package com.dm.linfen.root.repository;

import com.dm.linfen.root.entity.WeChatUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.util.Optional;

/**
 * @author  yinjie
 * @date  2019年7月23日15:20:43
 */
public interface WeChatUserRepository extends JpaRepository<WeChatUser, Long>, QuerydslPredicateExecutor<WeChatUser> {

   Optional<WeChatUser>  findByOpenId(String openId);
}
