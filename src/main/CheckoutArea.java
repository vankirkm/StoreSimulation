package main;

import java.util.ArrayList;
import java.util.Queue;

public class CheckoutArea {
    private ArrayList<CheckoutLane> lanes;

    public CheckoutArea(){
        lanes = new ArrayList<CheckoutLane>();
    }

    public void initLanes(String[] laneConfig){
        for(String lane : laneConfig){
            if(lane.equals("express")){
                CheckoutLane express = new ExpressLane();
                lanes.add(express);
            }
            else if(lane.equals("regular")){
                CheckoutLane regular = new RegularLane();
                lanes.add(regular);
            }
            else{
                CheckoutLane closed = new ClosedLane();
                lanes.add(closed);
            }
        }
    }

    public void addCustToQueue(Customer customer){
        if(customer.getNumItems() <= 12){

        }
    }

    public int getShortestOverallIndex(){
        int shortestIndex = Integer.MAX_VALUE;
        for(int i = 0; i < lanes.size(); i++){

            if(lanes.get(i) instanceof RegularLane && lanes.get(i).getLineLength() < shortestIndex){
                shortestIndex = i;
            }
            if(lanes.get(i).getLineLength() < shortestIndex){
                shortestIndex = i;
            }
        }
        return shortestIndex;
    }

    public int getShortestRegularIndex(){
        int shortestIndex = Integer.MAX_VALUE;
        for(int i = 0; i < lanes.size(); i++){
            if(lanes.get(i) instanceof RegularLane && lanes.get(i).getLineLength() < shortestIndex){
                shortestIndex = i;
            }
        }
        return shortestIndex;
    }
}
