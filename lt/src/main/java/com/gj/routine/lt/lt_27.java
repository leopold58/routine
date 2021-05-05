package com.gj.routine.lt;

/**
 * @title: 移除元素
 * @description: 给你一个数组 nums和一个值 val，你需要 原地 移除所有数值等于val的元素，并返回移除后数组的新长度。
 *               不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
 *               元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 *               输入：nums = [0,1,2,2,3,0,4,2], val = 2
 *               输出：5, nums = [0,1,4,0,3]
 *               解释：函数应该返回新的长度 5, 并且 nums 中的前五个元素为 0, 1, 3, 0, 4。
 *               注意这五个元素可为任意顺序。你不需要考虑数组中超出新长度后面的元素。
 * @author: jguo
 * @date: 2021/5/5
 */
public class lt_27 {

    public int removeElement(int[] nums, int val) {
        int index = 0;
        for(int i=0;i< nums.length;i++){
            if(nums[i] != val){  //内容可以换成nums[index++] = nums[i];
                int temp = nums[i];
                nums[i] = nums[index];
                nums[index] = temp;
                index++;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        int[] nums = {0,1,2,2,3,0,4,2};
        int val = 2;
        lt_27 solution = new lt_27();

        System.out.println(solution.removeElement(nums, val));
        int len = solution.removeElement(nums, val);
        for (int i = 0; i < len; i++) {
            System.out.print(nums[i]+" ");
        }
    }
}
