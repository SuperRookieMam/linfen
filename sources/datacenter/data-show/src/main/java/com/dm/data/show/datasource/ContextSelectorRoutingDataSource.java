package com.dm.data.show.datasource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ContextSelectorRoutingDataSource extends AbstractRoutingDataSource {

	private DataSourceKeyContext dataSourceKeyContext;

	public void setDataSourceKeyContext(DataSourceKeyContext dataSourceKeyContext) {
		this.dataSourceKeyContext = dataSourceKeyContext;
	}

	@Override
	protected Object determineCurrentLookupKey() {
		try {
			String key = dataSourceKeyContext.getKey();
			log.debug(String.format("Get key from Context %s, The key is %s", dataSourceKeyContext, key));
			return key;
		} catch (Exception e) {
			log.debug("Get key from Context error, use default value of null.");
			return null;
		}
	}

}
