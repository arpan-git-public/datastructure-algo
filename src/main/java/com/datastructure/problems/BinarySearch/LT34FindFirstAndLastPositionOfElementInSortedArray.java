package com.datastructure.problems.BinarySearch;

import java.util.Arrays;

/**
 * Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.
 *
 * If target is not found in the array, return [-1, -1].
 *
 * You must write an algorithm with O(log n) runtime complexity.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 * Example 2:
 *
 * Input: nums = [5,7,7,8,8,10], target = 6
 * Output: [-1,-1]
 * Example 3:
 *
 * Input: nums = [], target = 0
 * Output: [-1,-1]
 *
 *
 * Constraints:
 *
 * 0 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 * nums is a non-decreasing array.
 * -109 <= target <= 109
 */
public class LT34FindFirstAndLastPositionOfElementInSortedArray {
    public int[] searchRange(int[] nums, int target) {
        //1. find Last Position (Floor)
        //2. find First Position (ceil)

        int last = findLastPosition(nums, target);
        int first = findFirstPosition(nums, target);

        return new int[] {first, last};
    }
    int findLastPosition(int[] nums, int target) {
        int low = 0 , high = nums.length-1;
        int ans = -1;
        if(nums.length == 0) {return ans;}
        else if(nums.length == 1) {
            if (nums[0] == target) return 0;
            else return ans;
        }
        else {
            while (low <= high) {
                int mid = low + (high - low) / 2;
                if (nums[mid] == target) {
                    ans = mid;
                    low = mid + 1;
                } else if (nums[mid] < target) low = mid + 1;
                else
                    high = mid - 1;
            }
        }
        return ans;
    }
    int findFirstPosition(int[] nums, int target) {
        int low = 0 , high = nums.length-1;
        int ans = -1;
        if(nums.length == 0) {return ans;}
        else if(nums.length == 1) {
            if (nums[0] == target) return 0;
            else return ans;
        }
        else {
            while (low <= high) {
                int mid = low + (high - low) / 2;
                if (nums[mid] == target) {
                    ans = mid;
                    high = mid - 1;
                } else if (nums[mid] < target) low = mid + 1;
                else
                    high = mid - 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        //int[] nums = {5,7,7,8,8,10};
        int[] nums = {2,2};
        var lt = new LT34FindFirstAndLastPositionOfElementInSortedArray();
        Arrays.stream(lt.searchRange(nums, 3)).forEach(x -> System.out.print(x + " "));
    }
}
