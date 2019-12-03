package com.dm.data.show.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR , reason = "未知错误，请联系管理员")
public class AllException extends RuntimeException {

	private static final long serialVersionUID = -2998423583144479674L;

}
