package com.datastructure.problems.slidingwindow;

import java.util.HashMap;

public class LT3LongestSubstrWithoutRepeatingChar {
    public int lengthOfLongestSubstring(String s) {
        var map = new HashMap<Character,Integer>();
        int i = 0, j = 0;
        int maxSubString = 0;

        while(j < s.length() && i < s.length()) {
            char c = s.charAt(j);
            if(!map.containsKey(c)) {
                map.put(c,1);
                j++;
            } else {
                maxSubString = Math.max(maxSubString,j-i);
                map.remove(s.charAt(i));
                i++;
            }
        }
        return Math.max(maxSubString,j-i);
    }
    public static void main(String[] args) {
        String s = "abcabcbb";
     //   String s = "a";
        var lt = new LT3LongestSubstrWithoutRepeatingChar();
        System.out.println(lt.lengthOfLongestSubstring(s));
    }
}
