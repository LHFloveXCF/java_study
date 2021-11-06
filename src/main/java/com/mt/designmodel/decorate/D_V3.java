package com.mt.designmodel.decorate;

/**
 * java_study
 * 让child持有一个father的引用，如果child哭了，father就做出响应
 */
public class D_V3 {

    public static void main(String[] args) {
        Child child = new Child();
        child.cry();
    }

    static class Father{
        public void doSomething() {
            System.out.println("feed");
        }
    }

    static class Child{
        Father father = new Father();
        boolean isCry;

        public void cry() {
            isCry = true;
            father.doSomething();
        }
    }
}

