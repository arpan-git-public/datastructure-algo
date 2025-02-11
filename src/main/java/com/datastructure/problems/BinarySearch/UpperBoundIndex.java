package com.datastructure.problems.BinarySearch;

import java.util.Arrays;
import java.util.Comparator;

/**
 * nums[i] > n , find smallest upper bound index
 */
public class UpperBoundIndex {

    int findUpperBoundIndex(int[] nums, int target) {
        int low = 0 , high = nums.length;
        int ans = nums.length;
        while( low < high) {
            int mid = low + (high - low) / 2;
            if(nums[mid] > target) {
                ans = mid;
                high = mid -1;
            } else
                low = mid + 1;
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,4,5,6,6,7,8,10,12}; int target = 7;
        var lt = new UpperBoundIndex();
        System.out.println(lt.findUpperBoundIndex(nums, target));
    }
}
