package com.gj.routine.lt;

public class lt_141 {


    public boolean hasCycle(ListNode head){
        if (head == null || head.next == null){
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow!=fast){
            if (fast == null || fast.next==null){
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }

        return true;
    }
    public static void main(String[] args) {
        lt_141 solution = new lt_141();
        ListNode head = new ListNode(3);
        ListNode f1 = new ListNode(2);
        ListNode f2 = new ListNode(0);
        ListNode f3 = new ListNode(4);
        head.next = f1;
        f1.next = f2;
        f2.next = f3;
        f3.next = f1;
        boolean res = solution.hasCycle(head);
        System.out.println(res);
    }
}
