package com.rose.test;

/**
 * Created on 2021/9/18 14:21
 * 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
 * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。例如，121 是回文，而 123 不是
 * @author Rose
 */
public class Test7 {

    public static void main(String[] args) {
        System.out.println(isPalindrome(12344321));
        System.out.println(isPalindrome("123456789987654321"));
    }

    public static boolean isPalindrome(int x) {
        if (x == 0){
            return true;
        }
        if (x < 0 || x % 10 == 0){
            return false;
        }
        int a = 0, y = x;
        while (y != 0){
            a = a * 10 + y % 10;
            y = y / 10;
        }
        return x == a;
    }

    public static boolean isPalindrome(String s) {
        char[] chars = s.toCharArray();
        int length = chars.length;
        if (length == 1 && Integer.parseInt(String.valueOf(chars[0]))== 0){
            return true;
        }
        if ("-".equals(String.valueOf(chars[0])) || Integer.parseInt(String.valueOf(chars[length - 1]))== 0){
            return false;
        }
        boolean flag = false;
        int num = 0;
        while (num < length/2){
            if (chars[num] == chars[length - 1 - num]){
                flag = true;
                num++;
            }else {
                flag = false;
                break;
            }
        }
        return flag;
    }
}
