package com.dm.linfen.collection;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.dm.kpi.EnableCommonKpi;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
@EnableJpaRepositories
@EnableJpaAuditing
@ComponentScan
@EntityScan
@EnableCommonKpi
public class CollectionApplication {
	public static void main(String[] args) throws Exception {
		SpringApplication.run(CollectionApplication.class, args);
	}
}
