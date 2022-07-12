package com.rose.binary;

/**
 * Created on 2022/7/8 16:25
 *
 * @author Lakers
 *
 * 1385. 两个数组间的距离值
 *
 * 给你两个整数数组arr1，arr2和一个整数d，请你返回两个数组之间的距离值。
 *
 * 「距离值」定义为符合此距离要求的元素数目：对于元素arr1[i]，不存在任何元素arr2[j]满足 |arr1[i]-arr2[j]| <= d 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/find-the-distance-value-between-two-arrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Test1385 {

    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int res = 0;
        for (int i : arr1) {
            for (int j : arr2) {
                if (Math.abs(i - j) <= d){
                    res--;
                    break;
                }
            }
            res++;
        }

        return res;
    }
}
