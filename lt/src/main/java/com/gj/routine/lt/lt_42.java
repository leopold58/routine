package com.gj.routine.lt;

/**
 * @title: 接雨水
 * @description: 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 *               输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
 *               输出：6
 *               解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
 *               输入：height = [4,2,0,3,2,5]
 *               输出：9
 *               提示：
 *               n == height.length
 *               0 <= n <= 3 * 104
 *               0 <= height[i] <= 105
 * @author: jguo
 * @date: 2021/5/20
 */
public class lt_42 {
    //暴力法，时间复杂度较高，平方级别的时间复杂度   效率太低
//    public int trap(int[] height){
//        int res = 0;
//        int len = height.length;
//        if (height==null || len<=1) return res;
//        for (int i = 1; i < len-1; i++) {
//            int max_left = 0,max_right = 0;
//            for (int j = i; j >= 0; j--) {
//                max_left = Math.max(max_left,height[j]);
//            }
//            for (int j = i; j < len; j++) {
//                max_right = Math.max(max_right,height[j]);
//            }
//            res += Math.min(max_left,max_right) - height[i];
//        }
//        return res;
//    }
    //动态规划，储存该点到两侧的最大高度
    public int trap(int[] height){
        int len = height.length;
        if (height == null || len<=2){
            return 0;
        }
        int res = 0;
        int[] left_max = new int[len];
        int[] right_max = new int[len];
        left_max[0] = height[0];
        for (int i = 1; i < len; i++) {
            left_max[i] = Math.max(left_max[i-1],height[i]);
        }
        right_max[len-1] = height[len-1];
        for (int i = len-2; i >= 0 ; i--) {
            right_max[i] = Math.max(right_max[i+1],height[i]);
        }
        for (int i = 1; i < len-1; i++) {
            res += Math.min(left_max[i],right_max[i])-height[i];
        }
        return res;
    }

    //栈的思路。

    //双指针,思路非常好。
//    public int trap(int[] height){
//        int left = 0, right = height.length - 1;
//        int ans = 0;
//        int left_max = 0, right_max = 0;
//        while (left < right) {
//            if (height[left] < height[right]) {
//                if (height[left] >= left_max) {
//                    left_max = height[left];
//                } else {
//                    ans += (left_max - height[left]);
//                }
//                ++left;
//            } else {
//                if (height[right] >= right_max) {
//                    right_max = height[right];
//                } else {
//                    ans += (right_max - height[right]);
//                }
//                --right;
//            }
//        }
//        return ans;
//    }

    //TODO:双指针和动态规划的思路
    public static void main(String[] args) {
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        lt_42 solution = new lt_42();
        System.out.println(solution.trap(height));
    }
}
