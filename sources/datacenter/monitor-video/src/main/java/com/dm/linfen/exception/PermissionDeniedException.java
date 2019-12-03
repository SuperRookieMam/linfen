package com.dm.linfen.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.FORBIDDEN, reason = "权限不足")
public class PermissionDeniedException extends RuntimeException {
	private static final long serialVersionUID = -5759837905625582106L;
}
