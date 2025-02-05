package com.datastructure.problems.Array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LT128LongestConsecutiveSequence {

    public int longestConsecutive(int[] nums) {
        //1. sort the elements
        //2. track the counter for next consecutive number if found increment.
        // If sequence is broken then assign to maxLen if it is maximum value and reset counter to zero for futher iteration.
        //3. return maximumLen variable

        int counter = 1;
        int maxLen = 1;
        if(nums.length == 0) return 0;
        if(nums.length == 1) return maxLen;
        //1. sort
        Arrays.sort(nums);

        //2. iterate to check the maxLen
        for(int i = 1 ; i < nums.length ; i++) {
            if(nums[i-1] == nums[i] - 1 ) {
                counter++;
                maxLen = Math.max(maxLen,counter);
            } else if(nums[i-1] == nums[i]){
                continue;
            }else{
                counter = 1;
            }
        }
        return maxLen;
    }

    // Using Set
    public int longestConsecutiveOptimalIfDuplicatePresents(int[] nums) {
        int n = nums.length;
        if(n==0) return 0;
        int longest = 1;
        Set<Integer> set = new HashSet<>();
        for(int i = 0 ; i< nums.length ; i ++) {  //O(N)
           set.add(nums[i]);
        }

        for(int num : nums) {  //O(N)
            if(!set.contains(num-1)) {
                int counter = 1;
                int element = num;
                while(set.contains(element + 1)) { //O(M) -> consecutive elements
                    counter++;
                    element++;
                }
                longest = Math.max(longest,counter);
            }
        }
        return longest;
    }
    public static void main(String[] args) {
        int[] nums = {1,2,0,1};
        var lt = new LT128LongestConsecutiveSequence();
       // System.out.println(lt.longestConsecutive(nums));
        System.out.println(lt.longestConsecutiveOptimalIfDuplicatePresents(nums));
    }
}
