package com.datastructure.problems.Strings;

public class LT80RemoveDuplicatesfromSortedArrayII {

    /**
     * Given an integer array nums sorted in non-decreasing order, remove some duplicates in-place such that each unique element appears at most twice. The relative order of the elements should be kept the same.
     *
     * Since it is impossible to change the length of the array in some languages, you must instead have the result be placed in the first part of the array nums. More formally, if there are k elements after removing the duplicates, then the first k elements of nums should hold the final result. It does not matter what you leave beyond the first k elements.
     *
     * Return k after placing the final result in the first k slots of nums.
     *
     * Do not allocate extra space for another array. You must do this by modifying the input array in-place with O(1) extra memory.
     *
     * Custom Judge:
     *
     * The judge will test your solution with the following code:
     *
     * int[] nums = [...]; // Input array
     * int[] expectedNums = [...]; // The expected answer with correct length
     *
     * int k = removeDuplicates(nums); // Calls your implementation
     *
     * assert k == expectedNums.length;
     * for (int i = 0; i < k; i++) {
     *     assert nums[i] == expectedNums[i];
     * }
     * If all assertions pass, then your solution will be accepted.
     *
     *
     *
     * Example 1:
     *
     * Input: nums = [1,1,1,2,2,3]
     * Output: 5, nums = [1,1,2,2,3,_]
     * Explanation: Your function should return k = 5, with the first five elements of nums being 1, 1, 2, 2 and 3 respectively.
     * It does not matter what you leave beyond the returned k (hence they are underscores).
     * Example 2:
     *
     * Input: nums = [0,0,1,1,1,1,2,3,3]
     * Output: 7, nums = [0,0,1,1,2,3,3,_,_]
     * Explanation: Your function should return k = 7, with the first seven elements of nums being 0, 0, 1, 1, 2, 3 and 3 respectively.
     * It does not matter what you leave beyond the returned k (hence they are underscores).
     *
     *
     * Constraints:
     *
     * 1 <= nums.length <= 3 * 104
     * -104 <= nums[i] <= 104
     * nums is sorted in non-decreasing order.
     *
     * @param nums
     * @return
     */


//    public int removeDuplicates(int[] nums) {
//        int i = 0 , j = 1, count = 1;
//        if(nums.length <= 2 )
//             return nums.length;
//        while(j < nums.length) {
//            if(nums[i] == nums[j]) {
//                count++;
//                if(count > 2) {
//                    nums[j] = 105;
//                } else {
//                    i++;
//                }
//                j++;
//            } else {
//                count = 1;
//                i = j;
//                j++;
//            }
//        }
//        i = 0 ;
//        j = 1;
//
//        while( j <= nums.length) {
//            if(nums[i] == 105) {
//                 while( j < nums.length && nums[j] == 105) {
//                     j++;
//                 }
//                 if(j == nums.length)
//                     break;
//                 else
//                 swap(nums,i,j);
//            } else {
//                i++;
//                j++;
//            }
//        }
//
//        return i;
//    }
//
//    void swap(int nums1[],int m, int j) {
//        int temp = nums1[m];
//        nums1[m] = nums1[j];
//        nums1[j] = temp;
//    }

    public int removeDuplicates(int[] nums) {
        int k =2 ;
        for(int i =2 ; i < nums.length; i++ ){
            if(nums[i] != nums[k-2]) {
                nums[k] = nums[i];
                k++;
            }
        }
        return k;
    }
    public static void main(String[] args) {
       // int[] nums = {1,1,1,1,2,2,2,2,2,4,4,4,5,6,7,7,7,8};
       // int[] nums = {1,1,1,1,2,2,2,4};
       // int[] nums= {1,1};
     //   int[] nums = {1,1,2,2,2,2,2,2,4,4,5,5,5,5,5,5,5,5,6,6,7,7,8};
        int[] nums = {1,2,2};
        var lt = new LT80RemoveDuplicatesfromSortedArrayII();
        int k = lt.removeDuplicates(nums);

        for (int x = 0; x < k; x++) {
            System.out.print(nums[x] + " "); // Output: 1 1 2 2 3
        }
    }
}
