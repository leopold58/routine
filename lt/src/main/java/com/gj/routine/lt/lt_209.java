package com.gj.routine.lt;

public class lt_209 {
    public int minSubArrayLen(int target, int[] nums){
        int n = nums.length;
        if (n==0){
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        int start=0, end=0;
        int sum=0;
        while (end<n){
            sum+= nums[end];
            while (sum >= target){
                ans = Math.min(ans, end-start+1);
                sum -= nums[start];
                start++;
            }
            end++;
        }
        return ans == Integer.MAX_VALUE? 0:ans;
    }

    public static void main(String[] args) {
        lt_209 solution = new lt_209();
        int target = 7;
        int[] nums = {2,3,1,2,4,3};
        int res = solution.minSubArrayLen(target, nums);
        System.out.println(res);
    }
}
