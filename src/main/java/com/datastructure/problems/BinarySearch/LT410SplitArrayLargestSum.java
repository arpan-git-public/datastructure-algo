package com.datastructure.problems.BinarySearch;

/**
 *  IMPORTANT : A subarray is a contiguous part of the array. Otherwise, Dynamic Programing (DP) problem.
 * Given an integer array nums and an integer k, split nums into k non-empty subarrays such that the largest sum of any subarray is minimized.
 *
 * Return the minimized largest sum of the split.
 *
 * A subarray is a contiguous part of the array.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [7,2,5,10,8], k = 2
 * Output: 18
 * Explanation: There are four ways to split nums into two subarrays.
 * The best way is to split it into [7,2,5] and [10,8], where the largest sum among the two subarrays is only 18.
 * Example 2:
 *
 * Input: nums = [1,2,3,4,5], k = 2
 * Output: 9
 * Explanation: There are four ways to split nums into two subarrays.
 * The best way is to split it into [1,2,3] and [4,5], where the largest sum among the two subarrays is only 9.
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 1000
 * 0 <= nums[i] <= 106
 * 1 <= k <= min(50, nums.length)
 */
public class LT410SplitArrayLargestSum {
    public int splitArray(int[] nums, int k) {
        //determine the range
        //calculate the no of subbarray and match with input
        int max = 0, sum = 0;
        for(int i = 0; i < nums.length ; i++) {
            max = Math.max(max, nums[i]);
            sum += nums[i];
        }
        int low = max, high = sum;
        while( low <= high) {
            int mid = (low + high) / 2;
            if(calculateSubarraySize(nums, mid) <= k) high = mid -1;
            else low = mid + 1;
        }
        return low;
    }

    int calculateSubarraySize(int[] nums, int sum) {
        int currentSum = 0, counter = 0;
        for(int i = 0 ; i < nums.length; i++) {
            currentSum += nums[i];
            if(currentSum <= sum) continue;
            else {
                counter++;
                currentSum = nums[i];
            }
        }
        if(currentSum > 0)
            counter++;
        return counter;
    }

    public static void main(String[] args) {
        int[] nums = {7,2,5,10,8};
        int k = 2;
        var lt = new LT410SplitArrayLargestSum();
        System.out.println(lt.splitArray(nums, k));
    }
}
