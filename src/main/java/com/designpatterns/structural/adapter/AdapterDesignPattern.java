package com.designpatterns.structural.adapter;

/**
 * Type: structural design pattern.
 * What solves: It allows two incompatible interfaces to work together by creating a bridge between them.
 */
public class AdapterDesignPattern {
    public static void main(String[] args) {
        var adaptee = new Adaptee();
        var adapter = new Adapter(adaptee);
        adapter.requestAccess();
    }
}

class Adaptee {

    public void specificTask() {
        System.out.println("This is Adapter design pattern related task.");
    }
}

interface Target {
    void requestAccess();
}

class Adapter implements Target {
    Adaptee adaptee;
    public Adapter(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void requestAccess() {
        this.adaptee.specificTask();
    }
}