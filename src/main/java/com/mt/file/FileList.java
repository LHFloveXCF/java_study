package com.mt.file;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * java_study
 */
public class FileList {
    public static void main(String[] args) throws Exception {
        /*BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\Administrator\\Desktop\\代码文档.txt"));
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new GZIPOutputStream(new FileOutputStream("test.zip")));
        int c;
        while ((c = reader.read()) != -1) {
            bufferedOutputStream.write(c);
        }
        reader.close();
        bufferedOutputStream.close();*/

        /*Class<?> fileList = Class.forName("com.xu.mca.local.greenhouse.GreenHouseController");
        Class<?> superclass = fileList.getSuperclass();
        while (null != superclass) {
            System.out.println(superclass);
            superclass = superclass.getSuperclass();
        }*/

        /*FileList fileList = new FileList();
        System.out.println("main of : " + fileList);
        fileList.f(fileList);*/

//        aliasTest();
//        cloneTest();
//        stringTest();
//        counterTest();?
        whoAmI();
    }

    static void whoAmI() {
        try {
            InetAddress name = InetAddress.getByName(null);
            System.out.println(name);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

    static void counterTest() {
        Counter counter = new Counter();
        Frame frame = new Frame("counter");
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        frame.add(counter);
        frame.setSize(300, 200);
        counter.init();
        counter.start();
        frame.setVisible(true);

    }

    static void stringTest() {
        MyString str = new MyString("hello ");
        System.out.println(str);
        str.append();
        System.out.println(str);
        str.append2();
        System.out.println(str);
    }

    static void cloneTest() {
        Snake s1 = new Snake(5,'a');
        System.out.println("s1: " + s1);
        Snake s2 = (Snake) s1.clone();
        System.out.println("s2: " + s2);
        s2.increase();
        System.out.println("after increase s2: " + s1);
        System.out.println("after increase s2: " + s2);
    }

    static void protectedTest() {
        Integer i = new Integer(1);
//        i.clone();
        Alias a = new Alias();
        try {
            a.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }

    static void aliasTest() {
        Alias a = new Alias();
        Alias b = a;
        System.out.println(a.a);
        System.out.println(b.a);

        b.a++;

        System.out.println(a.a);
        System.out.println(b.a);
    }

    static class Alias{
        int a;

        @Override
        public Object clone() throws CloneNotSupportedException {
            return super.clone();
        }
    }

    void f(FileList fileList) {
        System.out.println("inside of : " + fileList);

    }
}

class Counter extends Applet{
    private int count = 0;
    private Button on = new Button("Toggle"), off = new Button("Start");
    private TextField textField = new TextField(10);
    private boolean runFlag = true;
    public void init() {
        add(textField);
        on.addActionListener(event -> go());
        add(on);
        off.addActionListener(event -> runFlag = !runFlag);
        add(off);
    }

    public void go() {
        while (true) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (runFlag) {
                textField.setText(Integer.toString(count++));
            }
        }
    }
}

class MyString implements Cloneable{
    String str;
    MyString(String value) {
        this.str = value;
    }

    void append() {
        concatenate("test");
    }

    void append2() {
        MyString clone = (MyString) clone();
        clone.concatenate("test");
    }

    @Override
    public Object clone() {
        Object o = null;
        try {
            o = super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return o;
    }

    void concatenate(String value) {
        str += value;
    }

    @Override
    public String toString() {
        return str;
    }
}

class Snake implements Cloneable {
    Snake next;
    char aChar;

    Snake(int count, char value) {
        aChar = value;
        if (--count > 0) {
            next = new Snake(count, (char) (value + 1));
        }
    }

    void increase() {
        aChar++;
        if (null != next) {
            next.increase();
        }
    }

    @Override
    public Object clone() {
        Object o = null;
        try {
            o = super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return o;
    }

    @Override
    public String toString() {
        String s = ":" + aChar;
        if (null != next) {
            s += next.toString();
        }
        return s;
    }
}