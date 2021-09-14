package com.gj.routine.lt;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @title: 格雷编码
 * @description: 格雷编码是一个二进制数字系统，在该系统中，两个连续的数值仅有一个位数的差异。
 *               给定一个代表编码总位数的非负整数 n，打印其格雷编码序列。即使有多个不同答案，你也只需要返回其中一种。
 *               格雷编码序列必须以 0 开头。
 *               示例 1:
 *                  输入:2
 *                  输出:[0,1,3,2]
 *                  解释:
 *                      00 - 0
 *                      01 - 1
 *                      11 - 3
 *                      10 - 2
 *                  对于给定的n，其格雷编码序列并不唯一。
 *                  例如，[0,2,3,1]也是一个有效的格雷编码序列。
 *                      00 - 0
 *                      10 - 2
 *                      11 - 3
 *                      01 - 1
 *               示例2:
 *                  输入:0
 *                  输出:[0]
 *                  解释: 我们定义格雷编码序列必须以 0 开头。
 *                  给定编码总位数为 n 的格雷编码序列，其长度为 2n。当 n = 0 时，长度为 20 = 1。
 *                  因此，当 n = 0 时，其格雷编码序列为 [0]。
 * @author: jguo
 * @date: 2021/9/13
 */
public class lt_89 {

    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<Integer>() {{ add(0); }};
        int head = 1;
        for (int i = 0; i < n; i++) {
            for (int j = res.size() - 1; j >= 0; j--)
                res.add(head + res.get(j));
            head <<= 1;
        }
        return res;
    }

    //回溯法解决，但是效率较低
//    List<Integer> res = new ArrayList<>();
//    public List<Integer> grayCode(int n) {
//        backtrace(n,new StringBuffer(),new int[]{0,1});
//        return res;
//    }
//    public void backtrace(int n, StringBuffer sb, int[] nums){
//        //判断条件，是否返回
//        if(sb.length() == n){
//            // 二进制转换为十进制
//            res.add(Integer.valueOf(sb.toString(),2));
//            return;
//        }
//        // 回溯第一个状态
//        sb.append(nums[0]);
//        //注意数组
//        backtrace(n,sb,new int[]{0,1});
//        sb.deleteCharAt(sb.length()-1);
//        // 回溯第二个状态
//        sb.append(nums[1]);
//        //注意数组
//        backtrace(n,sb,new int[]{1,0});
//        sb.deleteCharAt(sb.length()-1);
//    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("输入一个数字：");
        int num = in.nextInt();
        lt_89 solution = new lt_89();
        List<Integer> results = solution.grayCode(num);
        System.out.println("格雷编码之一是：");
        System.out.println(results);
    }
}
