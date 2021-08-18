package com.xu.calculator.l_08.lesson37;

/**
 * java_study
 * size balanced tree
 * 一定要学会封装，学好数据结构是一码事，会用是另外一码事
 */
public class SBTTree {

    private static class SBTNode<K extends Comparable<K>, V> {
        public K k;
        public V v;
        public SBTNode<K, V> l;
        public SBTNode<K, V> r;
        /** 不同key的数量 */
        public int size;

        public SBTNode(K k, V v) {
            this.k = k;
            this.v = v;
            this.size = 1;
        }
    }

    public static class SBMap<K extends Comparable<K>, V>{
        private SBTNode<K, V> root;

        private SBTNode<K, V> leftRotate(SBTNode<K, V> cur) {
            if (null == cur) {
                return null;
            }
            SBTNode<K, V> right = cur.r;
            cur.r = right.l;
            right.r = cur;
            right.size = cur.size;
            cur.size = (null != cur.r ? cur.r.size : 0) + (null != cur.l ? cur.l.size : 0) + 1;
            return right;
        }

        private SBTNode<K, V> rightRotate(SBTNode<K, V> cur) {
            if (null == cur) {
                return null;
            }
            SBTNode<K, V> left = cur.l;
            cur.l = left.r;
            left.r = cur;

            left.size = cur.size;
            cur.size = (null != cur.r ? cur.r.size : 0) + (null != cur.l ? cur.l.size : 0) + 1;
            return left;
        }

        /**
         * 调整平衡性
         * @param cur
         * @return
         */
        private SBTNode<K, V> maintain(SBTNode<K, V> cur) {
            if (null == cur) {
                return null;
            }
            int leftSize = null != cur.l ? cur.l.size : 0;
            int leftLeftSize = null != cur.l && null != cur.l.l ? cur.l.l.size : 0;
            int leftRightSize = null != cur.l && null != cur.l.r ? cur.l.r.size : 0;
            int rightSize = null != cur.r ? cur.r.size : 0;
            int rightRightSize = null != cur.r && null != cur.r.r ? cur.r.r.size : 0;
            int rightLeftSize = null != cur.r && null != cur.r.l ? cur.r.l.size : 0;
            if (leftLeftSize > rightSize) {
                cur = rightRotate(cur);
                cur.r = maintain(cur.r);
                cur = maintain(cur);
            } else if (leftRightSize > rightSize) {
                cur.l = leftRotate(cur.l);
                cur = rightRotate(cur);
                cur.l = maintain(cur.l);
                cur.r = maintain(cur.r);
                cur = maintain(cur);
            } else if (rightLeftSize > leftSize) {
                cur.r = rightRotate(cur.r);
                cur = leftRotate(cur);
                cur.r = maintain(cur.r);
                cur.l = maintain(cur.l);
                cur = maintain(cur);
            } else if (rightRightSize > leftSize) {
                cur = leftRotate(cur);
                cur.l = maintain(cur.l);
                cur = maintain(cur);
            }
            return cur;
        }

        private SBTNode<K, V> findLastIndex(K key) {
            SBTNode<K, V> pre = this.root;
            SBTNode<K, V> cur = this.root;
            while (cur != null) {
                pre = cur;
                if (key.compareTo(pre.k) == 0) {
                    break;
                } else if (key.compareTo(pre.k) > 0) {
                    cur = cur.r;
                } else {
                    cur = cur.l;
                }
            }
            return pre;
        }

        private SBTNode<K, V> add(SBTNode<K, V> cur, K key, V value) {
            // base case
            if (null == cur) {
                return new SBTNode<>(key, value);
            }
            cur.size++;
            if (key.compareTo(cur.k) < 0) {
                cur = add(cur.l, key, value);
            } else {
                cur = add(cur.r, key, value);
            }
            return maintain(cur);
        }

        private SBTNode<K, V> delete(SBTNode<K, V> cur, K key) {
            if (null == cur) {
                return null;
            }
            if (!contain(cur, key)) {
                return cur;
            }
            cur.size--;
            if (key.compareTo(cur.k) > 0) {
                // 删除右边节点
                cur = delete(cur.r, key);
            } else if (key.compareTo(cur.k) < 0) {
                cur = delete(cur.l, key);
            } else {
                // 当前节点
                if (null == cur.l && null == cur.r) {
                    cur = null;
                } else if (null == cur.l) {
                    cur = cur.r;
                } else if (null == cur.r) {
                    cur = cur.l;
                } else {
                    SBTNode<K, V> pre = null;
                    SBTNode<K, V> right = cur.r;
                    while (right.l != null) {
                        pre = right;
                        right = right.l;
                        right.size--;
                    }
                    if (pre != null) {
                        pre.l = right.r;
                        right.r = cur.r;
                    }
                    right.l = cur.l;
                    right.size = right.l.size + (right.r != null ? right.r.size : 0) + 1;
                    cur = right;
                }
            }
            return cur;
        }

        private boolean contain(SBTNode<K,V> cur, K key) {
            SBTNode<K, V> pre = cur;
            boolean isContain = false;
            while (pre != null) {
                if (key.compareTo(pre.k) == 0) {
                    isContain = true;
                    break;
                } else if (key.compareTo(pre.k) < 0) {
                    pre = pre.l;
                } else {
                    pre = pre.r;
                }
            }
            return isContain;
        }
    }
}
