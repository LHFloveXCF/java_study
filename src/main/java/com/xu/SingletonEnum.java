package com.xu;

import java.util.EnumMap;

/**
 * java_study
 */
public enum  SingletonEnum {
    INSTANCE;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public static void main(String[] args) {
//        EnumMap
    }
}
