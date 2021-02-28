package main;

public class CustomerEndCheckout extends Event{

    public CustomerEndCheckout(Event other, String eventType){
        super(other, eventType);
    }

    public CustomerEndCheckout(double startTime, Customer customer, String eventType){
        super(startTime, customer, eventType);
    }

    @Override
    public void calculateEventStartTime() {
    }
}
