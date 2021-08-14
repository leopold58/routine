package com.gj.routine.lt;

import java.util.Scanner;

/**
 * @title: 删除排序链表中的重复元素 II
 * @description: 存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除链表中所有存在数字重复情况的节点，只保留原始链表中没有重复出现的数字。
 *               返回同样按升序排列的结果链表。
 *               输入：head = [1,2,3,3,4,4,5]
 *               输出：[1,2,5]
 *               输入：head = [1,1,1,2,3]
 *               输出：[2,3]
 *               提示：
 *                  链表中节点数目在范围 [0, 300] 内
 *                  -100 <= Node.val <= 100
 *                  题目数据保证链表已经按升序排列
 * @author: jguo
 * @date: 2021/8/12
 */
public class lt_82 {

    /**
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head){
        if(head == null){
            return head;
        }
        ListNode originNode = new ListNode(0,head);
        ListNode cur = originNode;
        while (cur.next!=null && cur.next.next!=null){
            if (cur.next.val == cur.next.next.val){
                int temp = cur.next.val;
                while (cur.next!=null && cur.next.val == temp){
                    cur.next = cur.next.next;
                }
            }else {
                cur = cur.next;
            }
        }
        return originNode.next;
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
        lt_82 solution = new lt_82();
        ListNode res = solution.deleteDuplicates(head);
        System.out.println("删除排序链表中的重复元素 II 后的链表val值：");
        while (res!=null){
            System.out.print(res.val + "\t");
            res = res.next;
        }
    }
}
