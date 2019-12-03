package com.dm.data.show.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR , reason = "JDBC错误")
public class MyJDBCException extends RuntimeException {

	private static final long serialVersionUID = -1934437522669746481L;

}
