package com.leetcode.dsajava.course.common_50_probs;

import java.util.Stack;

public class IsValidPalindrome_27 {

    public static void main(String[] args) {
        System.out.println("isValid: "+isValid("{{[[]]}}"));
    }

    // Section 27
    public static boolean isValid(String str) {
        // your code here
        str = "{()}";
//        str = "()";
        Stack<Character> stack = new java.util.Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char si = str.charAt(i);
            if (stack.isEmpty()) {
                stack.add(si);
            } else {
                Character top = stack.peek();
                if ((top == '{' && si == '}') || (top == '[' && si == ']') || (top == '(' && si == ')')) {
                    stack.pop();
                } else stack.add(si);
            }
        }
        return stack.isEmpty();
    }
}
