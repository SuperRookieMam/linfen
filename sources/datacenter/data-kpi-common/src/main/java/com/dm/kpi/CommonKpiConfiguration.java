package com.dm.kpi;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EntityScan(basePackages = { "com.dm.kpi" })
@EnableJpaRepositories(basePackages = { "com.dm.kpi" })
@ComponentScan(basePackages = { "com.dm.kpi" })
public class CommonKpiConfiguration {

}
