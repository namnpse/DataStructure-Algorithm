package com.leetcode.dsajava.my_daily_leetcode_challenge.linked_list;

public class ConvertBinaryNumberInLinkedListToInteger_1290 {

    public static void main(String[] args) {
        ListNode head = new
                ListNode(1,
                new ListNode(0,
                        new ListNode(1)
                )
        );
        System.out.println("res: "+getDecimalValue(head));
    }

    public static int getDecimalValue(ListNode head) {
        int res = 0;
        int n = getLength(head);
        ListNode curr = head;
        while (curr != null) {
            res += (Math.pow(2, n - 1) * curr.val);
            curr = curr.next;
            n--;
        }

        return res;
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
