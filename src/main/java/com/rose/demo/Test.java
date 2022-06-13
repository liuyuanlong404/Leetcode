package com.rose.demo;

import java.lang.reflect.Field;
import java.util.Arrays;

/**
 * Created on 2022/6/13 9:56
 *
 * @author Lakers
 */
public class Test {

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        String name = "Lakers";
        Field field = String.class.getDeclaredField("value");
        field.setAccessible(true);
        char[] value = (char[]) field.get(name);
        value[0] = 'a';
        System.out.println(value);
        System.out.println("Lakers" == name);
    }

    public int heightChecker(int[] heights) {
        int [] copy = heights.clone();
        Arrays.sort(heights);
        int res = 0;
        for (int i = 0; i < heights.length; i++) {
            if (copy[i] != heights[i]){
                res++;
            }
        }

        return res;
    }
}
