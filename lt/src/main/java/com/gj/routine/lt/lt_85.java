package com.gj.routine.lt;

/**
 * @title: 最大矩形
 * @description: 给定一个仅包含 0 和 1 、大小为 rows x cols 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。
 *               输入：matrix = [["1","0","1","0","0"],
 *                              ["1","0","0","1","0"]]
 *                              ["1","0","1","1","1"],
 *                              ["1","1","1","1","1"],
 *               输出：6
 *               输入：matrix = []
 *               输出：0
 *               输入：matrix = [["0"]]
 *               输出：0
 *               输入：matrix = [["1"]]
 *               输出：1
 *               输入：matrix = [["0","0"]]
 *               输出：0
 *               提示：
 *                  rows == matrix.length
 *                  cols == matrix[0].length
 *                  0 <= row, cols <= 200
 *                  matrix[i][j] 为 '0' 或 '1'
 * @author: jguo
 * @date: 2021/8/21
 */
public class lt_85 {

    public int maximalRectangle(char[][] matrix) {
        if (matrix==null || matrix.length == 0 || matrix[0].length==0){
            return 0;
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println("二维矩阵如下：");
        char[][] matrix = {
                {'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'}
        };
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]+"\t");
            }
            System.out.println();
        }
        lt_85 solution = new lt_85();
        System.out.println("最大矩形面积：");
        System.out.println(solution.maximalRectangle(matrix));
    }
}
