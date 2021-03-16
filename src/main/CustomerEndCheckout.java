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
        if(this.getCustomer().getCustomerLane() instanceof ExpressLane){
            double startTime = (getCustomer().getNumItems() * 0.1) + 1;
            setStartTime(startTime);
        }
        else{
            double startTime = (getCustomer().getNumItems() * 0.05) + 2;
            setStartTime(startTime);
        }
    }
}
