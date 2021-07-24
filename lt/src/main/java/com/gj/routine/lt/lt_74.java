package com.gj.routine.lt;

/**
 * @title: 搜索二维矩阵
 * @description: 编写一个高效的算法来判断m x n矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 *               每行中的整数从左到右按升序排列。
 *               每行的第一个整数大于前一行的最后一个整数。
 *               输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
 *               输出：true
 *               输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
 *               输出：false
 *               提示：
 *               m == matrix.length
 *               n == matrix[i].length
 *               1 <= m, n <= 100
 *               -104 <= matrix[i][j], target <= 104
 * @author: jguo
 * @date: 2021/7/22
 */
public class lt_74 {

    public boolean searchMatrix(int[][] matrix, int target) {
        int rowIndex = binarySearchFirstColumn(matrix,target);
        if (rowIndex<0){
            return false;
        }
        return binarySearchRow(matrix[rowIndex],target);
    }
    public int binarySearchFirstColumn(int[][] matrix,int target){
        int low = -1,high = matrix.length - 1;
        while (low<high){
            int mid = low + (high - low + 1)/2;
            if (matrix[mid][0] <= target){
                low = mid;
            }else {
                high = mid -1;
            }
            System.out.println("diyige");
            System.out.print("low = " + low+"\t");
            System.out.print("high = " + high+"\t");
            System.out.print("mid = " + mid+"\t");
            System.out.println();
        }
        System.out.println(low);
        return low;
    }
    public boolean binarySearchRow(int[] rows,int target){
        int left = 0,right = rows.length-1;
        while (left<=right){
            int mid = (right - left)/2 + left;
            if (rows[mid] == target){
                return true;
            }else if (rows[mid] > target){
                right = mid - 1;
            }else {
                left = mid + 1;
            }
            System.out.println("dierge");
            System.out.println("left=" + left + "\t" + "right=" + right + "\t" + "mid=" + mid);
        }
        return false;
    }


    public static void main(String[] args) {
        int[][] matrix = {
                {1,3,5,7},
                {10,11,16,20},
                {23,30,34,60}
        };
        int target = 34;
        lt_74 solution = new lt_74();
        System.out.println(solution.searchMatrix(matrix, target));
    }
}
