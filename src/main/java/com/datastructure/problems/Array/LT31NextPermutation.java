package com.datastructure.problems.Array;

import java.util.Arrays;

/**
 * A permutation of an array of integers is an arrangement of its members into a sequence or linear order.
 *
 * For example, for arr = [1,2,3], the following are all the permutations of arr: [1,2,3], [1,3,2], [2, 1, 3], [2, 3, 1], [3,1,2], [3,2,1].
 * The next permutation of an array of integers is the next lexicographically greater permutation of its integer. More formally, if all the permutations of the array are sorted in one container according to their lexicographical order, then the next permutation of that array is the permutation that follows it in the sorted container. If such arrangement is not possible, the array must be rearranged as the lowest possible order (i.e., sorted in ascending order).
 *
 * For example, the next permutation of arr = [1,2,3] is [1,3,2].
 * Similarly, the next permutation of arr = [2,3,1] is [3,1,2].
 * While the next permutation of arr = [3,2,1] is [1,2,3] because [3,2,1] does not have a lexicographical larger rearrangement.
 * Given an array of integers nums, find the next permutation of nums.
 *
 * The replacement must be in place and use only constant extra memory.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,3]
 * Output: [1,3,2]
 * Example 2:
 *
 * Input: nums = [3,2,1]
 * Output: [1,2,3]
 * Example 3:
 *
 * Input: nums = [1,1,5]
 * Output: [1,5,1]
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 100
 */
public class LT31NextPermutation {
    public void nextPermutation(int[] nums) {
        // Intuition:
        // 12540 -> 14  520 -> sort 520 in ascending. -> 14 250
        //1. find longer prefix match index : a[i] < a[i+1]  if not found then fall to edge case
        //2. find the smallest greater element than break point element. and swap it
        //3. sort remaining elements in ascending order

        //4. Edge case: just reverse the lexicological order of number. 321 -> 123

        int index = -1;
        int n = nums.length;
        //1. find longer prefix match index: a[i] < a[i+1]
        for(int i = n-2; i >= 0 ; i--) {
            if(nums[i] < nums[i+1]) {
                index = i;
                break;
            }
        }
        //4. Edgecase:
        if(index == -1)
            reverse(nums);
        else {
            //2. find the smallest greater element than index element and swap it
            for (int i = n - 1; i > index; i--) {
                if (nums[i] > nums[index]) {
                    int temp = nums[index];
                    nums[index] = nums[i];
                    nums[i] = temp;
                    break;
                }
            }
            //3. sort the sub array from index+1
            Arrays.sort(nums, index + 1, n );

        }
    }

    void reverse(int[] nums) {
        int i = 0, j = nums.length - 1;
        while(i < j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }
    public static void main(String[] args) {
        //int[] nums = {1,2};
        int[] nums = {1,3,2};
        var lt = new LT31NextPermutation();
        lt.nextPermutation(nums);
        Arrays.stream(nums).forEach(System.out::println);


    }
}
