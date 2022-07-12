package com.rose.random;

/**
 * Created on 2022/7/8 15:46
 *
 * @author Lakers
 *
 * 1217. 玩筹码
 *
 * 有n个筹码。第 i 个筹码的位置是position[i]。
 *
 * 我们需要把所有筹码移到同一个位置。在一步中，我们可以将第 i 个筹码的位置从position[i]改变为:
 *
 * position[i] + 2或position[i] - 2，此时cost = 0
 * position[i] + 1或position[i] - 1，此时cost = 1
 * 返回将所有筹码移动到同一位置上所需要的 最小代价 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/minimum-cost-to-move-chips-to-the-same-position
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Test20220708 {

    public int minCostToMoveChips(int[] position) {
        int even = 0, odd = 0;
        for (int pos : position) {
            if ((pos & 1) != 0) {
                odd++;
            } else {
                even++;
            }
        }
        return Math.min(odd, even);
    }
}
