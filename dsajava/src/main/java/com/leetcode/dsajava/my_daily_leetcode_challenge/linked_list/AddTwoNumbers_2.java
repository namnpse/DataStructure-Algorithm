package com.leetcode.dsajava.my_daily_leetcode_challenge.linked_list;

import static com.leetcode.dsajava.my_daily_leetcode_challenge.linked_list.ListNode.printLL;

public class AddTwoNumbers_2 {

    public static void main(String[] args) {
        ListNode l1 = new
                ListNode(9,
                new ListNode(9,
                        new ListNode(9,
                                new ListNode(9,
                                        new ListNode(9,
                                                new ListNode(9,
                                                        new ListNode(9)
                                                )
                                        )
                                )
                        )
                )
        );

        ListNode l2 = new
                ListNode(9,
                    new ListNode(9,
                        new ListNode(9,
                                new ListNode(9)
                        )
                    )
        );

        printLL(l1);
        printLL(l2);
        ListNode res = addTwoNumbers(l1, l2);
        printLL(res);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        ListNode res = new ListNode(0);
        ListNode head = res;

        int m = 0;
        while (cur1 != null || cur2 != null) {
            int sum = m
                    + (cur1 != null ? cur1.val : 0)
                    + (cur2 != null ? cur2.val : 0);
            res.next = new ListNode(sum%10);
            res = res.next;
            m = sum/10;
            if(cur1 != null)  cur1 = cur1.next;
            if(cur2 != null)  cur2 = cur2.next;
        }

        if(m > 0) {
            res.next = new ListNode(m);
        }

        return head.next;
    }
}
