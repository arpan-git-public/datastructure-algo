package com.datastructure.problems.Array;

import java.util.Arrays;

public class MergeSortedArrayWithoutExtraSpace {

    // Brute force
    void merge_brute(int[] arr1, int[] arr2, int n, int m) {
        int i = 0, j = 0, index = 0;
        int[] arr3 = new int[m + n];
        while (i < n && j < m) {   // O(min(n+m))
            if (arr1[i] <= arr2[j]) {
                arr3[index++] = arr1[i++];
            } else {
                arr3[index++] = arr2[j++];
            }
        }

        while (i < n) {
            arr3[index++] = arr1[i++];
        }
        while (j < m) {
            arr3[index++] = arr2[j++];
        }

        for (int k = 0; k < m + n; k++) { //O(n+m)
            if (k < n) {
                arr1[k] = arr3[k];
            } else {
                arr2[k - n] = arr3[k];
            }
        }
    }

    // TC: O(min(n+m)) +  O(n log n) + O(m log m)
    // SC: O(1) + "for sorting :" O(log n)
    void merge(int[] arr1, int[] arr2, int n, int m) {
        int left = arr1.length - 1, right = 0;
        while (left >= 0 && right < m) { //O (min(n+m))
            if (arr1[left] > arr2[right]) {
                int temp = arr1[left];
                arr1[left] = arr2[right];
                arr2[right] = temp;

            }
            left--;
            right++;
        }
        Arrays.sort(arr1); // O(n log n)
        Arrays.sort(arr2); // O(m log m)
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 4, 5};
        int[] arr2 = {0, 2, 3, 6, 7};
        var lt = new MergeSortedArrayWithoutExtraSpace();
        lt.merge(arr1, arr2, arr1.length, arr2.length);
        Arrays.stream(arr1).forEach(x -> System.out.print(x + " "));
        Arrays.stream(arr2).forEach(x -> System.out.print(x + " "));
    }
}
