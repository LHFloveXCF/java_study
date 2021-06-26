package com.xu.anno.t_2;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;

/**
 * java_study
 * 自定义注解，用@interface来修饰
 */
@Target({TYPE})
@Retention(RetentionPolicy.SOURCE)
public @interface MyAnnotation {
}
