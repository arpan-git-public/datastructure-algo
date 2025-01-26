package com.designpatterns.structural.composite;

import java.util.ArrayList;
import java.util.List;

/**
 *  Type: Structural Design Pattern
 *  What Solves: Composes object into tree like structures to represent Part whole hierarchies, allowing
 *  uniform treatment of individual and composite objects.
 *  - when dealing with a tree structure where leaf and composite nodes should be treated same.
 */
public class CompositeDesignPattern {
    public static void main(String[] args) {
        var lt = new Employee("Arpan");
        lt.showDetails();
        var emp1 = new Employee("Employee 1");
        var emp2 = new Employee("Employee 2");
        var emp3 = new Employee("Employee 3");

        var manager = new Manager("Jack");
        manager.add(lt);
        manager.add(emp1);
        manager.add(emp2);
        manager.add(emp3);
        manager.remove(emp1);

        manager.showDetails();
    }
}
    interface Component {
        void showDetails();
    }

    class Employee implements Component {
        String name;

        public Employee(String name) {
            this.name = name;
        }
        @Override
        public void showDetails() {
            System.out.println("Employee : " + name);
        }
    }

    class Manager implements Component {
        String name;
        List<Component> subOrdinates = new ArrayList<>();

        public Manager(String name) {
            this.name = name;
        }

        public void add(Component component) {
            subOrdinates.add(component);
        }

        public void remove(Component component) {
            subOrdinates.remove(component);
        }

        @Override
        public void showDetails() {
            System.out.println("Employee : "+ name);
            for (Component subordinate : subOrdinates) {
                subordinate.showDetails();
            }
        }
    }

