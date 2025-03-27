package com.datastructure.problems.Array;

import java.util.*;

/**
 * You are given a circular array nums and an array queries.
 *
 * For each query i, you have to find the following:
 *
 * The minimum distance between the element at index queries[i] and any other index j in the circular array, where nums[j] == nums[queries[i]]. If no such index exists, the answer for that query should be -1.
 * Return an array answer of the same size as queries, where answer[i] represents the result for query i.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,3,1,4,1,3,2], queries = [0,3,5]
 *
 * Output: [2,-1,3]
 *
 * Explanation:
 *
 * Query 0: The element at queries[0] = 0 is nums[0] = 1. The nearest index with the same value is 2, and the distance between them is 2.
 * Query 1: The element at queries[1] = 3 is nums[3] = 4. No other index contains 4, so the result is -1.
 * Query 2: The element at queries[2] = 5 is nums[5] = 3. The nearest index with the same value is 1, and the distance between them is 3 (following the circular path: 5 -> 6 -> 0 -> 1).
 * Example 2:
 *
 * Input: nums = [1,2,3,4], queries = [0,1,2,3]
 *
 * Output: [-1,-1,-1,-1]
 *
 * Explanation:
 *
 * Each value in nums is unique, so no index shares the same value as the queried element. This results in -1 for all queries.
 *
 *
 *
 * Constraints:
 *
 * 1 <= queries.length <= nums.length <= 105
 * 1 <= nums[i] <= 106
 * 0 <= queries[i] < nums.length
 */
public class CircularQueries {

    public int[] minCircularDistance(int[] nums, int[] queries) {
        Map<Integer, TreeSet<Integer>> map = new HashMap<>();
        int n = nums.length;
        //1. precompute the indices of number
        for(int i = 0; i < n;i ++) {
            map.computeIfAbsent(nums[i],k->new TreeSet<>()).add(i);
        }

        int[] result = new int[queries.length];
        for(int i = 0 ; i < queries.length; i++) {
            int queryIndex = queries[i];
            TreeSet<Integer> indices = map.get(nums[queryIndex]);
            if( indices.size() == 1) result[i] = -1;
            else {
                Integer higher = indices.higher(queryIndex);
                Integer lower = indices.lower(queryIndex);

                int minDistance = Integer.MAX_VALUE;
                if(higher != null && higher != queryIndex) {
                    minDistance = Math.min(minDistance,higher - queryIndex);
                }
                if(lower != null && lower != queryIndex) {
                    minDistance = Math.min(minDistance,queryIndex - lower);
                }

                int firstIndex = indices.first();
                int lastIndex = indices.last();

                int circularDist = Math.min(n-Math.abs(queryIndex-firstIndex), n - Math.abs(lastIndex-queryIndex));

                result[i] = Math.min(minDistance,circularDist);
            }

        }
        return result;
    }


    //Optimal approach:
    // Algorithm consists two sweeps:
    //1. Left to Right Pass: Compute distances considering forward neighbors.
    //2. Right to left Pass: Compute distances considering backward neighbors.
    //3. Final Processing: Answer based on computed minimum distances.

    public List<Integer> minCircularDistanceOptimal(int[] nums, int[] queries) {
        Map<Integer,Integer> leftMap = new HashMap<>();
        Map<Integer,Integer> rightMap = new HashMap<>();
        List<Integer> dist = new ArrayList<>();
        List<Integer> result  = new ArrayList<>();
        int n = nums.length;
        // Left to Right Pass: forward processing
        for(int i = 0 ; i < nums.length*2; i++) {
            if(i < n) dist.add(n+1);
            int currInd = i%n;
            if(leftMap.containsKey(nums[currInd])) {
                dist.set(currInd,Math.min(dist.get(currInd),i - leftMap.get(nums[currInd])));
            }
            leftMap.put(nums[i%n],i);
        }

        //Right to Left Pass: backward Processing
        for(int j = n*2 - 1; j >= 0; j--) {
            int currInd = j % n;
            if (rightMap.containsKey(nums[currInd])) {
                dist.set(currInd, Math.min(dist.get(currInd), rightMap.get(nums[currInd]) - j));
            }
            rightMap.put(nums[currInd], j);

        }

        // prepare final result
        for(int q : queries) {
            result.add(dist.get(q) >= nums.length  ? -1 : dist.get(q));
        }
        return result;
    }


    public static void main(String[] args) {
        var obj = new CircularQueries();
        int[] nums = {1,3,1,4,1,3,2}, queries = {0,3,5};
        int[] result = obj.minCircularDistance(nums,queries);
        Arrays.stream(result).forEach(x -> System.out.print(x + " "));
        System.out.println();

        List<Integer> ansList = obj.minCircularDistanceOptimal(nums,queries);
        ansList.stream().forEach(x -> System.out.print(x + "  "));
    }
}
