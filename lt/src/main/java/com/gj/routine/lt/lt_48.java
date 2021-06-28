package com.gj.routine.lt;

import java.util.Scanner;

/**
 * @title: 旋转图像
 * @description: 给定一个 n×n 的二维矩阵matrix 表示一个图像。请你将图像顺时针旋转 90 度。
 *               你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。
 *                输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 *                输出：[[7,4,1],[8,5,2],[9,6,3]]
 *                输入：matrix = [[1,2],[3,4]]
 *                输出：[[3,1],[4,2]]
 *               提示：
 *               matrix.length == n
 *               matrix[i].length == n
 *               1 <= n <= 20
 *               -1000 <= matrix[i][j] <= 1000
 * @author: jguo
 * @date: 2021/6/18
 */
public class lt_48 {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        // 水平翻转
        for (int i = 0; i < n / 2; ++i) {
            for (int j = 0; j < n; ++j) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - i - 1][j];
                matrix[n - i - 1][j] = temp;
            }
        }
        // 主对角线翻转
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < i; ++j) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("输入n*n个数字，采用逗号隔开：");
        String s = in.nextLine();
        System.out.println("输入n：");
        int n = in.nextInt();
        String[] sInput = s.split(",");
        int[] numIn = new int[sInput.length];
        for (int i = 0; i < sInput.length; i++) {
            numIn[i] = Integer.parseInt(sInput[i]);
        }
        int[][] matrix = new int[n][n];
        int k = 0;
        System.out.println("输入的矩阵：");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = numIn[k++];
                System.out.print(matrix[i][j]+ " ");
            }
            System.out.println();
        }
        System.out.println("输出的矩阵：");
        lt_48 solution = new lt_48();
        solution.rotate(matrix);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j]+ " ");
            }
            System.out.println();
        }
    }
}
