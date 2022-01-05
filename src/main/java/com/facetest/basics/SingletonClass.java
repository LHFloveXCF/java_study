package com.facetest.basics;

/**
 * java_study
 * DCL
 */
public class SingletonClass {
    // 禁止指令重排序
    private static volatile SingletonClass instance;

    // 私有化构造器，不允许外部创建
    private SingletonClass () {}

    public static SingletonClass getInstance() {
        // 首次判空，提高性能
        if (null == instance) {
            // 对象锁，防止多条线程同时访问共享资源
            synchronized (SingletonClass.class) {
                // 再次判空，防止在获取锁期间，已经有其他线程，实现了初始化
                if (null == instance) {
                    instance = new SingletonClass();
                }
            }
        }
        return instance;
    }
}
