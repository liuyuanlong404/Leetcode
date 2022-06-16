package com.rose.random;

import java.util.*;

/**
 * Created on 2022/6/16 9:33
 *
 * @author Lakers
 *
 * 532. 数组中的 k-diff 数对
 *
 * 给定一个整数数组和一个整数k，你需要在数组里找到 不同的k-diff 数对，并返回不同的 k-diff 数对 的数目。
 *
 * 这里将k-diff数对定义为一个整数对 (nums[i], nums[j])，并满足下述全部条件：
 *
 * 0 <= i < j < nums.length
 * |nums[i] - nums[j]| == k
 * 注意，|val| 表示 val 的绝对值。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/k-diff-pairs-in-an-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Test20220616 {

    public static int findPairs(int[] nums, int k) {
        Arrays.sort(nums);

        Map<Integer, Set<Integer>> map = new HashMap<>();
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])){
                continue;
            }

            Set<Integer> set = new HashSet<>();
            for (int j = i + 1; j < nums.length; j++){
                if (k == Math.abs(nums[i] - nums[j])) {
                    if (set.add(nums[j])){
                        res++;
                        map.put(nums[i], set);
                    }
                }
            }
        }

        return res;
    }

    /**
     * 排序+双指针
     */
    public static int findPairs2(int[] nums, int k) {
        // 升序排列
        Arrays.sort(nums);
        int length = nums.length, y = 0, res = 0;

        // 双指针
        for (int x = 0; x < length; x++) {
            // 如果数字相同直接跳过(x==0防止数组的值全部相等)
            if (x == 0 || nums[x] != nums[x - 1]) {

                //
                while (y < length && (nums[y] < nums[x] + k || y <= x)) {
                    y++;
                }

                if (y < length && nums[y] == nums[x] + k) {
                    res++;
                }

            }
        }
        return res;
    }
}
