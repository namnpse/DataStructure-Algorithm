package com.leetcode.dsajava.course.common_50_probs;

import com.leetcode.dsajava.course.common_50_probs.common.Tree;

import java.util.ArrayList;
import java.util.Queue;

public class GetValuesByLevel_21 {

    // Section 21: Tree BFS II
    public static ArrayList<ArrayList<Integer>> getValuesByLevel(Tree root) {
        // your code here
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<Tree> queue = new java.util.LinkedList<>();
        queue.add(root);
        ArrayList<Integer> level0 = new ArrayList<>();
        level0.add(root.data);
        res.add(level0);

        while (true) {
            ArrayList<Tree> treeLevel = BFS(queue);
            if (!treeLevel.isEmpty()) {
                ArrayList<Integer> level = new ArrayList<>();
                for (Tree node : treeLevel) {
                    level.add(node.data);
                }
                res.add(level);
                queue.addAll(treeLevel);
            } else {
                break;
            }
        }
        return res;
    }

    private static ArrayList<Tree> BFS(Queue<Tree> queue) {
        ArrayList<Tree> level = new ArrayList<>();
        while (!queue.isEmpty()) {
            Tree top = queue.poll();
            if (top.left != null) {
                level.add(top.left);
            }
            if (top.right != null) {
                level.add(top.right);
            }
        }
        return level;
    }
}
