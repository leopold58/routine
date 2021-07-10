package com.gj.routine.lt;

import java.util.Scanner;

/**
 * @title: 最大子序和
 * @description: 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *               示例 1：
 *                  输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
 *                  输出：6
 *                  解释：连续子数组[4,-1,2,1] 的和最大，为6 。
 *               示例 2：
 *                  输入：nums = [1]
 *                  输出：1
 *               示例 3：
 *                  输入：nums = [0]
 *                  输出：0
 *               示例 4：
 *                  输入：nums = [-100000]
 *                  输出：-100000
 *               提示：
 *               1 <= nums.length <= 3 * 104
 *               -105 <= nums[i] <= 105
 * @author: jguo
 * @date: 2021/7/5
 */
public class lt_53 {

    //贪心
//    public int maxSubArray(int[] nums) {
//        int pre = 0, maxAns = nums[0];
//        for (int x : nums) {
//            pre = Math.max(pre + x, x);
//            maxAns = Math.max(maxAns, pre);
//        }
//        return maxAns;
//    }

    //动态规划
    public int maxSubArray(int[] nums) {
        int len = nums.length;
        int ans = nums[0];
        for (int i = 1; i < len; i++) {
            if (nums[i-1]>0){
                nums[i] += nums[i-1];
            }
            ans = Math.max(nums[i],ans);
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String[] sInput = s.trim().split(",");
        int[] nums = new int[sInput.length];
        for (int i = 0; i < sInput.length; i++) {
            nums[i] = Integer.parseInt(sInput[i]);
        }
        lt_53 solution = new lt_53();
        System.out.println(solution.maxSubArray(nums));
    }
}
