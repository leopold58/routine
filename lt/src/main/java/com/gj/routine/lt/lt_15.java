package com.gj.routine.lt;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * lt-15.三数之和
 * 给你一个包含n个整数的数组nums，判断nums中是否存在三个元素a，b，c，使得a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组。
 *
 * 示例 1：
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 *
 * 示例 2：
 * 输入：nums = []
 * 输出：[]
 *
 * 示例 3：
 * 输入：nums = [0]
 * 输出：[]
 *
 * 提示：
 * 0 <= nums.length <= 3000
 * -105 <= nums[i] <= 105
 */
public class lt_15 {
    public List<List<Integer>> threeSum(int[] nums){
        int len = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int first = 0; first < len; first++) {
            if (first > 0 && nums[first] == nums[first-1])
                continue;
            int third = len - 1;
            int target = - nums[first];
            for (int second = first+1; second < len; second++) {
                if (second>first+1 && nums[second] == nums[second-1])
                    continue;
                while (second<third && nums[second]+nums[third]>target)
                    --third;
                if (second == third)
                    break;
                if (nums[second] + nums[third] == target){
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(nums[first]);
                    list.add(nums[second]);
                    list.add(nums[third]);
                    res.add(list);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        lt_15 solution = new lt_15();
        Scanner in = new Scanner(System.in);
        System.out.println("请输入数组长度：");
        int len = in.nextInt();
        int[] nums = new int[len];
        System.out.println("请输入数组元素：");
        for (int i = 0; i < len; i++) {
            nums[i] = in.nextInt();
        }
//        System.out.println(solution.threeSum(nums));  都可以打印出 [[-1, -1, 2], [-1, 0, 1]]
        List<List<Integer>> result = solution.threeSum(nums);
        System.out.println(result);
    }
}
