package com.leetcode.dsajava.course.common_50_probs;

import java.util.ArrayList;
import java.util.List;

public class PalindromeLinkedList_11 {

    // section 11
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }

        Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    static class LinkedList {
        Node head;

        LinkedList() {
            this.head = null;
        }

        LinkedList(Node head) {
            this.head = head;
        }
    }

    // section 11: Palindrome Linked List
    public boolean isPalindromeList(LinkedList list) {
        // your code here
        Node temp = list.head;
        if (temp == null || temp.next == null) return true;
        List<Integer> values = new ArrayList<>();
        while (temp != null) {
            values.add(temp.data);
            temp = temp.next;
        }
        // reverse linked list
        Node prev = null;
        Node curr = list.head;
        Node next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        list.head = prev;
        temp = list.head;
        int i = 0;
        while (temp != null) {
            if (temp.data != values.get(i)) return false;
            i++;
            temp = temp.next;
        }
        return true;
    }

    // C2: Better about Space
/*    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null)   return true;
        ListNode slow = head;
        ListNode fast = head;
        // find middle node
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // reverse list from middle node to end
        ListNode prev = null;
        ListNode curr = slow;
        ListNode next;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        ListNode head1 = head;
        ListNode head2 = prev;

        while (head1 != null && head2 != null) {
            if(head1.val != head2.val) {
                return false;
            }
            head1 = head1.next;
            head2 = head2.next;
        }
        return true;
    }*/
}
