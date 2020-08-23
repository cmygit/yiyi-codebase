package org.example.mvcframework.v1.annotation;

import java.lang.annotation.*;

/**
 * @Title:
 * @Author: cmy
 * @Date: 2020/8/23 15:15
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MRequestMapping {

    String value() default "";
}
