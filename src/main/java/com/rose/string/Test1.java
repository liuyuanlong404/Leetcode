package com.rose.string;

/**
 * Created on 2021/11/4 17:46
 *
 * @author Rose
 */
public class Test1 {

    public static void main(String[] args) {
        char[] s = {'1','2'};
        reverseString(s);
        System.out.println(s);
    }

    public static void reverseString(char[] s) {
        for (int i = 0; i < s.length / 2; i++){
            char c = s[i];
            s[i] = s[s.length - i - 1];
            s[s.length - i - 1] = c;
        }
    }
}
