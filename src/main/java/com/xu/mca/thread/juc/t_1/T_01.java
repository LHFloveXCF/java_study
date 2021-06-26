package com.xu.mca.thread.juc.t_1;

/**
 * java_study
 * 两条线程分别输出123，abc最终产生1a2b3c的效果
 */
public class T_01 {
    Thread t1 = new Thread(() -> {
        for (int i=1; i<4; i++) {
            System.out.println(i);
            Thread.yield();
        }
    });

}
