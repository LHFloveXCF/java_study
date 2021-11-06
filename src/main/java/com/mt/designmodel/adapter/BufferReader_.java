package com.mt.designmodel.adapter;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * java_study
 */
public class BufferReader_ {
    public static void main(String[] args) throws IOException {
        // File file = new File("/test.txt");
        InputStream stream = BufferReader_.class/*.getClassLoader()*/.getResourceAsStream("/test.txt");
        InputStreamReader isr = new InputStreamReader(stream, StandardCharsets.UTF_8);
        BufferedReader br = new BufferedReader(isr);
        while (br.ready()) {
            System.out.println(br.readLine());
        }
    }
}
