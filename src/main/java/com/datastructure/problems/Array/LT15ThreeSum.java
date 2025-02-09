package com.datastructure.problems.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LT15ThreeSum {
    //TC: O(n logn) for sorting + O(n * m)
    // 3 pointers approach: i, j (i+1) ,k (size of array - 1)
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        for(int i = 0 ; i < n;i++) {
            if( i > 0 && nums[i] == nums[i-1]) continue;
            if(nums[i]>0)break;
            int j = i+1;
            int k = n-1;

            while(j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if(sum > 0) {
                    k--;
                } else if(sum < 0) {
                    j++;
                } else {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    result.add(list);
                    j++;
                    k--;
                    while(j < k && nums[j] == nums[j-1]) j++;
                    while(j < k && nums[k] == nums[k+1]) k--;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        var lt = new LT15ThreeSum();
        lt.threeSum(nums).forEach(x-> {
            x.forEach(y-> System.out.print(y + " "));
            System.out.println();
        });
    }
}
