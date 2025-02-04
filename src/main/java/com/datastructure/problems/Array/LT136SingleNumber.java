package com.datastructure.problems.Array;

/**
 * Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
 *
 * You must implement a solution with a linear runtime complexity and use only constant extra space.
 */
public class LT136SingleNumber {

    public int singleNumber(int[] nums) {
        int xor = 0;
        for(int i = 0 ; i < nums.length ; i ++ ) {
            xor ^= nums[i];
        }
        return xor;
    }

    public static void main(String[] args) {
        int[] nums = {2,2,1};
        var lt = new LT136SingleNumber();
        System.out.println(lt.singleNumber(nums));
    }
}
