package com.xu.test.ath;


import java.util.Scanner;

/**
 * java_study
 */
public class Garbage {
    public static void main(String[] args) {
        while (!Chair.f) {
            new Chair();
            new String("To take up space");
        }
        System.out.print(String.format("After all Chairs have been created:\n total created = %d, total finalized = %d" , Chair.created, Chair.finalized));
        System.out.println("请输入");
        Scanner scanner = new Scanner(System.in);
        String next = scanner.next();
        if ("before".equals(next)) {
            System.out.println("gc()");
            System.gc();
            System.out.println("runFinalization():");
            System.runFinalization();
        }
        System.out.println("bye");
        if ("after".equals(next)) {
            System.runFinalization();
        }
    }
}
class Chair{
    static boolean gcRun = false;
    static boolean f = false;
    static int created = 0;
    static int finalized = 0;
    int i;
    Chair() {
        i = ++created;
        if (created == 47) {
            System.out.println("Created 47");
        }
    }

    protected void finalize() {
        if (!gcRun) {
            gcRun = true;
            System.out.print(String.format("Beginning to finalize after %d Chairs has been created", created));
            System.out.println();
        }
        if (i == 47) {
            System.out.println("Finalizing Chair #47, Setting flag to stop Chair creation");
            f = true;
        }
        finalized++;
        if (finalized >= created) {
            System.out.print(String.format("All %d finalized", finalized));
        }
    }
}