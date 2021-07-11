package com.gj.routine.lt;

import java.util.*;

/**
 * @title: 螺旋矩阵
 * @description: 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 *               输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 *               输出：[1,2,3,6,9,8,7,4,5]
 *               输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 *               输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 *               提示：
 *               m == matrix.length
 *               n == matrix[i].length
 *               1 <= m, n <= 10
 *               -100 <= matrix[i][j] <= 100
 * @author: jguo
 * @date: 2021/7/10
 */
public class lt_54 {

    /**
     * 按照层模拟，每层填入
     * 时间效率O(mn) 空间O(1)
     * @param matrix
     * @return
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> order = new ArrayList<Integer>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return order;
        }
        int rows = matrix.length, columns = matrix[0].length;
        int left = 0, right = columns - 1, top = 0, bottom = rows - 1;
        while (left<=right && top<= bottom){
            for (int column = left; column <= right; column++) {
                order.add(matrix[left][column]);
            }
            for (int row = top+1; row <= bottom; row++) {
                order.add(matrix[row][right]);
            }
            if (left<right && top < bottom){
                for (int column = right-1; column > left; column--) {
                    order.add(matrix[bottom][column]);
                }
                for (int row = bottom; row > top; row--) {
                    order.add(matrix[row][left]);
                }
            }
            left++;
            right--;
            top++;
            bottom--;
        }
        return order;
    }
    /**
     * 时间和空间都为O(mn)
     * @param args
     */
//    public List<Integer> spiralOrder(int[][] matrix) {
//        List<Integer> order = new ArrayList<Integer>();
//        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
//            return order;
//        }
//        int rows = matrix.length, columns = matrix[0].length;
//        boolean[][] visited = new boolean[rows][columns];
//        int total = rows * columns;
//        int row = 0, column = 0;
//        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
//        int directionIndex = 0;
//        for (int i = 0; i < total; i++) {
//            order.add(matrix[row][column]);
//            visited[row][column] = true;
//            int nextRow = row + directions[directionIndex][0], nextColumn = column + directions[directionIndex][1];
//            if (nextRow < 0 || nextRow >= rows || nextColumn < 0 || nextColumn >= columns || visited[nextRow][nextColumn]) {
//                directionIndex = (directionIndex + 1) % 4;
//            }
//            row += directions[directionIndex][0];
//            column += directions[directionIndex][1];
//        }
//        return order;
//    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1,2,3,10},
                {4,5,6,21},
                {7,8,9,30}
        };
        lt_54 solution = new lt_54();
        List<Integer> results = solution.spiralOrder(matrix);
        System.out.println(results);
    }
}
