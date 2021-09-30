package com.xu.jvm.c2classloader;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * java_study
 */
public class T005_MyClassLoader extends ClassLoader {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        T005_MyClassLoader t = new T005_MyClassLoader();
        Class<?> aClass = t.loadClass("com.xu.jvm.c2classloader.T006_Hello");
        T006_Hello instance = (T006_Hello) aClass.newInstance();
        instance.m();
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        File file = new File("F:\\java_study\\target\\classes", name.replaceAll(".", "/").concat(".class"));
        try {
            FileInputStream fos = new FileInputStream(file);
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            int b;
            while ((b = fos.read()) != -1) {
                bos.write(b);
            }
            byte[] arry = bos.toByteArray();
            return defineClass(name, arry, 0, arry.length);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return super.findClass(name);
    }
}
