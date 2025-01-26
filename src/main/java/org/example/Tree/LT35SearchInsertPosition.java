package org.example.Tree;

/**
 * Given a sorted array of distinct integers and a target value,
 * return the index if the target is found.
 * If not, return the index where it would be if it were inserted in order.
 *
 * You must write an algorithm with O(log n) runtime complexity.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,3,5,6], target = 5
 * Output: 2
 * Example 2:
 *
 * Input: nums = [1,3,5,6], target = 2
 * Output: 1
 */
public class LT35SearchInsertPosition {

    public int searchInsert(int[] nums, int target) {
        int start = 0, end = nums.length-1, mid = 0;
        while (start <= end) {

          mid = (end + start) / 2;

            if(nums[mid] == target) return mid;
            else if(nums[mid] > target) end = mid -1;
            else start = mid + 1;
        }
        return  end+1;
    }

    public static void main(String[] args) {
        var lt = new LT35SearchInsertPosition();
       // int[] nums = {1,3,5,6};
        int[] nums = {2};
        int target = 0;
        System.out.println(lt.searchInsert(nums,target));
    }
}
