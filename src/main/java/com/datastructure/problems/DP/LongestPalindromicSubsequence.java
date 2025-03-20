package com.datastructure.problems.DP;

public class LongestPalindromicSubsequence {

    int countPalindromicSubSequence(String s1, String s2) {
        int[][] dp = new int[s1.length()+1][s2.length()+1];

        for(int i = 0 ; i <= s1.length(); i++) {
            for(int j = 0; j <= s2.length(); j++) {
                if(i==0 || j == 0) dp[i][j] = 0;
                else  {
                    int include = 0;
                    if(s1.charAt(i-1) == s2.charAt(j-1)){
                        include = 1+ dp[i-1][j-1];
                    }
                    int exclude = Math.max(dp[i-1][j], dp[i][j-1]);
                    dp[i][j] = Math.max(include , exclude);
                }
            }
        }
        return dp[s1.length()][s2.length()];
    }
    public static void main(String[] args) {
        var obj = new LongestPalindromicSubsequence();
        String s1 = "abca";
        System.out.println(obj.countPalindromicSubSequence(s1,new StringBuilder(s1).reverse().toString()));
    }

}
