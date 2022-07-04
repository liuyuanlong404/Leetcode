package com.rose.test;


/**
 * Created on 2022/6/22 11:03
 *
 * @author Lakers
 *      79. 单词搜索
 * 给定一个m x n 二维字符网格board 和一个字符串单词word 。如果word 存在于网格中，返回 true ；否则，返回 false 。
 *
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/word-search
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Test79 {


    public static void main(String[] args) {

        char[][] board = {{'a','b'},{'c','d'}};
        System.out.println(exist(board, "ab"));


    }


    public static boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (DFS(i, j, 0, board, word)){
                    return true;
                }
            }
        }

        return false;
    }

    private static boolean DFS(int i, int j, int index, char[][] board, String word) {

        // 1.找到了
        if (board[i][j] == word.charAt(index) && index == word.length() - 1){
            return true;
        }

        // 2.没找到
        if (board[i][j] != word.charAt(index)){
            return false;
        }

        // 继续搜索时防止重复搜索
        char temp = board[i][j];
        board[i][j] = '!';

        // 3.继续搜索
        if (checkIndex(i - 1, j, board) && DFS(i - 1, j, index + 1, board, word)){
            return true;
        }
        if (checkIndex(i, j - 1, board) && DFS(i, j - 1, index + 1, board, word)){
            return true;
        }
        if (checkIndex(i + 1, j, board) && DFS(i + 1, j, index + 1, board, word)){
            return true;
        }
        if (checkIndex(i, j + 1, board) && DFS(i, j + 1, index + 1, board, word)){
            return true;
        }

        board[i][j] = temp;

        return false;

    }

    private static boolean checkIndex(int i, int j, char[][] board) {
        return i >= 0 && i < board.length && j >= 0 && j < board[0].length;
    }

}
