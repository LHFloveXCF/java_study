package com.xu.calculator.l_08.lesson36;

/**
 * java_study
 * AVL平衡搜索二叉树
 */
public class AVLNode {
    private static class AVLTree<K extends Comparable<K>, V> {
        public K k;
        public V v;
        public AVLTree<K, V> l;
        public AVLTree<K, V> r;
        public int h;

        public AVLTree(K k, V v) {
            this.k = k;
            this.v = v;
            this.h = 1;
        }
    }

    public static class AVLTreeMap<K extends Comparable<K>, V> {
        private AVLTree<K, V> root;
        private int size;

        public AVLTreeMap() {
            this.root = null;
            this.size = 0;
        }

        /**
         * 二叉树右旋
         *
         * @param cur
         * @return
         */
        private AVLTree<K, V> rightRotate(AVLTree<K, V> cur) {
            AVLTree<K, V> left = cur.l;
            cur.l = left.r;
            left.r = cur;
            cur.h = Math.max(null == cur.l ? 0 : cur.l.h, null == cur.r ? 0 : cur.r.h) + 1;
            left.h = Math.max(null == left.l ? 0 : left.l.h, left.r.h) + 1;
            return left;
        }

        private AVLTree<K, V> leftRotate(AVLTree<K, V> cur) {
            AVLTree<K, V> right = cur.r;
            cur.r = right.l;
            right.l = cur;

            cur.h = Math.max(null == cur.l ? 0 : cur.l.h, null == cur.r ? 0 : cur.r.h) + 1;
            right.h = Math.max(right.l.h, null == right.r ? 0 : right.r.h) + 1;
            return right;
        }

        /**
         * 递归实现节点的增加
         * @param cur
         * @param k
         * @param v
         * @return
         */
        private AVLTree<K, V> add(AVLTree<K, V> cur, K k, V v) {
            if (null == cur) {
                return new AVLTree<>(k, v);
            }

            if (k.compareTo(cur.k) >= 0) {
                // 要放右边？
                cur.r = add(cur.r, k, v);
            } else {
                cur.l = add(cur.l, k, v);
            }
            cur.h = Math.max(null == cur.l ? 0 : cur.l.h, null == cur.r ? 0 : cur.r.h) + 1;
            return cur;
        }

        private AVLTree<K, V> delete(AVLTree<K, V> cur, K k) {
            if (k.compareTo(cur.k) > 0) {
                cur.r = delete(cur.r, k);
            } else if (k.compareTo(cur.k) < 0) {
                cur.l = delete(cur.l, k);
            } else {
                if (null == cur.l && null == cur.r) {
                    cur = null;
                } else if (null == cur.l && null != cur.r) {
                    cur = cur.r;
                } else if (null != cur.l && null == cur.r) {
                    cur = cur.l;
                } else {
                    AVLTree<K, V> des = cur.r;
                    while (des.l != null) {
                        des = des.l;
                    }
                    cur.r = delete(cur.r, des.k);
                    des.l = cur.l;
                    des.r = cur.r;
                    cur = des;
                }
            }
            if (null != cur) {
                cur.h = Math.max(null == cur.l ? 0 : cur.l.h, null == cur.r ? 0 : cur.r.h) + 1;
            }
            return maintain(cur);
        }

        /**
         * 调整二叉树的平衡性
         * 主要是分清是：LL，LR，RR，RL
         * LL 用右旋；LR用左旋，右旋；
         * RR 用左旋，RL用右旋,左旋
         * @param cur
         * @return
         */
        private AVLTree<K,V> maintain(AVLTree<K,V> cur) {
            if (cur == null) {
                return null;
            }
            int leftHeight = null == cur.l ? 0 : cur.l.h;
            int rightHeight = null == cur.r ? 0 : cur.r.h;
            if (Math.abs(leftHeight - rightHeight) > 1) {
                if (leftHeight > rightHeight) {
                    int leftLeftHeight = (null != cur.l && null != cur.l.l) ? cur.l.l.h : 0;
                    int leftRightHeight = (null != cur.r && null != cur.r.r) ? cur.r.r.h : 0;
                    if (leftLeftHeight >= leftRightHeight) {
                        // LL, LL/LR
                        cur = rightRotate(cur);
                    } else {
                        cur.l = leftRotate(cur.l);
                        cur = rightRotate(cur);
                    }
                } else {
                    int rightLeftHeight = (null != cur.r && null != cur.r.r) ? cur.r.r.h : 0;
                    int rightRightHeight = (null != cur.l && null != cur.l.l) ? cur.l.l.h : 0;
                    if (rightRightHeight >= rightLeftHeight) {
                        cur = leftRotate(cur);
                    } else {
                        cur.r = rightRotate(cur.r);
                        cur = leftRotate(cur);
                    }
                }
            }
            return cur;
        }
    }


}
