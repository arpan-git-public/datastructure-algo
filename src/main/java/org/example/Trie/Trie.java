package org.example.Trie;

import java.util.HashMap;
import java.util.Map;

class TrieNode {

    Map<Character,TrieNode> children; //to store childern name
    boolean isEndOfWord;
    public TrieNode() {
        this.children = new HashMap<>();
        this.isEndOfWord = false;
    }
}

public class Trie {
    TrieNode root;
    public Trie() {
        this.root = new TrieNode();
    }

    public void insert(String word) {
         TrieNode current = root;

         //iterate through all character
         for(Character c : word.toCharArray()) {
             //check if character is present then go down
            current.children.putIfAbsent(c,new TrieNode());
            current = current.children.get(c);
         }
         current.isEndOfWord = true;
    }

    public boolean search(String word) {
        TrieNode current = root;
        for(Character c: word.toCharArray()) {
            if(!current.children.containsKey(c)) {
                return false;
            }
            current = current.children.get(c);
        }
        return current.isEndOfWord;
    }

    public static void main(String args[]) {
        Trie trie = new Trie();
        trie.insert("Tesla");
        trie.insert("Honda");
        trie.insert("Volkswagen");
        trie.insert("Audi");

        System.out.println("Audi present : "+ trie.search("Audi"));
        System.out.println("Accord present : "+ trie.search("Accord"));
    }

}

