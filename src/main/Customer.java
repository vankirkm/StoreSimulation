package main;

import java.util.Queue;

public class Customer {

    private double arrivalTime;
    private int numItems;
    private double timePerItem;
    private CheckoutLane customerLane;
    private int customerNumber;

    public Customer(double arrivalTime, int numItems, double timePerItem, int customerNumber){
        this.arrivalTime = arrivalTime;
        this.numItems = numItems;
        this.timePerItem = timePerItem;
        this.customerNumber = customerNumber;
    }

    public double getArrivalTime(){
        return this.arrivalTime;
    }

    public int getNumItems(){
        return this.numItems;
    }

    public double getTimePerItem(){
        return this.timePerItem;
    }

    public void setCustomerCheckoutLine(CheckoutLane lane){
        this.customerLane = lane;
    }

    public CheckoutLane getCustomerLane(){
        return this.customerLane;
    }

    public String toString(){
        return this.arrivalTime + " " + this.numItems + " " + this.timePerItem;
    }


}
