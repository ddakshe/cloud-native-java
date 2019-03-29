package com.kennen.cloudnativejava.config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Aspect
public class LogginAroundAspect {
    Logger logger = LoggerFactory.getLogger(LogginAroundAspect.class);


    @Around("execution(* com.kennen.cloudnativejava.service.CustomerService.*(..))")
    public Object log(ProceedingJoinPoint joinPoint) throws Throwable {
        LocalDateTime start = LocalDateTime.now();
        Throwable toThrow = null;

        Object returnValue = null;

        try {
            returnValue = joinPoint.proceed();
        } catch (Throwable throwable) {
            toThrow = throwable;
        }

        LocalDateTime stop = LocalDateTime.now();

        logger.info("starting @ " + start.toString());
        logger.info("finishing @ " + stop.toString()  + " with duration " + stop.minusNanos(start.getNano()).getNano());

        if ( null != toThrow)
            throw toThrow;

        return returnValue;

    }
}
