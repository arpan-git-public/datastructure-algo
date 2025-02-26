package com.datastructure.problems.Graphs;

import java.util.*;

/**
 * A transformation sequence from word beginWord to word endWord using a dictionary wordList is a sequence of words beginWord -> s1 -> s2 -> ... -> sk such that:
 *
 * Every adjacent pair of words differs by a single letter.
 * Every si for 1 <= i <= k is in wordList. Note that beginWord does not need to be in wordList.
 * sk == endWord
 * Given two words, beginWord and endWord, and a dictionary wordList, return the number of words in the shortest transformation sequence from beginWord to endWord, or 0 if no such sequence exists.
 *
 *
 *
 * Example 1:
 *
 * Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
 * Output: 5
 * Explanation: One shortest transformation sequence is "hit" -> "hot" -> "dot" -> "dog" -> cog", which is 5 words long.
 * Example 2:
 *
 * Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log"]
 * Output: 0
 * Explanation: The endWord "cog" is not in wordList, therefore there is no valid transformation sequence.
 *
 *
 * Constraints:
 *
 * 1 <= beginWord.length <= 10
 * endWord.length == beginWord.length
 * 1 <= wordList.length <= 5000
 * wordList[i].length == beginWord.length
 * beginWord, endWord, and wordList[i] consist of lowercase English letters.
 * beginWord != endWord
 * All the words in wordList are unique.
 */
public class LT127WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        Queue<Pair> q = new ArrayDeque<>();
        q.offer(new Pair(beginWord,1));
        wordSet.remove(beginWord);

        if(!wordSet.contains(endWord)) return 0;

        while(!q.isEmpty()) {
            Pair pair = q.peek();
            q.poll();
            int startPointer = 1;


                for (int i = startPointer; i < pair.word().length(); i++) {
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        char[] wordArr = pair.word.toCharArray();
                        wordArr[i] = ch;
                        String word = new String(wordArr);
                        if (endWord.equals(word))
                            return pair.level() + 1;

                        if (wordSet.contains(word)) {
                            q.offer(new Pair(word, pair.level() + 1));
                            wordSet.remove(word);
                        }
                    }
                }

        }
        return 0;
    }

    private record Pair(String word, int level) {};

    public static void main(String[] args) {
        String beginWord = "hit", endWord = "cog";
        List<String> wordList = new ArrayList<>();
        wordList.add("hot");
        wordList.add("dot");
        wordList.add("dog");
        wordList.add("lot");
        wordList.add("log");
        wordList.add("cog");
        var lt = new LT127WordLadder();
        System.out.println(lt.ladderLength(beginWord,endWord,wordList));
    }
}
