package com.leetcode.dsakotin.my_daily_leetcode.backtrack_recursive

fun main() {
    val beginWord = "hit"
    val endWord = "cog"
    val wordList = arrayListOf("hot", "dot", "dog", "lot", "log", "cog")
    println("res: ${ladderLength(beginWord, endWord, wordList)}")
}

// Time: O(m*n^2), Space: O(m*n^2), n: wordList.size, m: word.length
fun ladderLength(beginWord: String, endWord: String, wordList: List<String>): Int {
    if (wordList.isEmpty() || !wordList.contains(endWord)) return 0
    val adj: MutableMap<String, MutableSet<String>> = mutableMapOf()
    // Step 1: convert words to adj list
    for (i in wordList.indices) {
        for (j in i + 1 until wordList.size) {
            val word1 = wordList[i]
            val word2 = wordList[j]
            if (adj[word1] == null) adj[word1] = mutableSetOf()
            if (adj[word2] == null) adj[word2] = mutableSetOf()
            if (difference(word1, word2) == 1) { // can transform
                adj[word1]?.add(word2)
                adj[word2]?.add(word1)
            }
        }
    }

    // Step 2: beginWord is not in wordList, have to find a word that beginWord can transform to
    val queue = arrayListOf<Pair<String, Int>>()
    val visited = mutableSetOf<String>()
    for (word in wordList) {
        if (difference(beginWord, word) == 1) {
            queue.add(Pair(word, 1))
            visited.add(word)
        }
    }

    // Step 3: traverse word list, do transformation
    var i = 0
    while (i < queue.size) {
        val word = queue[i].first
        val level = queue[i].second
        i++
        if (word == endWord) return level + 1
        for (transformation in adj[word].orEmpty()) {
            if (!visited.contains(transformation)) {
                queue.add(Pair(transformation, level + 1))
                visited.add(transformation)
            }
        }
    }
    return 0
}

fun difference(word1: String, word2: String): Int {
    var counter = 0
    word1.indices.forEach { i ->
        if (word1[i] != word2[i]) counter++
    }
    return counter
}