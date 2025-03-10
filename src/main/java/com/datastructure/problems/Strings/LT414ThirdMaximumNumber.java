package com.datastructure.problems.Strings;

public class  LT414ThirdMaximumNumber {

    /**
     * Given an integer array nums, return the third distinct maximum number in this array.
     * If the third maximum does not exist, return the maximum number.
     *
     * Example 1:
     *
     * Input: nums = [3,2,1]
     * Output: 1
     * Explanation:
     * The first distinct maximum is 3.
     * The second distinct maximum is 2.
     * The third distinct maximum is 1.
     * Example 2:
     *
     * Input: nums = [1,2]
     * Output: 2
     * Explanation:
     * The first distinct maximum is 2.
     * The second distinct maximum is 1.
     * The third distinct maximum does not exist, so the maximum (2) is returned instead.
     * Example 3:
     *
     * Input: nums = [2,2,3,1]
     * Output: 1
     * Explanation:
     * The first distinct maximum is 3.
     * The second distinct maximum is 2 (both 2's are counted together since they have the same value).
     * The third distinct maximum is 1.
     *
     *
     * Constraints:
     *
     * 1 <= nums.length <= 104
     * -231 <= nums[i] <= 231 - 1
     *
     *
     * Follow up: Can you find an O(n) solution?
     */

    public int thirdMax(int[] nums) {
        //no element return 0;
        long first = Long.MIN_VALUE ,second = Long.MIN_VALUE, third = Long.MIN_VALUE;

        for(int num : nums) {
            if(first == num || second == num || third == num)
                continue;


          if( num > first) {
              third = second;
              second = first;
              first = num;
          } else if( num > second) {
              third = second;
              second = num;
          } else if( num > third) {
              third = num;
          }
        }

        if(third != Long.MIN_VALUE) return (int)third;
        else return (int)first;

    }

    public static void main(String[] args) {
        int[] arrays = {1,2,-2147483648};
        var lt = new LT414ThirdMaximumNumber();
        System.out.println(lt.thirdMax(arrays));

    }

}
