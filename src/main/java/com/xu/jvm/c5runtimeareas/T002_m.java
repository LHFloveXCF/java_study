package com.xu.jvm.c5runtimeareas;

/**
 * java_study
 */
public class T002_m {
    public void m() {}
    private void n() {}
    private static void s() {}
    public final void f() {}
    public static void main(String[] args) {
        T002_m m = new T002_m();
        m.m();
        m.n();
        T002_m.s();
        m.f();
    }
}
