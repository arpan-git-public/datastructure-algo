package com.datastructure.problems.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeadersInArray {
    int[] findLeaders(int[] nums) {
        List<Integer> leadersList = new ArrayList<>();
        int len = nums.length;
        int currentLeader = Integer.MIN_VALUE;

        for(int i = len - 1 ; i >= 0; i--) {
            if(currentLeader < nums[i]) {
                currentLeader = nums[i];
                leadersList.add(currentLeader);
            }
        }

        int[] leaders = new int[leadersList.size()];
        int i = leadersList.size() - 1;
        for(int leader : leadersList){
            leaders[i--] = leader;
        }
        return leaders;
    }
    public static void main(String[] args) {
        int[] nums = {10,22,12,3,0,6};
        var lt = new LeadersInArray();
        Arrays.stream(lt.findLeaders(nums)).forEach(System.out::println);
    }
}
