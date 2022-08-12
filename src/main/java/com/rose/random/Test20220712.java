package com.rose.random;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created on 2022/7/12 16:02
 *
 * @author Lakers
 *
 * 1252. 奇数值单元格的数目
 *
 * 给你一个 m x n 的矩阵，最开始的时候，每个单元格中的值都是 0。
 *
 * 另有一个二维索引数组indices，indices[i] = [ri, ci] 指向矩阵中的某个位置，其中 ri 和 ci 分别表示指定的行和列（从 0 开始编号）。
 *
 * 对 indices[i] 所指向的每个位置，应同时执行下述增量操作：
 *
 * ri 行上的所有单元格，加 1 。
 * ci 列上的所有单元格，加 1 。
 * 给你 m、n 和 indices 。请你在执行完所有indices指定的增量操作后，返回矩阵中 奇数值单元格 的数目。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/cells-with-odd-values-in-a-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Test20220712 {

    public int oddCells(int m, int n, int[][] indices) {
        int[][] res = new int[m][n];

        AtomicInteger num = new AtomicInteger();
        for (int[] index : indices){
            int index1 = index[0];
            int index2 = index[1];


            for (int i = 0; i < n; i++){
                res[index1][i]++;
            }

            for (int i = 0; i < m; i++){
                res[i][index2]++;
            }
        }

        Arrays.stream(res).forEach(i -> Arrays.stream(i).forEach(j -> {
            if ((j & 1) != 0){
                num.getAndIncrement();
            }

        }));

        return num.get();
    }
}
