package com.xu.test.file;

import com.xu.test.collection.Test;
import org.apache.commons.lang.CharSet;

import java.io.*;

/**
 * java_study
 */
public class TestPath {
    public static void main(String[] args) {
        System.out.println(TestPath.class.getResource("/"));
        System.out.println(TestPath.class.getClassLoader().getResourceAsStream("/src/main/resources/test.txt"));
        System.out.println(TestPath.class.getResourceAsStream("src/main/resources/test.txt"));
//        File file = new File("F:\\java_study\\src\\main\\java\\com\\xu\\test\\file\\test.txt");
        File file = new File("/src/main/test.txt");
//        File file = new File("test.txt");
        InputStream in = null;
        try {
            System.out.println("以字节为单位读取文件内容，一次读多个字节：");
            // 一次读多个字节
            byte[] tempBytes = new byte[100];
            int byteread = 0;
            in = new FileInputStream(file);
            // 读入多个字节到字节数组中，byteread为一次读入的字节数
            while ((byteread = in.read(tempBytes)) != -1) {
                System.out.write(tempBytes, 0, byteread);
            }
        } catch (Exception e1) {
            e1.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e1) {
                }
            }
        }

//        try {
//            FileInputStream fs = new FileInputStream(file);
//            try {
//                int read = 0;
//                while ((read = fs.read()) != -1) {
//                    System.out.println(read);
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//
//            try {
//                fs.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
    }
}
