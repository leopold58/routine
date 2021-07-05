package com.gj.routine.lt;

import java.lang.reflect.Array;
import java.util.*;

/**
 * @title: N 皇后
 * @description: n皇后问题 研究的是如何将 n个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 *               给你一个整数 n ，返回所有不同的n皇后问题 的解决方案。
 *               每一种解法包含一个不同的n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 *               示例一：
 *                  输入：n = 4
 *                  输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
 *               解释：如上图所示，4 皇后问题存在两个不同的解法。
 *               示例 2：
 *                  输入：n = 1
 *                  输出：[["Q"]]
 *               提示：
 *                  1 <= n <= 9
 *                  皇后彼此不能相互攻击，也就是说：任何两个皇后都不能处于同一条横行、纵行或斜线上。
 * @author: jguo
 * @date: 2021/7/2
 */
public class lt_51 {

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<List<String>>();
        int[] queens = new int[n];
        Arrays.fill(queens,-1);
        Set<Integer> columns = new HashSet<Integer>();
        Set<Integer> diagonals1 = new HashSet<>();
        Set<Integer> diagonals2 = new HashSet<>();
        backtrack(result,queens,n,0,columns,diagonals1,diagonals2);
        return result;
    }
    public void backtrack(List<List<String>> ans,int[] queens,int n,int row,Set<Integer> columns,Set<Integer> diagonals1,Set<Integer> diagonals2){
        if (row == n){
            List<String> board = generateBoard(queens, n);
            ans.add(board);
        }else {
            for (int i = 0; i < n; i++) {
                if (columns.contains(i)){
                    continue;
                }
                int diagonal1 = row - i;
                if (diagonals1.contains(diagonal1)){
                    continue;
                }
                int diagonal2 = row + i;
                if (diagonals2.contains(diagonal2)){
                    continue;
                }
                queens[row] = i;
                columns.add(i);
                diagonals1.add(diagonal1);
                diagonals2.add(diagonal2);
                backtrack(ans, queens, n, row+1, columns, diagonals1, diagonals2);
                queens[row] = -1;
                columns.remove(i);
                diagonals1.remove(diagonal1);
                diagonals2.remove(diagonal2);
            }
        }
    }
    public List<String> generateBoard(int[] queens,int n){
        List<String> board = new ArrayList<String>();
        for (int i = 0; i < n; i++) {
            char[] row = new char[n];
            Arrays.fill(row,'.');
            row[queens[i]] = 'Q';
            board.add(new String(row));
        }
        return board;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("n个皇后在n*n的棋盘上，请输入n:");
        int n = in.nextInt();
        lt_51 solution = new lt_51();
        List<List<String>> result = solution.solveNQueens(n);
        for (int i = 0; i < result.size(); i++) {
            for (int j = 0; j < result.get(i).size(); j++) {
                System.out.println(result.get(i).get(j));
            }
            System.out.println("--------------------------");
        }
    }
}
