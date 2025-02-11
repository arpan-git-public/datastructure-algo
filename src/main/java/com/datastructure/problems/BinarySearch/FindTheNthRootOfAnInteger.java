package com.datastructure.problems.BinarySearch;

public class FindTheNthRootOfAnInteger {
    // 1 == m
    // 0 is less than m
    //2 is greater than m
    int calculateNthTimesOfMid(int n, int mid, int m) {
        int ans = 1;
        for(int i = 1; i<= n ;i++) {
            ans = ans * mid;
            if(ans > m) return 2;
        }
        if(ans == m) return 1;
        return 0;
    }
    int NthRoot(int n, int m) {
        int low = 1, high = m;

        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(calculateNthTimesOfMid(n,mid,m) == 1) return mid;
            else if(calculateNthTimesOfMid(n,mid,m) == 0) low = mid + 1;
            else
                high = mid - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        var lt = new FindTheNthRootOfAnInteger();
        System.out.println(lt.NthRoot(4,81));
    }
}
