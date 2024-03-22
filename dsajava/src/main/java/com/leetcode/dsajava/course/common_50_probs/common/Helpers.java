package com.leetcode.dsajava.course.common_50_probs.common;

public class Helpers {
    public static void printLL(Node head) {
        Node t = head;
        while (t != null) {
            System.out.print(t.data + "->");
            t = t.next;
        }
        System.out.println();
    }
}
