package com.gj.routine.lt;

import java.util.Scanner;

/**
 * lt-11.盛最多水的容器
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点(i,ai) 。在坐标内画 n 条垂直线，垂直线 i的两个端点分别为(i,ai) 和 (i, 0) 。找出其中的两条线，使得它们与x轴共同构成的容器可以容纳最多的水。
 * 说明：你不能倾斜容器。。
 *
 *示例 1：
 * 输入：[1,8,6,2,5,4,8,3,7]
 * 输出：49
 * 解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为49。
 *
 * 示例 2：
 * 输入：height = [1,1]
 * 输出：1
 *
 * 示例 3：
 * 输入：height = [4,3,2,1,4]
 * 输出：16
 *
 * 示例 4：
 * 输入：height = [1,2,1]
 * 输出：2
 *
 * 提示：
 * n = height.length
 * 2 <= n <= 3 * 104
 * 0 <= height[i] <= 3 * 104
 */
public class lt_11 {
    public int maxArea(int[] height){
        if (height == null || height.length == 0){
            return 0;
        }
        int left = 0,right = height.length-1;
        int maxArea = 0;
        while (left <= right){
            maxArea = Math.max(maxArea,Math.min(height[right],height[left]) * (right - left));
            if (height[right]>height[left]){
                left++;
            }else {
                right--;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        lt_11 solution = new lt_11();
        Scanner in = new Scanner(System.in);
        System.out.print("请输入长度：");
        int len = in.nextInt();
        int[] height = new int[len];
        System.out.println("请输入每个高度：");
        for (int i = 0; i < len; i++) {
            height[i] = in.nextInt();
        }
        System.out.println(solution.maxArea(height));
    }
}
