package com.datastructure.problems.Array;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.
 *
 * Example 1:
 *
 * Input: nums = [3,2,3]
 * Output: [3]
 */
public class LT229MajorityElementII {
    public List<Integer> majorityElement(int[] nums) {
        int count1 = 0, count2 = 0;
        int element1 = 0, element2 = 0;
        int n = nums.length;
        List<Integer> majorElements = new ArrayList<>();
        for(int i =0 ;i < n; i++) {
            if(count1 == 0 && element2 != nums[i]) {
                element1 = nums[i];
                count1++;
            } else if(count2 == 0 && element1 != nums[i]) {
                element2 = nums[i];
                count2++;
            } else if(element1 == nums[i])
                count1++;
            else if(element2 == nums[i])
                count2++;
            else {
                count1--;
                count2--;
            }
        }
        int counter1 = 0;
        for(int i = 0 ; i < n ; i++) {
            if(element1 == nums[i])
                counter1++;
        }
        int counter2 = 0;
        for(int i = 0 ; i < n ; i++) {
            if(element2 == nums[i])
                counter2++;
        }

        if(counter1 > Math.floor(nums.length / 3)) {
            majorElements.add(element1);
        }
        if(counter2 > Math.floor(nums.length / 3) && element1 != element2) {
            majorElements.add(element2);
        }
        return majorElements;
    }

    public static void main(String[] args) {
        var lt = new LT229MajorityElementII();
        int[] nums = {3,2,3};
        lt.majorityElement(nums).forEach(System.out::println);
    }
}
