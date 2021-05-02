package com.gj.routine.lt;
import java.util.HashMap;
import java.util.Scanner;

/**
 * lt-1.两数之和
 * 给定一个整数数组 nums和一个整数目标值 target，请你在该数组中找出 和为目标值 的那两个整数，并返回它们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 * 你可以按任意顺序返回答案。
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[0,1]
 * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 */
//无 序 的 数 组   -> 对数组没有排序的要求
    //暴力解法 或者 使用哈希数组
public class lt_1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int len = in.nextInt();
        int[] nums = new int[len];

        for (int i = 0; i < len; i++) {
            nums[i] = in.nextInt();
        }
        int target = in.nextInt();

//        int[] nums = {2,7,11,15};
//        int target = 9;
        int[] result = getIndexOfSum(nums,target);
        for (int i = 0; i < 2; i++) {
            System.out.print(result[i]+" ");
        }
    }
    public static int[] getIndexOfSum(int[] nums,int target){
        if(nums==null || nums.length == 0) return null;
        HashMap<Integer,Integer> hm = new HashMap<>();
        hm.put(nums[0],0);
        int[] res = new int[2];
        for (int i = 1; i < nums.length; i++) {
            if (hm.containsKey(target-nums[i])){
                return new int[]{i,hm.get(target-nums[i])};
            }
            else {
                hm.put(nums[i],i);
            }
        }
        return res;
    }

}
