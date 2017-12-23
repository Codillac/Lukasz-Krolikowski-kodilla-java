package com.codilla.patterns2.facade.api;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Aspect
@Component
public class OrderFacadeWatcher {
    private static final Logger LOGGER = LoggerFactory.getLogger(OrderFacadeWatcher.class);

    @Before("execution(* com.codilla.patterns2.facade.api.OrderFacade.processOrder(..)) && args(..,userId)")
    public void logStart(Long userId) {
        LOGGER.info("Starting order processing of the user with Id: " + userId);
    }

    @AfterReturning("execution(* com.codilla.patterns2.facade.api.OrderFacade.processOrder(..))")
    public void logEndSuccessful() {
        LOGGER.info("Processing order successful");
    }

    @AfterThrowing("execution(* com.codilla.patterns2.facade.api.OrderFacade.processOrder(..))")
    public void logEndThrowing() {
        LOGGER.info("Processing order ends with Error");
    }

    @Around("execution(* com.codilla.patterns2.facade.api.OrderFacade.processOrder(..))")
    public Object timeOfProcessingOrder(final ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Object result;
        try {
            BigDecimal startTime = BigDecimal.valueOf(System.currentTimeMillis());
            result = proceedingJoinPoint.proceed();
            BigDecimal endTime = BigDecimal.valueOf(System.currentTimeMillis());
            BigDecimal durationInSec = endTime.subtract(startTime);
            durationInSec = durationInSec.divide(BigDecimal.valueOf(1000));
            LOGGER.info("Processing order duration: " + durationInSec.toString() + " [s]");
        } catch (Throwable throwable) {
            LOGGER.error(throwable.getMessage());
            throw throwable;
        }
        return result;
    }
}
