package main;

public class CustomerEndShopping extends Event{

    public CustomerEndShopping(double startTime, Customer customer){
        super(startTime, customer);
    }

    @Override
    public double getEventTime() {
        return 0;
    }
}
