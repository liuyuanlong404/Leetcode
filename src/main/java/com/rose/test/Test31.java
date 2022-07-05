package com.rose.test;

/**
 * Created on 2022/7/4 15:23
 *
 * @author Lakers
 *
 * 31. 下一个排列
 */
public class Test31 {

    public static void main(String[] args) {
        new Test31().nextPermutation(new int[]{1,3,2});
    }

    public void nextPermutation(int[] nums) {
        int length = nums.length;

        int i = length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]){
            i--;
        }

        if (i < 0){
            reverseArray(nums, 0, length - 1);
            return;
        }

        int j = length - 1;
        while (j >= 0 && nums[j] <= nums[i]){
            j--;
        }

        swap(nums, i, j);
        reverseArray(nums, i + 1, length - 1);
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void reverseArray(int[] nums, int start, int end){
        for ( ; start < end; start++,end--) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
        }
    }
}
