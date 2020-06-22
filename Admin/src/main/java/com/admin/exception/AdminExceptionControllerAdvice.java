package com.admin.exception;

import com.common.exception.BizCodeEnume;
import com.common.exception.ExceptionControllerAdvice;
import com.common.utils.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

/*
	集中处理所有异常
 */

//@ResponseBody
//@ControllerAdvice(basePackages = "com.gulimall.product.controller")
@Slf4j
@RestControllerAdvice(basePackages = "com.admin.controller")
public class AdminExceptionControllerAdvice extends ExceptionControllerAdvice {

}


