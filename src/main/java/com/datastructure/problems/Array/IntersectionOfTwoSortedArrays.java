package com.datastructure.problems.Array;

import java.util.*;

public class IntersectionOfTwoSortedArrays {

    // Approach 1: Use Set structure to store duplicate unique elements.
    // nums1 = [4,9,5], nums2 = [9,4,9,8,4]
//    public int[] intersection(int[] nums1, int[] nums2) {
//       //add num1 to list
//        List<Integer> listNum1 = new ArrayList<>();
//       for(int num : nums1) {
//           listNum1.add(num);
//       }
//       Set<Integer> result = new HashSet<>();
//       //check if second array has present any element then move to result array.
//        for(int num : nums2) {
//            if(listNum1.contains(num)){
//                result.add(num);
//            }
//        }
//
//        //prepare result array.
//        int[] intersectionResult = new int[result.size()];
//        int i = 0;
//        for(int num : result) {
//            intersectionResult[i++] = num;
//        }
//        return intersectionResult;
//    }

    //Approach 2: Sorted and two pointer
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i =0 , j = 0;
        Set<Integer> intersectionList = new HashSet<>();
        while( i < nums1.length && j < nums2.length) {
            if( nums1[i] < nums2[j])
                i++;
            else if (nums1[i] > nums2[j])
                j++;
            else {
                intersectionList.add(nums1[i]);
                i++;
                j++;
            }
        }
        int[] result = new int[intersectionList.size()];
        i = 0;
        for(int num : intersectionList) {
            result[i++] = num;
        }
        return result;
    }
    public static void main(String[] args) {
        int[] nums1 = {4,9,5};
        int[] nums2 = {9,4,9,8,4};
        var lt = new IntersectionOfTwoSortedArrays();
        Arrays.stream(lt.intersection(nums1,nums2)).forEach(System.out::println);
    }
}
