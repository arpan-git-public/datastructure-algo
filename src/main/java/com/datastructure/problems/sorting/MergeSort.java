package com.datastructure.problems.sorting;

import java.util.Arrays;

public class MergeSort {

    // divide from middle - base condition of recursion to divinde into subarray
    // merge into temp array and replace to original index (two pointer approach)
    // TC: O(N logN)
    //Sc: O(N) because of temp array for merge
    void mergeSort(int[] arr, int low, int high) {
        if(low >= high) return;
        int mid = (high-low)/2 + low;
        mergeSort(arr,low,mid);
        mergeSort(arr,mid+1,high);
        merge(arr,low,mid,high);
    }

    void merge(int[] arr, int low, int mid, int high) {
        int[] temp = new int[high-low+1];
        int left = low;
        int right = mid+1;
        int index = 0;
        while(left <= mid && right <= high) {
            if(arr[left] <= arr[right]) {
                temp[index] = arr[left];
                index++;
                left++;
            }
            else {
                temp[index] = arr[right];
                index++;
                right++;
            }
        }
        while(left <= mid) {
            temp[index++] = arr[left++];
        }
        while(right <= high) {
            temp[index++] = arr[right++];
        }

        //replace value to original array
        for(int i = low ; i <= high; i++) {
            arr[i] = temp[i-low];
        }

    }
    public static void main(String[] args) {
        int[] arr = {3,4,5,1,2,5,0,3,7,2};
        var lt = new MergeSort();
        lt.mergeSort(arr,0,arr.length-1);
        Arrays.stream(arr).forEach(x-> System.out.println(x + " "));
    }


}
