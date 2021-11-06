package com.mt.designmodel.decorate;

/**
 * java_study
 * 将小孩封装成一个对象
 */
public class D_V2 {
    public static void main(String[] args) {
        Child child = new Child();
        while (child.isCry) {
            // do something
        }
    }
}

class Child{
    boolean isCry;

    public boolean isCry() {
        return isCry;
    }
}
