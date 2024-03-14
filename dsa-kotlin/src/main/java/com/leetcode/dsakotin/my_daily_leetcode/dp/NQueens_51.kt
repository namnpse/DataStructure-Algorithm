package com.leetcode.dsakotin.my_daily_leetcode.dp


fun main() {
    val n = 4
    solveNQueens(n)
}

fun solveNQueens(n: Int): List<List<String>> {
    val board = Array(n) { CharArray(n) { '.' } }
    val tempList = mutableListOf<Pair<Int, Int>>()
    val res: MutableList<List<String>> = mutableListOf()
    // use val + MutableList to modify (add/remove) list,
    // if use List, use var (plus fun return new List everytime)
    solveNQueens(n, board, row = 0, res, tempList)
    println("res: "+res.size)
    return res
}

fun solveNQueens(n: Int, board: Array<CharArray>, row: Int, res: MutableList<List<String>>, tempList: List<Pair<Int, Int>>) {
    if(row == n) {
        val list = mutableListOf<String>()
        board.forEach { // record current board with n Queens we have put in it
            list += it.joinToString(separator = "")
        }
        res += list // use '+' with MutableList (can modify), use 'plus' with List (read-only), plus return new object everytime adding new element
        return
    }
    (0 until n).forEach { i ->
        val coordinate = Pair(row, i)
        if (isNotAttacked(board, row, i)) {
            board[row][i] = 'Q'
            tempList.plus(coordinate)
            solveNQueens(n, board, row+1, res, tempList)
            board[row][i] = '.'
            tempList.minus(coordinate)
        }
    }
}

fun isNotAttacked(board: Array<CharArray>, row: Int, col: Int): Boolean {
    var i = row - 1
    var left = col - 1
    var right = col + 1
    while (i >= 0) {
        if (
            board[i][col] == 'Q'
            || left >= 0 && board[i][left] == 'Q'
            || right < board.size && board[i][right] == 'Q'
        ) {
            return false
        } else {
            i--
            left--
            right++
        }
    }
    return true
}