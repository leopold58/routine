package com.gj.routine.lt;

import java.util.Scanner;

/**
 * @title: 下一个排列
 * @description: 实现获取 下一个排列 的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 *               如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 *               必须 原地 修改，只允许使用额外常数空间。
 *               示例 1：
 *                  输入：nums = [1,2,3]
 *                  输出：[1,3,2]
 *               示例 2：
 *                  输入：nums = [3,2,1]
 *                  输出：[1,2,3]
 *               示例 3：
 *                  输入：nums = [1,1,5]
 *                  输出：[1,5,1]
 *               提示： 1 <= nums.length <= 100；0 <= nums[i] <= 100
 * @author: jguo
 * @date: 2021/5/9
 */
public class lt_31 {

    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length == 0){
            return;
        }
        int firstIndex = -1;
        for (int i = nums.length-2; i >=0 ; i--) {
            if (nums[i]<nums[i+1]){
                firstIndex = i;
                break;
            }
        }
        if (firstIndex == -1){
            reverse(nums,0,nums.length-1);
            return;
        }
        int secondIndex = -1;
        for (int i = nums.length-1; i >=0 ; i--) {
            if (nums[i]>nums[firstIndex]){
                secondIndex = i;
                break;
            }
        }
        swap(nums,firstIndex,secondIndex);
        reverse(nums,firstIndex+1,nums.length-1);
        return;

    }
    public void reverse(int[] nums,int i,int j){
        while (i<j){
            swap(nums,i++,j--);
        }
    }
    public void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("请输入数组，用空格区分：");
        String input = in.nextLine();
        String[] chars = input.trim().split(" ");
        int[] nums = new int[chars.length];
        for (int i = 0; i < chars.length; i++) {
            nums[i] = Integer.parseInt(chars[i]);
        }
        lt_31 solution = new lt_31();
        solution.nextPermutation(nums);
        for (Integer p:
             nums) {
            System.out.print(p+" ");
        }
    }
}
