package com.leetcode.dsajava.my_daily_leetcode_challenge.graph;

import java.util.ArrayList;
import java.util.HashMap;

public class Graph {
    public HashMap<Integer, ArrayList<Integer>> adjList;

    public Graph() {
        this.adjList = new HashMap<>();
    }

    public Graph(HashMap<Integer, ArrayList<Integer>> adjList) {
        this.adjList = adjList;
    }
}
