package com.gj.routine.lt;

import java.util.*;
/**
 * @title: N皇后II
 * @description: n皇后问题 研究的是如何将 n个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 *               给你一个整数 n ，返回 n 皇后问题 不同的解决方案的数量。
 *               示例 1：
 *               输入：n = 4
 *               输出：2
 *               示例 2：
 *               输入：n = 1
 *               输出：1
 *               提示：
 *               1 <= n <= 9
 *               皇后彼此不能相互攻击，也就是说：任何两个皇后都不能处于同一条横行、纵行或斜线上。
 * @author: jguo
 * @date: 2021/7/5
 */
public class lt_52 {

    public int totalNQueens(int n) {
        Set<Integer> columns = new HashSet<>();
        Set<Integer> diagonals1 = new HashSet<>();
        Set<Integer> diagonals2 = new HashSet<>();
        return backtrack(n, 0, columns, diagonals1, diagonals2);
    }

    public int backtrack(int n, int row, Set<Integer> columns, Set<Integer> diagonals1, Set<Integer> diagonals2) {
        if (row == n) {
            return 1;
        } else {
            int count = 0;
            for (int i = 0; i < n; i++) {
                if (columns.contains(i)) {
                    continue;
                }
                int diagonal1 = row - i;
                if (diagonals1.contains(diagonal1)) {
                    continue;
                }
                int diagonal2 = row + i;
                if (diagonals2.contains(diagonal2)) {
                    continue;
                }
                columns.add(i);
                diagonals1.add(diagonal1);
                diagonals2.add(diagonal2);
                count += backtrack(n, row + 1, columns, diagonals1, diagonals2);
                columns.remove(i);
                diagonals1.remove(diagonal1);
                diagonals2.remove(diagonal2);
            }
            return count;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("n个皇后在n*n的棋盘上，请输入n:");
        int n = in.nextInt();
        lt_52 solution = new lt_52();
        int result = solution.totalNQueens(n);
        System.out.println(result);
    }
}
