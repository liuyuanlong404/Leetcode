package com.rose.test;

import java.util.Arrays;

/**
 * Created on 2021/10/12 13:05
 * @author Rose
 *
 * 给定一个包括n个整数的数组nums和一个目标值target。
 * 找出nums中的三个整数，使得它们的和与target最接近。
 * 返回这三个数的和。假定每组输入只存在唯一答案
 *
 */
public class Test12 {

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,3,6,-5,15,54,5985,4,4};
        System.out.println(threeSumClosest(nums,6021));
    }

    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int res = 0;
        int difference = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - 2; i++){
            int j = i + 1, k = nums.length - 1;
            while(j < k){
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == target){
                    return sum;
                }
                if (Math.abs(sum - target) < difference){
                    difference = Math.abs(sum - target);
                    res = sum;
                }
                if (sum < target){
                    j++;
                }
                if (sum > target){
                    k--;
                }
            }
        }
        return res;
    }
}
