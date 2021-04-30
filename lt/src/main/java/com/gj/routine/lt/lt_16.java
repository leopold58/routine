package com.gj.routine.lt;

import java.util.Arrays;
import java.util.Scanner;

/**
 * lt-16.最接近的三数之和
 * 给定一个包括n 个整数的数组nums和 一个目标值target。找出nums中的三个整数，使得它们的和与target最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 *
 * 示例：
 * 输入：nums = [-1,2,1,-4], target = 1
 * 输出：2
 * 解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
 *
 * 提示：
 * 3 <= nums.length <= 10^3
 * -10^3<= nums[i]<= 10^3
 * -10^4<= target<= 10^4
 */
public class lt_16 {
    public int threeSumCloset(int[] nums,int target){
        Arrays.sort(nums);
        int ans = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length; i++) {
            int start = i+1,end = nums.length - 1;
            while (start < end){
                int sum = nums[start] + nums[end] + nums[i];
                if (Math.abs(target - sum) < Math.abs(target - ans))
                    ans = sum;
                if (sum > target){
                    int right = end -1;
                    while(start<right && nums[end]==nums[right])
                        right--;
                    end = right;
                }
                else if(sum < target){
                    int left = start + 1;
                    while(left<=end && nums[left]==nums[start])
                        left++;
                    start = left;
                }
                else
                    return ans;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        lt_16 solution = new lt_16();
        Scanner in = new Scanner(System.in);
        System.out.println("请输入数组长度：");
        int len = in.nextInt();
        int[] nums = new int[len];
        System.out.println("请输入数组元素:");
        for (int i = 0; i < len; i++) {
            nums[i] = in.nextInt();
        }
        System.out.println("请输入目标数字target:");
        int target = in.nextInt();
        System.out.println(solution.threeSumCloset(nums, target));
    }
}
