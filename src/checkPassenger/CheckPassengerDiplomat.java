package checkPassenger;

import main.Passenger;
import terminal.TerminalDiplomat;

public class CheckPassengerDiplomat extends CheckPassenger {

    TerminalDiplomat terminalDiplomat = new TerminalDiplomat();


    public void check(Passenger passenger){
        if(canHandlePassenger(passenger, "diplomat")) {
            System.out.println("Passenger is using the diplomat Terminal");
            terminalDiplomat.checkInPassenger(passenger);
        }
        else
            super.check(passenger);
    }
}
