package com.datastructure.problems.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an integer array nums and an integer k, return the maximum length of a
 * subarray
 *  that sums to k. If there is not one, return 0 instead.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,5,-2,3], k = 3
 * Output: 4
 * Explanation: The subarray [1, -1, 5, -2] sums to 3 and is the longest.
 */
public class LT325MaximumSizeSubarraySumEqualsK {
    //create all sub-arrays using i to j and sum each individual array. If sum matches then calculate matching index.
    //o(N3)
    public int maxSubArrayLenBruteForce(int[] nums, int k) {
        int len = 0;
        for(int i = 0 ; i < nums.length ; i++) {
            for(int j = i ; j < nums.length ; j++) {
                int sum = 0;
                for(int z = i ; z <= j; z++) {
                    sum += nums[z];
                }
                    if(sum == k)
                        len =  Math.max(len,j-i+1);

            }
        }
        return len;
    }

    //O(n2)
    public int maxSubArrayLenBruteForceNSquare(int[] nums, int k) {
        int len = 0;
        for(int i = 0 ; i < nums.length ; i++) {
            int sum = 0;

            for(int j = i ; j < nums.length ; j++) {
                sum += nums[j];
                if(sum == k)
                    len =  Math.max(len,j-i+1);
                }
        }
        return len;
    }


//  Better solution: hashing - Use HashMap to track the elements sum and position
    public int maxSubArrayLenUsingHashing(int[] nums, int k) {
            Map<Long,Integer> map = new HashMap<>();
            long sum = 0;
            int maxLen = 0 ;

            for(int i = 0 ; i < nums.length; i++) {
                sum += nums[i];
                if(sum == k){
                    map.put(sum,i);
                    maxLen = Math.max(maxLen,i+1);
                }
                long rem = sum - k;
                if(map.containsKey(rem)) {
                    maxLen = Math.max(maxLen,i- map.get(rem));
                }

                if(!map.containsKey(sum))
                    map.put(sum,i);
            }
            return maxLen;
    }
    //This sliding window approach works for positive numbers only.
    //Optimal approach: Sliding window, move left and right pointers by checking sum of inclusive elements.
    public int maxSubArrayLen(int[] nums, int k) {
        int left = 0 , right = 0;
        int sum = nums[0];
        int n = nums.length;
        int maxLen = 0;

        while(right < n) {
            while(left <= right && sum > k) {
                sum -= nums[left];
                left++;
            }
            if(sum == k)
                maxLen = Math.max(maxLen,right-left+1);
            right++;
            if(right < n) sum += nums[right];
        }
        return maxLen;
    }
    public static void main(String[] args) {
        int[] nums = {1,2,3};
      //  int[] nums = {1,-1,5,-2,3};
        var lt = new LT325MaximumSizeSubarraySumEqualsK();
       // System.out.println(lt.maxSubArrayLenBruteForce(nums,3));
       // System.out.println(lt.maxSubArrayLenBruteForceNSquare(nums,3));
    //    System.out.println(lt.maxSubArrayLenUsingHashing(nums,3));
        System.out.println(lt.maxSubArrayLen(nums,3));

    }

}
