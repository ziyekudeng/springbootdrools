package com.drools.config.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import static com.alibaba.fastjson.JSON.toJSONString;

/**
 * 创建时间：2018/一月/06
 * <p>
 * 类名：LogAspectService
 * 描述：日志记录 AOP 工具类，环绕通知
 */
@Aspect
@Component
@Slf4j
public class LogAspectService {
    /**
     * 环绕通知，决定真实的方法是否执行，而且必须有返回值。同时在所拦截方法的前后执行一段逻辑。
     *
     * @param pjp 连接点
     * @return 执行方法的返回值
     * @throws Throwable 抛出异常
     */
    @Around("execution(* com.drools.service..*(..))")
    public Object aroundService(ProceedingJoinPoint pjp) throws Throwable {
        // 开始调用时间
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        String className = pjp.getTarget().getClass().getName();
        // 获得方法名
        String methodName = pjp.getSignature().getName();
        // 获得参数列表
        Object[] args = pjp.getArgs();
        // 执行完方法的返回值：调用 proceed() 方法，就会触发切入点方法执行
        Object result = pjp.proceed();
        stopWatch.stop();
        log.info("{" +
                        "\"类名\":\"{}\"," +
                        "\"方法名\":\"{}\"," +
                        "\"入参\":{}," +
                        "\"出参\":{}," +
                        "\"花费时间\":{}" +
                        "}",
                className,
                methodName,
                toJSONString(toJSONString(args)),
                toJSONString(toJSONString(result)),
                stopWatch.getTotalTimeMillis());
        return result;
    }
}