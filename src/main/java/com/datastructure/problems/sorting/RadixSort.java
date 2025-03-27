package com.datastructure.problems.sorting;


import java.util.Arrays;

public class RadixSort {

    void radixSort(int[] arr, int n) {
        //get Maximum
         int maxValue = getMax(arr, n);
        //count sort
        for(int exp = 1; maxValue / exp > 0 ; exp *= 10) {
            countSort(arr, exp, n);
        }
    }

    private int getMax(int[] arr, int n) {
        int max = 0;
        for(int i = 0 ; i < n; i++) {
            max = Math.max(max,arr[i]);
        }
        return max;
    }

    void countSort(int[] arr, int exp, int n) {
        int[] count = new int[10];
        int[] output = new int[n];

        //count array from n-1 to 0.
        for(int i = n-1 ; i >= 0; i--) {
            count[(arr[i]/exp)%10]++;
        }

        // Change count[i] so that count[i] now contains
        // actual position of this digit in output[]
        for(int i = 1 ; i < 10 ; i++) {
            count[i] += count[i-1];
        }

        //output array to place using count array and adjust count
        for(int i = n-1 ; i >= 0; i--) {
            output[count[(arr[i]/exp)%10]-1] = arr[i];
            count[(arr[i]/exp)%10]--;
        }

        //replace back to array using output
        for(int i = 0; i < n ; i++) {
            arr[i] = output[i];
        }
    }

    public static void main(String[] args) {
        int[] arr = {120, 90, 89, 23, 44, 5, 10};
        int n = arr.length;
        var obj = new RadixSort();
        obj.radixSort(arr,n);
        Arrays.stream(arr).forEach(x-> System.out.print(x + " "));
    }
}
