package com.rose.random;

import java.util.Arrays;

/**
 * Created on 2022/7/4 14:35
 *
 * @author Lakers
 *
 * 556. 下一个更大元素 III
 *
 *给你一个正整数n ，请你找出符合条件的最小整数，其由重新排列 n中存在的每位数字组成，并且其值大于 n 。如果不存在这样的正整数，则返回 -1 。
 *
 * 注意 ，返回的整数应当是一个 32 位整数 ，如果存在满足题意的答案，但不是 32 位整数 ，同样返回 -1 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/next-greater-element-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Test20220703 {

    public int nextGreaterElement(int n) {
        char[] chars = String.valueOf(n).toCharArray();
        int length = chars.length;

        int i = length - 2;
        while (i >= 0 && chars[i] >= chars[i + 1]){
            i--;
        }

        if (i < 0){
            return -1;
        }

        int j = length - 1;
        while (j >= 0 && chars[j] <= chars[i]){
            j--;
        }

        swap(chars, i, j);
        reverseArray(chars, i + 1, length - 1);

        long res = Long.parseLong(String.valueOf(chars));

        return  res > Integer.MAX_VALUE ? -1 : (int)res;
    }

    private void swap(char[] nums, int i, int j) {
        char temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void reverseArray(char[] nums, int start, int end){
        for ( ; start < end; start++,end--) {
            char temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
        }
    }

}
