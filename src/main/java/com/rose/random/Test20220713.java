package com.rose.random;

import java.util.Stack;

/**
 * Created on 2022/7/13 10:20
 *
 * @author Lakers
 *
 * 735. 行星碰撞
 *
 * 给定一个整数数组 asteroids，表示在同一行的行星。
 *
 * 对于数组中的每一个元素，其绝对值表示行星的大小，正负表示行星的移动方向（正表示向右移动，负表示向左移动）。每一颗行星以相同的速度移动。
 *
 * 找出碰撞后剩下的所有行星。碰撞规则：两个行星相互碰撞，较小的行星会爆炸。如果两颗行星大小相同，则两颗行星都会爆炸。两颗移动方向相同的行星，永远不会发生碰撞
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/asteroid-collision
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Test20220713 {

    public static void main(String[] args) {
        asteroidCollision(new int[]{-2,1,1,-1});
    }

    public static int[] asteroidCollision(int[] asteroids) {

        Stack<Integer> positiveNumber = new Stack<>();
        Stack<Integer> negativeNumber = new Stack<>();
        
        for (int i = 0; i < asteroids.length; i++) {
            if (asteroids[i] > 0){
                positiveNumber.push(asteroids[i]);
            }else {
                negativeNumber.push(asteroids[i]);
                while (!positiveNumber.empty()){
                    Integer peek = positiveNumber.peek();
                    int abs = Math.abs(asteroids[i]);
                    if (peek < abs){
                        positiveNumber.pop();
                    }else if (peek == abs){
                        positiveNumber.pop();
                        negativeNumber.pop();
                        break;
                    }else  {
                        negativeNumber.pop();
                        break;
                    }
                }
            }
        }

        int[] ints = positiveNumber.stream().mapToInt(Integer::intValue).toArray();
        int[] ints1 = negativeNumber.stream().mapToInt(Integer::intValue).toArray();

        int[] res = new int[ints.length + ints1.length];
        for (int i = 0; i < ints1.length; i++) {
            res[i] = ints1[i];
        }

        for (int i = 0; i < ints.length; i++){
            res[i + ints1.length] = ints[i];
        }
        return res;
    }
}
