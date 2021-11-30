package com.rose.test;

import java.util.Arrays;

/**
 * Created on 2021/9/9 16:29
 *
 * @author Rose
 */
public class Test4 {

    public static void main(String[] args) {
        System.out.println(findMedianSortedArrays(new int[]{1,2},new int[]{1,3,4}));;
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int [] res = new int[nums1.length + nums2.length];
        for (int i = 0; i < nums1.length;i++){
            res[i] = nums1[i];
        }
        for (int i = 0; i < nums2.length; i++) {
            res[nums1.length + i] = nums2[i];
        }
        Arrays.sort(res);
        Arrays.stream(res).forEach(System.out::println);
        int a = res.length % 2;
        int b = res.length / 2;
        double c = 0;
        if (a == 0){
            c = (double) (res[b - 1] + res[b]) / 2;
        }else {
            c = res[b];
        }
        return c;
    }
}
