package com.mt.file;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * java_study
 */
public class FileRead {

    public static void main(String[] args) throws FileNotFoundException {
        String fileName = "C:\\Users\\Administrator\\Desktop\\涉及到的区服";
        Set<String> set = new HashSet<>();
        readFileByLines(fileName, set);
        set.forEach(System.out :: println);
    }
    /**
     * 以行为单位读取文件，常用于读面向行的格式化文件
     */
    public static void readFileByLines(String fileName, Set<String> result) {
        File file = new File(fileName);
        BufferedReader reader = null;
        try {
            System.out.println("以行为单位读取文件内容，一次读一整行：");
            reader = new BufferedReader(new FileReader(file));
            String tempString;
            while ((tempString = reader.readLine()) != null) {
                int index = tempString.indexOf("[") + 1;
                int endIndex  = index;
                for (int i=index; i<tempString.length(); i++) {
                    if (tempString.charAt(i) == ',' || tempString.charAt(i) == ']') {
                        endIndex = i;
                        break;
                    }
                }
                System.out.println("--------=" + index + "----------=" + endIndex);
                String str = tempString.substring(index, endIndex);
                result.add(str.split(",")[0]);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }
    }
}
