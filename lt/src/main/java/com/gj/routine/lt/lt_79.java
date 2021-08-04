package com.gj.routine.lt;

/**
 * @title: 单词搜索
 * @description: 给定一个m x n 二维字符网格board 和一个字符串单词word 。如果word 存在于网格中，返回 true ；否则，返回 false 。
 *               单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 *               输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 *               输出：true
 *               输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
 *               输出：true
 *               输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
 *               输出：false
 *               提示：
 *                  m == board.length
 *                  n = board[i].length
 *                  1 <= m, n <= 6
 *                  1 <= word.length <= 15
 *                  board 和 word 仅由大小写英文字母组成
 * @author: jguo
 * @date: 2021/8/1
 */
public class lt_79 {

    //回溯+多方向遍历
    public boolean exist(char[][] board, String word) {
        int rows = board.length,cols = board[0].length;
        boolean[][] visited = new boolean[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                boolean flag = check(board,visited,i,j,word,0);
                if (flag){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean check(char[][] board,boolean[][] visited,int i,int j,String s,int k){
        if (board[i][j]!=s.charAt(k)){
            return false;
        }else if (k == s.length()-1){
            return true;
        }
        visited[i][j] = true;
        int[][] directions = {
                {0,1},
                {0,-1},
                {1,0},
                {-1,0}
        };
        boolean result = false;
        for (int[] dir:
             directions) {
            int newI = i + dir[0],newJ = j + dir[1];
            if (newI >= 0 && newI < board.length && newJ >= 0 && newJ < board[0].length){
                if (!visited[newI][newJ]){
                    boolean flag = check(board, visited, newI, newJ, s, k+1);
                    if (flag){
                        result = true;
                        break;
                    }
                }
            }
        }
        visited[i][j] = false;
        return result;
    }
    public static void main(String[] args) {
        char[][] board = {
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}
        };
        String word = "ABCCED";
        lt_79 solution = new lt_79();
        System.out.println(solution.exist(board, word));
    }
}
