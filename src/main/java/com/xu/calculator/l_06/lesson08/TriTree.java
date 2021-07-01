package com.xu.calculator.l_06.lesson08;

import org.apache.commons.lang.StringUtils;

/**
 * java_study
 */
public class TriTree {

    public static void main(String[] args) {
        Tri tri = new Tri();
        tri.insert("apple");
        System.out.println(tri.contain("apple"));
        System.out.println(tri.contain("app"));
        tri.insert("app");

    }

    public static class Tri{
        private Node2 root;
        public Tri() {
            this.root = new Node2();
        }

        /**
         * 插入
         * @param word
         * @return
         */
        public boolean insert(String word) {
            if (StringUtils.isEmpty(word)) {
                return false;
            }
            char[] chars = word.toCharArray();
            Node2 node = root;
            node.pass++;
            for (int i = 0; i < chars.length; i++) {
                int path = chars[i] - 'a';
                if (node.next[path] == null) {
                    node.next[path] = new Node2();
                }
                node = node.next[path];
                node.pass++;
            }
            node.end++;
            return true;
        }

        /**
         * 查找是否包含
         * @param word
         * @return
         */
        public boolean contain(String word) {
            if (StringUtils.isEmpty(word)) {
                return false;
            }
            if (root == null || root.pass < 1) {
                return false;
            }
            char[] chars = word.toCharArray();
            Node2 node = root;
            boolean contain = true;
            for (int i = 0; i < chars.length; i++) {
                int path = chars[i] - 'a';
                if (node.next[path] == null) {
                    contain = false;
                    break;
                }
                node = node.next[path];
            }
            return contain && node.end != 0;
        }

        /**
         * 是否包含某个前缀数
         * @param pre
         * @return
         */
        public boolean containPre(String pre) {
            if (StringUtils.isEmpty(pre)) {
                return false;
            }
            if (null == pre || "".equalsIgnoreCase(pre)) {

            }
            if (root == null || root.pass < 1) {
                return false;
            }
            char[] chars = pre.toCharArray();
            Node2 node = root;
            boolean contain = true;
            for (int i = 0; i < chars.length; i++) {
                int path = chars[i] - 'a';
                if (node.next[path] == null) {
                    contain = false;
                    break;
                }
                node = node.next[path];
            }
            return contain;
        }
    }


    // 辅助前缀树
    public static class Node2{
        public int pass;
        public int end;
        public Node2[] next;

        public Node2() {
            next = new Node2[26];
        }
    }
}
