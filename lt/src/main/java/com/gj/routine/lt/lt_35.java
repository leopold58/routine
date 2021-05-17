package com.gj.routine.lt;

/**
 * @title: 搜索插入位置
 * @description: 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 *               你可以假设数组中无重复元素。
 *               示例 1:
 *               输入: [1,3,5,6], 5
 *               输出: 2
 *               示例2:
 *               输入: [1,3,5,6], 2
 *               输出: 1
 *               示例3：
 *               输入: [1,3,5,6], 7
 *               输出: 4
 * @author: jguo
 * @date: 2021/5/18
 */
public class lt_35 {
    public int searchInsert(int[] nums,int target){
        if (nums == null || nums.length == 0){
            return 0;
        }
        int left = 0,right = nums.length-1,ans = nums.length;
        while (left<=right){
            int mid = (left + right)/2;
            if (nums[mid]>target){
                right = mid -1;
                ans = mid;
            }else {
                left = mid + 1;
            }
        }
        if (ans == 0){
            return 0;
        }
        if (nums[ans-1] == target){
            return ans-1;
        }else {
            return ans;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,3,5,6};
        int target = 5;
        lt_35 solution = new lt_35();
        System.out.println(solution.searchInsert(nums, target));
    }
}
