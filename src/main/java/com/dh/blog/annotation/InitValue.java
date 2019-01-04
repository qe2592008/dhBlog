package com.dh.blog.annotation;

import java.lang.annotation.*;

/**
 * 初始化值注解，主要用于在创建博客的时候用于初始化一些参数
 *
 * @author donghao
 * @date 2019/1/4
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface InitValue {
    int value();
}
