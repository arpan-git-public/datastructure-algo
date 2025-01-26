package com.designpatterns.structural.bridge;

/**
 * Type: Structural Design Pattern
 * What to Solve: Decouples abstraction from implementation, allowing them to vary independently.
 * Use case: When you want to separate hierarchy into two parallel hierarchies to reduce complexity.
 */
public class BridgeDesignPattern {

    public static void main(String[] args) {
        var redColor = new RedColor();
        var squarShape = new SquarShape(redColor);
        squarShape.draw();

        var greenColor = new GreenColor();
        var roundShape = new RoundShape(greenColor);
        roundShape.draw();
    }


}

interface Color {
    void fillColor();
}

class RedColor implements Color {

    @Override
    public void fillColor() {
        System.out.println("Red color");
    }
}

class GreenColor implements Color {

    @Override
    public void fillColor() {
        System.out.println("Green Color");
    }
}

abstract class Shape {

    Color color;
    public Shape(Color color) {
        this.color = color;
    }

    abstract void draw();
}

class RoundShape extends Shape {

    public RoundShape(Color color) {
        super(color);
    }

    @Override
    void draw() {
        System.out.println("Round Shape");
        color.fillColor();
    }
}

class SquarShape extends Shape {
    public SquarShape(Color color) {
        super(color);
    }

    @Override
    void draw() {
        System.out.println("Square Shape");
        color.fillColor();
    }
}