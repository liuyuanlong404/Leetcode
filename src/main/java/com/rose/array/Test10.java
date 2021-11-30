package com.rose.array;


/**
 * Created on 2021/10/18 16:26
 *
 * @author Rose
 *
 *              有效的数独
 * 请你判断一个9x9 的数独是否有效。只需要根据以下规则 ，验证已经填入的数字是否有效即可。
 * 数字1-9在每一行只能出现一次。
 * 数字1-9在每一列只能出现一次。
 * 数字1-9在每一个以粗实线分隔的3x3宫内只能出现一次。（请参考示例图）
 * 数独部分空格内已填入了数字，空白格用'.'表示。
 * 注意：
 *   一个有效的数独（部分已被填充）不一定是可解的。
 *   只需要根据以上规则，验证已经填入的数字是否有效即可。
 *
 */
public class Test10 {

    public static boolean isValidSudoku(char[][] board) {
        int[] line = new int[9];
        int[] column = new int[9];
        int[] cell = new int[9];
        int shift;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                //如果还没有填数字，直接跳过
                if (board[i][j] == '.') {
                    continue;
                }
                shift = 1 << (board[i][j] - '0');
                int k = (i / 3) * 3 + j / 3;
                //如果对应的位置只要有一个大于0，说明有冲突，直接返回false
                if ((column[i] & shift) > 0 || (line[j] & shift) > 0 || (cell[k] & shift) > 0) {
                    return false;
                }
                column[i] |= shift;
                line[j] |= shift;
                cell[k] |= shift;
            }
        }
        return true;
    }
}
