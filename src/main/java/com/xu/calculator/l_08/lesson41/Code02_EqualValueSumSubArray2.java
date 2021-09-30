package com.xu.calculator.l_08.lesson41;

import com.xu.util.ArrayUtils;
import com.xu.util.SortUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * java_study
 *
 * 给定一个整数组成的无序数组arr，值可能正、可能负、可能0
 * 给定一个整数值K
 * 找到arr的所有子数组里，哪个子数组的累加和等于K，并且是长度最大的
 * 返回其长度
 */
public class Code02_EqualValueSumSubArray2 {
    private static int aweSome(int[] arr, int K) {
        int ans = 0;
        int N = arr.length;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += arr[i];
            if (map.containsKey(sum - K)) {
                ans = Math.max(ans, i - map.get(sum - K));
            } else {
                map.put(sum, i);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] generate = ArrayUtils.generate(10, 10);
        SortUtil.print(generate);
        aweSome(generate, 1);

        List list = new ArrayList();
        Map map = new HashMap();

    }
}
