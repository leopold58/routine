package com.gj.routine.lt;

import java.util.Scanner;

/**
 * @title: 螺旋矩阵 II
 * @description: 给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
 *               输入：n = 3
 *               输出：[[1,2,3],[8,9,4],[7,6,5]]
 *               输入：n = 1
 *               输出：[[1]]
 *               提示：1 <= n <= 20
 * @author: jguo
 * @date: 2021/7/14
 */
public class lt_59 {

    public int[][] generateMatrix(int n) {
        if (n<=0) return new int[0][];
        int num = 1;
        int[][] result = new int[n][n];
        int left = 0,right = n-1,top = 0,bottom = n-1;
        while (left<=right && top<=bottom){
            for (int col = left; col <= right; col++) {
                result[top][col] = num++;
            }
            for (int row = top+1; row <= bottom; row++) {
                result[row][right] = num++;
            }
            if (left<right && top<bottom){
                for (int col = right-1; col > left; col--) {
                    result[bottom][col] = num++;
                }
                for (int row = bottom; row > top; row--) {
                    result[row][left] = num++;
                }
            }
            left++;
            right--;
            top++;
            bottom--;
        }
        return result;
    }

    /**
     * 找的另外一种解法，基本类似。
     * @param args
     */
//    public int[][] generateMatrix(int n) {
//        int l = 0, r = n - 1, t = 0, b = n - 1;
//        int[][] mat = new int[n][n];
//        int num = 1, tar = n * n;
//        while(num <= tar){
//            for(int i = l; i <= r; i++) mat[t][i] = num++; // left to right.
//            t++;
//            for(int i = t; i <= b; i++) mat[i][r] = num++; // top to bottom.
//            r--;
//            for(int i = r; i >= l; i--) mat[b][i] = num++; // right to left.
//            b--;
//            for(int i = b; i >= t; i--) mat[i][l] = num++; // bottom to top.
//            l++;
//        }
//        return mat;
//    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        lt_59 solution = new lt_59();
        int[][] results = solution.generateMatrix(n);
        for (int i = 0; i < results.length; i++) {
            for (int j = 0; j < results[0].length; j++) {
                System.out.print(results[i][j]+"\t");
            }
            System.out.println();
        }
    }
}
