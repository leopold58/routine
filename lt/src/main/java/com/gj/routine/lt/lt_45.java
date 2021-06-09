package com.gj.routine.lt;

import java.util.Scanner;

/**
 * @title: 跳跃游戏 II
 * @description: 给定一个非负整数数组，你最初位于数组的第一个位置。
 *               数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *               你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 *               假设你总是可以到达数组的最后一个位置。            //假设总是可以到达数组的最后一个位置！！！
 *               示例 1:
 *               输入: [2,3,1,1,4]
 *               输出: 2
 *               解释: 跳到最后一个位置的最小跳跃数是 2。
 *               从下标为 0 跳到下标为 1 的位置，跳1步，然后跳3步到达数组的最后一个位置。
 *               示例 2:
 *               输入: [2,3,0,1,4]
 *               输出: 2
 *               提示:
 *                  1 <= nums.length <= 1000
 *                  0 <= nums[i] <= 105
 * @author: jguo
 * @date: 2021/6/7
 */
public class lt_45 {

    //贪心算法，
    public int jump(int[] nums){
        if (nums == null || nums.length == 0) return -1;
        int length = nums.length;
        int end = 0;
        int maxPosition = 0;
        int steps = 0;
        for (int i = 0; i < length-1; i++) {
            maxPosition = Math.max(maxPosition,i+nums[i]);
            if (i == end){
                end = maxPosition;
                steps ++;
            }
        }
        return steps;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String[] aChars = s.split(",");
        int[] nums = new int[aChars.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(aChars[i]);
        }
        lt_45 solution = new lt_45();
        System.out.println(solution.jump(nums));
    }

}
