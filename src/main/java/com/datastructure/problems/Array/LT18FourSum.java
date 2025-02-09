package com.datastructure.problems.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LT18FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);
        for(int i = 0 ; i < n; i++) {
            if(i > 0 && nums[i] == nums[i-1]) continue;
            for(int j = i+1; j < n; j++) {
                if(j != i+1 && nums[j] == nums[j-1]) continue;
                int k = j+1;
                int l = n-1;

                while(k < l) {
                    long sum = nums[i];
                    sum += nums[j];
                    sum += nums[k];
                    sum += nums[l];

                    if(sum == target) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        list.add(nums[l]);
                        result.add(list);
                        k++;
                        l--;
                        while(k < l && nums[k] == nums[k-1]) k++;
                        while(k < l && nums[l] == nums[l+1]) l--;
                    } else if(sum < target) k++;
                    else l--;
                }

            }
        }
        return result;
    }
    public static void main(String[] args) {
        int[] nums = {1000000000,1000000000,1000000000,1000000000};
        int target = -294967296;
        var lt = new LT18FourSum();
        lt.fourSum(nums,target).forEach(x -> {
            x.forEach(y->System.out.print(y +  " ") );
            System.out.println();
        });
    }
}
