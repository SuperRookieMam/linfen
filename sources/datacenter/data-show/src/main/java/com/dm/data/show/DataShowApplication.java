package com.dm.data.show;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.dm.kpi.EnableCommonKpi;

@SpringBootApplication
@EnableJpaAuditing
@EnableJpaRepositories
@EntityScan
//@EnableCaching
@EnableCommonKpi // 引用公共kpi模块
public class DataShowApplication {
	public static void main(String[] args) throws Exception {
		SpringApplication.run(DataShowApplication.class, args);
	}
}
