package com.dm.springboot.autoconfigure;

import com.dm.linfen.entity.MonitorManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.annotation.PostConstruct;

@Configuration
//@EnableConfigurationProperties(value = {MonitorVideoProperties.class})
@ComponentScan(value = { "com.dm.linfen.**" })
@EntityScan(basePackages = { "com.dm.linfen.**" })
@EnableJpaRepositories(basePackages = "com.dm.linfen.**")
@ConditionalOnClass(MonitorManager.class)
@Slf4j
public class MonitorVideoConfiguration {

//    @Autowired
//    private MonitorVideoProperties monitorVedioProperties;

	@PostConstruct
	public void getMssg() {
		log.info("");
	}
}
