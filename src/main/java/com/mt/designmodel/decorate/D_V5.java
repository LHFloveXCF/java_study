package com.mt.designmodel.decorate;

import java.util.ArrayList;
import java.util.List;

/**
 * java_study
 * 如果还想添加一个dog的观察者呢，这样处理会很麻烦
 * 所以来了一个优化版
 */
public class D_V5 {

    public static void main(String[] args) {
        Child child = new Child();
        child.cry();
    }

    static class Child{
        List<Observer> list = new ArrayList<>();

        Child () {
            list.add(new Father());
            list.add(new Mother());
            list.add(new Dog());
        }

        public void cry() {
            list.forEach(Observer::doSomething);
        }
    }

    static class Father implements Observer {

        @Override
        public void doSomething() {
            System.out.println("feed");
        }
    }

    static class Mother implements Observer {

        @Override
        public void doSomething() {
            System.out.println("hug");
        }
    }

    static class Dog implements Observer {

        @Override
        public void doSomething() {
            System.out.println("wang wang ");
        }
    }
}

interface Observer{
    void doSomething();
}
