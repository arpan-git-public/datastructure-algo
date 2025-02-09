package com.datastructure.problems.Array;


public class LT152MaximumProductSubarray {

    public int maxProduct(int[] nums) {
        int prefix = 1, suffix = 1;
        int n= nums.length;
        int maxProduct = Integer.MIN_VALUE;
        for(int i =0; i< n; i++) {
            if(prefix == 0) prefix = 1;
            if(suffix == 0) suffix = 1;
            prefix *= nums[i];
            suffix *= nums[n-i-1];
            maxProduct = Math.max(maxProduct,Math.max(prefix,suffix));
        }
        return maxProduct;
    }

    public static void main(String[] args) {
        int[] nums = {2,3,-2,4};
        var lt = new LT152MaximumProductSubarray();
        System.out.println(lt.maxProduct(nums));

    }
}
