package com.kodilla.spring.reader;

import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

import java.time.LocalDate;
import java.util.concurrent.locks.Condition;

public class IfDayIsOddCondition implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        return LocalDate.now().getDayOfMonth() % 2 != 0;
    }
}
