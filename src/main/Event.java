package main;

public abstract class Event implements Comparable<Event>{
    private String eventType;
    private double startTime;
    private Customer customer;

    public Event(Event other, String eventType){
        this.startTime = other.getStartTime();
        this.customer = other.getCustomer();
        this.eventType = eventType;
    }

    public Event(double startTime, Customer customer, String eventType) {
        this.startTime = startTime;
        this.customer = customer;
        this.eventType = eventType;
    }

    public double getStartTime(){
        return this.startTime;
    }

    public Customer getCustomer(){
        return this.customer;
    }

    public String getEventType(){
        return this.eventType;
    }

    public abstract void calculateEventStartTime();

    public void setStartTime(double startTime){
        this.startTime = startTime;
    }

    public void setEventType(String eventType){
        this.eventType = eventType;
    }

    public void setCustomer(Customer customer){
        this.customer = customer;
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
