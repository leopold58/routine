package com.gj.routine.lt;

/**
 * @title: 删除链表的倒数第 N 个结点
 * @description: 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 *               进阶：你能尝试使用一趟扫描实现吗？
 *               输入：head = [1,2,3,4,5], n = 2
 *               输出：[1,2,3,5]
 * @author: jguo
 * @date: 2021/4/30
 */
public class lt_19 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode root = new ListNode(0,head);
        ListNode start = root;
        ListNode end = root;
        for (int i = 0; i < n; i++) {
            end = end.next;
        }
        while (end.next!=null){
            start = start.next;
            end = end.next;
        }
        start.next = start.next.next;
        return root.next;

    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        int num = 2;
        lt_19 solution = new lt_19();
        ListNode head = new ListNode(nums[0]);
        ListNode cur = head;
        for (int i = 1; i < nums.length; i++) {
            ListNode temp = new ListNode(nums[i]);
            cur.next = temp;
            cur = cur.next;
        }
        cur.next = null;
        ListNode res = solution.removeNthFromEnd(head,num);
        while (res!=null){
            System.out.print(res.val + " ");
            res = res.next;

        }

    }
}
