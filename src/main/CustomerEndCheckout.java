package main;

public class CustomerEndCheckout extends Event{

    public CustomerEndCheckout(double startTime, Customer customer, String eventType){
        super(startTime, customer, eventType);
    }

    @Override
    public double getEventTime() {
        return 0;
    }
}
