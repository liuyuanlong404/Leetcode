package com.rose.test;

/**
 * Created on 2021/9/18 15:51
 *
 * @author Rose
 */
public class Test8 {

    public static void main(String[] args) {
        int[] height = new int[]{4,3,2,1,4};
        System.out.println(maxArea(height));
    }

    public static int maxArea(int[] height) {
        int max = 0;
        for (int i = 0, j = height.length - 1; i < j; ){
            int res = height[i] < height[j] ? height[i++] : height[j--];
            max = Math.max(max,(j - i +1) * res);
        }
        return max;
    }
}
