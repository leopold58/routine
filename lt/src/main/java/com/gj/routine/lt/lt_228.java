package com.gj.routine.lt;

import java.util.ArrayList;
import java.util.List;

public class lt_228 {

//    public List<String> summaryRanges(int[] nums){
//        List<String> res = new ArrayList<>();
//        if (nums == null || nums.length == 0){
//            return res;
//        }
//        int left = 0;
//
//        for (int i = 0; i < nums.length-1; i++) {
//            if (nums[i+1] - nums[i] != 1){
//                if (left == i){
//                    res.add(String.valueOf(nums[left]));
//                }else {
//                    res.add(nums[left]+"->"+nums[i]);
//                }
//                left = i+1;
//            }
//        }
//        if (left == nums.length-1){
//            res.add(String.valueOf(nums[nums.length-1]));
//        }else{
//            res.add(nums[left]+"->"+nums[nums.length-1]);
//        }
//        return res;
//    }
    public List<String>  summaryRanges(int[] nums){
        List<String> res = new ArrayList<>();
        int i = 0;
        int n = nums.length;
        while (i<n){
            int low = i;
            i++;
            while (i<n && nums[i]-nums[i-1] == 1){
                i++;
            }
            int high = i-1;
            StringBuilder temp = new StringBuilder(Integer.toString(nums[low]));
            if (low<high){
                temp.append("->");
                temp.append(Integer.toString(nums[high]));
            }
            res.add(temp.toString());
        }
        return res;
    }
    // 两种解法，第一个自己写，第二个参考题解
    public static void main(String[] args) {
        lt_228 solution = new lt_228();
        int[] nums = {0,2,3,4,6,8,9};
        List<String> res = solution.summaryRanges(nums);
        System.out.println(res);
    }
}
