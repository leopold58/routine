package com.gj.routine.lt;

import java.util.HashSet;

/**
 * @title: 矩阵置零
 * @description: 给定一个m x n 的矩阵，如果一个元素为 0 ，则将其所在行和列的所有元素都设为 0 。请使用 原地 算法。
 *               进阶：
 *               一个直观的解决方案是使用 O(mn)的额外空间，但这并不是一个好的解决方案。
 *               一个简单的改进方案是使用 O(m+n) 的额外空间，但这仍然不是最好的解决方案。
 *               你能想出一个仅使用常量空间的解决方案吗？
 *               示例一：
 *               输入：matrix = [[1,1,1],[1,0,1],[1,1,1]]
 *               输出：[[1,0,1],[0,0,0],[1,0,1]]
 *               示例二：
 *               输入：matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
 *               输出：[[0,0,0,0],[0,4,5,0],[0,3,1,0]]
 *               提示：
 *                  m == matrix.length
 *                  n == matrix[0].length
 *                  1 <= m, n <= 200
 *                  -231 <= matrix[i][j] <= 231 - 1
 * @author: jguo
 * @date: 2021/7/22
 */
public class lt_73 {

    public void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length==0 || matrix[0].length==0){
            return;
        }
        int m = matrix.length,n = matrix[0].length;
        HashSet<Integer> rows = new HashSet<>();
        HashSet<Integer> cols = new HashSet<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0){
                    rows.add(i);
                    cols.add(j);
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rows.contains(i) || cols.contains(j)){
                    matrix[i][j] = 0;
                }
            }
        }
        return;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {0,1,2,0},
                {3,4,5,2},
                {1,3,1,5}
        };
        lt_73 solution = new lt_73();
        solution.setZeroes(matrix);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j]+"\t");
            }
            System.out.println();
        }
    }
}
