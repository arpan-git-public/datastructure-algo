package com.datastructure.problems.Queue;

public class QueueUsingLinkedList {
    Node start;
    Node end;
    int currentSize;
    class Node {
        int element;
        Node next;

        public Node(int element) {
            this.element = element;
        }
    }
   // null ->       1  ->   3    ->   2
   //         start                  end
    void push(int element) {
        Node temp = new Node(element);
        if(currentSize == 0) {
            start = temp;
            end = temp;
        } else {
            end.next = temp;
            end = temp;
        }
        currentSize++;
    }

    int poll() {
        if(currentSize == 0) return -1;
        else {
            int element = start.element;
            start = start.next;
            if(start == null) end = start;
            currentSize--;
            return element;
        }
    }

    int top(){
        return start != null ? start.element : -1;
    }

    int size() {
        return currentSize;
    }

    public static void main(String[] args) {
        var obj = new QueueUsingLinkedList();
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
        System.out.println("Poll element " + obj.poll());
        System.out.println("Top element " + obj.top());
    }
}
