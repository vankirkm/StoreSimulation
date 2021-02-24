package main;

public abstract class Event implements Comparable<Event>{
    private double startTime;

    public abstract double getEventStartTime();

    public double getStartTime(){
        return this.startTime;
    }


    @Override
    public int compareTo(Event other) {
        if(this.startTime > other.getStartTime()){
            return -1;
        }
        else if(this.startTime < other.getStartTime()){
            return 1;
        }
        return 0;
    }
}
