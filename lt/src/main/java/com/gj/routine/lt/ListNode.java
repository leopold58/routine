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
}
