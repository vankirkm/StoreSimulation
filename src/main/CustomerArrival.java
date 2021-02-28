package main;

public class CustomerArrival extends Event{

    public CustomerArrival(Event other, String eventType){
        super(other, eventType);
    }

    public CustomerArrival(double startTime, Customer customer, String eventType){
        super(startTime, customer, eventType);
    }

    @Override
    public void calculateEventStartTime() {

    }
}
