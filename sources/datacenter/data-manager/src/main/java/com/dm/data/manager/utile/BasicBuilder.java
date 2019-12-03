package com.dm.data.manager.utile;

import org.springframework.util.Assert;

import javax.persistence.criteria.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.TimeZone;

public class BasicBuilder {
    /**
     * 这个事前端传过来的key 包含eq等方法
     */
    public static Predicate getPredicate(CriteriaBuilder builder, Root<?> root, String key, Object value) {
        int index = key.lastIndexOf("_");
        String key1 = key.substring(0, index);
        int type = Integer.parseInt(key.substring(index + 1));
        return index > -1 ? getPredicate(builder, root, key1, ConditionEnum.valueOf(type), value, JoinType.LEFT) : null;
    }

    public static Predicate getPredicate(CriteriaBuilder builder, Root<?> root, String key, String type, Object value) {
        return getPredicate(builder, root, key, type, value, JoinType.LEFT);
    }

    public static Predicate getPredicate(CriteriaBuilder builder, Root<?> root, String key, String type, Object value,
            JoinType joinType) {
        Predicate predicate = null;
        switch (type) {
        case "eq":
            predicate = addEq(builder, root, key, value, joinType);
            break;
        case "notEq":
            predicate = addNotEq(builder, root, key, value, joinType);
            break;
        case "like":
            predicate = addLike(builder, root, key, value, joinType);
            break;
        case "notLike":
            predicate = addNotLike(builder, root, key, value, joinType);
            break;
        case "lt":
            predicate = addLt(builder, root, key, value, joinType);
            break;
        case "le":
            predicate = addLe(builder, root, key, value, joinType);
            break;
        case "gt":
            predicate = addGt(builder, root, key, value, joinType);
            break;
        case "ge":
            predicate = addGe(builder, root, key, value, joinType);
            break;
        case "in":
            predicate = addIn(builder, root, key, joinType, value);
            break;
        case "notIn":
            predicate = addNotIn(builder, root, key, joinType, value);
            break;
        case "isNull":
            predicate = addIsNull(builder, root, key, joinType);
            break;
        case "notNull":
            predicate = addIsNotNull(builder, root, key, joinType);
            break;
        case "isMember":
            predicate = addIsMember(builder, root, key, joinType, value);
            break;
        case "isNotMember":
            predicate = addIsNotMember(builder, root, key, joinType, value);
            break;
        default:
            break;
        }
        return predicate;
    }

    private static Predicate addLike(CriteriaBuilder builder, Root<?> root, String key, Object value,
            JoinType joinType) {
        return builder.like(PathUtil.getPath(root, key, joinType), "%/" + value + "%", '/');
    }

    private static Predicate addNotLike(CriteriaBuilder builder, Root<?> root, String key, Object value,
            JoinType joinType) {
        return builder.notLike(PathUtil.getPath(root, key, joinType), "%/" + value + "%", '/');
    }

    private static Predicate addLt(CriteriaBuilder builder, Root<?> root, String key, Object value, JoinType joinType) {
        Path path = PathUtil.getPath(root, key, joinType);
        return Number.class.isAssignableFrom(path.getJavaType()) ? builder.lt(path, (Number) getComparable(path, value))
                : builder.lessThan(path, getComparable(path, value));
    }

    private static Predicate addLe(CriteriaBuilder builder, Root<?> root, String key, Object value, JoinType joinType) {
        Path path = PathUtil.getPath(root, key, joinType);
        return Number.class.isAssignableFrom(path.getJavaType()) ? builder.le(path, (Number) getComparable(path, value))
                : builder.lessThanOrEqualTo(path, getComparable(path, value));
    }

    private static Predicate addGt(CriteriaBuilder builder, Root<?> root, String key, Object value, JoinType joinType) {
        Path path = PathUtil.getPath(root, key, joinType);
        return Number.class.isAssignableFrom(path.getJavaType()) ? builder.gt(path, (Number) getComparable(path, value))
                : builder.greaterThan(path, getComparable(path, value));
    }

    private static Predicate addGe(CriteriaBuilder builder, Root<?> root, String key, Object value, JoinType joinType) {
        Path path = PathUtil.getPath(root, key, joinType);
        return path.getJavaType().getSimpleName().contains("Date")
                ? builder.ge(path, (Number) getComparable(path, value))
                : builder.greaterThanOrEqualTo(path, getComparable(path, value));
    }

    private static Predicate addEq(CriteriaBuilder builder, Root<?> root, String key, Object value, JoinType joinType) {
        Path path = PathUtil.getPath(root, key, joinType);
        return builder.equal(path, getComparable(path, value));
    }

    private static Predicate addNotEq(CriteriaBuilder builder, Root<?> root, String key, Object value,
            JoinType joinType) {
        Path path = PathUtil.getPath(root, key, joinType);
        return builder.notEqual(path, getComparable(path, value));
    }

    private static Predicate addIn(CriteriaBuilder builder, Root<?> root, String key, JoinType joinType,
            Object... value) {
        Path path = PathUtil.getPath(root, key, joinType);
        CriteriaBuilder.In in = builder.in(path);
        for (int i = 0; i < value.length; i++) {
            in.value(value[i]);
        }
        return in;
    }

    private static Predicate addNotIn(CriteriaBuilder builder, Root<?> root, String key, JoinType joinType,
            Object... value) {
        Path path = PathUtil.getPath(root, key, joinType);
        CriteriaBuilder.In inn = builder.in(path);
        for (int i = 0; i < value.length; i++) {
            inn.value(value[i]);
        }
        return builder.not(inn);
    }

    private static Predicate addIsNull(CriteriaBuilder builder, Root<?> root, String key, JoinType joinType) {
        return builder.isNull(PathUtil.getPath(root, key, joinType));
    }

    private static Predicate addIsNotNull(CriteriaBuilder builder, Root<?> root, String key, JoinType joinType) {
        return builder.isNotNull(PathUtil.getPath(root, key, joinType));
    }

    private static Predicate addIsMember(CriteriaBuilder builder, Root<?> root, String key, JoinType joinType,
            Object value) {
        return builder.isMember(value, PathUtil.getPath(root, key, joinType));
    }

    private static Predicate addIsNotMember(CriteriaBuilder builder, Root<?> root, String key, JoinType joinType,
            Object value) {
        return builder.isNotMember(value, PathUtil.getPath(root, key, joinType));
    }

    /**
     * 根据path 回对应的时间类型
     */
    public static Comparable getComparable(Path path, Object value) {
        Class timeclass = path.getJavaType();// 如果是基本的数据类型JVM会自动封装所以也会是个Comparable
        try {
            if (String.class.isAssignableFrom(timeclass)) {
                return value.toString();
            } else if (Date.class.isAssignableFrom(timeclass)) {
                return new SimpleDateFormat(getPantter(value.toString())).parse(value.toString());
            } else if (LocalDate.class.isAssignableFrom(timeclass)) {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern(getPantter(value.toString()));
                return LocalDate.parse(value.toString(), formatter);
            } else if (LocalDateTime.class.isAssignableFrom(timeclass)) {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern(getPantter(value.toString()));
                return LocalDateTime.parse(value.toString(), formatter);
            } else if (ZonedDateTime.class.isAssignableFrom(timeclass)) {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern(getPantter(value.toString()));
                LocalDateTime localDateTime = LocalDateTime.parse(value.toString(), formatter);
                ZoneId zone = ZoneId.of(TimeZone.getDefault().getID());
                return localDateTime.atZone(zone);
            } else if (LocalTime.class.isAssignableFrom(timeclass)) {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern(getPantter(value.toString()));
                return LocalDateTime.parse(value.toString(), formatter);
            } else if (Integer.class.isAssignableFrom(timeclass)) {
                return Integer.valueOf(value.toString());
            } else if (Long.class.isAssignableFrom(timeclass)) {
                return Long.valueOf(value.toString());
            } else if (Double.class.isAssignableFrom(timeclass)) {
                return Double.valueOf(value.toString());
            } else if (Float.class.isAssignableFrom(timeclass)) {
                return Float.valueOf(value.toString());
            } else {
                return (Comparable) value;
            }
        } catch (ParseException e) {
            e.printStackTrace();
            throw new RuntimeException("时间解析错误");
        }
    }

    /**
     * @param value 时间字符串 根据时间字符串解析出时间的Pantter
     */
    private static String getPantter(String value) {
        if (value.matches("\\d{4}-\\d{2}-\\d{2}\\s+\\d{2}:\\d{2}:\\d{2}")) {
            return "yyyy-MM-dd HH:mm:ss";
        } else if (value.matches("\\d{4}-\\d{2}-\\d{2}")) {
            return "yyyy-MM-dd";
        } else if (value.matches("\\d{2}:\\d{2}:\\d{2}")) {
            return "HH:mm:ss";
        } else if (value.matches("\\d{4}-\\d{2}-\\d{2}T\\d{2}:\\d{2}:\\d{2}\\+\\d{2}:\\d{2}\\[\\w+/\\w+\\]")) {
            return "yyyy-MM-dd HH:mm:ss";
        } else if (value.matches("\\d{4}-\\d{2}-\\d{2}T\\d{2}:\\d{2}:\\d{2}\\+\\d{2}:\\d{2}")) {
            return "yyyy-MM-dd HH:mm:ss";
        } else {
            Assert.isNull(null, "时间格式暂不支持");
            return null;
        }
    }
}
