package com.leetcode.dsajava.my_daily_leetcode_challenge.linked_list;

import static com.leetcode.dsajava.my_daily_leetcode_challenge.linked_list.ListNode.printLL;

public class SwappingNodesInLinkedList_1721 {

    public static void main(String[] args) {
        ListNode head = new
                ListNode(1,
                new ListNode(0,
                        new ListNode(1)
                )
        );
        printLL(head);
        int k = 2;
        ListNode res = swapNodes(head, k);
        printLL(res);

    }

    public static ListNode swapNodes(ListNode head, int k) {
        int n = getLength(head);
        if(k > n)   return head;

        ListNode n1 = head;
        int count = 1;
        while (count < k) {
            count++;
            n1 = n1.next;
        }
        ListNode n2 = head;
        count = 1;
        while (count < n-k+1) {
            count++;
            n2 = n2.next;
        }

        int t = n1.val;
        n1.val = n2.val;
        n2.val = t;

        return head;
    }

    private static int getLength(ListNode head) {
        int count = 0;
        ListNode t = head;
        while (t != null) {
            count++;
            t = t.next;
        }
        return count;
    }
}
