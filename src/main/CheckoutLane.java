package main;

import java.util.LinkedList;
import java.util.Queue;

public abstract class CheckoutLane {
    private Queue<Customer> customers;

    public CheckoutLane(){
        this.customers = new LinkedList<>();
    }

    public int getLineLength(){
        Integer size = customers.size();
        if(size == null){
            return 0;
        }
        else{
            return customers.size();
        }
    }

    public void addCustomer(Customer customer){
        customers.offer(customer);
    }

}
