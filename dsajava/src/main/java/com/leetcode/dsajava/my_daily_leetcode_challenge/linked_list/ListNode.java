package com.leetcode.dsajava.my_daily_leetcode_challenge.linked_list;

//  Definition for singly-linked list.
public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static void printLL(ListNode head) {
        ListNode t = head;
        while (t != null) {
            System.out.print(t.val + "->");
            t = t.next;
        }
        System.out.println();
    }
}
