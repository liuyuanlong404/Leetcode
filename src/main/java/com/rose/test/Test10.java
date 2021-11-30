package com.rose.test;


/**
 * Created on 2021/10/11 16:06
 * @author Rose
 *
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串 ""。
 */
public class Test10 {

    public static void main(String[] args) {
        String s = "qweeee,qweeeeew,qw";
        String s1 = longestCommonPrefix(s.split(","));
        System.out.println(s1);
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        String s = strs[0];
        for (int i = 0; i < strs.length; i++) {
            while (!strs[i].startsWith(s)){
                if (s.length() == 0){
                    return "";
                }
                s = s.substring(0,s.length() - 1);
            }
        }
        return s;
    }
}
