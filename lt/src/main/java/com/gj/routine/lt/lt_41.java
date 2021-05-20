package com.gj.routine.lt;

/**
 * @title: 缺失的第一个正数
 * @description: 给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。
 *               请你实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案。
 *               示例 1：
 *               输入：nums = [1,2,0]
 *               输出：3
 *               示例 2：
 *               输入：nums = [3,4,-1,1]
 *               输出：2
 *               示例 3：
 *               输入：nums = [7,8,9,11,12]
 *               输出：1
 *               提示：
 *                  1 <= nums.length <= 5 * 105
 *                  -231 <= nums[i] <= 231 - 1
 * @author: jguo
 * @date: 2021/5/20
 */
public class lt_41 {
    /**
     * 思路是最小值的取值范围是[1,N+1]，此时是1～N都出现了。可以将1～N填入到数组中，遍历数组中每个数字是否符合规范即可。
     * @param nums
     * @return
     */
    public int firstMissingPositive(int[] nums){
        int len = nums.length;
        if (nums == null || nums.length == 0)return 0;
        for (int i = 0; i < len; i++) {
            while (nums[i]>0 && nums[i]<=len && nums[nums[i]-1]!=nums[i]){
                int temp = nums[nums[i]-1];
                nums[nums[i]-1] = nums[i];
                nums[i] = temp;
            }
        }
        for (int i = 0; i < len; i++) {
            if (nums[i]!=i+1){
                return i+1;
            }
        }
        return len+1;
    }

    public static void main(String[] args) {
        int[] nums = {7,8,9,11,12};
        lt_41 solution = new lt_41();
        System.out.println(solution.firstMissingPositive(nums));
    }
}
