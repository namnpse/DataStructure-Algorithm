package com.leetcode.dsajava.my_daily_leetcode_challenge.linked_list;

import static com.leetcode.dsajava.my_daily_leetcode_challenge.linked_list.ListNode.printLL;

public class DeleteTheMiddleNodeOfALinkedList_2095 {

    public static void main(String[] args) {
        ListNode head = new ListNode(1,
                new ListNode(3,
                        new ListNode(4,
                                new ListNode(7,
                                        new ListNode(1,
                                                new ListNode(2, null
//                                                        new ListNode(6)
                                                ))))));
        printLL(head);
        head = deleteMiddle(head);
        printLL(head);

    }

    public static ListNode deleteMiddle(ListNode head) {
        if (head == null || head.next == null) return null;
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;
//        1->3->4->7->1->2->6->
//        1->3->4->7->2->6->
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = slow.next;
        slow.next = null;
        return head;
    }
}
