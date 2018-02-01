package reader;

import main.Passenger;

public class R1 implements IReader {
    public void readPass(Passenger passenger){
        System.out.println("Passenger with the id" + passenger.getId()+ " checked in by using R1");
    }

}
