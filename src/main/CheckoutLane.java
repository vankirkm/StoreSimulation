package main;

import java.util.Queue;

public abstract class CheckoutLane {
    private Queue<Customer> customers;


    public int getLineLength(){
        return customers.size();
    }

}
