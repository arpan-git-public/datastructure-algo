package com.designpatterns.structural.decorator;

/**
 * Type: Structural Design Pattern
 * What to Solve: Dynamically adds responsibilities to objects without altering the structure.
 * Use case: When extending functionality of objects in a flexible manner is needed.
 */
public class DecoratorDesignPattern {
    public static void main(String[] args) {
        var coffee = new SimpleCoffee();
        var lt = new MilkDecorator(coffee);
        System.out.println(lt.getDescription());
        System.out.println(lt.cost());

    }
}

interface Coffee {

    String getDescription();

    double cost();
}

class SimpleCoffee implements Coffee {


    @Override
    public String getDescription() {
        return "Simple Coffee";
    }

    @Override
    public double cost() {
        return 5.0;
    }
}

abstract class CoffeeDecorator implements Coffee {
    protected Coffee coffee;

    public CoffeeDecorator(Coffee coffee) {
        this.coffee = coffee;
    }
}

class MilkDecorator extends CoffeeDecorator {

    public MilkDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public String getDescription() {
        return coffee.getDescription() + " + Milk ";
    }

    @Override
    public double cost() {
        return coffee.cost() + 1.5;
    }
}

class SugarDecorator extends CoffeeDecorator {

    public SugarDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public String getDescription() {
        return coffee.getDescription() + " Sugar ";
    }

    @Override
    public double cost() {
        return coffee.cost() + 0.5;
    }
}


