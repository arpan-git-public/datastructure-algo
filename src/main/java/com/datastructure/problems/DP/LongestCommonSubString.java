package com.datastructure.problems.DP;

public class LongestCommonSubString {

    int longestCommonSubStringLen(String s1, String s2) {
        int[][] dp = new int[s1.length()+1][s2.length()+1];
        int maxLen = 0;
        for(int i = 0 ; i <= s1.length(); i++ ){
            for(int j = 0 ; j <= s2.length(); j++) {
                if(i == 0 || j ==0) dp[i][j] = 0;
                else if(s1.charAt(i-1) == s2.charAt(j-1)) {dp[i][j] = dp[i-1][j-1] + 1;
                maxLen = Math.max(maxLen,dp[i][j]);
                }
                else
                    dp[i][j] = 0;
            }
        }
        return maxLen;
    }

    //Space Optimized Version
    int longestCommonSubStringLenSpaceOptimized(String s1, String s2) {
        int[] prev = new int[s2.length()+1];
        int[] curr = new int[s2.length()+1];
        int maxLen = 0;
        for(int i = 0 ; i <= s1.length(); i++ ){
            for(int j = 0 ; j <= s2.length(); j++) {
                if(i == 0 || j ==0) curr[j] = 0;
                else if(s1.charAt(i-1) == s2.charAt(j-1)) {
                    curr[j] = prev[j-1] + 1;
                    maxLen = Math.max(maxLen,curr[j]);
                }
                else
                    curr[j] = 0;
            }
            // Swap arrays instead of assigning reference
            int[] temp = prev;
            prev = curr;
            curr = temp;
        }
        return maxLen;
    }

    public static void main(String[] args) {
        var obj = new LongestCommonSubString();
        System.out.println(obj.longestCommonSubStringLen("abcjklp","acjkp"));

        System.out.println(obj.longestCommonSubStringLenSpaceOptimized("abcjklp","acjkp"));

    }
}
