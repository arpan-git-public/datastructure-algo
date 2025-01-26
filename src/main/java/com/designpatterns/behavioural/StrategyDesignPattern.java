package com.designpatterns.behavioural;

/**
 * When to use: Define a family of algorithms, encapsulate each one and make them interchangeable at runtime.
 */
public class StrategyDesignPattern {

    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        cart.setPaymentStrategy(new CreditCardPayment());
        cart.checkout(20);

        cart.setPaymentStrategy(new PayPalPayment());
        cart.checkout(100);
    }
}
    interface PaymentStrategy {
        void pay(int amount);
    }

    class CreditCardPayment implements PaymentStrategy{

        @Override
        public void pay(int amount) {
            System.out.println("Paid " + amount + " using Credit Card.");
        }
    }
    class PayPalPayment implements PaymentStrategy {

        @Override
        public void pay(int amount) {
            System.out.println("Paid " + amount + " using Paypal payment.");
        }
    }

    //context
    class ShoppingCart {
        private PaymentStrategy paymentStrategy;

        public ShoppingCart() {}

        public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
            this.paymentStrategy = paymentStrategy;
        }

        public void checkout(int amount) {
            paymentStrategy.pay(amount);
        }
    }



