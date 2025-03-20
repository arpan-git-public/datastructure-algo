package com.datastructure.problems.Stack;

public class StackUsingLinkedList {
    int size;
    Node top;
    class Node {
        int element;
        Node next;

        public Node(int element) {
            this.element = element;
        }
    }

    void push(int element) {
        Node temp = new Node(element);
       temp.next = top;
       top = temp;
        size++;
    }

    void pop() {
        top = top.next;
        size--;
    }

    int top() {
        return top.element;
    }
    int size() {
        return size;
    }

    public static void main(String[] args) {
        var obj = new StackUsingLinkedList();
        obj.push(10);
        obj.push(20);
        obj.push(30);
        System.out.println("TOP : " + obj.top());
        obj.pop();
        obj.pop();
        System.out.println("TOP : " + obj.top());
        System.out.println("SIZE : " + obj.size());

    }
}
