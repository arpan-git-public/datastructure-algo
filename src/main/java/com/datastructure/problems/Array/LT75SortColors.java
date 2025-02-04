package com.datastructure.problems.Array;


import java.util.Arrays;

/**
 * ALGORITHM : Dutch National Algorithm
 * Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.
 *
 * We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
 *
 * You must solve this problem without using the library's sort function.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [2,0,2,1,1,0]
 * Output: [0,0,1,1,2,2]
 */
public class LT75SortColors {

    public void sortColors(int[] nums) {
        int low= 0, mid = 0, high = nums.length - 1;

        while(mid <= high) {
            if(nums[mid] == 0) {
                swap(nums,low, mid);
                mid++;
                low++;
            } else if (nums[mid] == 1) {
                mid++;
            } else {
                swap(nums,mid, high);
                high--;
            }
        }

    }

    private void swap(int[] nums, int x, int y ) {
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }
    public static void main(String[] args) {
        var lt = new LT75SortColors();
        int nums [] = {2,0,1};
        lt.sortColors(nums);
        Arrays.stream(nums).forEach(System.out::println);
    }

}
