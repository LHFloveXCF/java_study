package com.xu.mca.thread.juc.volatile_t;

/**
 * java_study
 */
public class SM_02 {

    private volatile SM_02 INSTANCE;

    private SM_02() {
    }

    public SM_02 getInstance() {
        if (INSTANCE == null) {
            synchronized(this) {
                if (INSTANCE == null) {
                    INSTANCE = new SM_02();
                }
            }
        }
        return INSTANCE;
    }
}
