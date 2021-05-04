package com.gj.routine.lt;

import java.util.List;
import java.util.Scanner;

/**
 * @title:  K 个一组翻转链表
 * @description: 给你一个链表，每k个节点一组进行翻转，请你返回翻转后的链表。k是一个正整数，它的值小于或等于链表的长度。
 *               如果节点总数不是k的整数倍，那么请将最后剩余的节点保持原有顺序。
 *               进阶：
 *               你可以设计一个只使用常数额外空间的算法来解决此问题吗？
 *               你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 *               输入：head = [1,2,3,4,5], k = 3
 *               输出：[3,2,1,4,5]
 *               输入：head = [1,2,3,4,5], k = 2
 *               输出：[2,1,4,3,5]
 * @author: jguo
 * @date: 2021/5/3
 */
public class lt_25 {

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode root = new ListNode(0);
        root.next = head;
        ListNode pre = root;
        ListNode end = root;
        while (end.next!=null){
            for (int i = 0; i < k && end!=null; i++) {
                end = end.next;
            }
            if (end == null){
                break;
            }
            ListNode start = pre.next;
            ListNode next = end.next;
            end.next = null;
            pre.next = reverse(start);
            start.next = next;
            pre = start;
            end = pre;
        }
        return root.next;

    }
    public ListNode reverse(ListNode node){
        ListNode pre = null;
        ListNode cur = node;
        while (cur!=null){
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }

    public static void main(String[] args) {
        //构建链表-> String 转成 链表
        Scanner in = new Scanner(System.in);
        System.out.println("输入链表：(数字形式、连续输入、中间不加空格eg：12345)");
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
        lt_25 solution = new lt_25();
        System.out.println("输入k值，每k个节点反转(数字形式，小于链表的长度)eg：2");
        int k = in.nextInt();
        ListNode result = solution.reverseKGroup(root.next, k);
        while (result!=null){
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}
