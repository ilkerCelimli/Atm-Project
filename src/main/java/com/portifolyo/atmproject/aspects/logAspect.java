package com.portifolyo.atmproject.aspects;

import com.portifolyo.atmproject.annonations.Log;
import com.portifolyo.atmproject.entity.BaseEntity;
import com.portifolyo.atmproject.services.impl.BaseServices;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
@Aspect
public class logAspect {

    private Logger logger;

    @AfterReturning(pointcut = "@annotation(com.portifolyo.atmproject.annonations.Log)",returning = "returnObject")
    public void afterReturning(JoinPoint jp , Object returnObject) {

        logger = LoggerFactory.getLogger(jp.getThis().getClass());
        Mono<BaseEntity> mono = (Mono<BaseEntity>) returnObject;
        BaseEntity entity = mono.block();
        logger.info("{} , {}",entity.toString(),entity.getId());
    }

    @AfterThrowing(pointcut = "@annotation(com.portifolyo.atmproject.annonations.Log)")
    public void afterThrowing(JoinPoint jp) throws Throwable {
        logger = LoggerFactory.getLogger(jp.getThis().getClass());
        BaseEntity base = (BaseEntity) jp.getThis();
        logger.error("Errors {}",base.toString());
    }

}
