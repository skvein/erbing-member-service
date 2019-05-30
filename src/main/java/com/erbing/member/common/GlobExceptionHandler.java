package com.erbing.member.common;

import com.erbing.util.exception.BizException;
import com.erbing.util.exception.CommonsConstants;
import com.erbing.util.web.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class GlobExceptionHandler {

    @Pointcut("execution(public * com.erbing.*.controller.*.*(..))")
    public void webException(){}

    @Around("webException()")
    public ResponseResult handlerControllerMethod(ProceedingJoinPoint proceedingJoinPoint){
        ResponseResult resultBean;
        try {
            long startTime = System.currentTimeMillis();
            resultBean= (ResponseResult) proceedingJoinPoint.proceed();
            long endTime = System.currentTimeMillis();
            log.info("spent time ："+ (endTime - startTime) + "ms" );
        }catch (Throwable e){
            resultBean= handlerException(e);
        }
        return resultBean;
    }

    private ResponseResult<?> handlerException(Throwable throwable){
        ResponseResult<?> resultBean=null;
        if (throwable instanceof BizException){
            BizException exception = (BizException)throwable;
            resultBean = new ResponseResult<>(exception.getBizCode());
        }else {
            log.error("UNKNOWN_EXCEPTION：",throwable);
            resultBean = new ResponseResult(CommonsConstants.SYSTEM_ERROR);
        }
        return resultBean;
    }
}
