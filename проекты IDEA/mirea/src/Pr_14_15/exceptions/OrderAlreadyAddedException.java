package Pr_14_15.exceptions;

public class OrderAlreadyAddedException extends Exception {
    public OrderAlreadyAddedException() {
        super("Such an order has already been created!");
    }
}