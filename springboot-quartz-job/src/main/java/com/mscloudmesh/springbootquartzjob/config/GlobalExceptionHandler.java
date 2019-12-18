package com.mscloudmesh.springbootquartzjob.config;

import com.mscloudmesh.springbootquartzjob.common.constant.ApiException;
import com.mscloudmesh.springbootquartzjob.common.constant.ApiResultEnum;
import com.mscloudmesh.springbootquartzjob.common.constant.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


import java.io.IOException;

/**
 * 全局异常捕获
 * @author rstyro
 *
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

	private Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
	
	@ExceptionHandler(Exception.class)
	public Result exceptionHandler(Exception ex) {
		logger.info(ex.getMessage(), ex);
		if(ex instanceof ApiException){
			return Result.error(((ApiException) ex).getStatus(),ex.getMessage());
		}else if(ex instanceof NullPointerException){
			return Result.error(ApiResultEnum.ERROR_NULL);
		}else if(ex instanceof ClassCastException){
			return Result.error(ApiResultEnum.ERROR_CLASS_CAST);
		}else if(ex instanceof IOException){
			return Result.error(ApiResultEnum.ERROR_IO);
		}else if(ex instanceof HttpRequestMethodNotSupportedException){
			return Result.error(ApiResultEnum.ERROR_MOTHODNOTSUPPORT);
		}else if(ex instanceof RuntimeException){
			return Result.error(ApiResultEnum.ERROR_RUNTION);
		}
		return Result.error(ApiResultEnum.FAILED);
	}
	
}
