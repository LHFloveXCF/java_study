package com.xu.test.collection;

import sun.reflect.generics.tree.Tree;

import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;

/**
 * java_study
 */
public class TestHashSet {
    public static void main(String[] args) {
        HashSet<Integer> hashSet = new HashSet<>();
        hashSet.add(3);
        hashSet.add(1222);
        hashSet.add(2);
        hashSet.add(2);
        hashSet.add(21111);
        hashSet.add(null);
        System.out.println(hashSet.size());
        System.out.println(hashSet);
    }
}

class T_LinkedHashSet{
    public static void main(String[] args) {
        LinkedHashSet<Integer> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add(333333);
        linkedHashSet.add(3);
        linkedHashSet.add(31);


        System.out.println(linkedHashSet);


    }
}

class T_TreeSet{
    public static void main(String[] args) {
        TreeSet<String> treeSet = new TreeSet<>(String::compareTo);
        treeSet.add(null);
        treeSet.add("a");
        treeSet.add("aaaa");
        System.out.println(treeSet.size());
        System.out.println(treeSet);
    }
}