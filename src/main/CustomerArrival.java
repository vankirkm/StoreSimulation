package main;

public class CustomerArrival extends Event{

    public CustomerArrival(double startTime, Customer customer, String eventType){
        super(startTime, customer, eventType);
    }

    @Override
    public double getEventTime() {
        return 0;
    }
}
