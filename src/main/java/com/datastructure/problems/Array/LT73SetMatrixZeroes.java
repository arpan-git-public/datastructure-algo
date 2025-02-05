package com.datastructure.problems.Array;

import java.util.Arrays;

public class LT73SetMatrixZeroes {
    //Brute force approach : O (n ^ 3)two loops for matrix and anothe loop for marking row and colum as -1. Another separate loop for mark those -1 as 0.
    // Better Approach: O(n ^ 2) below:
    public void setZeroes_Better(int[][] matrix) {
        //1. create a column and row to track zeros
        //2. Mark those columns and rows of matrix as zero.
        int[] row = new int[matrix.length];
        int[] column = new int[matrix[0].length];
        int n = matrix.length;
        int m = matrix[0].length;

        //1. create a column and row to track zeros
        for(int i = 0 ; i < n ; i++) {
            for(int j = 0; j < m; j++) {
                if(matrix[i][j] == 0) {
                    row[i] = 1;
                    column[j] = 1;
                }
            }
        }

        //2. Mark those columns and rows of matrix as zero.
        for(int i = 0 ; i < n ; i++) {
            for(int j = 0; j < m ;j++) {
                if(row[i] == 1 || column[j] == 1) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    // store column and row values within matrix itself.
    //TC: O (n^2)
    // SC: O(1)
    public void setZeroes(int[][] matrix) {
        //col matrix[0][...]
        //row matrix[..][0]
        int n = matrix.length;
        int m = matrix[0].length;
        int col0 = 1;
        for(int i = 0 ; i < n; i++) {
            for(int j =0; j < m; j++) {
                if(matrix[i][j] == 0) {
                    //mark i-th row
                    matrix[i][0] = 0;
                    //mark jth col
                    if(j != 0)
                        matrix[0][j] = 0;
                    else
                        col0 = 0;
                }
            }
        }
        //mark internal matrix 0
        for(int i = 1; i < n ;i++) {
            for(int j = 1; j < m; j++) {
                if(matrix[i][0] == 0 || matrix[0][j] == 0 ) {
                    matrix[i][j] = 0;
                }
            }
        }

        // 0th row
        if(matrix[0][0] == 0){
            for(int i =0 ;i < m ;i++) {
                matrix[0][i] = 0;
            }
        }
        //0th col
        if(col0 == 0){
            for(int i =0 ;i < n ;i++) {
                matrix[i][0] = 0;
            }
        }
    }

    public static void main(String[] args) {
        //int[][] matrix = {{1,1,1},{1,0,1},{1,1,1}};
        int[][] matrix = {{0,1}};
        var lt = new LT73SetMatrixZeroes();
        lt.setZeroes(matrix);
        int n = matrix.length;
        int m = matrix[0].length;

        for(int i = 0 ; i < n ; i++) {
            System.out.println();
            for(int j = 0; j < m ;j++) {
                System.out.print( matrix[i][j] + "   ");
            }
        }
    }
}
