package main;

public class Customer {

    private double arrivalTime;
    private int numItems;
    private double timePerItem;

    public Customer(double arrivalTime, int numItems, double timePerItem){
        this.arrivalTime = arrivalTime;
        this.numItems = numItems;
        this.timePerItem = timePerItem;
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


}
