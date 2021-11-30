package com.rose.test;

/**
 * Created on 2021/9/10 16:52
 * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果
 * @author Rose
 */
public class Test6 {

    public static void main(String[] args) {
        System.out.println(reverse(85239014));
    }

    public static int reverse(int x) {
        long n = 0;
        while(x != 0) {
            n = n*10 + x%10;
            x = x/10;
        }
        return (int)n==n? (int)n:0;
    }
}
