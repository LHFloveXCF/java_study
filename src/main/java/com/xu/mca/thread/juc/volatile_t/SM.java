package com.xu.mca.thread.juc.volatile_t;

/**
 * java_study
 */
public class SM {

    private static final SM INSTANCE = new SM();

    private SM() {
    }

    public static SM getInstance() {
        return INSTANCE;
    }

    public static void main(String[] args) {
        SM instance = SM.getInstance();
        System.out.println(instance.hashCode());
    }
}
