package main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class Simulation {
    private double simTime;
    private PriorityQueue<Event> eventQueue;
    private CheckoutArea checkoutArea;
    private double avgWait;
    private String[] laneConfig = new String[] {
            "express",
            "express",
            "express",
            "regular",
            "regular",
            "regular",
            "regular",
            "regular",
            "regular",
            "closed",
            "closed",
            "closed"};

    public Simulation(String fileName){
        simTime = 0;
        checkoutArea = new CheckoutArea();
        checkoutArea.initLanes(laneConfig);
        avgWait = 0;
        this.eventQueue = createEventQueue(fileName);
    }

    public boolean isFinished(){
        return eventQueue.isEmpty();
    }

    public void processEvent(){
        switch(eventQueue.peek().getEventType()){

            case("CustomerArrival"):
                Event endShopping = new CustomerEndShopping(eventQueue.poll(), "CustomerEndShopping");
                endShopping.calculateEventStartTime();
                eventQueue.offer(endShopping);
                break;

            //end customer shopping, schedule them for checkout, and put them in checkout queue.
            //if their lane is empty, immediately schedule a CustomerEndCheckout event
            case("CustomerEndShopping"):
                checkoutArea.addCustomerToQueue(eventQueue.peek().getCustomer());
                break;

            //end customer checkout
            case("CustomerEndCheckout"):
                //we need to take the customer out of the checkout line they are currently in and
                //add a new CustomerEndCheckout for the next person in line.
                eventQueue.peek().getCustomer();
                break;
        }
    }

    public void processCheckouts(){
        for(CheckoutLane lane : checkoutArea.getLanes()){
            if(!lane.getCustomers().peek().isCheckingOut()){

            }
        }
    }



    //read customer list in from file, and create an arrival event queue based on what time each customer event takes place
    public static PriorityQueue<Event> createEventQueue(String filename){
        PriorityQueue<Event> eventQueue = new PriorityQueue<>();
        try{
            BufferedReader br = new BufferedReader(new FileReader("data/" + filename));
            String line;
            boolean keepGoing = true;
            int customerCount = 1;
            while(keepGoing){
                try{
                    line = br.readLine();
                    String[] fields = line.split("\\s+");
                    Customer newCust = new Customer(Double.parseDouble(fields[0]), Integer.parseInt(fields[1]), Double.parseDouble(fields[2]), customerCount);
                    eventQueue.offer(new CustomerArrival(newCust.getArrivalTime(), newCust, "CustomerArrival"));
                }catch(IOException e){
                    keepGoing = false;
                }catch(NullPointerException e1){
                    keepGoing = false;
                }
                customerCount++;
            }
        }catch(FileNotFoundException e){
            System.out.println("File does not exist. Please check path and try again.");
        }
        return eventQueue;
    }

}
