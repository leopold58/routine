package com.gj.routine.lt;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author jguo
 * @date 2021/4/28
 *
 * 描述：四数之和
 * 给定一个包含n 个整数的数组nums和一个目标值target，判断nums中是否存在四个元素 a，b，c和 d，使得a + b + c + d的值与target相等？找出所有满足条件且不重复的四元组。
 * 注意：答案中不可以包含重复的四元组。
 * 示例 1：
 * 输入：nums = [1,0,-1,0,-2,2], target = 0
 * 输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
 * 示例 2：
 * 输入：nums = [], target = 0
 * 输出：[]
 */

public class lt_18 {

    public List<List<Integer>> fourSum(int[] nums,int target){
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> arr = new ArrayList<>();
        Arrays.sort(nums);
        int len = nums.length;
        if (nums.length<4) return result;
        for (int i = 0; i < nums.length-3; i++) {
            //找不重复
            if (i>0 && nums[i] == nums[i-1]){
                continue;
            }
            if (nums[i] + nums[i+1] + nums[i+2] + nums[i+3] > target){
                break;
            }
            if (nums[i] + nums[len-3] + nums[len-2] + nums[len-1] < target){
                continue;
            }
            int j = i+1;
            while (j< nums.length-2){
                int left = j+1;
                int right = len-1;
                while (left<right){
                    if (nums[i] + nums[j] + nums[left] + nums[right] == target){
                        arr.add(nums[i]);
                        arr.add(nums[j]);
                        arr.add(nums[left]);
                        arr.add(nums[right]);
                        result.add(new ArrayList<>(arr));
                        arr.clear();
                        while (left<right && nums[left] == nums[left+1]){
                            left++;
                        }
                        while (left<right && nums[right] == nums[right-1]){
                            right--;
                        }
                        left++;
                        right--;
                    }
                    else if (nums[i] + nums[j] + nums[left] + nums[right] < target){
                        left++;
                    }
                    else {
                        right--;
                    }
                }
                while (j<len-2 && nums[j] == nums[j+1]){
                    j++;
                }
                j++;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        int[] nums = {1,0,-1,0,-2,2};
        int target = 0;
        lt_18 solution = new lt_18();
        System.out.println(solution.fourSum(nums, target));
    }
}
