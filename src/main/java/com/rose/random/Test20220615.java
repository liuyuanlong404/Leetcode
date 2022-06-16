package com.rose.random;

import java.util.Arrays;

/**
 * Created on 2022/6/15 10:33
 *
 * @author Lakers
 *
 *
 * 719. 找出第 K 小的数对距离
 * 数对 (a,b) 由整数 a 和 b 组成，其数对距离定义为 a 和 b 的绝对差值。
 *
 * 给你一个整数数组 nums 和一个整数 k ，数对由 nums[i] 和 nums[j] 组成且满足 0 <= i < j < nums.length 。返回 所有数对距离中 第 k 小的数对距离。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/find-k-th-smallest-pair-distance
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Test20220615 {

    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        //最小的数对和最大的数对
        int l = 0, r = nums[nums.length-1] - nums[0];
        //二分查找答案
        while(l < r){
            int mid = (l + r) >> 1;
            if(getCnt(nums, mid) >= k){
                r = mid;
            }else{
                l = mid + 1;
            }
        }
        return l;
    }
    int getCnt(int[] nums, int val){
        //统计数对个数
        int ans = 0, left = 0;
        for(int i = 0; i < nums.length; i++){
            while(left < i && nums[i] - nums[left] > val) {
                left++;
            }
            ans += i - left;
        }
        return ans;
    }
}
