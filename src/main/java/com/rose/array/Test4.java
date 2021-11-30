package com.rose.array;

import java.util.Arrays;
import java.util.HashSet;

/**
 * Created on 2021/10/16 15:54
 *
 * @author Rose
 *
 *          存在重复元素
 *
 *  给定一个整数数组，判断是否存在重复元素。
 *
 * 如果存在一值在数组中出现至少两次，函数返回 true 。如果数组中每个元素都不相同，则返回 false 。
 *
 */
public class Test4 {

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5,6,7,8,9,1};
        System.out.println(containsDuplicate1(nums));
        System.out.println(containsDuplicate2(nums));
    }


    public static boolean containsDuplicate1(int[] nums) {
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return true;
            }
        }
        return false;
    }

    public static boolean containsDuplicate2(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (!set.add(nums[i])){
                return true;
            }
        }
        return false;
    }

}
