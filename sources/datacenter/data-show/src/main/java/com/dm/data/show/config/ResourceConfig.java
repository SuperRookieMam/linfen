package com.dm.data.show.config;

import java.util.Optional;

import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.resource.PrincipalExtractor;
import org.springframework.boot.autoconfigure.security.oauth2.resource.UserInfoTokenServices;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.AuditorAware;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

import com.dm.common.dto.AuditDto;
import com.dm.common.entity.Audit;
import com.dm.security.core.userdetails.UserDetailsDto;
import com.dm.security.oauth2.resource.UserDetailsDtoPrincipalExtractor;

@EnableResourceServer
@EnableWebSecurity
public class ResourceConfig extends ResourceServerConfigurerAdapter {

	@Autowired
	private UserInfoTokenServices userInfoTokenServices;

	@Override
	public void configure(HttpSecurity http) throws Exception {
		/**
		 * 指定所有的GET请求不过验证
		 */
		http.authorizeRequests().antMatchers(HttpMethod.GET).permitAll().antMatchers("/**").authenticated();
//		http.authorizeRequests().anyRequest().permitAll();
	}

	@Override
	public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
		super.configure(resources);
		// 指定这是一个restful service,不会保存会话状态
		resources.stateless(true);
	}

	@PostConstruct
	public void config() {
		userInfoTokenServices.setPrincipalExtractor(principalExtractor());
	}

	/**
	 * 指定一个用户信息解码器，将从服务器获取过来的用户信息解码为本地UserDetails
	 * 
	 * @return
	 */
	@Bean
	public PrincipalExtractor principalExtractor() {
		return new UserDetailsDtoPrincipalExtractor();
	}

	@Bean
	public AuditorAware<Audit> auditorAware() {
		return new AuditorAware<Audit>() {
			@Override
			public Optional<Audit> getCurrentAuditor() {
				Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
				if (authentication != null) {
					Object principal = authentication.getPrincipal();
					if (principal instanceof UserDetailsDto) {
						UserDetailsDto ud = (UserDetailsDto) principal;
						return Optional.ofNullable(new AuditDto(ud.getId(), ud.getFullname()));
					}
				}
				return Optional.empty();
			}
		};
	}

}
