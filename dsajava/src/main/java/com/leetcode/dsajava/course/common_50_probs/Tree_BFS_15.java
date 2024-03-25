package com.leetcode.dsajava.course.common_50_probs;

import com.leetcode.dsajava.course.common_50_probs.common.Tree;

import java.util.Queue;

public class Tree_BFS_15 {

    // section 15:
    public void bfs(Tree root) {
        // your code here
        if (root == null) return;
        Queue<Tree> queue = new java.util.LinkedList<>();
        Tree curr;
        queue.add(root);
        while (!queue.isEmpty()) {
            curr = queue.poll();
            System.out.println(curr.data);
            if (curr.left != null) {
                queue.add(curr.left);
            }
            if (curr.right != null) {
                queue.add(curr.right);
            }
        }
    }
}
