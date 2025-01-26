package org.example.Strings;


import java.awt.desktop.SystemSleepEvent;
import java.util.Arrays;

public class LT88MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        for (int i = m, j = 0; i < nums1.length && j < nums2.length; i++, j++) {
            nums1[i] = nums2[j];
        }

        quicksort(nums1,0, nums1.length-1);
        // 10 6 5 9 3 16 12
        Arrays.stream(nums1).forEach(System.out::println);
    }

    void quicksort( int nums1[],int low, int high) {
        if(low < high) {
            int j = partition(nums1,low,high);
            quicksort(nums1,low,j-1);
            quicksort(nums1,j+1,high);
        }
    }

    int partition(int[] nums1, int low, int high) {
        int pivot = nums1[low];
        int i = low, j = high;

        //iterate i and j crosses
        while (i < j) {
            //iterate until i <= pivot
            while (i <= high && nums1[i] <= pivot){
                 i++;
             }

            //iterate until j > pivot
            while ( j >= low && nums1[j] > pivot ) {
                j--;
            };
            //only swap if i and j are not crossed. i.e. i < j
            if(i < j)
                swap(nums1,i,j); //swap i and j
        }
        //i and j are crossed and found pivot position so, swap with j
        swap(nums1,low, j);
        return j; //pivot position is sorted so, return position to sort left and right array
    }

    void swap(int nums1[],int m, int j) {
        int temp = nums1[m];
        nums1[m] = nums1[j];
        nums1[j] = temp;
    }

    public static void main(String[] args) {
//        int[] nums1 = {1,2,3,0,0,0};
//        int m = 3;
//        int [] nums2 = {2,5,6};
//        int n = 3;

        int[] nums1 = {2,0};
        int m = 1;
        int [] nums2 = {1};
        int n = 1;
        var lt = new LT88MergeSortedArray();
        lt.merge(nums1,m,nums2,n);
    }
}
