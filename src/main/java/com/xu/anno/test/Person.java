package com.xu.anno.test;

import com.xu.anno.MyAnnotation;

/**
 * java_study
 */
@MyAnnotation
public class Person {
    @MyAnnotation
    private int id;
    @MyAnnotation
    public void eat() {}
    @MyAnnotation
    public Person() {}
}
