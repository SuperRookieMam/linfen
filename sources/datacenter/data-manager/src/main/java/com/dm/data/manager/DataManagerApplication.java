package com.dm.data.manager;

import com.dm.data.manager.core.DmRepositoryFactoryBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableJpaAuditing
@EnableJpaRepositories(repositoryFactoryBeanClass = DmRepositoryFactoryBean.class)
@EntityScan
@EnableAsync
public class DataManagerApplication {
    public static void main(String[] args) throws Exception {
        SpringApplication.run(DataManagerApplication.class, args);
    }

}
