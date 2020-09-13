package com.lgj.algorithm.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Semaphore;

/**
 * 79. 单词搜索
 * 给定一个非空二叉树, 返回一个由每层节点平均值组成的数组。
 * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 * <p>
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 * <p>
 *  
 * <p>
 * 示例:
 * <p>
 * board =
 * [
 * ['A','B','C','E'],
 * ['S','F','C','S'],
 * ['A','D','E','E']
 * ]
 * <p>
 * 给定 word = "ABCCED", 返回 true
 * 给定 word = "SEE", 返回 true
 * 给定 word = "ABCB", 返回 false
 *  
 * <p>
 * 提示：
 * <p>
 * board 和 word 中只包含大写和小写英文字母。
 * 1 <= board.length <= 200
 * 1 <= board[i].length <= 200
 * 1 <= word.length <= 10^3
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-search
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode79 {
    static class Solution {
        public boolean exist(char[][] board, String word) {
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    boolean[][] marked = new boolean[board.length][board[0].length];
                    if (dfs(board, marked, word, 0, i, j)) {
                        return true;
                    }
                }
            }
            return false;
        }

        boolean dfs(char[][] board, boolean[][] marked, String word, int k, int i, int j) {
            if (i >= board.length || i < 0) {
                return false;
            }
            if (j >= board[i].length || j < 0) {
                return false;
            }
            if (marked[i][j]) {
                return false;
            }
            if (k == word.length() - 1 && board[i][j] == word.charAt(k)) {
                //成功
                return true;
            }
            if (board[i][j] == word.charAt(k)) {
                marked[i][j] = true;
                if (dfs(board, marked, word, k + 1, i, j + 1) ||
                        dfs(board, marked, word, k + 1, i, j - 1) ||
                        dfs(board, marked, word, k + 1, i + 1, j) ||
                        dfs(board, marked, word, k + 1, i - 1, j)) {
                    return true;
                }
                marked[i][j] = false;
            }
            return false;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
    }
}
