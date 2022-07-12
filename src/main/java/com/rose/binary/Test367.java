package com.rose.binary;

/**
 * Created on 2022/7/8 16:04
 *
 * @author Lakers
 *
 * 367. 有效的完全平方数
 *
 * 给定一个 正整数 num ，编写一个函数，如果 num 是一个完全平方数，则返回 true ，否则返回 false 。
 *
 * 进阶：不要 使用任何内置的库函数，如  sqrt 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/valid-perfect-square
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Test367 {

    public static void main(String[] args) {
        System.out.println((int)Math.sqrt(8));
    }

    public static boolean isPerfectSquare(int num) {
        if (num == 1){
            return true;
        }

        int left = 1, right = num / 2;
        while (left <= right){
            int mid = ((right - left) >> 1) + left;
            long res = (long) mid * mid;
            if (res == num){
                return true;
            } else if (res > num) {
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }

        return false;
    }
}
