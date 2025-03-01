package com.datastructure.problems.DP;

public class FrogJump {
    //Recursion with Memoization
    int minimumJumpRecMemo(int[] arr, int index, int[] steps) {
        if(index == 0) return 0;
        if(steps[index] != 0) return steps[index];
        int move1 = minimumJumpRec(arr, index-1) + Math.abs(arr[index] - arr[index-1]);
        int move2 = Integer.MAX_VALUE;
        if(index > 1)
            move2 = minimumJumpRec(arr,index-2) + Math.abs(arr[index] - arr[index-2]);
        return steps[index] = Math.min(move1,move2);
    }

    //Recursion
    int minimumJumpRec(int[] arr, int index) {
        if(index == 0) return 0;
        int move1 = minimumJumpRec(arr, index-1) + Math.abs(arr[index] - arr[index-1]);
        int move2 = Integer.MAX_VALUE;
        if(index > 1)
            move2 = minimumJumpRec(arr,index-2) + Math.abs(arr[index] - arr[index-2]);
        return Math.min(move1,move2);
    }

    //DP : Bottom up (tabulation)
    int minimumJumpDP(int[] arr) {
        int[] dp = new int[arr.length];
        dp[0] = 0;
        for(int i = 1; i < arr.length ; i++) {
            int move1 = dp[i-1] + Math.abs(arr[i] - arr[i-1]);
            int move2 = Integer.MAX_VALUE;
            if(i > 1)
                move2 = dp[i-2] + Math.abs(arr[i] - arr[i-2]);
            dp[i] = Math.min(move1,move2);
        }
        return dp[arr.length-1];
    }

    public static void main(String[] args) {
        int[] arr = {10,20,30,10};
        var lt = new FrogJump();
        System.out.println(lt.minimumJumpRec(arr,arr.length-1));

        int[] steps = new int[arr.length];
        System.out.println(lt.minimumJumpRecMemo(arr,arr.length-1,steps));

        System.out.println(lt.minimumJumpDP(arr));
    }
}
