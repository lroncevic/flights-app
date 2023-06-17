package com.lukaroncevic.flightsapp.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class DashboardServiceAspect {

    Logger logger = LoggerFactory.getLogger(DashboardServiceAspect.class);

    @Before("execution(* com.lukaroncevic.flightsapp.services.DashboardService.getDashboard(..))")
    public void beforeDashboardServiceGetDashboard(JoinPoint joinPoint){

        logger.info("before dashboard service get dashboard: " + joinPoint.getTarget().getClass().getSimpleName());

    }
}
