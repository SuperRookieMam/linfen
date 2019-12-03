package com.dm.kpi;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.context.annotation.Import;

/**
 * 启用工共的kpi模块
 * 
 * @author LiDong
 *
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import(CommonKpiConfiguration.class)
public @interface EnableCommonKpi {

}
