package org.example.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UnionOfTwoSortedArrays {
    // arr = {1,1,2,2,3,4,5}
    // arr2 = {2,3,4,4,5,6,6}
    int[] unionArray(int[] arr1, int[] arr2){
        //two point approach
        int i = 0,j = 0;
        List<Integer> uniqueList = new ArrayList<>();

        while( i < arr1.length || j < arr2.length) {
            if(i < arr1.length && uniqueList.contains(arr1[i])) {
                i++;
            } else if(j < arr2.length && uniqueList.contains(arr2[j])){
                j++;
            } else {
                if(i < arr1.length && !uniqueList.contains(arr1[i])) {
                    uniqueList.add(arr1[i]);
                    i++;
                } else if(j < arr2.length && !uniqueList.contains(arr2[j])){
                    uniqueList.add(arr2[j]);
                    j++;
                }
            }
        }
        int[] result = new int[uniqueList.size()];
        i = 0;
       for(int element: uniqueList) {
           result[i++] = element;
       }
        return  result;
    }
    public static void main(String[] args) {
        var lt = new UnionOfTwoSortedArrays();
        int[] arr1 = {1,1,2,2,3,4,5};
        int[] arr2 = {2,3,4,4,5,6,6};
       Arrays.stream(lt.unionArray(arr1,arr2)).forEach(System.out::println);
    }
}
