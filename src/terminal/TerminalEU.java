package terminal;

import main.Passenger;
import random.MersenneTwisterFast;

import java.util.Timer;
import java.util.TimerTask;

public class TerminalEU implements ITerminal {


    @Override
    public void checkInPassenger(Passenger passenger) {
        Timer timer = new Timer();
        MersenneTwisterFast randomizer = new MersenneTwisterFast();

        timer.schedule(
                new TimerTask() {
                    @Override
                    public void run() {
                        System.out.println("EU citizen with the id" + passenger.getId() + " checked in");
                    }
                }, randomizer.nextInt(1, 3) * 1000);
    }

    @Override
    public String getType() {
        return "EU";
    }
}
