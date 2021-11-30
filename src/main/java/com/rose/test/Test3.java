package com.rose.test;

import com.rose.entity.Student;

import java.util.*;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

/**
 * Created on 2021/9/9 14:29
 *
 * @author Rose
 */
public class Test3 {

    public static void main(String[] args) {
        List<Student> list = null;
        list.forEach(System.out::println);
    }

    public static int lengthOfLongestSubstring(String s) {
        if ("".equals(s) || Objects.isNull(s)){
            return 0;
        }
        char [] chars = s.toCharArray();
        Set<Character> characters = new HashSet<>();
        int max = 0;
        int num = 0;
        while (num < chars.length) {
            for (int i = num; i < chars.length; i++) {
                if (characters.contains(chars[i])) {
                    if (max < characters.size()) {
                        max = characters.size();
                    }
                    characters.clear();
                    num++;
                    break;
                }
                characters.add(chars[i]);
            }
        }
        return max;
    }

    public static String longestPalindrome(String s) {
        char [] chars = s.toCharArray();
        List<Character> characters = new ArrayList<>();
        int num = 0;
        String res = "";
        while (num < chars.length) {
            for (int i = num; i < chars.length; i++) {
                if (characters.contains(chars[i])) {
                    if (res.length() < characters.size() - 1) {
                        res = "";
                        for (int j = 0; j < characters.size(); j++) {
                            res = res + characters.get(j);
                        }
                        res = res + characters.get(0);
                    }
                    characters.clear();
                    num++;
                    break;
                }
                characters.add(chars[i]);
            }
        }
        return res;
    }
}
