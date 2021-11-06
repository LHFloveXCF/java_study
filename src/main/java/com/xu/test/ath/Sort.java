package com.xu.test.ath;

import com.xu.util.ArrayUtils;
import org.apache.commons.lang.StringUtils;

import java.util.*;

/**
 * java_study
 * 算法基础：空间换时间；时间换空间
 */
public class Sort {
    private static int count;
    public static void main(String[] args) {
//        stringTest();
        resolveState();
//        calcCount();
//        System.out.println(count);
    }

    private static void calcCount() {
        int value = 38;
        int num = 3;
        subValue(value, num);
    }

    private static void subValue(int value, int num) {
        if (value == 17) {
            return;
        }
        count++;
        subValue(value - num, num);
    }

    /**
     * jdk1.8中用metaspace代替永久代来实现方法区；
     * 运行时常量池是在方法区中的；1.8以后都在堆中
     * 有些是逻辑概念；
     */
    private static void stringTest() {
        String str = "abc";
        String str2 = "abc";
        String str3 = new String("abc");
        String str4 = new String("abc");
        System.out.println(str == str2);
        System.out.println(str3 == str2);
        System.out.println(str3 == str4);

    }

    private static void calcTime() {
        int leave = 80957;
        long serverInitTime = 1632621600000L;
        String test;

        System.out.println(new Date(leave * 1000 + serverInitTime));


    }

    private static void calcState() {
        byte DULIN = 31;
        /****大梵天***/
        byte DA_FANTIAN = 32;

        int state = 0;

//        state |= (1 << 28);
        state |= (1 << 31);
//        state |= (1 << DA_FANTIAN);

        System.out.println(state);
    }

    private static void m() {
        count++;
        m();
    }

    private static void hex() {
        System.out.println(Integer.toHexString(1502));

    }

    private static void hashTest() {
        HashMap<String, String> map = new HashMap<>();
    }

    private static void queen2() {
        int n = 1024;
        boolean[] in = new boolean[n];
        int[] p = new int[n];
        q2(in, p, 1, n);
        System.out.println(count);
    }

    private static void q2(boolean[] in, int[] p, int now, int n) {
        if (now == n + 1) {
            count++;
            return;
        }
        for (int i = 1; i<=n; i++) {
            if (!in[i - 1]) {
                boolean flag = true;
                for (int j = 1; j<now; j++) {
                    if (Math.abs(now - j) == Math.abs(i - p[j - 1])) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    p[now - 1] = i;
                    in[i - 1] = true;
                    q2(in,p,now + 1, n);
                    in[i - 1] = false;
                }
            }
        }
    }

    private static void resolveState() {
        int state = 512;

        int n = 32;
        for (int i = 1; i <= n; i++) {
            int value = 1 << i;

            if ((state & value) > 0) {
                System.out.println(i);
            }
        }

    }

    private static void queen() {
        int n = 2048;
        boolean[] in = new boolean[n];
        int[] p = new int[n];
        q(in, p, 1, n);
        System.out.println(count);
    }

    private static void q(boolean[] in, int[] p, int now, int n) {
        if (now == n + 1) {
            boolean flag = true;
            for (int i=1; i<=n; i++) {
                for (int j=i+1; j<=n; j++) {
                    if (Math.abs(j - i) == Math.abs(p[j - 1] - p[i - 1])) {
                        flag = false;
                        break;
                    }
                }
            }
            if (flag) {
                count++;
            }
            return;
        }

        for (int x = 1; x <= n; x++) {
            if (!in[x - 1]) {
                in[x - 1] = true;
                p[x - 1] = now;
                q(in, p, now + 1, n);
                in[x - 1] = false;
            }
        }
    }

    /**
     * 全排列
     */
    private static void fullPermutation() {
        int n = 3;
        List<int[]> result = new ArrayList<>();
        boolean[] in = new boolean[3];
        int[] p = new int[3];
        generatePermutation(result, n, 1, in, p);
        System.out.println(result.size());
        for (int[] ints : result) {
            System.out.println(Arrays.toString(ints));
        }
    }

    private static void generatePermutation(List<int[]> result, int n, int now, boolean[] in, int[] p) {
        if (now == n + 1) {
            result.add(Arrays.copyOf(p, p.length));
            return;
        }
        for (int j = 1; j <= n; j++) {
            if (!in[j - 1]) {
                p[now - 1] = j;
                in[j - 1] = true;
                generatePermutation(result, n, now + 1, in, p);
                in[j - 1] = false;
            }
        }
    }

    private static void fibonacci() {
        int n = 3;
        System.out.println(m(n));
        // 1 1 2 3
    }

    private static int m(int n) {
        if (n == 1 || n == 0) {
            return 1;
        }
        return m(n - 1) + m(n - 2);
    }

    private static void factorial() {
        int n = 3;
        System.out.println(f(3));
    }

    private static int f(int i) {
        if (i == 1) {
            return 1;
        }
        return f(i - 1) * i;
    }

    /**
     * M个数中是否包含N个数中的元素
     */
    private static void MFindN() {
        int maxValue = 100;
        int M = 40;
        int N = 4;
        int[] mArr = new int[M];
        int[] nArr = new int[N];
        boolean[] b = new boolean[maxValue];

        for (int i = 0; i < M; i++) {
            int value = (int) (Math.random() * maxValue + 1);
            b[value - 1] = true;
            mArr[i] = value;
        }
        System.out.println(Arrays.toString(mArr));
        System.out.println("-------------------");
        for (int i = 0; i < N; i++) {
            int value = (int) (Math.random() * maxValue + 1);
            nArr[i] = value;
        }
        System.out.println(Arrays.toString(nArr));
        System.out.println("-------------------");
        for (int i : nArr) {
            System.out.println(b[i - 1]);
        }
    }

    private static void sortStudent() {
        List<Student> one = new ArrayList<>();
        List<Student> two = new ArrayList<>();
        List<Student> three = new ArrayList<>();
        List<Student> four = new ArrayList<>();
        List<Student> five = new ArrayList<>();
        // 构造一些学生
        int[] indexArr = new int[]{1, 2, 3, 4, 5};
        int indexLength = indexArr.length;
        for (int i = 0; i < 100; i++) {
            int index = indexArr[(int) (Math.random() * indexLength)];
            int score = (int) (Math.random() * 100);
            Student student = new Student(i + 1, index, score);
            switch (index) {
                case 1:
                    one.add(student);
                    break;
                case 2:
                    two.add(student);
                    break;
                case 3:
                    three.add(student);
                    break;
                case 4:
                    four.add(student);
                    break;
                case 5:
                    five.add(student);
                    break;
            }
        }

        Collections.sort(one);
        Collections.sort(two);
        Collections.sort(three);
        Collections.sort(four);
        Collections.sort(five);

        List<Student> result = new ArrayList<>();
        result.addAll(one);
        result.addAll(two);
        result.addAll(three);
        result.addAll(four);
        result.addAll(five);
        Collections.sort(result);

        for (Student student : result) {
            int rank = -1;
            switch (student.getIndex()) {
                case 1:
                    rank = one.indexOf(student);
                    break;
                case 2:
                    rank = two.indexOf(student);
                    break;
                case 3:
                    rank = three.indexOf(student);
                    break;
                case 4:
                    rank = four.indexOf(student);
                    break;
                case 5:
                    rank = five.indexOf(student);
                    break;
            }
            SortStudentWrapper studentWrapper = new SortStudentWrapper(student, rank);
            System.out.println(studentWrapper);
        }

    }

    /**
     * 回文串
     *
     * @param str
     * @return
     */
    private static boolean palindrome(String str) {
        String s1 = StringUtils.reverse(str);
        return s1.equals(str);
    }

    /**
     * 反转字符串
     *
     * @param str
     */
    private static void reverse(String str) {
        System.out.println(StringUtils.reverse(str));
    }

    private static void draw(int n, char c) {
        int row = n / 2;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < n; j++) {
                if (i != 0 && i != row - 1) {
                    if (j != 0 && j != n - 1) {
                        System.out.print(" ");
                        continue;
                    }
                }
                System.out.print(c);
            }
            System.out.println();
        }
    }

    private static int findX(int n) {
        int[] arr = ArrayUtils.generate(4, 200);
        System.out.println(Arrays.toString(arr));
        return org.apache.commons.lang.ArrayUtils.indexOf(arr, n);
    }

    private static String biggest() {
        System.out.println("请输入学院编号，以及学生成绩");
        int[][] schoolScore = new int[4][1];
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String line = scanner.nextLine();
            String[] s = line.split(" ");
            int schoolId = Integer.parseInt(s[0]);
            int score = Integer.parseInt(s[1]);
            if (schoolId <= 0 || schoolId > schoolScore.length) {
                System.out.println("参数错误，请重新输入！");
                continue;
            } else if (score == -1) {
                break;
            }
            schoolScore[schoolId - 1][0] += score;
        }
        int max = schoolScore[0][0];
        int maxSchoolId = 1;
        for (int i = 0; i < 4; i++) {
            if (schoolScore[i][0] > max) {
                maxSchoolId = i + 1;
                max = schoolScore[i][0];
            }
        }
        return String.format("%d_%d", maxSchoolId, max);
    }

    private static int cart(int n) {
        int count = 0;
        while (n != 1) {
            count++;
            if (n % 2 == 0) {
                n = n / 2;
            } else {
                n = (3 * n + 1) / 2;
            }
        }
        return count;
    }

    private static void sort() {
        int[] arr = ArrayUtils.generate(5, 100);
        System.out.println(Arrays.toString(arr));

        int length = arr.length;
        for (int i = 1; i <= length; i++) {
            for (int j = 0; j < length - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    private static void insertSort() {
        int[] arr = ArrayUtils.generate(5, 100);
        System.out.println(Arrays.toString(arr));
        int length = arr.length;
        for (int i = 0; i < length; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j] > arr[j - 1]) {
                    break;
                }
                int temp = arr[j - 1];
                arr[j - 1] = arr[j];
                arr[j] = temp;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    private static void selectSort() {
        int[] arr = ArrayUtils.generate(5, 100);
        System.out.println(Arrays.toString(arr));
        int length = arr.length;

        for (int i = 0; i < length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

}

class Student implements Comparable<Student> {

    private long id;
    private int index;
    private int score;

    public Student(long id, int index, int score) {
        this.id = id;
        this.index = index;
        this.score = score;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public int compareTo(Student o) {
        return this.score - o.score == 0 ? (int) (this.id - o.id) : this.score - o.score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", index=" + index +
                ", score=" + score +
                '}';
    }
}

/**
 * 学生排名包装类，包含考场排名
 */
class SortStudentWrapper {
    private Student student;
    private int rank;

    public SortStudentWrapper(Student student, int rank) {
        this.student = student;
        this.rank = rank;
    }

    @Override
    public String toString() {
        return "SortStudentWrapper{" +
                "student=" + student +
                ", rank=" + rank +
                '}';
    }
}