package com.datastructure.problems.BinarySearch;

/**
 * arr[i] <= n find the smallest index of an element who smaller than the given number.
 */
public class LowerBoundIndex {

    int findLowerBoundIndex(int[] nums, int target) {
        int low = 0, high = nums.length -1 ;
        int index = nums.length;
        while(low <= high) {
            int mid = low + (high - low) / 2;
           if(nums[mid] >= target) {
               index = mid;
               high = mid - 1;
           } else
               low = mid + 1;
        }
        return index;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,4,5,6,6,7,8,10,12}; int target = 6;
        var lt = new LowerBoundIndex();
        System.out.println(lt.findLowerBoundIndex(nums,target));
    }
}
