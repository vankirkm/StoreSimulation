package main;

public class CustomerEndShopping extends Event{

    public CustomerEndShopping(Event other, String eventType){
        super(other, eventType);
    }

    @Override
    public void calculateEventStartTime() {
        double startTime = (getCustomer().getNumItems() * getCustomer().getTimePerItem()) + getStartTime();
        setStartTime(startTime);
    }
}
