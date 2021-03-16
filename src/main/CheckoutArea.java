package main;

import java.util.ArrayList;
import java.util.Queue;

public class CheckoutArea {
    private CheckoutLane[] lanes;

    public CheckoutArea(){
        lanes = new CheckoutLane[12];
    }

    public void initLanes(String[] laneConfig){
        for(int i = 0; i < 12; i++){
            if(laneConfig[i].equals("express")){
                CheckoutLane express = new ExpressLane();
                lanes[i] = express;
            }
            else if(laneConfig[i].equals("regular")){
                CheckoutLane regular = new RegularLane();
                lanes[i] = regular;;
            }
            else{
                CheckoutLane closed = new ClosedLane();
                lanes[i] = closed;
            }
        }
    }

    public void addCustomerToQueue(Customer customer){
        if(customer.getNumItems() <= 12){
            lanes[getShortestOverallIndex()].addCustomer(customer);
            customer.setCustomerCheckoutLine(lanes[getShortestOverallIndex()]);
        }
        else{
            lanes[getShortestRegularIndex()].addCustomer(customer);
        }
    }

    public int getShortestOverallIndex(){
        int shortestIndex = Integer.MAX_VALUE;
        for(int i = 0; i < lanes.length; i++){

            if(lanes[i] instanceof RegularLane && lanes[i].getLineLength() < shortestIndex){
                shortestIndex = i;
            }
            if(lanes[i] instanceof ExpressLane && lanes[i].getLineLength() <= shortestIndex){
                shortestIndex = i;
            }
        }
        return shortestIndex;
    }

    public int getShortestRegularIndex(){
        int shortestIndex = Integer.MAX_VALUE;
        for(int i = 0; i < lanes.length; i++){
            if(lanes[i] instanceof RegularLane && lanes[i].getLineLength() < shortestIndex){
                shortestIndex = i;
            }
        }
        return shortestIndex;
    }
}
