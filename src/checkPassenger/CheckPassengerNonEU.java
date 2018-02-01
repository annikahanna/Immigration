package checkPassenger;

import main.Passenger;
import terminal.TerminalNonEU;

public class CheckPassengerNonEU extends CheckPassenger {

    TerminalNonEU terminalNonEU = new TerminalNonEU();

    public CheckPassengerNonEU(CheckPassenger successor) {
        this.setSuccessor(successor);
    }

    public void check(Passenger passenger) {
        if (canHandlePassenger(passenger, "nonEU")) {
            System.out.println("Passenger is using the nonEU Terminal");
            terminalNonEU.checkInPassenger(passenger);
        } else
            super.check(passenger);
    }
}

