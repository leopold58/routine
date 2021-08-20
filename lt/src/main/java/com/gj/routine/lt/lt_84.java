package com.gj.routine.lt;

import java.util.*;

/**
 * @title: 柱状图中最大的矩形
 * @description: 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 *               求在该柱状图中，能够勾勒出来的矩形的最大面积。
 *                  输入：heights = [2,1,5,6,2,3]
 *                  输出：10
 *                  解释：最大的矩形为图中红色区域，面积为 10
 *                  输入： heights = [2,4]
 *                  输出： 4
 *               提示：
 *                  1 <= heights.length <=105
 *                  0 <= heights[i] <= 104
 * @author: jguo
 * @date: 2021/8/15
 */
public class lt_84 {

    /**
     * 求的是面积最大  单调栈 数字优化
     * @param heights
     * @return
     */
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] left = new int[n];
        int[] right = new int[n];
        Arrays.fill(right, n);

        Stack<Integer> mono_stack = new Stack<Integer>();
        for (int i = 0; i < n; ++i) {
            while (!mono_stack.isEmpty() && heights[mono_stack.peek()] >= heights[i]) {
                right[mono_stack.peek()] = i;
                mono_stack.pop();
            }
            left[i] = (mono_stack.isEmpty() ? -1 : mono_stack.peek());
            mono_stack.push(i);
        }

        int ans = 0;
        for (int i = 0; i < n; ++i) {
            ans = Math.max(ans, (right[i] - left[i] - 1) * heights[i]);
        }
        return ans;
    }

    /**
     * 单调栈
     * @param heights
     * @return
     */
//    public int largestRectangleArea(int[] heights) {
//        int len = heights.length;
//        if (len == 0) {
//            return 0;
//        }
//        if (len == 1) {
//            return heights[0];
//        }
//
//        int res = 0;
//        Deque<Integer> stack = new ArrayDeque<>(len);
//        for (int i = 0; i < len; i++) {
//            // 这个 while 很关键，因为有可能不止一个柱形的最大宽度可以被计算出来
//            while (!stack.isEmpty() && heights[i] < heights[stack.peekLast()]) {
//                int curHeight = heights[stack.pollLast()];
//                while (!stack.isEmpty() && heights[stack.peekLast()] == curHeight) {
//                    stack.pollLast();
//                }
//
//                int curWidth;
//                if (stack.isEmpty()) {
//                    curWidth = i;
//                } else {
//                    curWidth = i - stack.peekLast() - 1;
//                }
//
//                // System.out.println("curIndex = " + curIndex + " " + curHeight * curWidth);
//                res = Math.max(res, curHeight * curWidth);
//            }
//            stack.addLast(i);
//        }
//
//        while (!stack.isEmpty()) {
//            int curHeight = heights[stack.pollLast()];
//            while (!stack.isEmpty() && heights[stack.peekLast()] == curHeight) {
//                stack.pollLast();
//            }
//            int curWidth;
//            if (stack.isEmpty()) {
//                curWidth = len;
//            } else {
//                curWidth = len - stack.peekLast() - 1;
//            }
//            res = Math.max(res, curHeight * curWidth);
//        }
//        return res;
//    }

    /**
     * 哨兵写法
     * @param args
     */
//    public int largestRectangleArea(int[] heights) {
//        int len = heights.length;
//        if (len == 0) {
//            return 0;
//        }
//
//        if (len == 1) {
//            return heights[0];
//        }
//
//        int res = 0;
//
//        int[] newHeights = new int[len + 2];
//        newHeights[0] = 0;
//        System.arraycopy(heights, 0, newHeights, 1, len);
//        newHeights[len + 1] = 0;
//        len += 2;
//        heights = newHeights;
//
//        Deque<Integer> stack = new ArrayDeque<>(len);
//        // 先放入哨兵，在循环里就不用做非空判断
//        stack.addLast(0);
//
//        for (int i = 1; i < len; i++) {
//            while (heights[i] < heights[stack.peekLast()]) {
//                int curHeight = heights[stack.pollLast()];
//                int curWidth = i - stack.peekLast() - 1;
//                res = Math.max(res, curHeight * curWidth);
//            }
//            stack.addLast(i);
//        }
//        return res;
//    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("输入一串数字，作为heights数组元素，用逗号隔开：");
        String s = in.nextLine();
        String[] sInput = s.trim().split(",");
        int[] heights = new int[sInput.length];
        for (int i = 0; i < heights.length; i++) {
            heights[i] = Integer.parseInt(sInput[i]);
        }
        lt_84 solution = new lt_84();
        System.out.println("柱状图中最大的矩形为：");
        System.out.println(solution.largestRectangleArea(heights));
    }

}
