package com.rose.binary;

/**
 * Created on 2022/7/7 9:30
 *
 * @author Lakers
 *
 *35. 搜索插入位置
 *
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 *
 * 请必须使用时间复杂度为 O(log n) 的算法
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/search-insert-position
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Test35 {

    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        if (target > nums[right]){
            return nums.length;
        }

        if (target < nums[0]){
            return 0;
        }

        while (left <= right){
            int mid = (right - left) >> 1 + left;
            if (nums[mid] == target){
                return mid;
            }else if (target > nums[mid]){
                left = mid + 1;
                if (target < nums[left]){
                    return left;
                }
            }else {
                right = mid - 1;
                if (target > nums[right]){
                    return right;
                }
            }
        }

        return left;
    }
}
