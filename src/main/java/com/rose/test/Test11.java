package com.rose.test;

import cn.hutool.core.convert.Convert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created on 2021/10/11 16:28
 * @author Rose
 *
 *给你一个包含 n 个整数的数组nums，判断nums中是否存在三个元素 a，b，c ，使得a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 */
public class Test11 {

    public static void main(String[] args) {
        String s = "-5,-4,-3,-2,-1,0,1,1,2,1,3,1,5,1,6,8,2,9,10,5,15";
        Integer[] integers = Convert.toIntArray(s.split(","));
        List<List<Integer>> lists = threeSum(integers);
        lists.forEach(System.out::println);
    }

    public static List<List<Integer>> threeSum(Integer[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        //排序
        Arrays.sort(nums);
        //双指针
        int len = nums.length;
        for(int i = 0;i < len;++i) {
            if(nums[i] > 0) {
                return lists;
            }
            if(i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            int curr = nums[i];
            int l = i+1, r = len-1;
            while (l < r) {
                int tmp = curr + nums[l] + nums[r];
                if(tmp == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(curr);
                    list.add(nums[l]);
                    list.add(nums[r]);
                    lists.add(list);
                    while(l < r && nums[l+1] == nums[l]) {
                        ++l;
                    }
                    while (l < r && nums[r-1] == nums[r]) {
                        --r;
                    }
                    ++l;
                    --r;
                } else if(tmp < 0) {
                    ++l;
                } else {
                    --r;
                }
            }
        }
        return lists;

    }
}
