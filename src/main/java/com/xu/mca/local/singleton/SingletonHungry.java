package com.xu.mca.local.singleton;

/**
 * java_study
 */
public class SingletonHungry {
    private static SingletonHungry singletonHungry = new SingletonHungry();
    private SingletonHungry(){}
    public static SingletonHungry getInstance(){
        return singletonHungry;
    }
}
