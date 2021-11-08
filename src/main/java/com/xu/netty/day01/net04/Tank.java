package com.xu.netty.day01.net04;

/**
 * java_study
 */
public class Tank {
    public int x;
    public int y;

    public Tank(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "Tank{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
