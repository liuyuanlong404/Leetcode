package com.rose.string;


import java.util.*;

/**
 * Created on 2021/11/26 9:25
 *
 * @author Rose
 *
 *                          字符串中的第一个唯一字符
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 *
 */
public class Test3 {

    public int firstUniqChar(String s) {
        HashMap<Character,Integer> map = new HashMap(s.length());
        char[] chars = s.toCharArray();
        //先统计每个字符出现的次数
        for (char ch : chars) {
            map.put(ch, map.getOrDefault(ch,0) + 1);
        }
        //然后在遍历字符串s中的字符，如果出现次数是1就直接返回
        for (int i = 0; i < s.length(); i++) {
            if (map.get(chars[i]) == 1) {
                return i;
            }
        }
        return -1;
    }

    public static int firstUniqChar2(String s) {
        //javaApi解法 一个从前查找，一个从后查找，如果下标相等，说明只出现了一次
        for (int i = 0; i < s.length(); i++) {
            if (s.indexOf(s.charAt(i)) == s.lastIndexOf(s.charAt(i))) {
                return i;
            }
        }
        return -1;
    }
}
