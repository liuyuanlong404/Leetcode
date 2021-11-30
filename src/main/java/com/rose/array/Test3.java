package com.rose.array;

/**
 * Created on 2021/10/16 14:13
 *
 * @author Rose
 *
 *              旋转数组
 *
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 *
 */
public class Test3 {

    public static void main(String[] args) {
        int[] nums = new int[]{-1};
        rotate(nums,2);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }

    public static void rotate(int[] nums, int k) {
        k = k % nums.length;
        reverseArray(nums,0,nums.length - 1);
        reverseArray(nums,0,k-1);
        reverseArray(nums,k,nums.length - 1);
    }

    public static void reverseArray(int[] nums, int start, int end){
        for ( ; start < end; start++,end--) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
        }
    }
}
