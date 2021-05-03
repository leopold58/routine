package com.gj.routine.lt;

import java.util.Scanner;

/**
 * @title: 两两交换链表中的节点
 * @description: 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *                输入：head = [1,2,3,4]
 *                输出：[2,1,4,3]
 *                输入：head = []
 *                输出：[]
 *                输入：head = [1]
 *                输出：[1]
 * @author: jguo
 * @date: 2021/5/3
 */
public class lt_24 {
    //递归法去实现链表的两两交换
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode next = head.next;
        head.next = swapPairs(next.next);
        next.next = head;
        return next;
    }

    public static void main(String[] args) {
        //构建链表
        Scanner in = new Scanner(System.in);
        String input = in.next();
        ListNode root = new ListNode(0);
        ListNode start = root;
        for (int i = 0; i < input.length(); i++) {
            int a = input.charAt(i)-'0';
            ListNode temp = new ListNode(a);
            start.next = temp;
            start = start.next;
        }
        start.next = null;
        lt_24 solution = new lt_24();
        ListNode res = solution.swapPairs(root.next);
        //输出结果
        while (res!=null){
            System.out.print(res.val + " ");
            res = res.next;
        }

    }

}
