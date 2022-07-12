package com.rose.binary;

/**
 * Created on 2022/7/9 13:52
 *
 * @author Lakers
 *
 * 69. x 的平方根
 *
 * 给你一个非负整数 x ，计算并返回x的算术平方根 。
 *
 * 由于返回类型是整数，结果只保留整数部分 ，小数部分将被舍去 。
 *
 * 注意：不允许使用任何内置指数函数和算符，例如 pow(x, 0.5) 或者 x ** 0.5 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/sqrtx
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Test69 {

    public static void main(String[] args) {
        new Test69().mySqrt(2147395599);
    }

    public int mySqrt(int x) {
        int l = 0, r = x, ans = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if ((long) mid * mid <= x) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }
}
