package checkPassenger;

import main.Passenger;
import terminal.TerminalEU;

public class CheckPassengerEU extends CheckPassenger {
    TerminalEU terminalEU = new TerminalEU();

    public CheckPassengerEU(CheckPassenger successor) {
        this.setSuccessor(successor);
    }

    public void check(Passenger passenger) {
        if (canHandlePassenger(passenger,"EU")) {
            System.out.println("Passenger is using the EU citizen Terminal");
            terminalEU.checkInPassenger(passenger);
        } else
            super.check(passenger);
    }
}
