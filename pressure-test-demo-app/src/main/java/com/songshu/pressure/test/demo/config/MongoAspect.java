package com.songshu.pressure.test.demo.config;

import com.songshu.pressure.test.demo.plugin.context.MarkContext;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author 鼠笑天
 * @date 2019/12/29
 */
@Component
@Aspect
public class MongoAspect {

    @Pointcut("execution(public * org.springframework.data.mongodb.core.MongoTemplate.insert(*,*))")
    public void mongoInsertPointCut() {}

    @Around("mongoInsertPointCut()")
    public Object mongoInsertPointCutAround(ProceedingJoinPoint point) throws Throwable {
        Object[] args = point.getArgs();
        Object mark = MarkContext.PRESSUER_TEST_MARK.get();
        if (mark != null) {
            args[1] = (String)args[1] + "_test";
        }
        Object result = point.proceed(args);
        return result;

    }

    @Pointcut("execution(public * org.springframework.data.mongodb.core.MongoTemplate.find*(*,*,*))")
    public void mongoQueryPointCut() {}

    @Around("mongoQueryPointCut()")
    public Object mongoQueryPointCutAround(ProceedingJoinPoint point) throws Throwable {
        Object[] args = point.getArgs();
        Object mark = MarkContext.PRESSUER_TEST_MARK.get();
        if (mark != null) {
            args[2] = (String)args[2] + "_test";
        }
        Object result = point.proceed(args);
        return result;

    }

    @Pointcut("execution(public * org.springframework.data.mongodb.core.MongoTemplate.update(*))")
    // @Pointcut("within(org.springframework.data.mongodb.core.MongoTemplate)")
    public void mongoUpdatePointCut() {}

    @Around("mongoUpdatePointCut()")
    public Object mongoUpdatePointCutAround(ProceedingJoinPoint point) throws Throwable {
        Object[] args = point.getArgs();
        args[1] = (String)args[1] + "_test";
        Object result = point.proceed(args);
        return result;

    }

    @Pointcut("execution(* com.songshu.pressure.test.demo.controller.*.*(..))")
    public void aaa() {}

    @Around("aaa()")
    public Object aa(ProceedingJoinPoint point) throws Throwable {
        Object result = point.proceed();
        return result;

    }

    // @Autowired
    // WebApplicationContext context;
    //
    // @Around("execution(* com.mongo.basic..*.*(..))")
    // public Object setMongoOperations(ProceedingJoinPoint joinPoint) throws Throwable {
    // setMongoTemplate4Repository(joinPoint, (MongoTemplate)context.getBean("mongoTemplate"));
    //
    // return joinPoint.proceed();
    // }
    //
    // private void setMongoTemplate4Repository(ProceedingJoinPoint joinPoint, MongoTemplate template)
    // throws NoSuchFieldException, IllegalAccessException {
    // // 通过反射获取到target
    // Field methodInvocationField = joinPoint.getClass().getDeclaredField("methodInvocation");
    // methodInvocationField.setAccessible(true);
    // ReflectiveMethodInvocation o = (ReflectiveMethodInvocation)methodInvocationField.get(joinPoint);
    //
    // Field targetField = o.getClass().getDeclaredField("target");
    // targetField.setAccessible(true);
    // Object target = targetField.get(o);
    //
    // // 获得SimpleMongoRepository，并往里面填入指定mongoTemplate
    // Object singletonTarget = AopProxyUtils.getSingletonTarget(target);
    // Field mongoOperationsField = singletonTarget.getClass().getDeclaredField("mongoOperations");
    // mongoOperationsField.setAccessible(true);
    // mongoOperationsField.set(singletonTarget, template);
    // }

}
