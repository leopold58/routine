package com.gj.routine.lt;

import java.util.Scanner;

/**
 * @title: 旋转链表
 * @description: 给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。
 *               输入：head = [1,2,3,4,5], k = 2
 *                  输出：[4,5,1,2,3]
 *               输入：head = [0,1,2], k = 4
 *                  输出：[2,0,1]
 *               提示：
 *                  链表中节点的数目在范围 [0, 500] 内
 *                  -100 <= Node.val <= 100
 *                  0 <= k <= 2 * 109
 * @author: jguo
 * @date: 2021/7/16
 */
public class lt_61 {

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k<=0){
            return head;
        }
        int count = 1;
        ListNode cur = head;
        while (cur.next!=null){
            cur = cur.next;
            count++;
        }
        ListNode end = cur;
        //需要往前移动的数目
        int preSteps = k % count;
        if(preSteps == 0) return head;
        ListNode temp = head;
        for (int i = 1; i < count - preSteps; i++) {
            temp = temp.next;
        }
        ListNode res = temp.next;
        temp.next = null;
        end.next = head;
        return res;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("输入一串数字,以逗号分隔");
        String s = in.nextLine();
        String[] sInput = s.trim().split(",");
        int[] nums = new int[sInput.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(sInput[i]);
        }
        ListNode node = new ListNode(0);
        ListNode ans = node.buildList(nums);
        System.out.println("请输入一个数字k:");
        int k = in.nextInt();
        lt_61 solution = new lt_61();
        ListNode result = solution.rotateRight(ans, k);
        while (result!=null){
            System.out.print(result.val+"\t");
            result = result.next;
        }
    }
}
