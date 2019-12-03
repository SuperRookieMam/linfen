package com.dm.linfen.emergency.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Description: webApi配置
 * @Author: 温东山
 * @CreateDate: 2019/8/6 0006 09:57
 * @UpdateUser: 温东山
 * @UpdateDate: 2019/8/6 0006 09:57
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
	@Bean
	public Docket createRestApi() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
				// 只扫描RestController注解的类
				.apis(RequestHandlerSelectors.withClassAnnotation(RestController.class)).paths(PathSelectors.any())
				.build();
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				// 页面标题
				.title("临汾").
				// 创建人
				contact(new Contact("like", "", "like@jusfoun.com"))
				// 版本号
				.version("1.0")
				// 描述
				.description("API描述").build();
	}
}
