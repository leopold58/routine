package com.gj.routine.lt;

import java.util.logging.Handler;

/**
 * @title: 合并K个升序链表
 * @description: 给你一个链表数组，每个链表都已经按升序排列。请你将所有链表合并到一个升序链表中，返回合并后的链表。
 *               输入：lists = [[1,4,5],[1,3,4],[2,6]]
 *               输出：[1,1,2,3,4,4,5,6]
 *               解释：链表数组如下：
 *                 [
 *                   1->4->5,
 *                   1->3->4,
 *                   2->6
 *                 ]
 *               将它们合并到一个有序链表中得到。
 *               1->1->2->3->4->4->5->6
 * @author: jguo
 * @date: 2021/5/3
 */
public class lt_23 {

    public ListNode mergeKLists(ListNode[] lists){
        return merge(lists,0,lists.length-1);
    }
    public ListNode merge(ListNode[] lists,int l, int r){
        if (l == r){
            return lists[l];
        }
        if (l > r){
            return null;
        }
        int mid = (l + r)>>1;
        return mergeTwoLists(merge(lists,l,mid),merge(lists,mid+1,r));
    }
    public ListNode mergeTwoLists(ListNode node1,ListNode node2){
        if (node1 == null || node2 ==null){
            return node1!=null? node1:node2;
        }
        ListNode head = new ListNode(0);
        ListNode cur = head;
        while (node1!=null && node2!=null){
            if (node1.val < node2.val){
                cur.next = node1;
                node1 = node1.next;
            }else {
                cur.next = node2;
                node2 = node2.next;
            }
            cur = cur.next;
        }
        cur.next = node1!=null? node1:node2;
        return head.next;
    }

    public static void main(String[] args) {
        //构建lists

        //构建样例类测试
    }
}
