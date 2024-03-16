package com.leetcode.dsakotin.my_daily_leetcode.backtrack_recursive


fun main() {
    val board = arrayOf(
        charArrayOf('K', 'I', 'N', 'T'),
        charArrayOf('B', 'I', 'N', 'S'),
        charArrayOf('G', 'N', 'Y', 'I'),
        charArrayOf('U', 'O', 'E', 'D'),
        charArrayOf('D', 'I', 'B', 'V'),
        charArrayOf('H', 'I', 'R', 'T')
    )
    val word = "INSIDE"
    println("res: ${exist(board, word)}")
}

fun exist(board: Array<CharArray>, word: String): Boolean {
    val n = board.size
    val m = board[0].size
    val visited = Array(n) { BooleanArray(m) { false } }
    for (i in 0 until n) {
        (0 until m).forEach { j ->
            if (board[i][j] == word[0]
                && wordSearch(board, word, i, j, 0, visited)
            ) return true
        }
    }
    return false
}

fun wordSearch(
    board: Array<CharArray>,
    word: String,
    i: Int, j: Int,
    counter: Int,
    visited: Array<BooleanArray>,
): Boolean {
    if (counter == word.length) return true
    if (
        outOfBoard(board, i, j)
        || visited[i][j]
        || board[i][j] != word[counter]
    ) return false
    visited[i][j] = true
    val isFound = wordSearch(board, word, i + 1, j, counter + 1, visited)
            || wordSearch(board, word, i, j + 1, counter + 1, visited)
            || wordSearch(board, word, i - 1, j, counter + 1, visited)
            || wordSearch(board, word, i, j - 1, counter + 1, visited)
    if (isFound) return true
    else {
        visited[i][j] = false
        return false
    }
}

fun outOfBoard(board: Array<CharArray>, i: Int, j: Int): Boolean {
    val n = board.size
    val m = board[0].size
    return i < 0 || i >= n || j < 0 || j >= m
}