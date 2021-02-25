package main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args){
        String filename = "arrival medium.txt";
        PriorityQueue<Event> eventQueue = createEventQueue(filename);
        while(!eventQueue.isEmpty()){
            Event event = eventQueue.poll();
            switch(event){

            }
        }
    }


    //read customer list in from file, and create an event queue based on what time each customer event takes place
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
                    eventQueue.offer(new CustomerArrival(newCust.getArrivalTime(), newCust));
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
