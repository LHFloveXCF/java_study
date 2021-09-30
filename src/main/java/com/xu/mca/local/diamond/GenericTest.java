package com.xu.mca.local.diamond;

/**
 * java_study
 */
public class GenericTest<E> {
    public int id;
    public String name;
    public E data;
    public void add(E e) {
    }
    public void describe(E e) {
    }
}
class SubGenericTest extends GenericTest<Integer> {
}
class TestGenericClass{
    public static void main(String[] args) {
        SubGenericTest test = new SubGenericTest();
        test.add(1);
        test.describe(2);
    }
}
