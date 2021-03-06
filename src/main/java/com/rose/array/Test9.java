package com.rose.array;

import java.util.HashMap;
import java.util.Map;

/**
 * Created on 2021/10/18 15:59
 *
 * @author Rose
 *
 *                                  两数之和
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 * 你可以按任意顺序返回答案。
 *
 */
public class Test9 {

    public static void main(String[] args) {

    }

    public static int[] twoSum(int[] nums, int target) {
        int [] res = new int[2];
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int temp = target - nums[i];
            if (map.containsKey(temp)){
                res[1] = i;
                res[0] = map.get(temp);
            }
            map.put(nums[i],i);
        }
        return res;
    }
}
