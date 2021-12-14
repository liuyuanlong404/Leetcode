package com.rose.string;

import java.util.Arrays;

/**
 * Created on 2021/12/2 14:06
 *
 * @author Lakers
 *
 *                         有效的字母异位词
 *  给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 *  注意：若 s 和 t 中每个字符出现的次数都相同，则称 s 和 t 互为字母异位词。
 *
 */
public class Test4 {

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()){
            return false;
        }

        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        Arrays.sort(sChars);
        Arrays.sort(tChars);

        return Arrays.equals(sChars, tChars);
    }
}
