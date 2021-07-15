package com.gj.routine.lt;

/**
 * @title: ListNode
 * @description: 链表节点类
 * @author: jguo
 * @date 2021/4/30
 */
public class ListNode {
    int val;
    ListNode next;
    ListNode(){}
    ListNode(int val){
        this.val = val;
    }
    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
    public ListNode buildList(int[] nums){
        if (nums == null || nums.length == 0){
            return new ListNode(-1);
        }
        ListNode head = new ListNode(0);
        ListNode cur = head;
        for (int i = 0; i < nums.length; i++) {
            ListNode temp = new ListNode(nums[i]);
            cur.next = temp;
            cur = cur.next;
        }
        cur.next = null;
        return head.next;
    }
}
