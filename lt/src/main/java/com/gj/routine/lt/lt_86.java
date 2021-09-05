package com.gj.routine.lt;

import java.util.Scanner;

/**
 * @title: 分隔链表
 * @description: 给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
 *               你应当 保留 两个分区中每个节点的初始相对位置。
 *               输入：head = [1,4,3,2,5,2], x = 3
 *               输出：[1,2,2,4,3,5]
 *               输入：head = [2,1], x = 2
 *               输出：[1,2]
 *               提示：
 *                  链表中节点的数目在范围 [0, 200] 内
 *                  -100 <= Node.val <= 100
 *                  -200 <= x <= 200
 * @author: jguo
 * @date: 2021/9/5
 */
public class lt_86 {
    public ListNode partition(ListNode head,int x){
        ListNode lowHead = new ListNode(-1);
        ListNode low = lowHead;
        ListNode highHead = new ListNode(-1);
        ListNode high = highHead;
        while (head!=null){
            if (head.val < x){
                low.next = head;
                low = low.next;
            }else {
                high.next = head;
                high = high.next;
            }
            head = head.next;
        }
        high.next = null;
        low.next = highHead.next;
        return lowHead.next;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        int x= in.nextInt();
        String[] sInput = s.trim().split(",");
        int[] nums = new int[sInput.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(sInput[i]);
        }
        ListNode temp = new ListNode(0);
        ListNode head = temp.buildList(nums);
        lt_86 solution = new lt_86();
        ListNode result = solution.partition(head, x);
        while (result!=null){
            System.out.print(result.val+ "\t");
            result = result.next;
        }
    }
}
