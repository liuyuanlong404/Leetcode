package com.rose.array;

import java.util.Arrays;

/**
 * Created on 2021/10/16 16:30
 *
 * @author Rose
 *
 *              加一
 *
 * 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
 *
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 *
 * 你可以假设除了整数 0 之外，这个整数不会以零开头
 *
 */
public class Test7 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(plusOne(new int[]{9, 9, 9, 9, 9, 9})));
    }

    public static int[] plusOne(int[] digits) {
        if (digits.length == 0){
            return digits;
        }
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] != 9){
                digits[i]++;
                return digits;
            }else {
                digits[i] = 0;
            }
        }
        int[] res = new int[digits.length + 1];
        res[0] = 1;
        return res;
    }
}
