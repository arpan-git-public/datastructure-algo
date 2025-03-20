package com.datastructure.problems.Stack;

public class StackUsingArray {
    int[] stack;
    int top = -1;

    public StackUsingArray(int size){
        this.stack = new int[size];
    }

    void push(int element){
      if(top >= stack.length) return;
      top = top + 1;
      stack[top] = element;
    }

    int pop() {
        if(top == -1) return -1;
        top--;
       return stack[top+1];
    }

    int top() {
        if(top == -1) return -1;
        return stack[top];
    }
    int size() {
        return top+1;
    }

    public static void main(String[] args) {
        var obj = new StackUsingArray(3);
        obj.push(10);
        obj.push(20);
        obj.push(30);
        System.out.println(obj.top());
        System.out.println("POP Element: "+ obj.pop());
        System.out.println("POP Element: "+ obj.pop());
        System.out.println(obj.top());
        System.out.println("POP Element: "+ obj.pop());
        System.out.println(obj.top());

    }
}
