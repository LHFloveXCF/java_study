package com.mt.test;

import java.util.*;

/**
 * java_study
 */
public class Test_Reduce {
    public static class Info{
        public int id;
        public int count;

        public Info() {
        }

        public Info(int count) {
            this.id = 1;
            this.count = count;
        }

        @Override
        public String toString() {
            return "Info{" +
                    "id=" + id +
                    ", count=" + count +
                    '}';
        }
    }

    public static void main(String[] args) {
        Map<Integer, List<Info>> map = new HashMap<>();
        List<Info> list1 = new ArrayList<>();
        List<Info> list2 = new ArrayList<>();
        List<Info> list3 = new ArrayList<>();

        list1.add(new Info(1));
        list1.add(new Info(11));
        list1.add(new Info(111));

        list2.add(new Info(2));
        list2.add(new Info(22));
        list2.add(new Info(222));

        list3.add(new Info(3));
        list3.add(new Info(33));
        list3.add(new Info(333));

        map.put(1, list1);
        map.put(2, list2);
        map.put(3, list3);

        Info result = map.values().stream().reduce(new Info(), (info, data) -> {
//            info.id = 1;
//            data.stream().mapToInt(d -> d.count).max().ifPresent(max -> info.count = Math.max(info.count, max));
//            data.stream().min((o1, o2) -> o2.count - o1.count).ifPresent(d ->{
//                info.id = d.id;
//                info.count = Math.max(info.count, d.count);
//            });
            data.stream().sorted((o1, o2) -> o2.count - o1.count).forEach(System.out :: println);
            data.sort((o1, o2) -> o2.count - o1.count);

            data.forEach(System.out::println);
            data.stream().findFirst().ifPresent(System.out :: println);
            return info;
        }, (info1, info2) -> info1);

        System.out.println(result.toString());
    }
}
