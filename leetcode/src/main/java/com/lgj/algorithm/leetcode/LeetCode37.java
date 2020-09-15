package com.lgj.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 37. 解数独
 *编写一个程序，通过已填充的空格来解决数独问题。
 *
 * 一个数独的解法需遵循如下规则：
 *
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
 * 空白格用 '.' 表示。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sudoku-solver
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode37 {
    static class Solution {
        private boolean[][] line = new boolean[9][9];
        private boolean[][] column = new boolean[9][9];
        private boolean[][][] block = new boolean[3][3][9];
        private boolean valid = false;
        private List<int[]> spaces = new ArrayList<int[]>();
        public void solveSudoku(char[][] board) {
            for(int i=0;i<board.length;i++){
                for(int j=0;j<board[i].length;j++){
                    char c = board[i][j];
                    if(c=='.'){
                        spaces.add(new int[]{i,j});
                    }else{
                        line[i][c-'0'-1] = true;
                        column[j][c-'0'-1]=true;
                        block[i/3][j/3][c-'0'-1]=true;
                    }
                }
            }
            dfs(board,0);
        }
        void dfs(char[][] board, int pos){
            if(pos==spaces.size()){
                valid = true;
                return;
            }
            int[] ij = spaces.get(pos);
            int i = ij[0];
            int j = ij[1];

            for(int digit=0;digit<9&&!valid;digit++){
                if(!line[i][digit]&&!column[j][digit]&&!block[i/3][j/3][digit]){
                    line[i][digit] = true;
                    column[j][digit]=true;
                    block[i/3][j/3][digit]=true;
                    board[i][j] = (char)('0'+digit+1);
                    dfs(board,pos+1);
                    line[i][digit] = false;
                    column[j][digit]=false;
                    block[i/3][j/3][digit]=false;
                }
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
    }
}
