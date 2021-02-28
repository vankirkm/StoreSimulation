package main;

public class Main {
    public static void main(String[] args){
        String filename = "arrival medium.txt";
        Simulation newSim = new Simulation(filename);
        while(!newSim.isFinished()){
            newSim.processEvent();
        }
    }
}
