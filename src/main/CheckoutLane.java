package main;

import java.util.Queue;

public abstract class CheckoutLane {
    private boolean isOpen;
    private Queue<Customer> customers;

    public void setClosed(){
        this.isOpen = false;
    }
}
