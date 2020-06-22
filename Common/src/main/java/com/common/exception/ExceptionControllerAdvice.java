package com.common.exception;

import com.common.utils.R;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/*
	集中处理所有异常
 */
@Slf4j
public class ExceptionControllerAdvice {

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public R handlerException(MethodArgumentNotValidException e) {
        log.error("数据校验出现问题{}，异常类型:{}", e.getMessage(), e.getClass());
        BindingResult bindResult = e.getBindingResult();

        Map<String, String> resultMap = new HashMap<>();
        bindResult.getFieldErrors().forEach((fieldError) -> {
            resultMap.put(fieldError.getField(), fieldError.getDefaultMessage());
        });
//		return R.error(400,"数据校验出现问题").put("data",resultMap);
        return R.error(BizCodeEnume.VAILD_EXCEPTION.getCode(), BizCodeEnume.VAILD_EXCEPTION.getMsg()).put("data", resultMap);
    }

//    @ExceptionHandler(value = Throwable.class)
//    public R handlerException(Throwable throwable) {
//        return R.error(BizCodeEnume.UNKNOW_EXCEPTION.getCode(), BizCodeEnume.UNKNOW_EXCEPTION.getMsg());
//    }
}


