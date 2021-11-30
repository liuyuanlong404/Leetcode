package com.rose.test;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

/**
 * Created on 2021/10/15 11:32
 * @author Rose
 *
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且有效的括号组合
 *
 */
public class Test18 {


    public List<String> generateParenthesis(int n) {

        if (n == 0){
            return new ArrayList<>();
        }
        if (n == 1){
            return new ArrayList<>(Collections.singletonList("()"));
        }
        HashSet<String> set = new HashSet<>();
        for (String str : generateParenthesis(n - 1)){
            for (int i = 0; i <= str.length()/2; i++) {
                set.add(str.substring(0,i) + "()" + str.substring(i));
            }
        }
        return new ArrayList<>(set);
    }



}
