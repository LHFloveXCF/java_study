package com.xu.calculator;

import java.util.*;
import java.util.stream.Stream;

/**
 * java_study
 */
public class Test {
    private static Map<Integer, People> map = new HashMap<>();
    public static void main(String[] args) {


        // 输入总金额
        double amt = 66.66;
// 输入红包个数
        int luckPackage = 12;
// 总下标数
        int allIndex = (int) (amt * 100);
// 根据红包金额和红包个数创建下标集合
        List<Integer> list = new ArrayList();
// 默认添加最小下标
        list.add(0);
// 默认添加最大下标
        list.add(allIndex);
// 根据红包个数，获取各个下标
        while (list.size() < luckPackage + 1) {
            Random rnd = new Random();
            int r = rnd.nextInt(allIndex);
            // 避免下标重复
            if (list.contains(r)) {
                continue;
            }
            // 添加下标
            list.add(r);
        }
// 从小到大排序
        Collections.sort(list);
// 红包集合
        List<Integer> lpAmtList = new ArrayList<Integer>();
        for (int i = 0; i < list.size() - 1; i++) {
            // 每个红包金额 = 相邻下标值的差
            int lpAmt = list.get(i + 1) - list.get(i);
            // 添加红包金额
            lpAmtList.add(lpAmt);
        }
// 红包金额
        System.out.println(lpAmtList);
        System.out.println(lpAmtList.stream().mapToDouble(x -> x).sum());
// 运气王
        System.out.println("本轮中第" + (lpAmtList.indexOf(Collections.max(lpAmtList)) + 1) + "人手气最佳");



//        People people = new People();
//        people.id = 1;
//        map.put(1, people);
//
//        People p2 = map.get(1);
//        addHate();
////        p2.hate = 2;
//        map.put(1, p2);
//        System.out.println(map.get(1));

    }

    private static void addHate() {
        People p2 = map.get(1);
        p2.hate = 5;
    }

    private static void priintPeople(People people) {
        int[] score = people.score;
        score[1] = 2;
    }
}

class People implements Comparator<People>{
    int id;
    int[] score;
    int hate;

    @Override
    public String toString() {
        return "People{" +
                "id=" + id +
                ", score=" + Arrays.toString(score) +
                ", hate=" + hate +
                '}';
    }

    @Override
    public int compare(People o1, People o2) {
        // 返回负数，认为第一个参数放前面
        // 返回正数，认为第二个参数放前面
        // 返回0，谁放前面无所谓
        if (o1.id < o2.id) {
            return -1;
        } else if (o1.id > o2.id) {
            return 1;
        }
        return 0;
    }
}
