package com.rose.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created on 2021/10/16 16:17
 *
 * @author Rose
 *
 *     两个数组的交集 II
 *
 * 给定两个数组，编写一个函数来计算它们的交集
 *
 *
 */
public class Test6 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(intersect(new int[]{1, 2, 3, 4, 3, 1, 3}, new int[]{3})));
    }

    public static int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> list = new ArrayList<>();
        for (int i = 0, j = 0; i < nums1.length && j < nums2.length; ){
            if (nums1[i] == nums2[j]){
                list.add(nums1[i]);
                i++;
                j++;
            }else if (nums1[i] < nums2[j]){
                i++;
            }else {
                j++;
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

}
