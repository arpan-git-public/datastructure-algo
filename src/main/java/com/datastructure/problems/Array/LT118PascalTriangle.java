package com.datastructure.problems.Array;

import java.util.ArrayList;
import java.util.List;

public class LT118PascalTriangle {
    // Brute Force: TC: O(n * c * r) approx n cube.
    public List<List<Integer>> generateBrute(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> rowList = new ArrayList<>();
            for (int c = 0; c <= i; c++) {
                rowList.add(calculateCombination(i, c));
            }
            result.add(rowList);
        }
        return result;
    }

    //Optimal Solution : TC O (n ^ 2)
    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> result = new ArrayList<>();
        for(int row = 1 ; row <= numRows; row++) {
            List<Integer> rowList = generateRow(row);
            result.add(rowList);
        }
        return result;
    }

    /**
     *  Generate each row
     * @param row
     * @return
     */
    private static List<Integer> generateRow(int row) {
        int ans = 1;
        List<Integer> rowList = new ArrayList<>();
        rowList.add(1);
        for(int col = 1; col < row; col++) {
            ans = ans * (row - col);
            ans = ans / col ;
            rowList.add(ans);
        }
        return rowList;
    }

    /**
     *  Use Pascal formula to determine element as particular row and column index.
     * @param row
     * @param col
     * @return
     */

    int calculateCombination(int row, int col) {
        int res = 1;
        for (int i = 0; i < col; i++) {
            res = res * (row - i);
            res = res / (i + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        var lt = new LT118PascalTriangle();
        lt.generate(5).stream().forEach(ltR -> {
            ltR.forEach(x -> System.out.print(x + " "));
            System.out.println();
        });
    }
}
