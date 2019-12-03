package com.dm.data.show.config;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;

import com.dm.data.show.datasource.ContextSelectorRoutingDataSource;
import com.dm.data.show.datasource.DataSourceKeyContext;
import com.dm.data.show.datasource.support.SimpleDataSourceKeyContext;

@Configuration
@EnableAutoConfiguration(exclude = { DataSourceAutoConfiguration.class })
public class DataSourceConfig {

	/**
	 * 动态数据源，可以根据一定的规则选择要使用的数据源
	 * 
	 * @return
	 */
	@Bean
	@Primary
	public DataSource dataSource() {
		ContextSelectorRoutingDataSource dataSource = new ContextSelectorRoutingDataSource();
		dataSource.setDefaultTargetDataSource(primaryDataSource());
		Map<Object, Object> targetDataSources = new HashMap<>();
		targetDataSources.put("primary", primaryDataSource());
		dataSource.setTargetDataSources(targetDataSources);
		dataSource.setDataSourceKeyContext(keyContext(null));
		return dataSource;
	}

	@Bean("primary")
	@ConfigurationProperties(prefix = "spring.datasource")
	public DataSource primaryDataSource() {
		return DataSourceBuilder.create().build();
	}

	@Bean
	@Scope(value = "request", proxyMode = ScopedProxyMode.INTERFACES)
	public DataSourceKeyContext keyContext(@Value("#{request.getParameter('dataSource')}") String key) {
		return new SimpleDataSourceKeyContext(key);
	}
}
