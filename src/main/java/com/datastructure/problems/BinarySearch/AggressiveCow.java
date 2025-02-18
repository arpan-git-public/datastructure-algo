package com.datastructure.problems.BinarySearch;

/**
 *  BS : Min to Max Pattern
 *
 *  Given an array of length ‘N’, where each element denotes the position of a stall. Now you have ‘N’ stalls and an integer ‘K’ which denotes the number of cows that are aggressive. To prevent the cows from hurting each other, you need to assign the cows to the stalls, such that the minimum distance between any two of them is as large as possible. Return the largest minimum distance.
 * Eg
 *
 *
 * array: 1,2,4,8,9  &  k=3
 * O/P: 3
 * Explaination: 1st cow at stall 1 , 2nd cow at stall 4 and 3rd cow at stall 8
 * https://leetcode.com/discuss/general-discussion/1302335/aggressive-cows-spoj-fully-explained-c
 */
public class AggressiveCow {
    int aggressiveCows(int[] stalls, int k) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for(int i = 0; i < stalls.length ; i++) {
            max = Math.max(max,stalls[i]);
            min = Math.min(min,stalls[i]);
        }
        int low = 1, high = max - min;
        while( low <= high) {
            int mid = (low+high) / 2;
            if(isPossiblePlacement(stalls,mid,k)) low = mid + 1;
            else high = mid - 1;
        }
        return high;
    }

    boolean isPossiblePlacement(int[] stalls, int dist, int k) {
        int last = stalls[0], count = 1;
        for(int i = 1; i < stalls.length ; i++) {
            if(stalls[i] -  last >= dist) {
                count++;
                last = stalls[i];
            }
            if(count == k) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = { 1,2,4,8,9 };
        int k =3;
        var lt = new AggressiveCow();
        System.out.println(lt.aggressiveCows(nums,k));
    }

}
