package com.datastructure.problems.BinarySearch;

public class LT704BinarySearch {
    public int search(int[] nums, int target) {
        int low = 0 , high = nums.length - 1;

        while(low <= high) {
            int mid = low + (high-low)/2;
            if(nums[mid] == target) return mid;
            else if(nums[mid] < target) low = mid + 1;
            else high = mid - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {-2,-1,-1,-1,1,2,3,4,5,6,7,8,9};
        int target = 6;
        var lt = new LT704BinarySearch();
        System.out.println(lt.search(nums, target));
    }
}
