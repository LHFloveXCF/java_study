package com.mt.designmodel.decorate;

/**
 * java_study
 * 再添加一个mother的观察者
 */
public class D_V4 {

    public static void main(String[] args) {
        Child child = new Child();
        child.cry();
    }

    static class Child{
        Father father = new Father();
        Mother mother = new Mother();
        boolean isCry;

        public void cry() {
            isCry = true;
            father.doSomething();
            mother.doSomething();
        }
    }

    static class Father{
        public void doSomething() {
            System.out.println("feed");
        }
    }

    static class Mother{
        public void doSomething() {
            System.out.println("hug");
        }
    }
}
