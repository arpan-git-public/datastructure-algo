package com.datastructure.problems.Stack;


import java.util.Arrays;
import java.util.Stack;

/**
 *  Next Greater Element
 */
public class NextGreaterElementI {

    int[] findNextGreaterElementBrute(int[] arr) {
        int[] nge = new int[arr.length];
        for(int i = 0 ; i < arr.length; i++) {
            for(int j = i+1; j < arr.length ; j++) {
                if(arr[j] > arr[i]) {
                    nge[i] = arr[j];
                    break;
                }
            }
        }
        return nge;
    }

    int[] findNextGreaterElement(int[] arr) {
        int[] nge = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
        //start from back
        // if stack is empty add the element.
        // current number > top then pop the element until you reach greater number and add num to stack. put top to array and
        // current number < top just add num to stack
        //input : 6, 9, 1
        //output : 9 , 0, 0



        for(int i = arr.length - 1 ; i >= 0 ; --i) {
//            if(stack.empty()) stack.push(arr[i]);
//            else if(arr[i] < stack.peek()) {
//                nge[i] = stack.peek();
//                stack.push(arr[i]);
//            } else if(arr[i] > stack.peek()) {
//                while(!stack.isEmpty() && arr[i] >= stack.peek()) {
//                    stack.pop();
//                }
//                if(!stack.isEmpty()) {
//                    nge[i] = stack.peek();
//                }
//                stack.push(arr[i]);
//            }

            // Remove smaller elements from the stack
            while (!stack.isEmpty() && stack.peek() <= arr[i]) {
                stack.pop();
            }

            // Assign next greater element or 0 if none exists
            nge[i] = stack.isEmpty() ? 0 : stack.peek();

            // Push current element to stack
            stack.push(arr[i]);

        }
        return nge;
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 4, 1, 4, 5, 6, 9, 1};
        var obj = new NextGreaterElementI();
        System.out.println("Brute Force Approach: ");
        Arrays.stream(obj.findNextGreaterElementBrute(arr)).forEach(x-> System.out.print(x + "  "));
        System.out.println("Optimal Approach: ");
        Arrays.stream(obj.findNextGreaterElement(arr)).forEach(x-> System.out.print(x + "  "));

    }

}
