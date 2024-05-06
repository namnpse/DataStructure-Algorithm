package com.leetcode.dsajava.course.common_50_probs;

import java.util.Stack;

public class SmallestAfterRemoving_41 {

    public static void main(String[] args) {
        System.out.println(smallestAfterRemoving("12000321", 2));
    }

    // Section 41:
    // Time: O(7n)
    public static String smallestAfterRemoving(String num, int k) {
        if (k == num.length()) return "0"; // remove all -> empty -> not a number -> "0"
        Stack<Character> stack = new Stack<>();
        for (Character digit : num.toCharArray()) {
            while (!stack.isEmpty() && stack.peek() > digit && k > 0) {
                stack.pop();
                k--;
            }
            stack.push(digit);
        }
        while (k > 0) {
            stack.pop();
            k--;
        }
        Stack<Character> numberStack = new Stack<>();
        while (!stack.isEmpty()) { // reverse stack
            numberStack.add(stack.pop());
        }
        while (!numberStack.isEmpty() && numberStack.peek() == '0') { // remove leading 0
            numberStack.pop();
        }
        StringBuilder res = new StringBuilder();
        while (!numberStack.isEmpty()) {
            res.append(numberStack.pop());
        }
        return res.isEmpty() ? "0" : res.toString();
    }
}
