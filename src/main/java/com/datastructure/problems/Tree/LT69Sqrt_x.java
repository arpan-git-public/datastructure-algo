package com.datastructure.problems.Tree;

/**
 * Given a non-negative integer x, return the square root of x rounded down
 * to the nearest integer. The returned integer should be non-negative as well.
 *
 * You must not use any built-in exponent function or operator.
 *
 * For example, do not use pow(x, 0.5) in c++ or x ** 0.5 in python.
 *
 *
 * Example 1:
 *
 * Input: x = 4
 * Output: 2
 * Explanation: The square root of 4 is 2, so we return 2.
 *
 * Example 2:
 *
 * Input: x = 8
 * Output: 2
 * Explanation: The square root of 8 is 2.82842...,
 * and since we round it down to the nearest integer, 2 is returned.
 */
public class LT69Sqrt_x {
    public int mySqrt(int x) {
        if(x < 2) return x;
        int left = 2, right = x/2, pivot = 0;long num = 0;
        while(left <= right) {
            pivot = left + (right - left) / 2;
            num = (long) pivot * pivot;
            if (num > x) right = pivot - 1;
            else if (num < x) left = pivot + 1;
            else return pivot;
        }
        return right;
    }

    public static void main(String[] args) {
        int x = 9;
        var lt = new LT69Sqrt_x();
        System.out.println(lt.mySqrt(x));
    }
}
