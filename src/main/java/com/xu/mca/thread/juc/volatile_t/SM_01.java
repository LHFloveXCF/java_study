package com.xu.mca.thread.juc.volatile_t;

/**
 * java_study
 */
public class SM_01 {
    private static SM_01 INSTANCE;

    private SM_01() {
    }

    public static synchronized SM_01 getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new SM_01();
        }
        return INSTANCE;
    }
}
