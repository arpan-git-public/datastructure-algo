package com.datastructure.problems.Queue;

import java.util.Arrays;
import java.util.Queue;

public class QueueUsingArray {
    int[] queue;
    int start = -1;
    int end = -1;
    public QueueUsingArray(int size) {
        this.queue = new int[size];
    }

    void push(int element) {
      if(end >= queue.length) return;

      if(start == -1) start++;
      end = end % queue.length + 1;
      queue[end] = element;
    }

    int poll() {
        if(start == -1) return -1;
        int element = queue[start];
        start = start % queue.length + 1;
        return element;
    }

    int top() {
        return queue[start];
    }

    int size() {
        return end - start + 1;
    }

    public static void main(String[] args) {
        var obj = new QueueUsingArray(3);
        obj.push(10);
        obj.push(20);
        obj.push(30);
        System.out.println("Top element " + obj.top());
        System.out.println("Poll element " + obj.poll());
        System.out.println("Top element " + obj.top());
        System.out.println("Poll element " + obj.poll());
        System.out.println("Top element " + obj.top());
        System.out.println("Poll element " + obj.poll());
        System.out.println("Current Size "+ obj.size());
    }
}
