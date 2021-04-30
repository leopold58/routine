package com.gj.routine.lt;

import java.util.Scanner;

/**
 * lt-2.两数相加
 * 给你两个非空 的链表，表示两个非负的整数。它们每位数字都是按照逆序的方式存储的，并且每个节点只能存储一位数字。
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * 你可以假设除了数字 0 之外，这两个数都不会以 0开头。
 *
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]
 * 解释：342 + 465 = 807.
 * 示例 2：
 * 输入：l1 = [0], l2 = [0]
 * 输出：[0]
 * 示例 3：
 * 输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * 输出：[8,9,9,9,0,0,0,1]
 */
public class lt_2 {
    public static ListNode addTwoNumbers(ListNode l1,ListNode l2){
        if (l1==null) return l2;
        if (l2==null) return l1;
        ListNode head = new ListNode(0);
        ListNode cur = head;
        int carry = 0;
        while (l1!=null || l2!=null ){
            int sum = carry;
            if (l1!=null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2!=null){
                sum += l2.val;
                l2 = l2.next;
            }
            ListNode node = new ListNode(sum%10);
            cur.next = node;
            carry = sum/10;
            cur = cur.next;
        }
        if (carry>0){
            ListNode temp = new ListNode(carry);
            cur.next = temp;
            cur = cur.next;
        }
        cur.next = null;
        return head.next;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("链表1的长度：");
        int len1 = in.nextInt();
        System.out.println("链表1的元素：");
        ListNode h1=new ListNode(0);
        ListNode cur1 = h1;
        ListNode h2 = new ListNode(0);
        ListNode cur2 = h2;
        for (int i = 0; i < len1; i++) {
            int temp = in.nextInt();
            cur1.next = new ListNode(temp);
            cur1 = cur1.next;
        }
        System.out.println("链表2的长度：");
        int len2 = in.nextInt();
        System.out.println("链表2的元素：");
        for (int i = 0; i < len2; i++) {
            int temp = in.nextInt();
            cur2.next = new ListNode(temp);
            cur2 = cur2.next;
        }
        ListNode res = addTwoNumbers(h1.next,h2.next);
        ListNode node = res;
        while (node!=null){
            System.out.print(node.val + " ");
            node = node.next;
        }

    }

}
