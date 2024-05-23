package com.leetcode.dsajava.course.common_50_probs;

public class WordSearch_48 {

    // Section 48: word search
    // C1: recursive
    // Time: O(n*m*4^w) (w: word length), Space: O(w)
    public static boolean wordSearch(char[][] board, String word) {
        // your code here
        int n = board.length;
        int m = board[0].length;
        boolean[][] visited = new boolean[n][m];
        for (int i = 0; i < n; i++) { // n
            for (int j = 0; j < m; j++) { // m
                if(
                        board[i][j] == word.charAt(0) // start searching if board at (i,j) == first word's letter
                                && wordSearch(board, word, i, j, 0, visited) // 4^w
                ) return true;
            }
        }
        return false;
    }

    // O(4^w) for wordSearch() recursive
    public static boolean wordSearch(char[][] board, String word, int i, int j, int counter, boolean[][] visited) {
        if (counter == word.length()) return true;
        if (
                isOutOfBoard(board, i, j)
                        || visited[i][j]
                        || board[i][j] != word.charAt(counter)
        ) return false;
        visited[i][j] = true;
        boolean isFound =
                wordSearch(board, word, i+1, j, counter+1, visited)
                        || wordSearch(board, word, i, j+1, counter+1, visited)
                        || wordSearch(board, word, i-1, j, counter+1, visited)
                        || wordSearch(board, word, i, j-1, counter+1, visited);
        if(isFound) return true;
        else {
            visited[i][j] = false;
            return false;
        }
    }

    private static boolean isOutOfBoard(char[][] board, int i, int j) {
        int n = board.length;
        int m = board[0].length;
        return i < 0 || i >= n || j < 0 || j >= m;
    }
}
