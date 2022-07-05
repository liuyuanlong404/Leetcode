package com.rose.offer;

/**
 * Created on 2022/7/5 10:36
 *
 * @author Lakers
 *
 * 剑指 Offer 43. 1～n 整数中 1 出现的次数
 *
 * 输入一个整数 n ，求1～n这n个整数的十进制表示中1出现的次数。
 *
 * 例如，输入12，1～12这些整数中包含1 的数字有1、10、11和12，1一共出现了5次。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/1nzheng-shu-zhong-1chu-xian-de-ci-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Test43 {

    public static void main(String[] args) {
        System.out.println(countDigitOne(888885312));
    }

    public static int countDigitOne(int n) {
        int res = 0;
        for (int i = 1; i <= n; i++){
            String nums = String.valueOf(i);
            if (nums.contains("1")){
                char[] chars = nums.toCharArray();
                for (char aChar : chars) {
                    if (aChar == '1') {
                        res++;
                    }
                }
            }
        }

        return res;
    }

    public int countDigitOne2(int n) {
        // mulk 表示 10^k
        // 在下面的代码中，可以发现 k 并没有被直接使用到（都是使用 10^k）
        // 但为了让代码看起来更加直观，这里保留了 k
        long mulk = 1;
        int ans = 0;
        for (int k = 0; n >= mulk; ++k) {
            ans += (n / (mulk * 10)) * mulk + Math.min(Math.max(n % (mulk * 10) - mulk + 1, 0), mulk);
            mulk *= 10;
        }
        return ans;
    }

}
