package org.example.spring.framework.annotation;

import java.lang.annotation.*;

/**
 * @Title:
 * @Author: cmy
 * @Date: 2020/8/23 15:15
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MService {

    String value() default "";
}
