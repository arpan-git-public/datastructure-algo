package com.datastructure.problems.sorting;

import java.util.Arrays;

// 1. choose initial element as pivot
// 2. make left array elements from pivot (partition index) smaller and right side larger.
// 3. call recursively and choose partition index until it is sorted.
// TC: O(N logN)
// SC: O(1) because sorting is done in same array
public class QuickSort {

    void quickSort(int[] nums, int low, int high) {
        if(low < high) {
            int partition = findPartitionIndex(nums, low, high);
            quickSort(nums, low, partition - 1);
            quickSort(nums, partition + 1, high);
        }
    }

    int findPartitionIndex(int[] nums, int low, int high) {
        int pivot = nums[low]; //first element as pivot
        int i = low, j = high; // two pointers to compare against pivot

        while(i < j) {
            while(i <= high-1 && nums[i] <= pivot ) {
                i++;
            }
            while(j >= low + 1  && nums[j] >= pivot ) {
                j--;
            }
            if( i < j) {
                swap(nums, i, j);
            }
        }

        swap(nums,j, low);
        return j;
    }

    void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {4,5,1,2,0,3,6};
        var lt = new QuickSort();
        lt.quickSort(nums,0,nums.length-1);
        Arrays.stream(nums).forEach(x-> System.out.print(x + " "));
    }
}
