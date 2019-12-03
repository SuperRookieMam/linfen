package com.dm.data.manager.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.dm.data.manager.entity.core.AbstractCurrency;
import com.dm.data.manager.service.ApiService;
import com.dm.data.manager.utile.ParamUtile;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ApiServiceImpl<T> implements ApiService<T> {

    @Autowired
    private EntityManager entityManager;

    /**
     * { pageNum: 1 pageSize:10; sort: ["fieldName:desc"]; groupby:["fieldName"];
     * condition: { 这是一个condition fieldName_1: '', disjunction: [{这是一个condition}],
     * conjunction: [{这是一个condition}]}, } }
     */
    @Override
    public List<T> getByPatams(JSONObject jsonObject, Class<T> tClass) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery(tClass);
        Root<T> root = query.from(tClass);
        Predicate predicate = null;
        // 添加自己可见区域的regioncode,并且过滤前端穿过来的空值
        String regionCode = null;
        addRegincode(regionCode, jsonObject);
        predicate = ParamUtile.analysis(jsonObject.getJSONObject("condition"), builder, root);
        if (!ObjectUtils.isEmpty(predicate)) {
            query.where(predicate);
        }
        if (jsonObject.containsKey("sort")) {
            ParamUtile.orderby(builder, query, root, jsonObject.getJSONArray("sort").toArray(new String[0]));
        }
        if (jsonObject.containsKey("groupby")) {
            ParamUtile.groupBy(query, root, jsonObject.getJSONArray("groupby").toArray(new String[0]));
        }
        List<T> list = entityManager.createQuery(query).getResultList();

        if (!ObjectUtils.isEmpty(regionCode)) {
            // 过滤
            list = list.stream().filter(ele -> {
                String code = ((AbstractCurrency) ele).getRegionCode();
                if (code.startsWith(StringUtils.stripEnd(regionCode, "0"))) {
                    return true;
                }
                return false;
            }).collect(Collectors.toList());
        }
        return list;
    }

    // 获取今年总数和往年总数对比
    @Override
    public Long getCompare(Class<T> tClass) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Long> query = builder.createQuery(Long.class);
        CriteriaQuery<Long> query1 = builder.createQuery(Long.class);
        Root<T> root = query.from(tClass);
        Root<T> root1 = query1.from(tClass);
        ZonedDateTime zonedDateTime = ZonedDateTime.now(ZoneId.of("Asia/Shanghai"));
        LocalDate localDate = LocalDate.now();
        ZonedDateTime zonedDateTime1 = ZonedDateTime.of(localDate.getYear(), 1, 1, 0, 0, 0, 0, ZoneId.of("Asia/Shanghai"));
        query.select(builder.count(root));
        query1.select(builder.count(root1));
        query.where(builder.lessThan(root.get("createDate"), zonedDateTime));
        query1.where(builder.lessThan(root1.get("createDate"), zonedDateTime1));
        TypedQuery<Long> typedQuery = entityManager.createQuery(query);
        TypedQuery<Long> typedQuery1 = entityManager.createQuery(query1);
        // 今年的总条数
        List<Long> totals = typedQuery.getResultList();
        long total = 0L;
        Long element = 0l;
        for (Iterator var4 = totals.iterator(); var4.hasNext(); total += element == null ? 0L : element) {
            element = (Long) var4.next();
        }

        List<Long> totals1 = typedQuery1.getResultList();
        long total1 = 0L;
        Long element1 = 0l;
        for (Iterator var4 = totals1.iterator(); var4.hasNext(); total1 += element1 == null ? 0L : element1) {
            element1 = (Long) var4.next();
        }
        return element - element1;
    }

    private void addRegincode(final String regionCode, final JSONObject jsonObject) {
        JSONObject condition = jsonObject.getJSONObject("condition");
        if (!ObjectUtils.isEmpty(condition)) {
            JSONObject temp = new JSONObject();
            Set<String> set = condition.keySet();
            Iterator<String> iterator = set.iterator();
            while (iterator.hasNext()) {
                String key = iterator.next();
                if (!ObjectUtils.isEmpty(condition.get(key)) && StringUtils.isNotBlank(condition.getString(key))) {
                    if (key.contains("regionCode")) {
                        temp.put(key, StringUtils.stripEnd(condition.getString(key), "0"));
//						regionCode = condition.getString(key);
                    } else {
                        temp.put(key, condition.get(key));
                    }
                }
            }
            condition = temp;
            jsonObject.put("condition", condition);
        }
    }
}
