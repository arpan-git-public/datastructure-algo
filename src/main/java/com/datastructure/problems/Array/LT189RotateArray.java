package com.datastructure.problems.Array;

import java.util.Arrays;

/**
 * Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,3,4,5,6,7], k = 3
 * Output: [5,6,7,1,2,3,4]
 * Explanation:
 * rotate 1 steps to the right: [7,1,2,3,4,5,6]
 * rotate 2 steps to the right: [6,7,1,2,3,4,5]
 * rotate 3 steps to the right: [5,6,7,1,2,3,4]
 */
public class LT189RotateArray {

    public void rotate(int[] nums, int k) {

        //Approach : 1
//        int rotation = k % nums.length;
//        while(rotation > 0) {
//            int temp = nums[nums.length-1];
//            for(int i = nums.length - 2; i >=0; i--) {
//                nums[i+1] = nums[i];
//            }
//            nums[0] = temp;
//            rotation--;
//        }

        // Approach 2
//        k = k % nums.length;
//        //store k elements
//        int[] temp = new int[k];
//        for(int i = 0 ; i < k ; i++) {
//            temp[i] = nums[nums.length-k+i];
//        }
//
//        //start rotation
//        for(int i = nums.length-k-1 ; i >=0  ; i--) {
//            nums[i+k] = nums[i];
//        }
//
//        for(int i = 0 ; i < k  ; i++) {
//            nums[i] = temp[i];
//        }

        //Approach 3

   k = k % nums.length;

   reverse(nums,0,nums.length-k-1);
   reverse(nums,nums.length-k,nums.length-1);
   reverse(nums,0,nums.length-1);
    }

    private void reverse(int[] nums, int start , int end) {
        int temp = 0;
        while(start < end) {
            temp = nums[end];
            nums[end] = nums[start];
            nums[start] = temp;
            start++;
            end--;
        }
    }


    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7}; int k = 3;
        var lt = new LT189RotateArray();
        lt.rotate(nums,k);
        Arrays.stream(nums).forEach(System.out::println);
    }
}
