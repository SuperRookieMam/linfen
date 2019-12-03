package com.dm.data.show.datasource;

/**
 * 数据源Key容器。<br>
 * 
 * 这个容器存储的是数据源key.它应该是一个thread-local的实例
 * 
 * @author lidong
 *
 */
public interface DataSourceKeyContext {
	public String getKey();
}
