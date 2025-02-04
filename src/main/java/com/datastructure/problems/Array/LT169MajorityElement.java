package com.datastructure.problems.Array;

import java.util.HashMap;
import java.util.Map;

/**
 * ALGORITHM : Moore Voting Algorithm
 * Given an array nums of size n, return the majority element.
 *
 * The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [3,2,3]
 * Output: 3
 */
public class LT169MajorityElement {
    //Brute force : two loop and keep counter. check counter if greater than N/2.
    // TC: O(N * N)
    // Better : Hashing
    //TC: O(2N)
    //SC : O(N)
    public int majorityElementBetter(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap();
        int maxElement = 0;
        int maxOccurance = 0;
        for(Integer num : nums) {
            if(map.containsKey(num))
                map.put(num,map.get(num)+1);
            map.putIfAbsent(num,1);
        }
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            if(entry.getValue() > maxOccurance) {
                maxOccurance = entry.getValue();
                maxElement = entry.getKey();
            }
        }
        return maxElement;
    }
    //Optimal: Moore voting algorithm
    // TC: O(N)
    //SC: o(1)
    public int majorityElement(int[] nums) {
        int element = 0;
        int count = 0;

        for(int i = 0; i < nums.length; i++) {
            if(count == 0) {
                element = nums[i];
                count++;
            } else if(nums[i] == element)
                count++;
            else {
                   count--;
            }
        }
        return element;
    }

    public static void main(String[] args) {
        int[] nums = {3,2,3};
        var lt = new LT169MajorityElement();
        System.out.println(lt.majorityElement(nums));
    }
}
