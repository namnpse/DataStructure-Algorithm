package com.leetcode.dsajava.my_daily_leetcode_challenge.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal_102 {

    public static void main(String[] args) {

    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<Integer> level0 = new ArrayList<>();
        level0.add(root.val);
        res.add(level0);

        while (true) {
            List<TreeNode> treeLevel = BFS(queue);
            if(!treeLevel.isEmpty()) {
                List<Integer> level = new ArrayList<>();
                for (TreeNode node: treeLevel) {
                    level.add(node.val);
                }
                res.add(level);
                queue.addAll(treeLevel);
            } else {
                break;
            }
        }


        return res;
    }

    private static List<TreeNode> BFS(Queue<TreeNode> queue) {
        List<TreeNode> nodes = new ArrayList<>();
        while (!queue.isEmpty()) {
            TreeNode top = queue.poll();
            if(top.left != null) {
                nodes.add(top.left);
            }
            if(top.right != null) {
                nodes.add(top.right);
            }
        }
        return nodes;
    }
}
