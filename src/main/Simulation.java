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

    public Simulation(String fileName){
        this.eventQueue = createEventQueue(fileName);
    }

    public boolean isFinished(){
        return eventQueue.isEmpty();
    }

    public void processEvent(){
        switch(eventQueue.peek().getEventType()){

            case("CustomerArrival"):
                Event endShopping = new CustomerEndShopping(eventQueue.poll(), "CustomerEndShopping");
                System.out.println("OG start time: " + endShopping.getStartTime());
                endShopping.calculateEventStartTime();
                eventQueue.offer(endShopping);
                System.out.println(endShopping.getStartTime());
                break;

            //end customer shopping, schedule them for checkout, and put them in checkout queue.
            case("CustomerEndShopping"):
                Event endCheckout = new CustomerEndCheckout(eventQueue.poll(), "CustomerEndCheckout");
                break;
        }
    }


    //read customer list in from file, and create an arrival event queue based on what time each customer event takes place
    public static PriorityQueue<Event> createEventQueue(String filename){
        PriorityQueue<Event> eventQueue = new PriorityQueue<>();
        try{
            BufferedReader br = new BufferedReader(new FileReader("data/" + filename));
            String line;
            boolean keepGoing = true;
            while(keepGoing){
                try{
                    line = br.readLine();
                    String[] fields = line.split("\\s+");
                    Customer newCust = new Customer(Double.parseDouble(fields[0]), Integer.parseInt(fields[1]), Double.parseDouble(fields[2]));
                    eventQueue.offer(new CustomerArrival(newCust.getArrivalTime(), newCust, "CustomerArrival"));
                }catch(IOException e){
                    keepGoing = false;
                }catch(NullPointerException e1){
                    keepGoing = false;
                }
            }
        }catch(FileNotFoundException e){
            System.out.println("File does not exist. Please check path and try again.");
        }
        return eventQueue;
    }
}
