package com.gj.routine.lt;

/**
 * @title: 在排序数组中查找元素的第一个和最后一个位置
 * @description: 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 *               如果数组中不存在目标值 target，返回[-1, -1]。
 *               进阶：
 *               你可以设计并实现时间复杂度为O(log n)的算法解决此问题吗？
 *               输入：nums = [5,7,7,8,8,10], target = 8
 *               输出：[3,4]
 * @author: jguo
 * @date: 2021/5/17
 */
public class lt_34 {

    public int[] searchRange(int[] nums,int target){
        if (nums == null || nums.length == 0) return new int[]{-1,-1};
        if (nums[0]>target || nums[nums.length-1]<target)
            return new int[]{-1,-1};
        int leftIndex = searchIndex(nums,target,true);
        int rightIndex = searchIndex(nums,target,false) - 1;
        if (leftIndex<=rightIndex && rightIndex<nums.length && nums[leftIndex] == target && nums[rightIndex] == target){
            return new int[]{leftIndex,rightIndex};
        }
        return new int[]{-1,-1};
    }

    /**
     * 左边界理解成找小于等于target；右边界理解成找大于target的数字，小于该数字的数字即为所求
     * @param nums
     * @param target
     * @param flag
     * @return
     *
     * 我们定义 binarySearch(nums, target, lower) 表示在nums 数组中二分查找 target 的位置，如果 lower 为 true，
     * 则查找第一个大于等于 target 的下标，否则查找第一个大于 target 的下标。
     *
     */
    public int searchIndex(int[] nums,int target,boolean flag){
        int left = 0,right = nums.length-1,ans = nums.length;
        while (left<=right){
            int mid = (left + right)/2;
            if (nums[mid] > target || (flag && nums[mid]>=target)){
                right = mid - 1;
                ans = mid;
            }else {
                left = mid + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
        int target = 8;
        lt_34 solution = new lt_34();
        int[] res = solution.searchRange(nums, target);
        System.out.print(res[0] + " " +res[1]);
    }
}
