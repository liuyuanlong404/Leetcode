package com.rose.binary;

/**
 * Created on 2022/7/6 17:01
 *
 * @author Lakers
 *
 * 704.二分查找
 */
public class Test704 {

    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right){
            int mid = (right + left) / 2;
            int num = nums[mid];
            if (num == target){
                return mid;
            }else if (num > target){
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        return -1;
    }

    public int search2(int[] nums, int target){
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            int num = nums[mid];
            if (num == target) {
                return mid;
            } else if (num > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}
