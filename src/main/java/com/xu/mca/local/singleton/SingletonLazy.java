package com.xu.mca.local.singleton;

/**
 * java_study
 */
public class SingletonLazy {
    private static volatile SingletonLazy instance;

    private SingletonLazy() {}

    public static synchronized SingletonLazy getInstance() {
        if (instance == null) {
            return new SingletonLazy();
        }
        return instance;
    }
}
