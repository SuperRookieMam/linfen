package com.dm.data.show.aspect;

import com.dm.kpi.core.dto.AbstractBaseIndexDto;
import com.dm.data.show.exception.AllException;
import com.dm.data.show.exception.MyJDBCException;
import com.dm.data.show.exception.PermissionDeniedException;
import com.dm.security.core.userdetails.UserDetailsDto;


import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.hibernate.JDBCException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectConfig {

	@Pointcut("execution(public * com.dm.data.show.service.impl.*.*(..))")
	public void addAdvice() {
	}

	@AfterThrowing(throwing = "ex" , value = "addAdvice()")
	public void mythorws(Throwable ex) {
		if(ex != null) {
			if(ex.getCause() instanceof JDBCException) {
				throw new MyJDBCException();
			}else if(ex.getCause() instanceof Exception) {
				throw new AllException();
			}
		}
	}
	
//	@Before("addAdvice()")
	public void interceptor(JoinPoint pjp) {
		Object[] args = pjp.getArgs();
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof UserDetailsDto) {
			UserDetailsDto userDetails = (UserDetailsDto) principal;
			String regionCodeSys = userDetails.getRegionCode();
			boolean flag = true;
			for (int i = 0; i < args.length; i++) {
				if (AbstractBaseIndexDto.class.isAssignableFrom(args[i].getClass())) {
					AbstractBaseIndexDto<?> abstractBaseIndexDto = (AbstractBaseIndexDto<?>) args[i];
					String regincode = abstractBaseIndexDto.getRegionCode();
					flag = false;
					if (!StringUtils.startsWith(regincode, StringUtils.stripEnd(regionCodeSys, "0"))) {
						throw new PermissionDeniedException();
					}
				}
			}
			if (flag) {
				throw new PermissionDeniedException();
			}
		}

	}

}
