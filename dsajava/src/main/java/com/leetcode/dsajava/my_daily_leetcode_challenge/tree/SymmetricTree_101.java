package com.leetcode.dsajava.my_daily_leetcode_challenge.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class SymmetricTree_101 {

    public static void main(String[] args) {

    }

    public static boolean isSymmetric(TreeNode root) {
        ArrayList<ArrayList<Integer>> levels = bfs(root);
        for (int i = 0; i < levels.size(); i++) {
            for (int j = 0; j < levels.get(i).size() / 2; j++) {
                if(levels.get(i).get(j) != (levels.get(i).get(levels.get(i).size() - 1 - j).intValue()))
                    return false;
            }
        }
        return true;
    }

    private static ArrayList<ArrayList<Integer>> bfs(TreeNode root) {
        ArrayList<ArrayList<Integer>> levels = new ArrayList<>();
        TreeNode fakeNode = new TreeNode(1000);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int qLen = queue.size();
            ArrayList<Integer> level = new ArrayList<>();
            for (int i = 0; i < qLen; i++) {
                TreeNode top = queue.poll();
                level.add(top.val);
                if(top != fakeNode) { // avoid infinite adding fake node, when top is fakeNode, do nothing
                    queue.add(top.left != null ? top.left : fakeNode);
                    queue.add(top.right != null ? top.right : fakeNode);
                }
            }
            levels.add(level);
        }
        return levels;
    }
}
