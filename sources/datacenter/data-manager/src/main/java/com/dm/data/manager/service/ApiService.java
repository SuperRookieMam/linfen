package com.dm.data.manager.service;

import com.alibaba.fastjson.JSONObject;

import java.util.List;

public interface ApiService<T> {
    List<T> getByPatams(JSONObject jsonObject, Class<T> tClass);

    Long getCompare(Class<T> tClass);
}
