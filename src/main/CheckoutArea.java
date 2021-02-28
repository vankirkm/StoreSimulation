package main;

import java.util.ArrayList;

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
                CheckoutLane closed = new RegularLane();
                closed.setClosed();
                lanes.add(closed);
            }
        }
    }

    public void getShortestExpressLane(){

    }

    public void getShortestLane(){

    }
}
