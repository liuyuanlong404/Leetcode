package com.rose.array;

import lombok.Data;

import java.util.Arrays;

/**
 * Created on 2021/11/1 16:04
 *
 * @author Rose
 *
 *                          旋转图像
 * 给定一个 n×n 的二维矩阵matrix 表示一个图像。请你将图像顺时针旋转 90 度。
 *
 * 你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。
 *
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xnhhkv/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
@Data
public class Test11 {

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        rotate(matrix);
        Arrays.stream(matrix).forEach(array -> Arrays.stream(array).forEach(System.out::println));
    }

    public static void rotate(int[][] matrix) {

        int length = matrix.length;
        //上下行交换
        for (int i = 0; i < length / 2; i++){
            int[] temp = matrix[i];
            matrix[i] = matrix[length - i - 1];
            matrix[length - i - 1] = temp;
        }
        //对角线进行交换
        for (int i = 0; i < length; i++){
            for (int j = i + 1; j < length; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

    }
}
