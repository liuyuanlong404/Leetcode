package com.rose.array;

import java.util.HashSet;
import java.util.Set;

/**
 * Created on 2021/10/16 16:01
 *
 * @author Rose
 *
 *                                      只出现一次的数字
 *
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素
 *
 */
public class Test5 {

    public static void main(String[] args) {
        System.out.println(2^1);
    }


    public int singleNumber1(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (!set.add(nums[i])){
                 set.remove(nums[i]);
            }
        }
        return (int) set.toArray()[0];
    }

    /**
     * 使用异或运算，将所有值进行异或
     * 异或运算，相异为真，相同为假，所以 a^a = 0 ;0^a = a
     * 因为异或运算 满足交换律 a^b^a = a^a^b = b 所以数组经过异或运算，单独的值就剩下了
     * @param nums 数组
     * @return 唯一不相同的数
     */
    public int singleNumber2(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res = res ^ nums[i];
        }
        return res;
    }
}
