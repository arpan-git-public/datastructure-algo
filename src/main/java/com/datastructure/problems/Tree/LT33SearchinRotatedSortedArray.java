package com.datastructure.problems.Tree;

/**
 * There is an integer array nums sorted in ascending order (with distinct values).
 *
 * Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k (1 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].
 *
 * Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.
 *
 * You must write an algorithm with O(log n) runtime complexity.
 *
 *Example 1:
 *
 * Input: nums = [4,5,6,7,0,1,2], target = 0
 * Output: 4
 * Example 2:
 *
 * Input: nums = [4,5,6,7,0,1,2], target = 3
 * Output: -1
 * Example 3:
 *
 * Input: nums = [1], target = 0
 * Output: -1
 *
 */
public class LT33SearchinRotatedSortedArray {

    public int search(int[] nums, int target) {
        int left = 0, right = nums.length -1, mid = 0;

        while(left <= right) {
            mid = left + (right - left) / 2;
            //find the pivot (smallest element)
           if(nums[mid] > nums[nums.length - 1])
               left = mid + 1;
            else
                right = mid - 1;
        }
        // 0 to pivot binary search
        int ans = binarySearch(nums, 0,left,target);
        if( ans != -1) return ans;

        //pivot to right binary search
      return   binarySearch(nums,left+1,nums.length -1,target);

    }


    int binarySearch(int[] nums, int leftBoundary, int rightBoundary, int target) {
        int left = leftBoundary, right =rightBoundary;

        while(left <= right) {
            int mid = left + (right-left)/2;
            if(nums[mid] == target) return mid;
            else if(nums[mid] > target)
                right = mid - 1;
            else
                left = mid + 1;
        }
        return -1;
    }
    public static void main(String[] args) {
        var lt = new LT33SearchinRotatedSortedArray();
        int nums[] = {5,1,3};//{4,5,6,7,0,1,2,3};
        int target = 5;
        System.out.println(lt.search(nums, target));
    }
}
