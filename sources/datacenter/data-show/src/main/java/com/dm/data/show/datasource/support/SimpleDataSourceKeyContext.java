package com.dm.data.show.datasource.support;

import com.dm.data.show.datasource.DataSourceKeyContext;

public class SimpleDataSourceKeyContext implements DataSourceKeyContext {

	private final String key;

	public SimpleDataSourceKeyContext(String key) {
		super();
		this.key = key;
	}

	@Override
	public String getKey() {
		return key;
	}

}
