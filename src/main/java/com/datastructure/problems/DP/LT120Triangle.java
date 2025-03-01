package com.datastructure.problems.DP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LT120Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size();
        int n = triangle.get(m-1).size();
        int minSum = Integer.MAX_VALUE;
        for(int i = 0 ; i < n; i++)
            minSum = Math.min(minSum,countMinSumOfTriangle(m-1,i,triangle));
        return minSum;
    }

    private int countMinSumOfTriangle(int m, int n, List<List<Integer>> triangle) {
        if(m == 0 && n == 0) return triangle.get(m).get(n);
        if(m < 0 || n < 0 || n > m) return Integer.MAX_VALUE;

        int up = countMinSumOfTriangle(m-1,n,triangle);
        int diagonal = countMinSumOfTriangle(m-1,n-1,triangle);
        int left = countMinSumOfTriangle(m,n-1,triangle);


        return triangle.get(m).get(n) + Math.min(up,Math.min(diagonal,left));
    }


    public int minimumTotalRecMemo(List<List<Integer>> triangle) {
        int m = triangle.size();
        int n = triangle.get(m-1).size();
        int minSum = Integer.MAX_VALUE;
        List<List<Integer>> memo = new ArrayList<>();
        for(int i = 0; i < m ;i++) {
            memo.add(new ArrayList<>());
        }
        for(int i = 0 ; i < n; i++)
            minSum = Math.min(minSum,countMinSumOfTriangleRecMemo(m-1,i,triangle, memo));
        return minSum;
    }

    private int countMinSumOfTriangleRecMemo(int m, int n, List<List<Integer>> triangle,List<List<Integer>> memo) {
        if(m == 0 && n == 0) return triangle.get(m).get(n);
        if(m < 0 || n < 0 || n > m) return Integer.MAX_VALUE;
        if(!memo.get(m).isEmpty()) return memo.get(m).get(n);
        int up = countMinSumOfTriangleRecMemo(m-1,n,triangle, memo);
        int diagonal = countMinSumOfTriangleRecMemo(m-1,n-1,triangle, memo);
        int left = countMinSumOfTriangleRecMemo(m,n-1,triangle, memo);
        int sum  = triangle.get(m).get(n) + Math.min(up,Math.min(diagonal,left));
        if(!memo.get(m).isEmpty()) {
            memo.get(m).add(sum);
        }
        return sum;
    }


    public int minimumTotalDP(List<List<Integer>> triangle) {
       int m = triangle.size();
       int n = triangle.get(m-1).size();
        int[][] dp = new int[m][n];
       for(int i = 0; i < n; i++) {
           dp[m-1][i] = triangle.get(m-1).get(i);
       }

       for(int i = m-2; i >= 0 ; i--) {
           for(int j = 0 ; j <= i  ; j++) {
               dp[i][j] = triangle.get(i).get(j) + Math.min(dp[i+1][j], dp[i+1][j+1]);
           }

       }
       return dp[0][0];
    }


    public static void main(String[] args) {
        var lt = new LT120Triangle();

        int[][] triangleArr = {{2},{3,4},{6,5,7},{4,1,8,3}};
        List<List<Integer>>  triangle = Arrays.stream(triangleArr).map(row -> Arrays.stream(row).boxed().toList()).toList();
        System.out.println(lt.minimumTotal(triangle));
        System.out.println(lt.minimumTotalRecMemo(triangle));
        System.out.println(lt.minimumTotalDP(triangle));

    }
}
