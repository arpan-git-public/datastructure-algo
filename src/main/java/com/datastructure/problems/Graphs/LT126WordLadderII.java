package com.datastructure.problems.Graphs;

import java.util.*;

public class LT126WordLadderII {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
       Set<String> wordSet = new HashSet<>(wordList);
       Queue<List<String>> q = new ArrayDeque<>();
       List<String> usedLevelList = new ArrayList<>();
       List<List<String>> ans = new ArrayList<>();
        List<List<String>> levelList = new ArrayList<>();

       usedLevelList.add(beginWord);
       q.offer(usedLevelList);
       int level = 0;
       while(!q.isEmpty()) {
           List<String> peekList = q.peek();
           q.poll();
           String lastWord = peekList.get(peekList.size()-1);

           if(peekList.size() > level) {
               level++;
               levelList.stream().forEach(ll -> {
                   String lastWordInList = ll.get(ll.size() - 1);
                   wordSet.remove(lastWordInList); //level has been changed
               });
               levelList.clear();
           }

           // if word matches then add all pairs of that level to the ans list
           if(endWord.equals(lastWord)) {
               if (ans.isEmpty()) {
                    ans.add(peekList);
               } else if(ans.get(0).size() == peekList.size()) {
                   ans.add(peekList);
               }

           }

           //form a matching transformed word pair and add to queue.
           for(int i = 0 ; i < lastWord.length(); i++) {
               for(char ch = 'a' ; ch <= 'z'; ch++) {
                   char[] arr = lastWord.toCharArray();
                   arr[i] = ch;
                   String transformedWord = new String(arr);
                   if(wordSet.contains(transformedWord)) {
                       List<String> newList = new ArrayList<>();
                       newList.addAll(peekList);
                       newList.add(transformedWord);
                       q.offer(newList);
                       levelList.add(newList);
                   }
               }
           }


       }
       return ans;
    }

    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> ls = new ArrayList<>();
        ls.add("hot");
        ls.add("dot");
        ls.add("dog");
        ls.add("lot");
        ls.add("log");
        ls.add("cog");
        var lt = new LT126WordLadderII();
        lt.findLadders(beginWord,endWord,ls).forEach(lsa ->{
            System.out.println();
                lsa.forEach(s -> System.out.print( s  + " --> "));
        });
    }
}
