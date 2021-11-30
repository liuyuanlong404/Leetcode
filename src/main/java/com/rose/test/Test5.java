package com.rose.test;



/**
 * Created on 2021/9/9 17:06
 *  给定一个字符串s，找到s中最长的回文子串。你可以假设s的最大长度为 1000。
 * @author Rose
 */
public class Test5 {

    public static void main(String[] args) {
        System.out.println(longestPalindrome("fads"));
    }

    public static String longestPalindrome(String s) {
        int len = s.length();
        if (len <= 1){
            return s;
        }
        //初始化数组与
        String maxStr = s.substring(0,1);
        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        for (int right = 1;right < len;right++){
            for (int left = 0; left < right ; left++) {
                if (s.charAt(left) != s.charAt(right)){
                    dp[left][right] = false;
                    continue;
                }
                //两端相等的话
                if (left + 1 >= right - 1){
                    dp[left][right] = true;
                }
                else {
                    dp[left][right] = dp[left + 1][right - 1];
                }
                if (dp[left][right] && right-left + 1 > maxStr.length()){
                    maxStr = s.substring(left,right + 1);
                }
            }
        }
        return maxStr;
    }
}
