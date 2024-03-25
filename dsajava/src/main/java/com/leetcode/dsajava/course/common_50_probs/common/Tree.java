package com.leetcode.dsajava.course.common_50_probs.common;

public class Tree {
    public int data;
    public Tree left;
    public Tree right;

    Tree(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    Tree(int data, Tree left, Tree right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
}
