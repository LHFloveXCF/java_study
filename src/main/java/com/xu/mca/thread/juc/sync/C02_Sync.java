package com.xu.mca.thread.juc.sync;

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * java_study
 */
public class C02_Sync {
    static class Account {
        private String name;
        private int count;

        public String getName() {
            return name;
        }

        public synchronized void setName(String name) {
            this.name = name;

            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            m();
            this.count = 100;
            System.out.println(Thread.currentThread().getName() + "===============" + getCount());
        }

        public synchronized void m() {
            System.out.println("我是可重入锁的测试代码");
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }
    }

    public static void main(String[] args) {
        Account account = new Account();

        Thread thread2 = new Thread(() -> {
            account.setName("hello");
        }, "t2");
        thread2.start();

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "===============" + account.getCount());
            }
        };

        Thread thread = new Thread(runnable, "t1");
        thread.start();

    }
}
