package com.datastructure.problems.Stack;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElementII {

    int[] findNextGreaterElement(int[] arr) {
        int[] nge = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
        //start from hypothetical array (2N-1) (double the array)
        //if currentNum > top then poll the element. Make sure index should not fall in array range
        // if currNum < top then push to stack
          // special condition : check if index < N then start filling up nge array.
        int n = arr.length;
        for(int i = 2*n - 1 ; i >= 0 ; i--) {
            while(!stack.isEmpty() && stack.peek() <= arr[i%n]) {
                stack.pop();
            }
            if(i < n) {
                nge[i] = stack.isEmpty()? -1 : stack.peek();
            }
            stack.push(arr[i%n]);
        }
        return nge;
    }
    public static void main(String[] args) {
        int[] arr = {2,10,12,1,11};
        var obj = new NextGreaterElementII();
        Arrays.stream(obj.findNextGreaterElement(arr)).forEach(x-> System.out.print(x + " "));
    }
}
