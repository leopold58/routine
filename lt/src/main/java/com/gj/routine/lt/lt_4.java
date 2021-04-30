package com.gj.routine.lt;

import javax.security.auth.login.CredentialException;

/**
 * lt-4.寻找两个正序数组的中位数
 * 给定两个大小为 m 和 n 的正序（从小到大）数组nums1 和nums2。请你找出并返回这两个正序数组的中位数。
 * 进阶：你能设计一个时间复杂度为 O(log (m+n)) 的算法解决此问题吗？
 *
 * 示例 1：
 * 输入：nums1 = [1,3], nums2 = [2]
 * 输出：2.00000
 * 解释：合并数组 = [1,2,3] ，中位数 2
 *
 * 示例 2：
 * 输入：nums1 = [1,2], nums2 = [3,4]
 * 输出：2.50000
 * 解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
 *
 * 示例 3：
 * 输入：nums1 = [0,0], nums2 = [0,0]
 * 输出：0.00000
 *
 * 示例 4：
 * 输入：nums1 = [], nums2 = [1]
 * 输出：1.00000
 */
public class lt_4 {
    public static double findMedianSortedArrays(int[] A,int[] B){
        int m = A.length;
        int n = B.length;
        int len = m+n;
        int left = -1,right = -1;
        int aStart = 0,bStart = 0;
        for (int i = 0; i <= len/2; i++) {
            left = right;
            if (aStart<m && (bStart >= n || A[aStart] < B[bStart])){
                right = A[aStart++];
            }
            else {
                right = B[bStart++];
            }
        }
        if ((len & 1)==0)
            return (left+right)/2.0;
        else
            return right;
    }

    public static void main(String[] args) {
        int[] A = {1};
        int[] B = {};
        double result = findMedianSortedArrays(A,B);
        System.out.println(result);
    }
}
