package com.xu.test.collection;

import com.xu.util.ArrayUtils;
import com.xu.util.SortUtil;

import java.util.*;

/**
 * java_study
 */
public class Test {
    // 冒泡排序
    private static void bubbleSort(int[] arr) {
        if (null == arr || arr.length < 1) {
            return;
        }
        for (int i = 0; i<arr.length; i++) {
            for (int j = 0; j<arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    SortUtil.swap(arr, j , j+ 1);
                }
            }
        }
    }

    private static void quickSort(int[] arr, int low, int high) {
        if (low > high) {
            return;
        }
        int pivot = arr[low];
        int i = low;
        int j = high;
        while (i < j) {
            while (arr[j] >= pivot && i < j) {
                j--;
            }
            while (arr[i] <= pivot && i < j) {
                i++;
            }
            if (i < j) {
                SortUtil.swap(arr, i, j);
            }
        }
        SortUtil.swap(arr, i, low);
        quickSort(arr, low, j - 1);
        quickSort(arr, j + 1, high);
    }

    // 选择排序
    private static void selectSort(int[] arr) {
        if (null == arr || arr.length < 1) {
            return;
        }
        for (int i=0; i<arr.length; i++) {
            int maxIndex = i;
            for (int j=i; j<arr.length; j++) {
                if (arr[j] < arr[maxIndex]) {
                    maxIndex = j;
                }
            }
            if (maxIndex != i) {
                SortUtil.swap(arr, i, maxIndex);
            }
        }
    }

    // 插入排序
    private static void insertSort(int[] arr) {
        if (null == arr || arr.length < 1) {
            return;
        }
        for (int i=0; i< arr.length; i++) {
            for (int j=i; j>0; j--) {
                if (arr[j] < arr[j - 1]) {
                    SortUtil.swap(arr, j, j - 1);
                }
            }
        }

    }

    private static void mergerSort(int[] arr) {
        if (null == arr || arr.length < 1) {
            return;
        }
        process(arr, 0, arr.length - 1);
    }

    private static void process(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = left + (right - left) / 2;
        process(arr, left, mid);
        process(arr, mid + 1, right);
        merger(arr, mid, left, right);
    }

    private static void merger(int[] arr, int mid, int left, int right) {
        int[] help = new int[right - left + 1];
        int leftIndex = left;
        int rightIndex = mid + 1;
        int index = 0;
        while (leftIndex <= mid && rightIndex <= right) {
            help[index++] = arr[leftIndex] < arr[rightIndex] ? arr[leftIndex++] : arr[rightIndex++];
        }
        while (leftIndex <= mid)
            help[index++] = arr[leftIndex++];
        while (rightIndex <= right)
            help[index++] = arr[rightIndex++];
        for (int i = 0; i < help.length; i++) {
            arr[left + i] = help[i];
        }
    }

    public static void main(String[] args) {
        int[] arr = ArrayUtils.generate(10, 10);
        SortUtil.print(arr);
//        bubbleSort(arr);
//        insertSort(arr);
//        selectSort(arr);
//        quickSort(arr, 0, arr.length - 1);
        mergerSort(arr);
        SortUtil.print(arr);
    }


}

class TestList{
    	public static void main(String[] args) {
    	    List<Integer> list = new ArrayList<>();
    	    list.add(null);
    	}
}

class Test2 {
    	public static void main(String[] args) {
            TreeSet<Integer> treeSet = new TreeSet<>();
            treeSet.add(1);
            treeSet.add(2);
            treeSet.add(1);
            treeSet.add(3);
            treeSet.add(11);

            System.out.println(treeSet.size());
            System.out.println(treeSet);
        }
}

class TestString{
    	public static void main(String[] args) {
    	    TreeSet<String> treeSet = new TreeSet<>();
    	    treeSet.add("abc");
    	    treeSet.add("bc");
    	    treeSet.add("abc");
    	    treeSet.add("ab");

            System.out.println(treeSet.size());
            System.out.println(treeSet);
        }
}

class TestPerson{
    public static void main(String[] args) {
        TreeSet<Person> treeSet = new TreeSet<>();
        treeSet.add(new Person(1, "liSi"));
        treeSet.add(new Person(12, "liSi"));
        treeSet.add(new Person(1, "liSi"));
        System.out.println(treeSet.size());
        System.out.println(treeSet);
    }
}

class TestLinkedList{
    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(1);
        linkedList.add(12);
        linkedList.add(133);
        linkedList.add(121);
        linkedList.add(1123);
        linkedList.add(1232323);
        linkedList.add(null);
        System.out.println(linkedList.size());
        System.out.println(linkedList);
    }
}

class TestPerson2{
	public static void main(String[] args) {
	    TreeSet<Person> treeSet = new TreeSet<>(Comparator.comparing(o -> o.name));
        treeSet.add(new Person(1, "fliSi"));
        treeSet.add(new Person(12, "fliSi"));
        treeSet.add(new Person(1, "aliSi"));
        System.out.println(treeSet.size());
        System.out.println(treeSet);

	}
}

class Test3{
    public static void main(String[] args) {
        List<Object> list = new ArrayList<>();
        // extends 泛型的上限
        List<? extends Person> list1 = new ArrayList<>();
        List<Student> list2 = new ArrayList<>();
        list1 = list2;
        // super 关键字修饰的叫泛型的下限
        List<? super Person> list3 = new ArrayList<>();
        // list3 = list2;
    }
}
class Person implements Comparable<Person> {
    int age;
    String name;

    public Person() {
    }

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Person o) {
        return this.age - o.age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
class Student extends Person{}