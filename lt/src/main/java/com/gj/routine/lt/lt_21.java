package com.gj.routine.lt;


/**
 * @title: 合并两个有序链表
 * @description: 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 *               输入：l1 = [1,2,4], l2 = [1,3,4]
 *               输出：[1,1,2,3,4,4]
 *               输入：l1 = [], l2 = []
 *               输出：[]
 *               输入：l1 = [], l2 = [0]
 *               输出：[0]
 * @author: jguo
 * @date: 2021/5/1
 */
public class lt_21 {
    //递归法
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null){
            return l2;
        }else if (l2 == null){
            return l1;
        }else if (l1.val < l2.val){
            l1.next = mergeTwoLists(l1.next,l2);
            return l1;
        }else {
            l2.next = mergeTwoLists(l1,l2.next);
            return l2;
        }

    }

    public static void main(String[] args) {
        //输入待测升序链表
        int[] l1 = {1,2,4};
        int[] l2 = {1,3,4};
        //构建链表
        ListNode root1 = new ListNode(0);
        ListNode node1 = root1;
        ListNode root2 = new ListNode(0);
        ListNode node2 = root2;
        for (int i = 0; i < l1.length; i++) {
            ListNode temp = new ListNode(l1[i]);
            node1.next = temp;
            node1 = node1.next;
        }
        node1.next = null;
        for (int i = 0; i < l2.length; i++) {
            ListNode temp = new ListNode(l2[i]);
            node2.next = temp;
            node2 = node2.next;
        }
        node2.next = null;
        //solution
        lt_21 solution = new lt_21();
        ListNode res = solution.mergeTwoLists(root1.next,root2.next);
        while (res!=null){
            System.out.print(res.val + " ");
            res = res.next;
        }

    }

}
