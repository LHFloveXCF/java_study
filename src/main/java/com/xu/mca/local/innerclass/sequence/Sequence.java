package com.xu.mca.local.innerclass.sequence;

/**
 * java_study
 * 创建自己的内部类时，那个类的对象同时拥有指向封装对象的一个链接，可以访问封装对象的成员。
 */
public class Sequence {
    private Object[] o;
    private int next = 0;
    public Sequence(int size) {
        o = new Object[size];
    }

    public void add(Object x) {
        o[next++] = x;
    }

    public Selector getSelector() {
        return new SSelector();
    }


    private class SSelector implements Selector{
        int i = 0;

        @Override
        public boolean end() {
            return i == o.length;
        }

        @Override
        public Object current() {
            return o[i];
        }

        @Override
        public void next() {
            if (i < o.length) {
                i++;
            }
        }
    }


    public static void main(String[] args) {
        Sequence sequence = new Sequence(10);
        for (int i = 0; i < 10; i++) {
            sequence.add(Integer.toString(i));
        }
        Selector selector = sequence.getSelector();
        while (!selector.end()) {
            System.out.println(selector.current());
            selector.next();
        }
    }
}

interface Selector{
    boolean end();
    Object current();
    void next();
}
