package com.datastructure.problems.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class LT560SubarraySumEqualsK {

        public int subarraySum(int[] nums, int k) {
            int count = 0, sum = 0;
            HashMap < Integer, Integer > map = new HashMap < > ();
            map.put(0, 1);
            for (int i = 0; i < nums.length; i++) {
                sum += nums[i];
                if (map.containsKey(sum - k))
                    count += map.get(sum - k);
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
            return count;
        }

    public static void main(String[] args) {
         int[] nums = {0,0}; int k = 0;
        var lt = new LT560SubarraySumEqualsK();
       System.out.println(lt.subarraySum(nums,k));

        int[] nums1 = {0,0,0,0,0,0,0,0,0,0}; int k1 = 0;
        System.out.println(lt.subarraySum(nums1,k1));

    }
}
