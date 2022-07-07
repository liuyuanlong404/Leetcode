package com.rose.binary;

/**
 * Created on 2022/7/7 9:55
 *
 * @author Lakers
 *
 * 852. 山脉数组的峰顶索引
 *
 * 符合下列属性的数组 arr 称为 山脉数组 ：
 * arr.length >= 3
 * 存在 i（0 < i< arr.length - 1）使得：
 * arr[0] < arr[1] < ... arr[i-1] < arr[i]
 * arr[i] > arr[i+1] > ... > arr[arr.length - 1]
 * 给你由整数组成的山脉数组 arr ，返回任何满足 arr[0] < arr[1] < ... arr[i - 1] < arr[i] > arr[i + 1] > ... > arr[arr.length - 1] 的下标 i 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/peak-index-in-a-mountain-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Test852 {

    public static void main(String[] args) {
        peakIndexInMountainArray(new int[]{1,2,4,5});
    }

    public static int peakIndexInMountainArray(int[] arr) {
        int left = 0, right = arr.length - 2;
        while (left <= right){
            int mid = ((right - left) >> 1) + left;

            if (arr[mid] > arr[mid + 1] && arr[mid] > arr[mid - 1]){
                return mid;
            }

            if (arr[mid] > arr[mid + 1] && arr[mid] < arr[mid - 1]){
                right = mid - 1;
            }

            if (arr[mid] < arr[mid + 1] && arr[mid] > arr[mid - 1]){
                left = mid + 1;
            }
        }

        return -1;
    }
}
