package com.leetcode.dsajava.my_daily_leetcode_challenge.backtrack_recursive;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class WordLadder_127 {

    public static void main(String[] args) {

    }

    // Time: O(m*n^2), Space: O(m*n^2), n: wordList.size, m: word.length
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // B1: convert words to adj list
        if (wordList.isEmpty() || !wordList.contains(endWord)) return 0;
        Map<String, Set<String>> adj = new HashMap<>();
        for (int i = 0; i < wordList.size(); i++) {
            for (int j = i + 1; j < wordList.size(); j++) {
                String word1 = wordList.get(i);
                String word2 = wordList.get(j);
                adj.computeIfAbsent(word1, k -> new HashSet<>());
                adj.computeIfAbsent(word2, k -> new HashSet<>());
                if (different(word1, word2) == 1) { // can transform
                    adj.get(word1).add(word2);
                    adj.get(word2).add(word1);
                }
            }
        }
        Set<String> visited = new HashSet<>();
        ArrayList<Pair<String, Integer>> queue = new ArrayList<>();
        // Step 2: beginWord is not in wordList, have to find a word that beginWord can transform to
        for (String word : wordList) {
            if (different(beginWord, word) == 1) { // can transform
                queue.add(new Pair<>(word, 1)); // word, level
                visited.add(word);
            }
        }

        // Step3:
        int i = 0;
        while (i < queue.size()) {
            String word = queue.get(i).fst; // first
            Integer level = queue.get(i).snd; // second
            i++;
            if (word.equals(endWord)) return level + 1;
            else {
                for (String transformation : adj.get(word)) {
                    if(!visited.contains(transformation)) {
                        queue.add(new Pair<>(transformation, level+1));
                        visited.add(transformation);
                    }
                }
            }
        }
        return 0;
    }


    private int different(String word1, String word2) {
        int counter = 0;
        for (int i = 0; i < word1.length(); i++) {
            if (word1.charAt(i) != word2.charAt(i)) counter++;
        }
        return counter;
    }

    public class Pair<A, B> {
        public final A fst;
        public final B snd;

        public Pair(A fst, B snd) {
            this.fst = fst;
            this.snd = snd;
        }
    }
}
