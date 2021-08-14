package com.gj.routine.lt;

import java.util.Scanner;

/**
 * @title: 删除排序链表中的重复元素
 * @description: 存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除所有重复的元素，使每个元素 只出现一次 。
 *               返回同样按升序排列的结果链表。
 *                  输入：head = [1,1,2]
 *                  输出：[1,2]
 *                  输入：head = [1,1,2,3,3]
 *                  输出：[1,2,3]
 *               提示：
 *                  链表中节点数目在范围 [0, 300] 内
 *                  -100 <= Node.val <= 100
 *                  题目数据保证链表已经按升序排列
 * @author: jguo
 * @date: 2021/8/15
 */
public class lt_83 {

    public ListNode deleteDuplicates(ListNode head) {
        if(head == null)  return null;
        ListNode cur = head;
        while (cur.next!=null ){
            if (cur.val == cur.next.val){
                cur.next = cur.next.next;
            }else {
                cur = cur.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("请输入一串数字，以逗号隔开，作为链表的val值：");
        String s = in.nextLine();
        String[] sInput = s.trim().split(",");
        int[] nums = new int[sInput.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(sInput[i]);
        }
        ListNode temp = new ListNode(-1);
        ListNode head = temp.buildList(nums);
        lt_83 solution = new lt_83();
        ListNode res = solution.deleteDuplicates(head);
        System.out.println("删除排序链表中的重复元素后的链表val值：");
        while (res!=null){
            System.out.print(res.val + "\t");
            res = res.next;
        }
    }
}
