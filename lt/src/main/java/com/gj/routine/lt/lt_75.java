package com.gj.routine.lt;

import java.util.Scanner;

/**
 * @title: 颜色分类
 * @description: 给定一个包含红色、白色和蓝色,一共n个元素的数组，原地 对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 *               此题中，我们使用整数 0、1 和 2 分别表示红色、白色和蓝色。
 *               示例 1：
 *                  输入：nums = [2,0,2,1,1,0]
 *                  输出：[0,0,1,1,2,2]
 *               示例 2：
 *                  输入：nums = [2,0,1]
 *                  输出：[0,1,2]
 *               示例 3：
 *                  输入：nums = [0]
 *                  输出：[0]
 *               示例 4：
 *                  输入：nums = [1]
 *                  输出：[1]
 *               提示：
 *                  n == nums.length
 *                  1 <= n <= 300
 *               nums[i] 为 0、1 或 2
 * @author: jguo
 * @date: 2021/7/25
 */
public class lt_75 {

    //循环不变量定义两种做法，这个做法比较厉害啊，参考在 Java 的 JDK 的源码中 Arrays.sort()

    /**
     * all in [0, zero) = 0
     * all in [zero, i) = 1
     * all in [two, len - 1] = 2
     * @param nums
     */
    public void sortColors(int[] nums) {
        int len = nums.length;
        if (len < 2){
            return;
        }
        //循环终止条件是 i == two，那么循环可以继续的条件是 i < two
        //为了保证初始化的时候 [0, zero) 为空，设置 zero = 0，
        //所以下面遍历到 0 的时候，先交换，再加
        int zero = 0;

        //为了保证初始化的时候[two,len-1]为空，设置two = len,所以下面遍历到2的时候，先减，再交换
        int two = len;
        int i = 0;
        //当i = two 的时候上面的三个子区间正好覆盖了全部数组，因此，循环条件为i<two
        while (i<two){
            if (nums[i] == 0){
                swap(nums,i,zero);
                zero++;
                i++;
            }else if (nums[i] == 1){
                i++;
            }else {
                two--;
                swap(nums,i,two);
            }
        }
    }
    //第二种
//    public void sortColors(int[] nums) {
//        int len = nums.length;
//        if (len < 2) {
//            return;
//        }
//        // all in [0, zero] = 0
//        // all in (zero, i) = 1
//        // all in (two, len - 1] = 2
//
//        // 为了保证初始化的时候 [0, zero] 为空，设置 zero = -1，
//        // 所以下面遍历到 0 的时候，先加，再交换
//        int zero = -1;
//
//        // 为了保证初始化的时候 (two, len - 1] 为空，设置 two = len - 1
//        // 所以下面遍历到 2 的时候，先交换，再减
//        int two = len - 1;
//        int i = 0;
//        // 当 i == two 的时候，还有一个元素还没有看，
//        // 因此，循环可以继续的条件是 i <= two
//        while (i <= two) {
//            if (nums[i] == 0) {
//                zero++;
//                swap(nums, i, zero);
//                i++;
//            } else if (nums[i] == 1) {
//                i++;
//            } else {
//                swap(nums, i, two);
//                two--;
//            }
//        }
//    }
    public void swap(int[] nums,int l,int r){
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }
    //指针思想，自己很久前搞的
//    public static void sortColors(int[] nums) {
//        int left=0,right=nums.length-1;
//        int curr=0,temp=0;
//        while(curr<=right){
//            if(nums[curr]==0){
//                temp=nums[curr];
//                nums[curr]=nums[left];
//                nums[left]=temp;
//                curr++;
//                left++;
//            }
//            else if (nums[curr]==2){
//                temp=nums[curr];
//                nums[curr]=nums[right];
//                nums[right]=temp;
//                right--;
//            }
//            else {
//                curr++;
//            }
//        }
//    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("请输入一串全部为0、1、2三个数字的数组用来分类，以逗号隔开：");
        String s = in.nextLine();
        String[] sInput = s.trim().split(",");
        int[] nums = new int[sInput.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(sInput[i]);
        }
        lt_75 solution = new lt_75();
        solution.sortColors(nums);
        System.out.println("分类后的数组：");
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]+"\t");
        }
    }
}
