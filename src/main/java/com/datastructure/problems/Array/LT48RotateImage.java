package com.datastructure.problems.Array;

public class LT48RotateImage {
    /**
     * You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).
     *
     * You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.
     *
     * Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
     * Output: [[7,4,1],[8,5,2],[9,6,3]]
     * @param matrix
     */
    public void rotate(int[][] matrix) {
        // Transpose: Diagonal stay as is and col become row value (swap it).
        int n = matrix.length; // row
        int m = matrix[0].length; // col
        for (int i = 0; i <= n - 2; i++) {
            for (int j = i + 1; j <= n - 1; j++) {

                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        // reverse the rows
        for (int i = 0; i < n; i++) {
            reverse(matrix[i]);
        }
    }

    void reverse(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        var lt = new LT48RotateImage();
        lt.rotate(matrix);
        int n = matrix.length; // row
        int m = matrix[0].length; // col
        for (int i = 0; i < n; i++) {
            System.out.println();
            for (int j = 0; j < m; j++) {
                System.out.print(matrix[i][j] + "   ");
            }
        }
    }
}
