package com.datastructure.problems.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SpiralMatrix {

    public List<Integer> spiralOrder(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int left=0, top = 0, right = col - 1, bottom = row - 1;
        List<Integer> elements = new ArrayList<>() ;
        while(left <= right && top <= bottom) {
            for(int i = left; i <= right; i++) {
                elements.add(matrix[left][i]);
            }
            top++;
            for(int i = top; i <= bottom; i++) {
                elements.add(matrix[i][right]);
            }
            right--;
            if(top <= bottom) {
                for (int i = right; i >= left; i--) {
                    elements.add(matrix[bottom][i]);
                }
                bottom--;
            }
            if(left <= right) {
                for (int i = bottom; i >= top; i--) {
                    elements.add(matrix[i][left]);
                }
                left++;
            }
        }
        return elements;
    }
    public static void main(String[] args) {
        var lt = new SpiralMatrix();
       // int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        lt.spiralOrder(matrix).forEach(System.out::println );
    }
}
