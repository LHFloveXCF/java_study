package com.xu.calculator;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * java_study
 */
public class FileReader {
    private static final Map<String, Integer> resultMap = new HashMap<>();
    private static final String[] path = new String[]{
//            "C:\\Users\\Administrator\\Desktop\\game_log\\3_558\\logs.log.20210326",
//            "C:\\Users\\Administrator\\Desktop\\game_log\\3_558\\logs.log.20210327",
//            "C:\\Users\\Administrator\\Desktop\\game_log\\3_558\\logs.log.20210328",
//            "C:\\Users\\Administrator\\Desktop\\game_log\\3_558\\logs.log.20210329",
            "C:\\Users\\Administrator\\Desktop\\game_log\\1747\\logs.log.20210331",
            "C:\\Users\\Administrator\\Desktop\\game_log\\1747\\logs.log",
    };

    public static void main(String[] args) throws IOException {
        for (String s : path) {
            readFile(s);
//            readFile2(s);
        }
        printResult();
    }

    private static void readFile2(String path) throws IOException {
        FileInputStream inputStream = new FileInputStream(new File(path));
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        int start = 0;
        String str = null;
        while ((str = bufferedReader.readLine()) != null) {
            if (str.contains("游戏服已关闭")) {
                start = 0;
                resultMap.clear();
            } else if (str.contains("SingleFightTcpManager.java:348")) {
                start = 1;
            } else if (start == 1) {
                start += 1;
            } else if (start == 2) {
                int index = str.indexOf("- ");
                String substring = str.substring(index + 1);
                Integer integer = resultMap.computeIfAbsent(substring, i -> 0);
                integer += 1;
                resultMap.put(substring, integer);
                start = 0;
            }
        }
        inputStream.close();
        bufferedReader.close();
    }

    private static void readFile(String path) throws IOException {
        FileInputStream inputStream = new FileInputStream(new File(path));
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        int start = 0;
        String str = null;
        while ((str = bufferedReader.readLine()) != null) {
            if (str.contains("游戏服已关闭")) {
                start = 0;
                resultMap.clear();
            } else if (str.contains("BossManager - init player")) {
                start = 1;
            } else if (str.contains("PlayerManager.prepare(PlayerManager.java:283)")) {
                start += 1;
            } else if (start == 2) {
                start += 1;
            } else if (start == 3) {
                int index = str.indexOf("- ");
                String substring = str.substring(index + 1);
                Integer integer = resultMap.computeIfAbsent(substring, i -> 0);
                integer += 1;
                resultMap.put(substring, integer);
                start = 0;
            }
        }
        inputStream.close();
        bufferedReader.close();
    }

    private static void printResult() {
        AtomicInteger count = new AtomicInteger();
        resultMap.entrySet().stream().sorted((e1, e2) -> {
            if (e1.getValue() < e2.getValue()) {
                return 1;
            } else if (e1.getValue() > e2.getValue()) {
                return -1;
            } else {
                return 0;
            }
        }).forEach(e -> {
            System.out.println(e);
            count.addAndGet(e.getValue());
        });
        System.out.println(count.get());
    }
}
