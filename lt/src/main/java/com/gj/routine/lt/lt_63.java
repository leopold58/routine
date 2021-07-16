package com.gj.routine.lt;

/**
 * @title: 不同路径 II
 * @description: 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 *               机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 *               现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 *               网格中的障碍物和空位置分别用 1 和 0 来表示。
 *               输入：obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
 *               输出：2
 *                  解释：
 *                  3x3 网格的正中间有一个障碍物。
 *                  从左上角到右下角一共有 2 条不同的路径：
 *                  1. 向右 -> 向右 -> 向下 -> 向下
 *                  2. 向下 -> 向下 -> 向右 -> 向右
 *               输入：obstacleGrid = [[0,1],[0,0]]
 *               输出：1
 *               提示：
 *                  m ==obstacleGrid.length
 *                  n ==obstacleGrid[i].length
 *                  1 <= m, n <= 100
 *                  obstacleGrid[i][j] 为 0 或 1
 * @author: jguo
 * @date: 2021/7/16
 */
public class lt_63 {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0 || obstacleGrid[0][0] == 1){
            return 0;
        }
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        boolean mHAS = false;
        boolean nHAS = false;
        for (int i = 0; i < m; i++) {
            if (obstacleGrid[i][0]==1){
                nHAS = true;
                obstacleGrid[i][0]=0;
                continue;
            }
            if (nHAS){
                obstacleGrid[i][0]=0;
            }else {
                obstacleGrid[i][0]=1;
            }
        }
        for (int i = 1; i < n; i++) {  //注意此时[0][0]已经填过了，需要跳过
            if (obstacleGrid[0][i]==1){
                mHAS = true;
                obstacleGrid[0][i]=0;
                continue;
            }
            if (mHAS){
                obstacleGrid[0][i]=0;
            }else {
                obstacleGrid[0][i]=1;
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j]==1){
                    obstacleGrid[i][j] = 0;
                    continue;
                }
                obstacleGrid[i][j] = obstacleGrid[i-1][j] + obstacleGrid[i][j-1];
            }
        }
        //测试输出
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//                System.out.print(obstacleGrid[i][j]+"\t");
//            }
//            System.out.println();
//        }
        return obstacleGrid[m-1][n-1];
    }

    /**
     * 网上的解法，借鉴一下，占的空间少了
     * @param args
     */
//    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
//        int n = obstacleGrid.length, m = obstacleGrid[0].length;
//        int[] f = new int[m];
//
//        f[0] = obstacleGrid[0][0] == 0 ? 1 : 0;
//        for (int i = 0; i < n; ++i) {
//            for (int j = 0; j < m; ++j) {
//                if (obstacleGrid[i][j] == 1) {
//                    f[j] = 0;
//                    continue;
//                }
//                if (j - 1 >= 0 && obstacleGrid[i][j - 1] == 0) {
//                    f[j] += f[j - 1];
//                }
//            }
//        }
//        return f[m - 1];
//    }


    public static void main(String[] args) {
        int[][] obstacleGrid = {
                {0,0,0},
                {0,1,0},
                {0,0,0}
//                {0,1},
//                {0,0}
        };
        lt_63 solution = new lt_63();
        System.out.println(solution.uniquePathsWithObstacles(obstacleGrid));
    }
}
