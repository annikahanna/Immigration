package listener;

import main.Passenger;
import random.MersenneTwisterFast;
import reader.IReader;
import reader.R1;
import reader.R2;

import java.util.ArrayList;

public class TerminalEasyPass implements IListener {


    @Override
    public void openTerminal(ArrayList<Passenger> queue) {
        checkInPassengers(queue);
    }

    public void checkInPassengers(ArrayList<Passenger> queue) {
        MersenneTwisterFast randomizer = new MersenneTwisterFast();
        IReader r1 = new R1();
        IReader r2 = new R2();

        for (Passenger passenger : queue) {
            if (randomizer.nextBoolean()) {
                r1.readPass(passenger);
            } else {
                r2.readPass(passenger);
            }
        }
    }
}
