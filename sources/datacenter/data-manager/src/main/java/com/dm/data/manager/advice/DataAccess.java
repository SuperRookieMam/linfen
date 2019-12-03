package com.dm.data.manager.advice;

import com.dm.data.manager.dto.AbstractRegionDto;
import com.dm.data.manager.exception.PermissionDeniedException;
import com.dm.security.core.userdetails.UserDetailsDto;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.annotation.Before;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * 这个切面用来过滤增改的数据权限
 *
 * @author LiDong
 *
 */
//@Aspect
//@Component
public class DataAccess {

    /**
     * 新增时判断是否为用户所在的地域，如果不是，返回403
     *
     * @param data
     */
    @Before("execution(public * com.dm.data.manager.service.impl.*.save(..)) && args(data)")
    public void beforeSaveCheck(AbstractRegionDto data) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetailsDto) {
            UserDetailsDto userDetails = (UserDetailsDto) principal;
            String regionCode = userDetails.getRegionCode();
            if (!StringUtils.startsWith(data.getRegionCode(), StringUtils.stripEnd(regionCode, "0"))) {
                throw new PermissionDeniedException();
            }
        }
    }

}
