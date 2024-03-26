package com.leetcode.dsajava.course.common_50_probs;

import com.leetcode.dsajava.course.common_50_probs.common.Node;
import com.leetcode.dsajava.course.common_50_probs.common.LinkedList;

public class SortLinkedList_16 {

    // section 16: Sort the linked list
    public static void sortList(LinkedList list) {
        // your code here
        Node head = list.head;
        if (head == null || head.next == null) return;
        Node newNode = new Node(0);
        newNode.next = list.head;
        list.head = newNode;

        Node prev = newNode;
        Node i = prev.next;
        Node next;
        int count = getLength(i);
        while (count > 0) {
            Node j = newNode.next;
            prev = newNode;
            int temp = 0;
            while (j.next != null && temp < count) { // while (j < n - i -1)
                next = j.next;
                temp++;
                if (j.data > next.data) {
                    j.next = next.next;
                    prev.next = next;
                    next.next = j;

                    prev = next;
                } else {
                    prev = j;
                    j = j.next;
                }
            }
            System.out.println("i: " + i.data);
//            i = i.next;
            count--;
        }
        list.head = newNode.next;
    }

    private static int getLength(Node head) {
        int count = 0;
        Node curr = head;
        while (curr != null) {
            count++;
            curr = curr.next;
        }
        return count;
    }
}
