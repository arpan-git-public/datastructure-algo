package com.datastructure.problems.Array;

import java.util.Arrays;

/**
 * Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 *
 * Note that you must do this in-place without making a copy of the array.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 */
public class LT283MovesZeroToRight {

    void moveToRight(int[] nums) {
        int i = 0, j = -1;

        //step 1: identify first zero
        while( i < nums.length) {
            if(nums[i] == 0) {
                j = i;
                break;
            }
            i++;
        }

        //step 2: iterate through all remaining elements from pivot and shuffle zero to right side.
        i = j + 1;
        while ( i < nums.length) {
            if(nums[i] != 0) {
                nums[j] = nums[i];
                nums[i] = 0;
                j++;
            }
            i++;
        }
    }

    public static void main(String[] args) {
        var lt = new LT283MovesZeroToRight();
        int nums[] = {4,4,0,1};
        lt.moveToRight(nums);
        Arrays.stream(nums).forEach(System.out::println);
    }
}
