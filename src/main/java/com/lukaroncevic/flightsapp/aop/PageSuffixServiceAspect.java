package com.lukaroncevic.flightsapp.aop;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class PageSuffixServiceAspect {

    Logger logger = LoggerFactory.getLogger(PageSuffixServiceAspect.class);

    @AfterReturning(value = "execution(* com.lukaroncevic.flightsapp.services.PageSuffixService.getSuffix(..))",
            returning = "result")
    public void afterPageSuffixServiceGetSuffix(String result){

        logger.error("after suffix service get suffix: " + result);

    }
}
