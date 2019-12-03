package com.dm.linfen.emergency.config;

import com.dm.security.oauth2.resource.UserDetailsDtoPrincipalExtractor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.resource.PrincipalExtractor;
import org.springframework.boot.autoconfigure.security.oauth2.resource.UserInfoTokenServices;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

import javax.annotation.PostConstruct;

/**
 * @Description: 资源权限配置
 * @Author: 温东山
 * @CreateDate: 2019/8/6 0006 09:56
 * @UpdateUser: 温东山
 * @UpdateDate: 2019/8/6 0006 09:56
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
@EnableResourceServer
@EnableWebSecurity
public class ResourceConfig extends ResourceServerConfigurerAdapter {

	@Autowired
	private UserInfoTokenServices userInfoTokenServices;

	@Override
	public void configure(HttpSecurity http) throws Exception {
		/**
		 * 测试的时候开启这行代码,不需要登录
		 */
		http.authorizeRequests().antMatchers("/**").permitAll();
//		http.authorizeRequests()
//				.antMatchers(
//						"/views/**"
//						,"/weathers/**")
//				.permitAll();
//		http.authorizeRequests().antMatchers(HttpMethod.GET,
//				"/files**/**"
//				)
//                .permitAll()
//				.anyRequest().authenticated();
		http.antMatcher("/**");
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

}
