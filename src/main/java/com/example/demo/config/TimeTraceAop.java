package com.example.demo.config;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * packageName : com.example.demo.config
 * fileName : TimeTraceAop
 * author : isbn8
 * date : 2022-02-05
 * description :
 * ===========================================================
 * DATE                  AUTHOR                  NOTE
 * -----------------------------------------------------------
 * 2022-02-05              isbn8             최초 생성
 */

@Component
@Aspect
@Slf4j
public class TimeTraceAop {
    @Around("execution(* com.example.demo.boarder.service..*(..))")
    public Object execute(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        log.info(" *** SERVICE START : {} ",joinPoint.toString());
        try {
            return joinPoint.proceed();
        } finally {
            long finish = System.currentTimeMillis();
            long timeMs = finish - start;

            log.info(" *** SERVICE END : {} , time : {} ms",joinPoint.toString(), timeMs);
        }
    }
}
