package com.gj.routine.lt;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @title: 合并区间
 * @description: 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。
 *               请你合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。
 *                  输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
 *                  输出：[[1,6],[8,10],[15,18]]
 *                  解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 *                  输入：intervals = [[1,4],[4,5]]
 *                  输出：[[1,5]]
 *                  解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。
 *               提示：
 *                  1 <= intervals.length <= 104
 *                  intervals[i].length == 2
 *                  0 <= starti <= endi <= 104
 * @author: jguo
 * @date: 2021/7/11
 */
public class lt_56 {

    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0 || intervals[0].length == 0){
            return new int[0][2];
        }
        List<int[]> result = new ArrayList<>();
        Arrays.sort(intervals,(a,b)->(a[0]-b[0]));
        int i = 0;
        while (i < intervals.length){
            int left = intervals[i][0];
            int right = intervals[i][1];
            while (i < intervals.length - 1 && intervals[i+1][0]<=right){
                i++;
                right = Math.max(right,intervals[i][1]);
            }
            result.add(new int[]{left,right});
            i++;
        }
        return result.toArray(new int[0][]);
    }
    public static void main(String[] args){
        int[][] intervals = {
                {1,3},
                {2,6},
                {8,10},
                {15,18}
        };
        lt_56 solution = new lt_56();
        int[][] result = solution.merge(intervals);
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                System.out.print(result[i][j]+" ");
            }
            System.out.println();
        }
    }
}
