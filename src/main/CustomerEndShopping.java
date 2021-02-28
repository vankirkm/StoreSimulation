package main;

public class CustomerEndShopping extends Event{

    public CustomerEndShopping(Event other, String eventType){
        super(other, eventType);
    }

    public CustomerEndShopping(double startTime, Customer customer, String eventType){
        super(startTime, customer, eventType);
    }

    @Override
    public void calculateEventStartTime() {
        double startTime = (getCustomer().getNumItems() * getCustomer().getTimePerItem()) + getStartTime();
        setStartTime(startTime);
    }
}
