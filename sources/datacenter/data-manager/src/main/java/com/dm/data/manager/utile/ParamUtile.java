package com.dm.data.manager.utile;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.query.QueryUtils;
import org.springframework.util.ObjectUtils;

import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ParamUtile {

    private final static String DISJUNCTION = "disjunction";
    private final static String CONJUNCTION = "conjunction";

    /**
     * @param condition 条件 ：{fieldname_conditionType: value, disjunction:
     *                  [{这是一个condition}] conjunction: [{这是一个condition}]}
     *                  fieldname_conditionType 是根据filename基础字段 和 conditionType and
     *                  连接的 如果需要or 连接，disjunction 数组里面构建多个condition 如果是一个符合条件的and 连接
     *                  conjunction 数组里面构建多个condition 注意:
     *                  此条件解析一定是先把所有的and条件包括conjunction多and条件 构建为一个 predict 再与
     *                  disjunction 构建的多or条件再or
     * @param builder   不解释
     * @param root      不解释
     * @author yhl
     */
    public static Predicate analysis(JSONObject condition, CriteriaBuilder builder, Root<?> root) {
        if (ObjectUtils.isEmpty(condition)) {
            return null;
        } else {
            return toPredicate(condition, builder, root);
        }
    }

    /**
     * 解析
     */
    private static Predicate toPredicate(JSONObject condition, CriteriaBuilder builder, Root<?> root) {
        Iterator<String> iterator = condition.keySet().iterator();
        List<Predicate> list = new ArrayList<>();
        Predicate conPredicate = null;
        Predicate disPredicate = null;
        Predicate returnPredicate = null;
        while (iterator.hasNext()) {
            String key = iterator.next();
            if (key.equals(DISJUNCTION)) {
                JSONArray disArray = condition.getJSONArray(key);
                List<Predicate> dislist = new ArrayList<>();
                for (int i = 0; i < disArray.size(); i++) {
                    Predicate tempPredicate = toPredicate(disArray.getJSONObject(i), builder, root);
                    if (!ObjectUtils.isEmpty(tempPredicate))
                        dislist.add(tempPredicate);
                }
                disPredicate = dislist.isEmpty() ? null : builder.or(dislist.toArray(new Predicate[0]));
            } else if (key.equals(CONJUNCTION)) {
                JSONArray disArray = condition.getJSONArray(key);
                List<Predicate> conlist = new ArrayList<>();
                for (int i = 0; i < disArray.size(); i++) {
                    Predicate tempPredicate = toPredicate(disArray.getJSONObject(i), builder, root);
                    if (!ObjectUtils.isEmpty(tempPredicate))
                        conlist.add(tempPredicate);
                }
                conPredicate = conlist.isEmpty() ? null : builder.and(conlist.toArray(new Predicate[0]));
            } else {
                list.add(BasicBuilder.getPredicate(builder, root, key, condition.get(key)));
            }
        }
        if (!list.isEmpty()) {
            returnPredicate = builder.and(list.toArray(new Predicate[0]));
        }
        if (!ObjectUtils.isEmpty(conPredicate)) {
            returnPredicate = ObjectUtils.isEmpty(returnPredicate) ? conPredicate
                    : builder.and(returnPredicate, conPredicate);
        }
        if (!ObjectUtils.isEmpty(disPredicate)) {
            returnPredicate = ObjectUtils.isEmpty(returnPredicate) ? disPredicate
                    : builder.or(returnPredicate, disPredicate);
        }
        return returnPredicate;
    }

    public static void groupBy(CriteriaQuery query, Root root, String... fieldNames) {
        if (fieldNames != null) {
            List<Path> paths = new ArrayList<>();
            for (String field : fieldNames) {
                paths.add(PathUtil.getPath(root, field, JoinType.LEFT));
            }
            query.groupBy(paths);
        }
    }

    /**
     * 获取排序 sort 的格式为 如果有多个排序字段为" fieldName:desc"," fieldName:asc"
     * 注意这个值做了单一属性的排序，多字段
     */
    public static void orderby(CriteriaBuilder builder, CriteriaQuery query, Root root, String... sorts) {
        if (sorts != null) {
            List<Sort.Order> list = new ArrayList<>();
            for (String sort : sorts) {
                String[] sor = sort.split(":");
                if ("desc".equalsIgnoreCase(sor[1])) {
                    list.add(new Sort.Order(Sort.Direction.DESC, sor[0]));
                } else {
                    list.add(new Sort.Order(Sort.Direction.ASC, sor[0]));
                }
            }
            query.orderBy(QueryUtils.toOrders(Sort.by(list), root, builder));
        }
    }

    public static JSONObject paresjson(String jsonStr) {
        System.out.println(jsonStr);
        if (ObjectUtils.isEmpty(jsonStr)) {
            return new JSONObject();
        }
        return JSON.parseObject(jsonStr);
    }

}
