package com.datastructure.problems.Array;

public class MissingNumber {

    int missingNumberBruteForce(int[] nums, int N) {
        // Approach 1:

        for(int i = 1; i<= N; i++ ) {
            boolean elementPresent = false;
            for(int j = 0 ; j < nums.length ; j++) {
                if(nums[j] == i) {
                    elementPresent = true;
                }
            }
            if(!elementPresent) return i;
        }
        return -1;
    }

    //Track element through visited array
    //TC: O(N)
    //SC : O(N)

    int missingElementBetter(int nums[], int N) {
        int[] visited = new int[N+1];

        for(int num : nums) { //O(n)
            visited[num] = 1;
        }

        for(int i = 1 ; i < visited.length ; i ++) {
            if(visited[i] == 0)
                return i;
        }
        return -1;
    }
    // sum of element or XOR
    // TC : O(N)
    // SC : o(1)
    int missingElementOptimal(int[] nums, int N) {
        int xor1 = 0 , xor2 = 0 ;
        for(int i = 0 ; i < nums.length ; i ++) {
            xor2 = xor2 ^ nums[i];
            xor1 = xor1 ^ (i+1);
        }
        xor1 = xor1 ^ N;

        return xor2 ^ xor1;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,4,5};
        int N = 5;
        var lt = new MissingNumber();
        System.out.println(lt.missingNumberBruteForce(nums,N));
        System.out.println(lt.missingElementBetter(nums,N));
        System.out.println(lt.missingElementOptimal(nums,N));
    }
}
