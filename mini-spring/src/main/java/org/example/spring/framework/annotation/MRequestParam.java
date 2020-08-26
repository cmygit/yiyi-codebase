package org.example.spring.framework.annotation;

import java.lang.annotation.*;

/**
 * @Title:
 * @Author: cmy
 * @Date: 2020/8/23 15:15
 */
@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MRequestParam {

    String value() default "";
}
