package com.gj.routine.lt;

import java.util.Scanner;

/**
 * @title: 跳跃游戏
 * @description: 给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
 *               数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *               判断你是否能够到达最后一个下标。
 *               输入：nums = [2,3,1,1,4]
 *               输出：true
 *               解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
 *               输入：nums = [3,2,1,0,4]
 *               输出：false
 *               解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ， 所以永远不可能到达最后一个下标。
 *               提示：
 *               1 <= nums.length <= 3 * 104
 *               0 <= nums[i] <= 105
 * @author: jguo
 * @date: 2021/7/11
 */
public class lt_55 {

    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0){
            return false;
        }
        int n = nums.length;
        int rightmost = 0;
        for (int i = 0; i < n; i++) {
            if (i <= rightmost){
                rightmost = Math.max(rightmost,i+nums[i]);
                if (rightmost >= n-1){
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String[] sInput = s.trim().split(",");
        int[] nums = new int[sInput.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(sInput[i]);
        }
        lt_55 solution = new lt_55();
        System.out.println(solution.canJump(nums));
    }
}
