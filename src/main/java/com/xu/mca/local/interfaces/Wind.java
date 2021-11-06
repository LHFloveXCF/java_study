package com.xu.mca.local.interfaces;

/**
 * java_study
 */
public class Wind implements Instrument {
    @Override
    public void play() {
        System.out.println("wind play()");
    }

    @Override
    public String what() {
        return "wind";
    }

    @Override
    public void adjust() {

    }
}
