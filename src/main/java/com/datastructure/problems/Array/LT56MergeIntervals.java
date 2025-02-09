package com.datastructure.problems.Array;

import javax.naming.InsufficientResourcesException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals,
 * and return an array of the non-overlapping intervals that cover all the intervals in the input.
 * Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
 */
public class LT56MergeIntervals {
    //Better: TC: O(N log N) + O(2N)
    public int[][] merge_Better(int[][] intervals) {

        //sort array based on first index if same then compare against second index
        // TC: (N log N)
        Arrays.sort(intervals, ((o1, o2) -> {
            if (o1[0] == o2[0]) {
                return Integer.compare(o1[1], o2[1]);
            } else
                return Integer.compare(o1[0], o2[0]);
        }
        ));

        List<int[]> ans = new ArrayList<>();
        // TC: (2N)
        for(int i = 0; i < intervals.length; i++) {
            //check if pair is already covered
            int start = intervals[i][0];
            int end = intervals[i][1];
            if(!ans.isEmpty() && ans.get(ans.size()-1)[1] >= intervals[i][0] ) {
                continue;
            }

            for(int j = i+1 ; j < intervals.length; j++) {
               if (end >= intervals[j][0]) {
                    end = Math.max(end, intervals[j][1]);
                } else {
                   break;
                }
            }
            ans.add(new int[]{start, end});
        }
        int[][] intervalsResult = new int[ans.size()][2];
        int i = 0;
        for(int[] pair : ans){
            intervalsResult[i++] = pair;
        }

        return  intervalsResult;
    }
//  Optimal:

        public int[][] merge(int[][] intervals) {
            //sort the array
            Arrays.sort(intervals, (o1,o2)->{
                if(o1[0] == o2[0]) {
                    return Integer.compare(o1[1],o2[1]);
                } else
                    return Integer.compare(o1[0],o2[0]);
            });

            //iterate
            int start = intervals[0][0];
            int end = intervals[0][1];
            List<int[]> ans = new ArrayList<>();
            for(int i = 1; i < intervals.length; i++) {
                if(end >= intervals[i][0]) {
                    end=Math.max(end,intervals[i][1]);
                }else {
                    ans.add(new int[]{start,end});
                    start = intervals[i][0];
                    end = intervals[i][1];
                }
            }
            ans.add(new int[]{start,end});
            return  ans.toArray(new int[ans.size()][]);
        }

    public int[][] merge_clean(int[][] intervals) {
        Arrays.sort(intervals,Comparator.comparingInt(a-> a[0]));

        List<int[]> merged = new ArrayList<>();
        int[] currentInterval = intervals[0];
        merged.add(currentInterval);

        for(int[] interval : intervals) {
            if(currentInterval[1] >= interval[0]) {
                currentInterval[1] = Math.max(currentInterval[1],interval[1]);
            } else {
                currentInterval = interval;
                merged.add(currentInterval);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }
    public static void main(String[] args) {
        int[][] nums = {{1,3},{2,6},{8,10},{15,18}};
        var lt = new LT56MergeIntervals();
        Arrays.stream(lt.merge(nums)).forEach(
                x-> {
                    Arrays.stream(x).forEach(y -> System.out.print(y + " "));
                    System.out.println();
                }
        );
    }
}
