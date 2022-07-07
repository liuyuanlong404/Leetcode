package com.rose.binary;

/**
 * Created on 2022/7/6 17:20
 *
 * @author Lakers
 *
 * 374. 猜数字大小
 *
 * 猜数字游戏的规则如下：
 *
 * 每轮游戏，我都会从1到n 随机选择一个数字。 请你猜选出的是哪个数字。
 * 如果你猜错了，我会告诉你，你猜测的数字比我选出的数字是大了还是小了。
 * 你可以通过调用一个预先定义好的接口 int guess(int num) 来获取猜测结果，返回值一共有 3 种可能的情况（-1，1或 0）：
 *
 * -1：我选出的数字比你猜的数字小 pick < num
 * 1：我选出的数字比你猜的数字大 pick > num
 * 0：我选出的数字和你猜的数字一样。恭喜！你猜对了！pick == num
 * 返回我选出的数字。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/guess-number-higher-or-lower
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Test374 {

    public int guessNumber(int n) {
        int left = 1;
        while (left <= n){
            int res = (n - left) / 2 + left;
            int num = guess(res);
            if (num == 0){
                return res;
            }else if (num == 1){
                left = res + 1;
            }else {
                n = res - 1;
            }
        }
        return -1;


    }

    private int guess(int res) {
        return 0;
    }
}
