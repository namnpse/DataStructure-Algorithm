package com.leetcode.dsajava.my_daily_leetcode_challenge.linked_list;

import com.leetcode.dsajava.leetcode.linked_list.ListNode;

public class RemoveDuplicatesFromSortedList_83 {

    public static void main(String[] args) {

    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
//        Map<Integer, Boolean> map = new HashMap<>();
        // linked list is already sorted,
        // don't need to use HashMap,
        // just need to find the next node that has value > current node's value.
        ListNode curr = head;
        while (curr != null) {
            ListNode temp = curr.next;
            while (temp != null && temp.val == curr.val) {
                temp = temp.next;
            }
            curr.next = temp;
            curr = curr.next;
        }
        return head;
    }
}
