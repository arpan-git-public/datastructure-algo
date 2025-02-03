package org.example.Array;

/**
 * Given a binary array nums, return the maximum number of consecutive 1's in the array.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,1,0,1,1,1]
 * Output: 3
 * Explanation: The first two digits or the last three digits are consecutive 1s. The maximum number of consecutive 1s is 3.
 */
public class LT485MaxConsecutiveOnes {

    // increment count for each consecutive ones and reset to zero when dis-continue. Also, assign counter value if max is lower than counter.
    public int findMaxConsecutiveOnes(int[] nums) {
        int count = 0 , max = 0;
        for(int num : nums) {
            if(num == 1)
                count++;
            else {
                count = 0;
                max = Math.max(max, count);
            }

        }
        return Math.max(max, count);
    }
    public static void main(String[] args) {
        int[] nums = {1,1,0,1,1,1};
        var lt = new LT485MaxConsecutiveOnes();
        System.out.println(lt.findMaxConsecutiveOnes(nums));
    }
}
