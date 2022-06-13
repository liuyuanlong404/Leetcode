package com.rose.test;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created on 2021/10/15 10:05
 *
 * @author Rose
 *
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 */
public class Test16 {

    public static void main(String[] args) {
        System.out.println(isValid("({[]})"));
    }


    public static boolean isValid(String s) {
        Deque<Character> deque = new LinkedList<>();
        char ch;
        for (int i = 0; i < s.length(); i++) {
            ch = s.charAt(i);
            //碰到左括号，就把相应的右括号入栈
            if (ch == '(') {
                deque.push(')');
            } else if (ch == '{') {
                deque.push('}');
            } else if (ch == '[') {
                deque.push(']');
            } else if (!deque.isEmpty() && deque.peek() == ch) {
                //栈中元素不为空 且栈顶元素等于匹配字符 则出栈
                deque.pop();
            } else {
                return false;
            }
        }
        //最后判断栈中元素是否全部匹配
        return deque.isEmpty();
    }
}



