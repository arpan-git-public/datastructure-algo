package com.datastructure.problems.BinarySearch;

public class LT153FindMinimumInRotatedSortedArray {
    public int findMin(int[] nums) {
        int low = 0, high = nums.length;
        while(low <= high) {
            int mid = low + (high - low)/2;
            if(nums[mid] > nums[nums.length-1]) low = mid + 1;
            else
                high = mid - 1;
        }
        return nums[low];
    }

    public static void main(String[] args) {

    }
}
