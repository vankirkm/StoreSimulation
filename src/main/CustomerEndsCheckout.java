package main;

public class CustomerEndsCheckout extends Event{

    public CustomerEndsCheckout(double startTime, Customer customer){
        super(startTime, customer);
    }

    @Override
    public double getEventTime() {
        return 0;
    }
}
