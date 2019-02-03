package com.drools.config.aspect;

import com.alibaba.fastjson.JSON;
import com.drools.util.restful.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * 描述：
 * CLASSPATH: com.drools.config.aspect.WebLogAspect
 * VERSION:   1.0
 * Created by gaowei
 * DATE: 2017/11/16
 */
@Aspect
@Slf4j
@Order(5)
@Component
public class LogAspectController {
    //统计请求的处理时间
    private ThreadLocal<Long> startTime = new ThreadLocal<>();

    @Pointcut("execution(public * com.drools.controller..*.*(..))")
    public void webLog() {
        // do something
    }

    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint) {
        //开始时间
        startTime.set(System.currentTimeMillis());
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        //请求路径
        String requestURL = request.getRequestURL().toString();
        //请求参数
        String args = Arrays.toString(joinPoint.getArgs());
        //方法名称
        String methodName = joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName();
        // 记录下请求内容
        log.info("{URL:'{}',HTTP_METHOD:'{}',IP:'{}',CLASS_METHOD:'{}',ARGS:'{}'}",
                requestURL,
                request.getMethod(),
                request.getRemoteAddr(),
                methodName,
                args);

    }

    @AfterReturning(returning = "ret", pointcut = "webLog()")
    public void doAfterReturning(Object ret) {
        String result;
        //特殊处理data使其成为String
        if (ret instanceof ResponseResult) {
            ResponseResult orgRet = (ResponseResult) ret;
            result = JSON.toJSONString(ResponseResult.builder()
                    .code(orgRet.getCode())
                    .message(orgRet.getMessage())
                    .data(JSON.toJSONString(orgRet.getData()))
                    .build());
        } else {
            result = JSON.toJSONString(ret);
        }
        //所用时间
        String spendTime = (System.currentTimeMillis() - startTime.get()) + "ms";
        startTime.remove();
        // 处理完请求，返回内容
        log.info("RESPONSE:'{}',SPEND_TIME:'{}'}",
                result,
                spendTime);
    }
}
