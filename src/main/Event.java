package main;

public abstract class Event implements Comparable<Event>{
    private String eventType;
    private double startTime;
    private Customer customer;

    public Event(double startTime, Customer customer, String eventType) {
        this.startTime = startTime;
        this.customer = customer;
        this.eventType = eventType;
    }

    public abstract double getEventTime();

    public double getStartTime(){
        return this.startTime;
    }

    public Customer getCustomer(){
        return this.customer;
    }

    public String getEventType(){
        return this.eventType;
    }

    public void setStartTime(double startTime){
        this.startTime = startTime;
    }


    @Override
    public int compareTo(Event other) {
        if(this.startTime < other.getStartTime()){
            return -1;
        }
        else if(this.startTime > other.getStartTime()){
            return 1;
        }
        else{
            return 0;
        }
    }
}
