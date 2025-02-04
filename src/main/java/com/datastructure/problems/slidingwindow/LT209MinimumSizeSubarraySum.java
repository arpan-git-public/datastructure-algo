package com.datastructure.problems.slidingwindow;

public class LT209MinimumSizeSubarraySum {

    public static void main(String[] args) {
        int[] nums = {2,3,1,2,4,3};int target = 7;

     //   int[] nums = {1,4,4}; int target = 4;
       // int nums[] = {1,1,1,1,1,1,1,1};int target = 11;
        //int nums[] = {1,2,3,4,5}; int target = 11;
        var lt = new LT209MinimumSizeSubarraySum();
        System.out.println(lt.minSubArrayLen(target,nums));
    }
    public int minSubArrayLen(int target, int[] nums) {
        int window = Integer.MAX_VALUE, sum = 0;
        int i = 0, j = 0;
        while(j < nums.length && i < nums.length) {
            sum = sum + nums[j];
            if(target > sum && j < nums.length) {
                j++;
            } else {
                window = Math.min(window,j - i + 1);
                while(target < sum) {
                    sum = sum - nums[j];
                    j--;
                }
                sum = sum - nums[i];
                i++;
                if(j < nums.length)
                    j++;
            }

        }
        return window == Integer.MAX_VALUE ? 0 : window;
    }

//    public int minSubArrayLen(int target, int[] nums) {
//        int minLen = Integer.MAX_VALUE;
//        int left = 0;
//        int curSum = 0;
//
//        for (int right = 0; right < nums.length; right++) {
//            curSum += nums[right];
//
//            while (curSum >= target) {
//                if (right - left + 1 < minLen) {
//                    minLen = right - left + 1;
//                }
//                curSum -= nums[left];
//                left++;
//            }
//        }
//
//        return minLen != Integer.MAX_VALUE ? minLen : 0;
//    }
}
