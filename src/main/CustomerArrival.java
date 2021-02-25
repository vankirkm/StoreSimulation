package main;

public class CustomerArrival extends Event{

    public CustomerArrival(double startTime, Customer customer){
        super(startTime, customer);
    }

    @Override
    public double getEventTime() {
        return 0;
    }
}
