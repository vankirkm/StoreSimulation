package main;

public class CustomerEndShopping extends Event{

    public CustomerEndShopping(double startTime, Customer customer, String eventType){
        super(startTime, customer, eventType);
    }

    @Override
    public double getEventTime() {
        return 0;
    }
}
