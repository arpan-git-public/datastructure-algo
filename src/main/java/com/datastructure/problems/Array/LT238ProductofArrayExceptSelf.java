package com.datastructure.problems.Array;

import java.util.Arrays;

/**
 * Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].
 *
 * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 *
 * You must write an algorithm that runs in O(n) time and without using the division operation.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,3,4]
 * Output: [24,12,8,6]
 * Example 2:
 *
 * Input: nums = [-1,1,0,-3,3]
 * Output: [0,0,9,0,0]
 *
 *
 * Constraints:
 *
 * 2 <= nums.length <= 105
 * -30 <= nums[i] <= 30
 * The input is generated such that answer[i] is guaranteed to fit in a 32-bit integer.
 *
 *
 * Follow up: Can you solve the problem in O(1) extra space complexity? (The output array does not count as extra space for space complexity analysis.)
 */
public class LT238ProductofArrayExceptSelf {

    public int[] productExceptSelf(int[] nums) {

        //left product of nums
        int[] left = new int[nums.length];
        left[0] = 1;
        for(int i = 1 ; i < nums.length; i++) {
            left[i] = left[i-1] * nums[i-1];
        }
        //right product of nums
        int[] right = new int[nums.length];
        right[nums.length - 1] = 1;
        for(int i = nums.length - 2; i >= 0; i--) {
            right[i] = right[i+1] * nums[i+1];
        }

        // left * right
        int[] result = new int[nums.length];
        for(int i = 0 ; i < nums.length; i++) {
            result[i] = left[i] * right[i];
        }

        return result;
    }

    public static void main(String[] args) {
        var obj = new LT238ProductofArrayExceptSelf();
        int[] arr = {1,2,3,4};
        int[] result = obj.productExceptSelf(arr);
        Arrays.stream(result).forEach(x -> System.out.print(x + "  "));
    }
}
