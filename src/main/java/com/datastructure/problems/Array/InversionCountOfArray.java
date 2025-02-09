package com.datastructure.problems.Array;

import java.util.ArrayList;
import java.util.List;

public class InversionCountOfArray {

    // This is incorrect solution, use Merge sort to count the pairs.
    // TC: O(N) + O(N) == approx O(2N)
    // SC: O(1)
    int countInversionPair(int[] nums) {
        int n = nums.length;
        int totalPairs = n * (n-1) / 2;
        int start = -1, end = -1;
        int excludePair= 0;
        int totalExcludePair = 0;
        for(int right = n-2 ; right >=0; right--) {
            if(nums[right] <= nums[right + 1]) {
               if(end == -1) end = right+1;
               else
                   excludePair++;
            }else {
                if(end != -1) {
                    if(nums[end] > nums[right])
                        excludePair++;
                    start = right;
                }
            }
            if(start != -1 && end != -1){
                int count = end - start + 1;
                totalPairs -= (count * (count - 1)/2);
                totalPairs += excludePair;
                start = -1;
                end = -1;
                excludePair = 0;
            }
        }
        if(end != -1 && start == -1) {
            start = 0;
            int count = end - start + 1;
            totalPairs -= (count * (count - 1)/2);
        }
//        if(end == -1 && start == -1)
//            return 0;
        return totalPairs;
    }
    public static void main(String[] args) {
        int[] nums = {5,3,6,4,1};
        //int[] nums = {4,3,2,1};
       // int[] nums = {1,2,3,4};
        var lt = new InversionCountOfArray();
        System.out.println(lt.countInversionPair(nums));
    }
}
