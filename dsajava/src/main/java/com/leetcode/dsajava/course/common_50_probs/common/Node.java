package com.leetcode.dsajava.course.common_50_probs.common;

public class Node {
    public int data;
    public Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }

    Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }
}
