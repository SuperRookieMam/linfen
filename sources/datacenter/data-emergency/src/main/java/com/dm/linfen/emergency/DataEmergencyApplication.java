package com.dm.linfen.emergency;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

@EnableScheduling
@EnableJpaAuditing
@EnableJpaRepositories(basePackages = "com.dm.linfen.emergency.repository")
@EntityScan(basePackages = "com.dm.linfen.emergency.entity")
@SpringBootApplication
@EnableSpringDataWebSupport
/**
 * EntityScan EnableJpaRepositories必须配置否则启动失败 EnableScheduling定时任务配置
 * 
 * @Author: 温东山
 * @CreateDate: 2019/8/6 0006 09:58
 * @UpdateUser: 温东山
 * @UpdateDate: 2019/8/6 0006 09:58
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public class DataEmergencyApplication {

	public static void main(String[] args) {
		SpringApplication.run(DataEmergencyApplication.class, args);
	}

}
