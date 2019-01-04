
package com.dh.blog.annotation.aop;

import com.dh.blog.annotation.InitValue;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 注解驱动
 *
 * @author donghao
 * @date 2019/1/4
 */
@Aspect
@Component
public class InitValueInject {
    @Pointcut(value = "execution(* com.dh.blog.controller.*.add*(..))")
    private void pointCut(){}

    @Around("pointCut()")
    public void aroundAdvice(ProceedingJoinPoint jp) throws Throwable {
        System.out.println("环绕前置通知");
        Object[] os = jp.getArgs();
        Object arg = os[0];
        Class c = arg.getClass();
        Field[] fs = c.getDeclaredFields();
        for (Field f:fs) {
            f.setAccessible(true);
            Object value = f.get(arg);
            InitValue ann = f.getAnnotation(InitValue.class);
            if(ann == null)
                continue;
            Method[] ms = ann.annotationType().getDeclaredMethods();
            for (Method m:ms) {
                if(value == null || (int)value == 0){
                    m.setAccessible(true);
                    Object val = m.invoke(ann, null);
                    f.set(arg, val);
                }
            }
        }
        jp.proceed(os);
    }

}
