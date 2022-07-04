package com.rose.random;

import java.util.*;

/**
 * Created on 2022/6/17 9:26
 *
 * @author Lakers
 *
 *  1089. 复写零
 *
 * 给你一个长度固定的整数数组arr，请你将该数组中出现的每个零都复写一遍，并将其余的元素向右平移。
 *
 * 注意：请不要在超过该数组长度的位置写入元素。
 *
 * 要求：请对输入的数组就地进行上述修改，不要从函数返回任何东西。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/duplicate-zeros
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Test20220617 {

    public static void main(String[] args) {
        duplicateZeros2(new int[]{0,0,0,0,0,0,0});
    }

    public static void duplicateZeros(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0){
                i++;
                int j = arr.length - 1;
                while (j >= i){
                    arr[j] = arr[j - 1];
                    j--;
                }

                if (i < arr.length) {
                    arr[i] = 0;
                }
            }
        }
    }


    /**
     * 队列
     */
    public static void duplicateZeros2(int[] arr){
        Deque<Integer> deque = new LinkedList<>();
        for (int j : arr) {
            deque.add(j);
            if (j == 0) {
                deque.add(0);
            }

            if (deque.size() >= arr.length) {
                break;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i] = deque.pop();
        }
    }

}
