package com.datastructure.problems.Array;

public class LT53MaximumSubarray {
    /**
     * ALGORITHM : KADEN's ALGORITHM
     * Given an integer array nums, find the
     * subarray
     *  with the largest sum, and return its sum.
     *
     * Example 1:
     *
     * Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
     * Output: 6
     * Explanation: The subarray [4,-1,2,1] has the largest sum 6.
     */
    //TC : O(N)
    //SC : O(1)
    public int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int minusHighestSum = Integer.MIN_VALUE;
        int sum = 0;
        for(int i =0 ; i < nums.length; i++) {
            sum += nums[i];
            if(sum < 0) {
                minusHighestSum = Math.max(minusHighestSum,sum);
                sum = 0;
            }
            else {
                maxSum = Math.max(maxSum,sum);
            }
        }
        return Math.max(maxSum,minusHighestSum);
    }

    public static void main(String[] args) {
        //int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        int[] nums = {-1,-2};
        var lt = new LT53MaximumSubarray();
        System.out.println(lt.maxSubArray(nums));
    }

}
